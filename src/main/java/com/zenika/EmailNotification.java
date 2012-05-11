package com.zenika;
/**
 * 
 */

/**
 * @author acogoluegnes
 *
 */
public class EmailNotification {

	private String to,subject,body;
	
	public EmailNotification() {}

	public EmailNotification(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "EmailNotification [to=" + to + ", subject=" + subject
				+ ", body=" + body + "]";
	}
	
}
