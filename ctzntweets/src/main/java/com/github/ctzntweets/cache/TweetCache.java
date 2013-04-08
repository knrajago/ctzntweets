package com.github.ctzntweets.cache;

import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.SimpleFormatter;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.HashtagEntity;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.github.ctzntweets.twitter.TweetLoader;

public class TweetCache {
	TweetCache() {
		
	}
	
	private static long ALLOWED_DELAY = 30000;
	
	private ConcurrentHashMap<String, List<TweetInfo>> map = new ConcurrentHashMap<String, List<TweetInfo>>();
	private long mLastUpdateTime;

	public List<TweetInfo> getTweets(double pLatitude, double pLongitude) throws TwitterException {
		Place place = getPlace(pLatitude, pLongitude);
		long curTime = Calendar.getInstance().getTimeInMillis();
		
		if ((this.mLastUpdateTime + ALLOWED_DELAY) < curTime) {
			// Needs an update
			synchronized(this) {
				if ((this.mLastUpdateTime + ALLOWED_DELAY) < curTime) {
					List<Status> tweets = getTweetsSince(mLastUpdateTime);
					mLastUpdateTime = curTime;
					
					for (Status oneTweet : tweets) {
						updateTweetInformation(oneTweet);
					}
				}
			}
		}
		
		return map.get(place.getFullName());
	}
	
	public void clear() {
		this.map.clear();
	}
	
	private void updateTweetInformation(Status pTweet) {
		if (pTweet == null) {
			return;
		}
		
		TweetInfo tInfo = new TweetInfo(pTweet);
		String loc = tInfo.getLocation();
		List<TweetInfo> tweetInfoList = this.map.get(loc);
		if (tweetInfoList == null) {
			tweetInfoList = new LinkedList<TweetInfo>();
			this.map.put(loc, tweetInfoList);
		}
		tweetInfoList.add(tInfo);
	}
	
	private List<Status> getTweetsSince(long since) throws TwitterException {
		Twitter twttr = new TweetLoader().getTwitterInstance();
		Query qry = new Query();
	    qry.setQuery("@ctzntweets");
	    QueryResult qryResults = twttr.search(qry);
	    
	    List<Status> tweets = qryResults.getTweets();
	    return tweets;
	}
	
	private Place getPlace(double pLatitude, double pLongitude) throws TwitterException {
		Twitter twttr = new TweetLoader().getTwitterInstance();
		GeoQuery query = null;
        query = new GeoQuery(new GeoLocation(pLatitude,pLongitude));
        ResponseList<Place> places = twttr.searchPlaces(query);
		return places.get(0);
	}
	
}
