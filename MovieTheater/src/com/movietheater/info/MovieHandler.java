package com.movietheater.info;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MovieHandler extends DefaultHandler {
	ArrayList<Movie> movieList;
	Movie movie;

	boolean isTitle;
	boolean isGenre;
	boolean isRating;
	boolean isRelease_date;
	boolean isStory;
	boolean isUrl;

	public void startDocument() throws SAXException {
	}

	public void startElement(String uri, String localName, String data, Attributes attributes) throws SAXException {
		
		if (data.equals("movies")) {
			movieList = new ArrayList<Movie>();
		} else if (data.equals("movie")) {
			movie = new Movie();
		} else if (data.equals("title")) {
			isTitle = true;
		} else if (data.equals("genre")) {
			isGenre = true;
		} else if (data.equals("rating")) {
			isRating = true;
		} else if (data.equals("release_date")) {
			isRelease_date = true;
		} else if (data.equals("story")) {
			isStory = true;
		} else if (data.equals("url")) {
			isUrl = true;
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length);

		if (isTitle) {
			movie.setTitle(data);
		} else if (isGenre) {
			movie.setGenre(data);
		} else if (isRating) {
			movie.setRating(data);
		} else if (isRelease_date) {
			movie.setRelease_date(data);
		} else if (isStory) {
			movie.setStory(data);
		} else if (isUrl) {
			movie.setUrl(data);
		}
	}

	public void endElement(String uri, String localName, String data) throws SAXException {
		
		if (data.equals("movie")) {
			movieList.add(movie);
		} else if (data.equals("title")) {
			isTitle = false;
		} else if (data.equals("genre")) {
			isGenre = false;
		} else if (data.equals("rating")) {
			isRating = false;
		} else if (data.equals("release_date")) {
			isRelease_date = false;
		} else if (data.equals("story")) {
			isStory = false;
		} else if (data.equals("url")) {
			isUrl = false;
		}
	}

	public void endDocument() throws SAXException {
		System.out.println("문서종료");
		for (Movie movie : movieList) {
			System.out.println("title:" + movie.getTitle());
			System.out.println("genre:" + movie.getGenre());
			System.out.println("rating:" + movie.getRating());
			System.out.println("release:" + movie.getRelease_date());
			System.out.println("story:" + movie.getStory());
			System.out.println("url:" + movie.getUrl());
			System.out.println("------------------------------------");
		}
		
	}
	public static void main(String[] args) {
		new MovieHandler();
	}

}
