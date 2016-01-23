package cn.attck.M.scan;

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
@RequestMapping("/scan")
public class ScanAction {

	@Resource
	private ScanService scanService;

	// ======================端口扫描===========================
	/**
	 * @author lauix
	 * @return 返回端口扫描视图
	 */
	@RequestMapping("/port")
	public ModelAndView port(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		mv.setViewName("scan/port");
		return mv;
	}

	/**
	 * @author lauix
	 * @return 获取开放端口数据 添加
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
		String ip = request.getParameter("ip");
		String ports = request.getParameter("ports");
		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());
		scanService.portScan(ip, user_id, ports);
		mv.addObject("ip", ip);
		mv.addObject("status", '1');
		return mv;
	}

	/**
	 * @author lauix
	 * @return 获取开放端口数据
	 */
	@RequestMapping("/queryPort")
	public @ResponseBody ModelAndView queryPort(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());
		List<Map<String, Object>> result = scanService.queryPort(user_id);
		mv.addObject("result", result);
		return mv;
	}

	/**
	 * @author lauix
	 * @return 删除开放端口数据
	 */
	@RequestMapping("/delPort")
	public @ResponseBody ModelAndView delPort(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());
		String p_id = request.getParameter("id");
		int result = scanService.delPort(user_id, Integer.parseInt(p_id));
		mv.addObject("result", result);
		return mv;
	}

	// ======================web扫描===========================
	/**
	 * @author lauix
	 * @return 返回网站扫描视图
	 */
	@RequestMapping("/web")
	public ModelAndView web(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		mv.setViewName("scan/web");
		return mv;
	}

	/**
	 * @author lauix
	 * @return web扫描URL 列表
	 */
	@RequestMapping("/findWeb")
	public @ResponseBody ModelAndView findWeb(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		String w_id = request.getParameter("id");
		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());

		List<Map<String, Object>> result = scanService.findWeb(Integer.parseInt(w_id), user_id);
		mv.addObject("result", result);
		return mv;
	}

	/**
	 * @author lauix
	 * @url 扫描网站
	 * @return web扫描存在列表
	 */
	@RequestMapping("/addWeb")
	public @ResponseBody ModelAndView addWeb(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		String url = request.getParameter("url");
		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());
		scanService.webScan(url, user_id);
		mv.addObject("status", '1');
		return mv;
	}

	/**
	 * @author lauix
	 * @return web扫描列表
	 */
	@RequestMapping("/queryWeb")
	public @ResponseBody ModelAndView queryWeb(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());
		List<Map<String, Object>> result = scanService.queryWeb(user_id);
		mv.addObject("result", result);
		return mv;
	}

	/**
	 * @author lauix
	 * @return 删除web扫描数据
	 */
	@RequestMapping("/delWeb")
	public @ResponseBody ModelAndView delWeb(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MvUtil mu = new MvUtil();
		boolean is = mu.is_login(request);
		if (is == false) {
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		Object id = request.getSession().getAttribute("id");
		int user_id = Integer.parseInt(id.toString());
		String w_id = request.getParameter("id");
		int result = scanService.delWeb(user_id, Integer.parseInt(w_id));
		mv.addObject("result", result);
		return mv;
	}
}
