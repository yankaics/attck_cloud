package cn.attck.M.home;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.attck.util.MvUtil;

@Controller
@RequestMapping("/home")
public class HomeAction {

	@Resource
	private HomeService homeService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		mv.setViewName("home/index");
		return mv;
	}
}
