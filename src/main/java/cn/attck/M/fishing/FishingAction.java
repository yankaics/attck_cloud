package cn.attck.M.fishing;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fishing")
public class FishingAction {

	@Resource
	private FishingService fishingService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("404");
		return mv;
	}

	@RequestMapping("/xss")
	public ModelAndView xss(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String type = request.getParameter("type");
		if (type != null) {
			String id = request.getParameter("id");
			if (Integer.parseInt(type) == 1) {
				String location = request.getParameter("location");
				String toplocation = request.getParameter("toplocation");
				String cookie = request.getParameter("cookie");
				String opener = request.getParameter("opener");

				mv.addObject("id", id);
				mv.addObject("location", location);
				mv.addObject("toplocation", toplocation);
				mv.addObject("cookie", cookie);
				mv.addObject("opener", opener);
			} else if (Integer.parseInt(type) == 2) {
				String mycode = request.getParameter("mycode");

				mv.addObject("mycode", mycode);
			}else if (Integer.parseInt(type) == 3) {
				String mycode = request.getParameter("mycode");

				mv.addObject("mycode", mycode);
			}

		}
		return mv;
	}
}
