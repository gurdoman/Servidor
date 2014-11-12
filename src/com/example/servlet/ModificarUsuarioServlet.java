package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.domain.GenericResponse;
import com.example.servicios.impl.UsuarioService;
import com.example.utils.ObtenerJson;

@WebServlet("/ModificarUsuarioServlet")
public class ModificarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModificarUsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioService us = new UsuarioService();
		GenericResponse gr = new GenericResponse();
		
		gr = us.modificar(ObtenerJson.getJson(request));
		
		PrintWriter out = response.getWriter();
        out.println(gr.getMensaje());
        
	}

}
