package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.domain.GenericResponse;
import com.example.domain.Usuario;

public class UsuarioDao {

	public GenericResponse crear (Usuario u){
		GenericResponse gr = new GenericResponse();
		SessionFactory sf = SessionFactoryUtil.createSessionFactory();
		Session ss = sf.openSession();
		ss.beginTransaction();
		try{
			ss.save(u);
			ss.getTransaction().commit();
			gr.setExito(true);
			gr.setMensaje("Usuario creado con exito");
			gr.setCodigo(1000);
		}catch(org.hibernate.exception.ConstraintViolationException ex){
			System.out.println("ConstraintViolationException");
			System.out.println("Mensaje de error: "+ex.getCause());
			gr.setExito(false);
			gr.setMensaje("Ese email ya esta registrado");
			gr.setCodigo(-2);
		}catch(Exception e){
			System.out.println("Error inesperado");
			System.out.println("Mensaje de error: "+e.getCause());
			gr.setExito(false);
			gr.setMensaje("Error inesperado");
			gr.setCodigo(-1);
		}finally{
			ss.close();
		}
		return gr;
	}
	
	public GenericResponse modificar(Usuario u){
		GenericResponse gr = new GenericResponse();
		SessionFactory sf = SessionFactoryUtil.createSessionFactory();
		Session ss = sf.openSession();
		ss.beginTransaction();
		try{
			ss.update(u);
			ss.getTransaction().commit();
			gr.setExito(true);
			gr.setMensaje("Usuario modificado con exito");
			gr.setCodigo(1000);
		}catch(Exception e){
			System.out.println("Error inesperado");
			System.out.println("Mensaje de error: "+e.getCause());
			gr.setExito(false);
			gr.setMensaje("Error inesperado");
			gr.setCodigo(-1);
		}finally{
			ss.close();
		}
		return gr;
	}
	
	public GenericResponse leer(Usuario u){
		GenericResponse gr = new GenericResponse();
		Usuario dbUsr = new Usuario();
		SessionFactory sf = SessionFactoryUtil.createSessionFactory();
		Session ss = sf.openSession();
		ss.beginTransaction();
		try{
			dbUsr = (Usuario) ss.get(Usuario.class, u.getEmail());
			ss.getTransaction().commit();
			gr.setExito(true);
			gr.setMensaje("Usuario creado con exito");
			gr.setCodigo(1000);
			gr.setObjeto(dbUsr);
		}catch(Exception e){
			System.out.println("Error inesperado");
			System.out.println("Mensaje de error: "+e.getCause());
			gr.setExito(false);
			gr.setMensaje("Error inesperado");
			gr.setCodigo(-1);
		}finally{
			ss.close();
		}
		return gr;
	}
	
	public GenericResponse eliminar(Usuario u){
		GenericResponse gr = new GenericResponse();
		SessionFactory sf = SessionFactoryUtil.createSessionFactory();
		Session ss = sf.openSession();
		ss.beginTransaction();
		try{
			ss.delete(u);
			ss.getTransaction().commit();
			gr.setExito(true);
			gr.setMensaje("Usuario eliminado con exito");
			gr.setCodigo(1000);
		}catch(Exception e){
			System.out.println("Error inesperado");
			System.out.println("Mensaje de error: "+e.getCause());
			gr.setExito(false);
			gr.setMensaje("Error inesperado");
			gr.setCodigo(-1);
		}finally{
			ss.close();
		}
		return gr;
	}
}
