package cn.attck.M.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.attck.util.MakeMd5;

@Service
public class IndexService {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> findUser(String account, String passwd) {
		Map<String, Object> map = new HashMap<String, Object>();
		String md5Passwd = "";
		try {
			md5Passwd = MakeMd5.md5Encode(passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT COUNT(1) as sum,id,account,nikeName,type FROM attck_user WHERE account=? AND passwd=?";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, new Object[] { account, md5Passwd });
		int num = Integer.parseInt(result.get("sum").toString());
		if (num == 0) {
			map.put("code", "1");
			map.put("mess", "账号密码错误！");
		} else {
			map.put("code", "2");
			map.put("mess", "登陆成功！");
			map.put("nikeName", result.get("nikeName"));
			map.put("type", result.get("type"));
			map.put("id", result.get("id"));
		}
		return map;
	}
}
