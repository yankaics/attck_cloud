package cn.attck.core.scan.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lauix 端口扫描核心模块
 */
public class PortScanImpl {

	// 初始化Socket
	private Socket ss = null;
	// 初始化List 保存可访问端口
	private List<Integer> list = new ArrayList<Integer>();

	/**
	 * @author lauix
	 * @param ip
	 *            要扫描的IP
	 * @param port
	 *            要扫描的端口
	 */
	public List<Integer> getList(String ip, int[] port) {
		try {
			for (int i = 0; i < port.length; i++) {
				try {
					this.ss = new Socket(ip, port[i]);
					this.list.add(port[i]);
				} catch (IOException e) {
					// 不打印任何报错信息
				}
			}
		} finally {
			return this.list;
		}
	}

}
