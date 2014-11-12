package com.example.servicios;

import com.example.domain.GenericResponse;

public interface IUsuariosService {
	public String obtener(String json);
	public GenericResponse crear (String json);
	public GenericResponse modificar(String json);
	public GenericResponse eliminar(String json);
}
