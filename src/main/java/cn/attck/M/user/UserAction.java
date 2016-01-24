package cn.attck.M.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.attck.util.MvUtil;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource
	private UserService userService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		mv.setViewName("user/index");
		return mv;
	}

	/**
	 * @author lauix
	 * @return 获取全部用户
	 */
	@RequestMapping("/queryUser")
	public @ResponseBody ModelAndView queryPort(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		List<Map<String, Object>> result = userService.queryUser();
		mv.addObject("result", result);
		return mv;
	}

	/**
	 * @author lauix
	 * @return 添加 or 修改 新用户
	 */
	@RequestMapping("/addPort")
	public @ResponseBody ModelAndView addPort(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}

		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());
		int sum = userService.is_admin(user_id);
		if (sum > 0) {
			String u_id = request.getParameter("id");
			String account = request.getParameter("account");
			String passwd = request.getParameter("passwd");
			String nikename = request.getParameter("nikename");
			String type = request.getParameter("type");
			String status = request.getParameter("status");
			if (u_id != null) {
				userService.updateUser(account, passwd, nikename, type, status, Integer.parseInt(u_id));
			} else {
				userService.addUser(account, passwd, nikename, type, status);
			}
		}
		return mv;
	}

	/**
	 * @author lauix
	 * @return 删除用户
	 */
	@RequestMapping("/delUser")
	public @ResponseBody ModelAndView delUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());
		int sum = userService.is_admin(user_id);
		if (sum > 0) {
			String u_id = request.getParameter("id");
			if (Integer.parseInt(u_id) != user_id) {
				int result = userService.delUser(Integer.parseInt(u_id));
			}
		}
		return mv;
	}
}
