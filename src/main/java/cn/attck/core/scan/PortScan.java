package cn.attck.core.scan;

import java.util.List;

import cn.attck.core.scan.impl.PortScanImpl;

/**
 * @author lauix 端口扫描核心模块
 */
public class PortScan {
	private PortScan() {
	}

	private static PortScan portScan = null;

	public static PortScan getInstance() {
		if (portScan == null) {
			portScan = new PortScan();
		}
		return portScan;
	}

	/**
	 * @author lauix
	 * @param ip
	 *            要扫描的IP
	 * @param port
	 *            要扫描的端口
	 * @return 获取全部开放端口
	 */
	public List<Integer> getList(String ip, int[] port) {
		PortScanImpl ps = new PortScanImpl();
		return ps.getList(ip, port);
	}
}
