package com.BrowserBuddyTabHistoryManager;

public class WebPageNode {
	String url;
	WebPageNode next;
	WebPageNode prev;
	
	public WebPageNode(String url) {
		this.url = url;
	}
}