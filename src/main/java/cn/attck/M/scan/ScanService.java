package cn.attck.M.scan;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.attck.core.scan.PortScan;

//import cn.attck.core.scan.PortScan;

/**
 * @author lauix 扫描模块 Service
 */
@Service
public class ScanService {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * @author lauix
	 * @param ip
	 *            要扫描的IP
	 * @param port
	 *            要扫描的端口
	 * @return 获取全部开放端口
	 */
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
}
