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
	 * @param url
	 *            要扫描的web url
	 * @param path
	 *            要扫描的web
	 * @return 
	 */
	public boolean getList(String url, String path) {
		WebScanImpl ws = new WebScanImpl();
		return ws.getList(url, path);
	}
}
