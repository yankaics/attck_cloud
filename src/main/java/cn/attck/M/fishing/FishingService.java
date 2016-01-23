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
	 * @author lauix
	 * 查询当前用户全部XSS
	 * */
	public List<Map<String, Object>> queryXss(int userId) {
		String sql = "SELECT * FROM attck_fishing_xss WHERE user_id=?";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, new Object[] { userId });
		return result;
	}
}
