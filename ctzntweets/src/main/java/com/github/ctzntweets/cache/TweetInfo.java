package com.github.ctzntweets.cache;

/**
 * Stores Information about Tweets
 * @author koushik
 *
 */
public class TweetInfo {
	private double mLatitude;
	private double mLongitude;
	private TweetCategory mCategory;
	private String mTweetText;
	
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
