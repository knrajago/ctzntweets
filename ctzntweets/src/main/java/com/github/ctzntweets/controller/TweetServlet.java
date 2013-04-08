package com.github.ctzntweets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONObject;

import com.github.ctzntweets.cache.TweetCache;
import com.github.ctzntweets.cache.TweetCacheFactory;
import com.github.ctzntweets.cache.TweetInfo;

public class TweetServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	
static final long serialVersionUID = 1L;
public TweetServlet() { super(); }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String latitude = request.getParameter("latitude");
	String longitude = request.getParameter("longitude");
	System.out.println(request.getRequestURL()+" "+latitude+" "+longitude);
	PrintWriter out = response.getWriter();
	
	//response.setContentType("text/text");
	out.println(getTweets(latitude,longitude));
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{}

private JSONArray getTweets(String latitude, String longitude)
{

	JSONArray array= new JSONArray();
	
	try{
		TweetCache tcf=new TweetCacheFactory().getTweetCache();
		List<TweetInfo> tInfoList=tcf.getTweets(Double.parseDouble(latitude), Double.parseDouble(longitude));
		
						
		for(TweetInfo oneTweet: tInfoList)
		{
			array.put(new JSONObject().put("Category",oneTweet.getCategory().toString()));
		}

		/**
		 * "tweets": [{
		 * 		"category": cat,
		 * 		"location": loc,
		 * 		"text": txt
		 * }, {}]
		 * */
	}catch(Exception e){}
	return array;
}



}