package cn.attck.M.index;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexAction {

	@Resource
	private IndexService indexService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index/index");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String account = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		ModelAndView mv = new ModelAndView();
		Map<String, Object> result = null;
		if (account != null && passwd != null) {
			result = indexService.findUser(account, passwd);
			if (Integer.parseInt(result.get("code").toString()) == 2) {
				// 登陆时间
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String loginTime = df.format(new Date());

				request.getSession().setAttribute("loginType", result.get("type"));
				request.getSession().setAttribute("loginName", result.get("nikeName"));
				request.getSession().setAttribute("loginTime", loginTime);
				request.getSession().setAttribute("id", result.get("id"));
				mv.setViewName("redirect:/home/index.html");
			} else {
				mv.setViewName("redirect:/index.html");
			}
		}
		mv.addObject("result", result);
		return mv;
	}
}
