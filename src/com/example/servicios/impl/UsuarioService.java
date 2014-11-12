package com.example.servicios.impl;

import com.example.dao.UsuarioDao;
import com.example.domain.GenericResponse;
import com.example.domain.Usuario;
import com.example.servicios.IUsuariosService;
import com.example.utils.JsonParser;

public class UsuarioService implements IUsuariosService{

	@Override
	public String obtener(String json){
		try{
			UsuarioDao dao = new UsuarioDao();
			Usuario u = JsonParser.jsonAUsuario(json);
			GenericResponse gr = dao.leer(u);
			Usuario usrNv = (Usuario) gr.getObjeto();
			if(gr.isExito() && (usrNv.getPassword().equals(u.getPassword())))
				return JsonParser.usuarioAJson((Usuario) gr.getObjeto()); 
			else
				throw new Exception("Error el password no fue igual o la respuesta generica fue falsa");
		}catch (Exception e){
			System.out.println("Error: "+e.getMessage());
			return "Error inesperado";
		}
	}

	@Override
	public GenericResponse crear(String json){
		try{
			UsuarioDao dao = new UsuarioDao();
			Usuario u = JsonParser.jsonAUsuario(json);
			return dao.crear(u);
		}catch (Exception e){
			return new GenericResponse(false, "Error inesperado", -1, new Object());
		}
		
	}

	@Override
	public GenericResponse modificar(String json){
		try{
			UsuarioDao dao = new UsuarioDao();
			Usuario u = JsonParser.jsonAUsuario(json);
			return dao.modificar(u);
		}catch (Exception e){
			return new GenericResponse(false, "Error inesperado", -1, new Object());
		}
	}

	@Override
	public GenericResponse eliminar(String json) {
		try{
			UsuarioDao dao = new UsuarioDao();
			Usuario u = JsonParser.jsonAUsuario(json);
			return dao.eliminar(u);
		}catch (Exception e){
			return new GenericResponse(false, "Error inesperado", -1, new Object());
		}
	}

}
