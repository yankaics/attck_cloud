package cn.attck.M.fishing;

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
@RequestMapping("/fishing")
public class FishingAction {

	@Resource
	private FishingService fishingService;

	// ======================端口扫描===========================
	/**
	 * @author lauix 返回xss视图
	 */
	@RequestMapping("/xss")
	public ModelAndView xss(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		mv.setViewName("fishing/xss");
		return mv;
	}

	/**
	 * @author lauix 查询当前用户全部XSS
	 */
	@RequestMapping("/queryXss")
	public @ResponseBody ModelAndView queryXss(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());
		List<Map<String, Object>> result = fishingService.queryXss(user_id);
		mv.addObject("result", result);
		return mv;
	}
	
	

	@RequestMapping("/xssServer")
	public ModelAndView xssServer(HttpServletRequest request, HttpServletResponse response) {
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
			} else if (Integer.parseInt(type) == 3) {
				String mycode = request.getParameter("mycode");

				mv.addObject("mycode", mycode);
			}

		}
		return mv;
	}
}
