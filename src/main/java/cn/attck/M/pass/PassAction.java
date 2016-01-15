package cn.attck.M.pass;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pass")
public class PassAction {

	@Resource
	private PassService passService;

	@RequestMapping("/index")
	public ModelAndView query1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		return mv;
	}
}
