/**
 * 
 */
package com.zenika;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author acogoluegnes
 *
 */
public class EmailService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
	
	private final AtomicInteger counter = new AtomicInteger(0);

	public void send(EmailNotification email) throws Exception {
		LOGGER.info("about to process {}",email);
		Thread.sleep(2000L); // simulates latency
//		LOGGER.info("{} has been sent",email);
		counter.incrementAndGet();
	}
	
	public int getCount() {
		return counter.get();
	}
	
	public void reset() {
		counter.set(0);
	}
	
}
