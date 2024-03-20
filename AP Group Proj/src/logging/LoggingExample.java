package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {
	
	public static void main(String[] args) {
		
		final Logger logger = LogManager.getLogger(LoggingExample.class);
		logger.info("info test");
		logger.debug("debug test");
		logger.error("error test");
		logger.trace("trace test");
		logger.fatal("fatal test");
		logger.warn("warn test");
	}
}