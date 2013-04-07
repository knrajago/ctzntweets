package com.github.ctzntweets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TweetServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	
static final long serialVersionUID = 1L;
public TweetServlet() { super(); }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String latitude = request.getParameter("latitude");
	String longitude = request.getParameter("longitude");
	System.out.println(request.getRequestURL()+" "+latitude+" "+longitude);
	PrintWriter out = response.getWriter();
	response.setContentType("text/xml");
	out.println(getTweets(latitude,longitude));
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{}

private String getTweets(String latitude, String longitude)
{
	String xml=null;
	
	xml="<Tweets> " +
			"<Tweet>" +
			"<Lat>43.0517859</Lat>" +
			"<Lng>-89.51438399999999</Lng>" +
			"<Category>Bribe</Category>" +
			"<Text> Test Tweet </Text>" +
			"<Tweet>" +
			"</Tweets>";
	
	return xml;
}



}