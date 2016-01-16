package cn.attck.core.scan.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lauix web目录扫描核心模块
 */
public class WebScanImpl {

	private URL url;
	private HttpURLConnection conn;
	// private Proxy proxy = null; // 代理

	private List<String> list = new ArrayList<String>();

	/**
	 * @author lauix
	 * @param url网址
	 * @param path目录字典
	 */
	public List<String> getList(String url, String[] path) {
		try {
			for (int i = 0; i < path.length; i++) {
				String urlPath = url + "" + path[i];
				this.url = new URL(urlPath);
				this.conn = (HttpURLConnection) this.url.openConnection();
				if (this.conn.getResponseCode() == 200) {
					this.list.add(urlPath);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return this.list;
		}
	}
}
