package com.example.utils;

import com.example.domain.Usuario;
import com.google.gson.Gson;

public class JsonParser {
	
	public static Usuario jsonAUsuario (String json) throws Exception{
		Gson gson = new Gson();
		Usuario u = gson.fromJson(json, Usuario.class);
		
		return u;
	}
	
	public static String usuarioAJson (Usuario u) throws Exception{
		Gson gson = new Gson();
		String json = gson.toJson(u);
		
		return json;
	}
	
}
