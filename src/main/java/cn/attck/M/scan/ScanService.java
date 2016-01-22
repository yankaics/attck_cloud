package cn.attck.M.scan;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.attck.core.scan.PortScan;
import cn.attck.core.scan.WebScan;

//import cn.attck.core.scan.PortScan;

/**
 * @author lauix 扫描模块 Service
 */
@Service
public class ScanService {

	@Resource
	private JdbcTemplate jdbcTemplate;

	// ======================端口扫描===========================
	/**
	 * @author lauix
	 * @param ip
	 *            要扫描的IP
	 * @param port
	 *            要扫描的端口
	 * @return 获取全部开放端口
	 */
	@Async
	public void portScan(String ip, int user_id, String port) {
		// 分割字符串
		String[] portAyy = port.split(",");
		// 声明int数组
		int[] portInt = new int[portAyy.length];
		// 改变类型
		for (int i = 0; i < portAyy.length; i++) {
			portInt[i] = Integer.parseInt(portAyy[i]);
		}
		List<Integer> list = PortScan.getInstance().getList(ip, portInt);
		String result = list.toString();
		result = result.substring(1, result.length() - 1);
		String sql = "INSERT INTO attck_scan_port(ip,port,user_id) VALUES(?,?,?)";
		jdbcTemplate.update(sql, new Object[] { ip, result, user_id });
	}

	/**
	 * @author lauix 获取端口扫描数据
	 */
	public List<Map<String, Object>> queryPort(int user_id) {
		String sql = "SELECT * FROM attck_scan_port WHERE user_id=? ORDER BY id desc";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, new Object[] { user_id });
		return result;
	}

	/**
	 * @author lauix 删除端口扫描数据
	 */
	public int delPort(int user_id, int p_id) {
		String sql = "DELETE FROM attck_scan_port WHERE id=? AND user_id=?";
		int result = jdbcTemplate.update(sql, new Object[] { p_id, user_id });
		return result;
	}

	// ======================web扫描===========================
	/**
	 * @author lauix
	 * @param url
	 *            扫描网站
	 * @return 获取全部目录列表
	 */
	@Async
	public void webScan(String url, int user_id) {
		String findSql = "SELECT url_path FROM attck_diction WHERE type=1";
		List<Map<String, Object>> listMap = jdbcTemplate.queryForList(findSql);
		String[] path = null;
		for (Map<String, Object> map : listMap) {
			path = map.get("url_path").toString().split(",");
		}
		List<String> list = WebScan.getInstance().getList(url, path);
		String result = list.toString();
		result = result.substring(1, result.length() - 1);
		String sql = "INSERT INTO attck_scan_web(user_id,url,url_path) VALUES(?,?,?)";
		jdbcTemplate.update(sql, new Object[] { user_id, url, result });
	}

	/**
	 * @author lauix 获取端口扫描数据
	 */
	public List<Map<String, Object>> queryWeb(int user_id) {
		String sql = "SELECT * FROM attck_scan_web  WHERE user_id=? ORDER BY id desc";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, new Object[] { user_id });
		return result;
	}

	/**
	 * @author lauix 删除端口扫描数据
	 */
	public int delWeb(int user_id, int w_id) {
		String sql = "DELETE FROM attck_scan_web WHERE id=? AND user_id=?";
		int result = jdbcTemplate.update(sql, new Object[] { w_id, user_id });
		return result;
	}
}
