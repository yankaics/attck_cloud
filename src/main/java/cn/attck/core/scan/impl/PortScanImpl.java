package cn.attck.core.scan.impl;

import java.io.IOException;
import java.net.Socket;
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
	public PortScanImpl(String ip,int[] port) {
		for (int i = 0; i <port.length; i++) {
			try {
				ss = new Socket(ip, port[i]);
				list.add(port[i]);
			} catch (IOException e) {
				// 不打印任何报错信息
			}
		}
	}

	public List<Integer> getList() {
		return list;
	}
}
