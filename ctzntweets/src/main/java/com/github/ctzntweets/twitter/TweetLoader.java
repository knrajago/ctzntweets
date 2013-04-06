package com.github.ctzntweets.twitter;

import java.util.List;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterListener;
import twitter4j.TwitterMethod;
import twitter4j.conf.ConfigurationBuilder;

public class TweetLoader {
	public void getTweets() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setUser("");
		cb.setPassword("");
		TwitterListener listener = new TwitterAdapter() {
	        @Override
	        public void updatedStatus(Status status) {
	          System.out.println("Successfully updated the status to [" +
	                   status.getText() + "].");
	        }

	        @Override
	        public void onException(TwitterException e, TwitterMethod method) {
	          if (method == TwitterMethod.UPDATE_STATUS) {
	            e.printStackTrace();
	          } else {
	            throw new AssertionError("Should not happen");
	          }
	        }
	        
	        @Override
	        public void searched(QueryResult pQResult) {
	        	List<Status> statusList = pQResult.getTweets();
	        	for (Status s : statusList) {
	        		System.out.println(s.getText());
	        	}
	        }
	    };
	    
	    listener.toString();
	    // The factory instance is re-useable and thread safe.
	    AsyncTwitterFactory factory = new AsyncTwitterFactory();
	    AsyncTwitter asyncTwitter = factory.getInstance();
	    Query q = new Query();
	    q.setQuery("#IPL");
	    q.setCount(5);
	    asyncTwitter.search(q);
	}
	
	public static void main(String [] args) {
		new TweetLoader().getTweets();
	}
}
