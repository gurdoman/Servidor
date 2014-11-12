package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servicios.impl.UsuarioService;
import com.example.utils.ObtenerJson;

@WebServlet("/BuscarUsuarioServlet")
public class BuscarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarUsuarioServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioService us = new UsuarioService();
		
		String json = us.obtener(ObtenerJson.getJson(request));
		
		PrintWriter out = response.getWriter();
        out.println(json);
	}

}
