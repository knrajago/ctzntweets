package com.github.ctzntweets.cache;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class TweetCacheTest extends TestCase {
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testRetrieval() {
		try {
			List<TweetInfo> tInfoList = new TweetCache().getTweets(44.501189,-88.060355);
			for (TweetInfo oneTweet : tInfoList) {
				System.out.println(oneTweet.getLatitude() + " - " + oneTweet.getLongitude() + " - " + oneTweet.getLocation() + " - " + oneTweet.getCategory().toString() + " - " + oneTweet.getTweetText());
			}
		} catch(Exception e) {
			assertFalse(true);
		}
	}
}
