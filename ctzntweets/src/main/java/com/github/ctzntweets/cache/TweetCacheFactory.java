package com.github.ctzntweets.cache;

public class TweetCacheFactory {
	static TweetCache sInstance = new TweetCache();
	
	public TweetCache getTweetCache() {
		return sInstance;
	}
}
