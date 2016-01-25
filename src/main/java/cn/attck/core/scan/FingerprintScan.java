package cn.attck.core.scan;

import cn.attck.core.scan.impl.FingerprintScanImpl;

/**
 * @author lauix 指纹扫描核心模块
 */
public class FingerprintScan {
	private FingerprintScan() {
	}

	private static FingerprintScan fingerprintScan = null;

	public static FingerprintScan getInstance() {
		if (fingerprintScan == null) {
			fingerprintScan = new FingerprintScan();
		}
		return fingerprintScan;
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
		FingerprintScanImpl fs = new FingerprintScanImpl();
		return fs.getList(url, path);
	}
}
