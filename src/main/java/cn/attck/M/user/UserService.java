package cn.attck.M.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.attck.util.MakeMd5;

@Service
public class UserService {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> queryUser() {
		String sql = "SELECT * FROM attck_user";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		return result;
	}

	// 判断是否是管理员
	public int is_admin(int user_id) {
		String sql = "SELECT count(1) as sum FROM attck_user WHERE id=? AND type=1";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, new Object[] { user_id });
		int sum = 0;
		for (Map<String, Object> map : result) {
			sum = Integer.parseInt(map.get("sum").toString());
		}
		return sum;
	}

	// 删除用户
	public int delUser(int user_id) {
		String sql = "DELETE FROM attck_user WHERE id=?";
		int result = jdbcTemplate.update(sql, new Object[] { user_id });
		return result;
	}

	// 添加用户
	public int addUser(String account, String passwd, String nikename, String type, String status) {
		String md5Passwd = "";
		try {
			md5Passwd = MakeMd5.md5Encode(passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO attck_user(account,passwd,nikeName,type,status,last_login_time) VALUES(?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, new Object[] { account, md5Passwd, nikename, type, status, new Date() });
		return result;
	}

	// 修改用户
	public int updateUser(String account, String passwd, String nikename, String type, String status, int u_id) {
		int result = 0;
		if (passwd != null) {
			String md5Passwd = "";
			try {
				md5Passwd = MakeMd5.md5Encode(passwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql = "UPDATE attck_user SET account=?,passwd=?,nikeName=?,type=?,status=? WHERE id =?";
			result = jdbcTemplate.update(sql, new Object[] { account, md5Passwd, nikename, type, status, u_id });
		} else {
			String sql = "UPDATE attck_user SET account=?,nikeName=?,type=?,status=? WHERE id =?";
			result = jdbcTemplate.update(sql, new Object[] { account, nikename, type, status, u_id });
		}
		return result;
	}
}
