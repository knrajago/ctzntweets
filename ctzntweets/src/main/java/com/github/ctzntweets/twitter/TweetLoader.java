package com.github.ctzntweets.twitter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetLoader {
	
	public List<Status> getTweets(double pLatitude, double pLongitude, long pSince, long pUntil) throws TwitterException, ParseException {
		
		Twitter twitter = getTwitterInstance();
	    // The factory instance is re-useable and thread safe.
	    
	    String DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";

	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    Query q = new Query();
	    q.setQuery("@ctzntweets");
	    q.setCount(50);
	    q.setSince(sdf.format(new Date(pSince)));
	    q.setUntil(sdf.format(new Date(pUntil)));
	    //q.setGeoCode(new GeoLocation(pLatitude, pLongitude), 15, "miles");
	    QueryResult qResult = twitter.search(q);
	    return qResult.getTweets();
	}
	
	public Twitter getTwitterInstance() {
	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setOAuthAccessToken("1332356904-hwRpa9LZGj9WeZUkxWoZQxDWVhsSjXFhhisZLUs");
	    cb.setOAuthAccessTokenSecret("rD3QUAppbmdb2ksnrTvBtwkVX42MvHjazS43xj2T7fg");
	    cb.setOAuthConsumerKey("tp9jqDkXXeacaiF0GfI1Q");
	    cb.setOAuthConsumerSecret("v8nDozkHMTpkepDuzkXk6POzd0k7anhNqFVSxE3ig");
	    
	    TwitterFactory factory = new TwitterFactory(cb.build());
	    return factory.getInstance();
	}
	
	public static void main(String [] args) throws TwitterException {
		//List<Status> tweets = new TweetLoader().getTweets();
	}
}
