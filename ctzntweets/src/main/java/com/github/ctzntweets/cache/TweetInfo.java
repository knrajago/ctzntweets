package com.github.ctzntweets.cache;

import twitter4j.HashtagEntity;
import twitter4j.Status;

/**
 * Stores Information about Tweets
 * @author koushik
 *
 */
public class TweetInfo {
	private double mLatitude;
	private double mLongitude;
	private String mLocation;
	private TweetCategory mCategory;
	private String mTweetText;
	
	public TweetInfo() {
		
	}
	
	public TweetInfo(Status pTweet) {
		this.mCategory = getCategoryFromTweet(pTweet);
		this.mLocation = pTweet.getUser().getLocation();
		this.mTweetText = pTweet.getText();
	}
	
	/**
	 * Get category from tweet
	 * @param pTweet
	 * @return
	 */
	private TweetCategory getCategoryFromTweet(Status pTweet) {
		if (pTweet == null) {
			return null;
		}
		String txt = pTweet.getText();
		TweetCategory [] allvalues = TweetCategory.values();
		HashtagEntity[] hashtags = pTweet.getHashtagEntities();
		for (HashtagEntity oneHashtag : hashtags) {
			System.out.println(oneHashtag.getText());
			TweetCategory cat = TweetCategory.valueOf(oneHashtag.getText().toUpperCase());
			if (cat != null) {
				return cat;
			}
		}
		return null;
	}
	
	/**
	 * Returns Latitude
	 * @return
	 */
	public double getLatitude() {
		return mLatitude;
	}
	
	/**
	 * Sets Latitude
	 * @param pLatitude
	 */
	public void setLatitude(double pLatitude) {
		this.mLatitude = pLatitude;
	}
	
	/**
	 * Returns Longitude
	 * @return
	 */
	public double getLongitude() {
		return mLongitude;
	}
	
	/**
	 * Sets Longitude
	 * @param pLongitude
	 */
	public void setLongitude(double pLongitude) {
		this.mLongitude = pLongitude;
	}
	
	/**
	 * Return location
	 * @return
	 */
	public String getLocation() {
		return this.mLocation;
	}
	
	/**
	 * Sets location
	 * @param pLocation
	 */
	public void setLocation(String pLocation) {
		this.mLocation = pLocation;
	}
	
	/**
	 * Returns Category
	 * @return
	 */
	public TweetCategory getCategory() {
		return mCategory;
	}
	
	/**
	 * Sets Category
	 * @param pCategory
	 */
	public void setCategory(TweetCategory pCategory) {
		this.mCategory = pCategory;
	}
	
	/**
	 * Returns Tweet Text
	 * @return
	 */
	public String getTweetText() {
		return mTweetText;
	}
	
	/**
	 * Sets pTweetText
	 * @param pTweetText
	 */
	public void setTweetText(String pTweetText) {
		this.mTweetText = pTweetText;
	}
}
