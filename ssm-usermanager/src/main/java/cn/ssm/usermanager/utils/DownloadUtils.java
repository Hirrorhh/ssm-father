package cn.ssm.usermanager.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;

public class DownloadUtils {

	public static String getAttachmentFilename(String filename, String header) {
		// 火狐
		try {
			if (header.contains("Firefox")) {
				filename = "=?utf-8?B?"
						+ new BASE64Encoder()
								.encode(filename.getBytes("utf-8")) + "?=";
			} else {
				// chrome ie
				filename = URLEncoder.encode(filename, "utf-8")
						.replace("+", " ").replace("%3A", ":");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return filename;
	}

}
