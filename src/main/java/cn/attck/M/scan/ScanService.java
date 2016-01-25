package cn.attck.M.scan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.attck.core.scan.PortScan;
import cn.attck.core.scan.WebScan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.PreparedStatementCreator;

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
	public void portScan(final String ip, final int user_id, String port) {
		final String sql = "INSERT INTO attck_scan_port(ip,port,user_id) VALUES(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql, new String[] { "id" });
				psst.setString(1, ip);
				psst.setString(2, "正在扫描中...");
				psst.setInt(3, user_id);
				return psst;
			}
		}, keyHolder);
		int id = keyHolder.getKey().intValue();

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

		String updateSql = "UPDATE attck_scan_port SET port=? WHERE id=? ";
		jdbcTemplate.update(updateSql, new Object[] { result, id });
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
	public void webScan(final String url, final int user_id) {
		final String sql = "INSERT INTO attck_scan_web(user_id,url,url_path) VALUES(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql, new String[] { "id" });
				psst.setInt(1, user_id);
				psst.setString(2, url);
				psst.setString(3, "正在扫描中...");
				return psst;
			}
		}, keyHolder);
		int id = keyHolder.getKey().intValue();

		String findSql = "SELECT url_path FROM attck_diction_dir";
		List<Map<String, Object>> listMap = jdbcTemplate.queryForList(findSql);
		for (Map<String, Object> map : listMap) {
			String path = map.get("url_path").toString();
			boolean result = WebScan.getInstance().getList(url, path);
			if (result == true) {
				String sqlInser = "INSERT INTO attck_scan_webresult(user_id,web_id,url  VALUES(?,?,?)";
				jdbcTemplate.update(sqlInser, new Object[] { user_id, id, url + path });
			}
		}
	}

	/**
	 * @author lauix 获取web扫描数据
	 */
	public List<Map<String, Object>> queryWeb(int user_id) {
		String sql = "SELECT id,user_id,url,create_time  FROM attck_scan_web WHERE user_id=? ORDER BY id desc";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, new Object[] { user_id });
		return result;
	}

	/**
	 * @author lauix 获取web扫描URL数据
	 */
	public List<Map<String, Object>> findWeb(int id, int user_id) {
		String sql = "SELECT url  as url_path FROM attck_scan_webresult WHERE web_id=? and user_id=?";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, new Object[] { id, user_id });
		return result;
	}

	/**
	 * @author lauix 删除web扫描数据
	 */
	public int delWeb(int user_id, int w_id) {
		String sql = "DELETE FROM attck_scan_web WHERE id=? AND user_id=?";
		int result = jdbcTemplate.update(sql, new Object[] { w_id, user_id });
		return result;
	}

	// ======================指纹扫描===========================
	/**
	 * @author lauix
	 * @param url
	 *            扫描网站
	 * @return 获取全部目录列表
	 */
	@Async
	public void fingerprintScan(final String url, final int user_id) {
		final String sql = "INSERT INTO attck_scan_web(user_id,url,url_path) VALUES(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql, new String[] { "id" });
				psst.setInt(1, user_id);
				psst.setString(2, url);
				psst.setString(3, "正在扫描中...");
				return psst;
			}
		}, keyHolder);
		int id = keyHolder.getKey().intValue();

		String findSql = "SELECT cms,url FROM attck_diction_cms";
		List<Map<String, Object>> listMap = jdbcTemplate.queryForList(findSql);
		for (Map<String, Object> map : listMap) {
			String path = map.get("url").toString();
			String cms = map.get("cms").toString();
			boolean result = WebScan.getInstance().getList(url, path);
			if (result == true) {
				String sqlInser = "INSERT INTO attck_scan_webresult(user_id,web_id,url  VALUES(?,?,?)";
				jdbcTemplate.update(sqlInser, new Object[] { user_id, id, url + path });
			}
		}
	}

}
