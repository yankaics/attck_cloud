package cn.attck.core.scan;

import java.util.List;

import cn.attck.core.scan.impl.WebScanImpl;

/**
 * @author lauix web扫描核心模块
 */
public class WebScan {
	private WebScan() {
	}

	private static WebScan webScan = null;

	public static WebScan getInstance() {
		if (webScan == null) {
			webScan = new WebScan();
		}
		return webScan;
	}

	/**
	 * @author lauix
	 * @param ip
	 *            要扫描的IP
	 * @param port
	 *            要扫描的端口
	 * @return 获取全部开放端口
	 */
	public List<String> getList(String url, String[] path) {
		WebScanImpl ws = new WebScanImpl();
		return ws.getList(url, path);
	}
}
