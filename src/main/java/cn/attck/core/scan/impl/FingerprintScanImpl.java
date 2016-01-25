package cn.attck.core.scan.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author lauix 指纹扫描核心模块
 */
public class FingerprintScanImpl {

	private URL url;
	private HttpURLConnection conn;
	// private Proxy proxy = null; // 代理

	private boolean list = false;

	/**
	 * @author lauix
	 * @param url网址
	 * @param 指纹
	 */
	public boolean getList(String url, String path) {
		try {
			String up = url + path;
			this.url = new URL(path);
			this.conn = (HttpURLConnection) this.url.openConnection();
			if (this.conn.getResponseCode() == 200) {
				this.list = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return this.list;
		}
	}
}
