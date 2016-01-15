package cn.attck.M.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource
	private UserService userService;

	@RequestMapping("/index")
	public ModelAndView query1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> result = userService.query();
		mv.addObject("result", result);
		mv.setViewName("404");
		return mv;
	}
}
