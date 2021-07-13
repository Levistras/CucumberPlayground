/*
 * Kangeyan Passoubady
 * Version 1.0
 */
package com.kavinschool.examples.utils;

import java.lang.invoke.MethodHandles;

import org.apache.log4j.lf5.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void writeLog(String message, LogLevel logLevel) {
		if (log.isDebugEnabled() && logLevel == LogLevel.DEBUG) {
			log.debug(message);
		} else if (log.isWarnEnabled() && logLevel == LogLevel.WARN) {
			log.warn(message);
		} else {
			log.info(message);
		}
	}

	public static void writeLog(String message) {
		log.info(message);
	}

}
