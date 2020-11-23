package com.movietheater.info;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MoviePaxing {
	FileInputStream fis;
	InputStreamReader reader;
	BufferedReader buffr;
	File file;
	URL url;
	URI uri;

	public MoviePaxing() {
		url = this.getClass().getClassLoader().getResource("com/movietheater/file/movieInfo.xml");
		try {
			uri = url.toURI();
			file = new File(uri);

			parse();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void read() {
		try {
			fis = new FileInputStream(file);
			reader = new InputStreamReader(fis);
			buffr = new BufferedReader(reader);
			String data = null;
			while (true) {
				data = buffr.readLine();
				if (data == null)
					break;
				System.out.println(data);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parse() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(file, new MovieHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MoviePaxing();
	}
}
