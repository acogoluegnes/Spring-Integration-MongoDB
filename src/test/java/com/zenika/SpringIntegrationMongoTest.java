/**
 * 
 */
package com.zenika;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.integration.core.MessagingOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author acogoluegnes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringIntegrationMongoTest {

	@Autowired MessagingOperations msgTpl;
	
	@Autowired MongoOperations mongoTpl;
	
	@Autowired EmailService emailService;
	
	@Before public void setUp() {
		mongoTpl.getCollection("emailtasks").drop();
		emailService.reset();
	}
	
	@Test public void springIntegrationMongo() throws Exception {
		int messageCount = 5; 
		for(int i=0;i<messageCount;i++) {
			msgTpl.convertAndSend(new EmailNotification("mickey@mouse.com","Message from Minnie "+i,"Minnie is waiting for you!"));
		}
		long wait = 0;
		while(emailService.getCount() != messageCount && wait <= 5000) {
			Thread.sleep(1000L);
			wait += 1000L;
		}
		assertThat(emailService.getCount(),is(messageCount));
	}
	
}
