package cn.attck.M.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> query() {
		String sql = "SELECT * from lf_user";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		return result;
	}
}
