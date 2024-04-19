package com.syncinator.kodi.login.util;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class Utils {
	private static final Logger LOG = LoggerFactory.getLogger(Utils.class);
	public static String getRemoteAddress(HttpServletRequest request) {
		String remote = request.getHeader("x-forwarded-for");
		if (remote == null) {
			remote = request.getRemoteAddr();
		}

		// Let's return the very first IP address.
		return remote.split(",")[0].trim();
	}
	public static String getSourceId(HttpServletRequest request) {
		String ip = getRemoteAddress(request);
		int sourceid = 0;
		try {
			sourceid = Stream.of(ip.contains(".") ? ip.split("\\.") : ip.split(":")).mapToInt(Integer::parseInt).sum();
		} catch(Exception e) {
			sourceid = -1;
		}
		return String.valueOf(sourceid);
	}
	
}
