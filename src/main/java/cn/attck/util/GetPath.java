package cn.attck.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPath {
	// 获取配置文件
	public static Properties getFilePath() throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream("filePath.properties"));
		Properties p = new Properties();
		p.load(in);
		return p;
	}
}
