package com.example.utils;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class ObtenerJson {
	public static String getJson(HttpServletRequest request) throws IOException{
		
		int length = request.getContentLength();
        byte[] input = new byte[length];
        ServletInputStream sin = request.getInputStream();
        int c, count = 0 ;
        while ((c = sin.read(input, count, input.length-count)) != -1) {
            count +=c;
        }
        sin.close();
        return new String(input);
	}
}
