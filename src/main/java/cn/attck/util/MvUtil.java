package cn.attck.util;

import javax.servlet.http.HttpServletRequest;

public class MvUtil {

	// 判断用户是否登陆
	public boolean is_login(HttpServletRequest request) {
		boolean result = false;
		Object type = request.getSession().getAttribute("loginType");
		if (type != null) {
			result = true;
		}
		return result;
	}
}
