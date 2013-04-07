package com.github.ctzntweets.cache;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import twitter4j.GeoLocation;
import twitter4j.Status;
import twitter4j.TwitterException;

import com.github.ctzntweets.twitter.TweetLoader;

public class TweetCache {
	TweetCache() {
		
	}
	
	ConcurrentHashMap<GeoLocation, TweetInfo> map = new ConcurrentHashMap<GeoLocation, TweetInfo>();
	
	// List<TweetInfo> getTweets(double pLatitude, double pLongitude)
	// void clear()
	
	List<TweetInfo> getTweets(double pLatitude, double pLongitude) {
		GeoLocation gLocation = new GeoLocation(pLatitude, pLongitude);
		
		return null;
	}
	
	private void loadTweets(double pLatitude, double pLongitude, long pSince, long pUntil) {
		Calendar cal = Calendar.getInstance();
		long until = cal.getTimeInMillis();
		cal.set(Calendar.MONTH, 3);
		long since = cal.getTimeInMillis();
		try {
			System.out.println("Since: " + since);
			System.out.println("Until: " + until);
			List<Status> tweets = new TweetLoader().getTweets(44.467111,-88.074517, since, until);
			for (Status oneTweet : tweets) {
				GeoLocation gLoc = oneTweet.getGeoLocation();
				if (gLoc == null) { 
					System.out.println(" - " + oneTweet.getText());
				} else {
					System.out.println(gLoc.getLatitude() + "," + gLoc.getLongitude() + " - " + oneTweet.getText());
				}
			}
		}catch(TwitterException tException) {
			//TODO
		}
		catch(ParseException pEx) {
			//TODO
		}
		System.out.println("\n");
		//for (Status oneTweet : tweets) {
		//	System.out.println(oneTweet.getUser().getName() + " - " + oneTweet.getText());
		//}
	}
	
	public static void main(String [] args) {
		new TweetCache().loadTweets(0, 0, 0, 0);
	}
}
