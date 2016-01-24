package cn.attck.M.fishing;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FishingService {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * @author lauix 查询当前用户全部XSS
	 */
	public List<Map<String, Object>> queryXss(int userId) {
		String sql = "SELECT * FROM attck_fishing_xss WHERE user_id=?";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, new Object[] { userId });
		return result;
	}

	/**
	 * @author lauix xss info
	 */
	public List<Map<String, Object>> findXssInfo(int userId, int id) {
		String sql = "SELECT * FROM attck_fishing_xssinfo WHERE user_id=? AND xss_id=?";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, new Object[] { userId, id });
		return result;
	}

	/**
	 * @author lauix del info
	 */
	public int delXss(int userId, int id) {
		String sql = "DELETE FROM attck_fishing_xss WHERE id=? and user_id=?";
		String sql1 = "DELETE FROM attck_fishing_xssinfo WHERE xss_id=? and user_id=?";
		jdbcTemplate.update(sql, new Object[] { id, userId });
		int result = jdbcTemplate.update(sql1, new Object[] { id, userId });
		return result;
	}

	/**
	 * @author lauix 添加项目
	 */
	public int addXss(int userId, String xssTitle, String xssDesc, int types) {
		String sql = "INSERT INTO attck_fishing_xss(user_id,title,detail,type) VALUES(?,?,?,?)";
		int result = jdbcTemplate.update(sql, new Object[] { userId, xssTitle, xssDesc, types });
		return result;
	}

	/**
	 * @author lauix 添加项目接收结果
	 */
	public int addXssInfo(int id, int user_id, String json) {
		String sql = "INSERT INTO attck_fishing_xssinfo(user_id,xss_id,list) VALUES(?,?,?)";
		int result = jdbcTemplate.update(sql, new Object[] { user_id, id, json });

		String sqljia = "UPDATE attck_fishing_xss SET num=(num+1) WHERE id=?";
		jdbcTemplate.update(sqljia, new Object[] { id });
		return result;
	}
}
