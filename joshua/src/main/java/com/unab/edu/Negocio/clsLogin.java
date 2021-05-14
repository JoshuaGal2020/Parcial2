package com.unab.edu.Negocio;

import com.unab.edu.DAO.*;
import com.unab.edu.Entidades.*;

public class clsLogin {
	
	public int VerificarUsuario(Usuario usuario) {
		
		int Acceso = 0;
		ClsUsuario validacion = new ClsUsuario();
		
		var validar = validacion.ValidarLogin(usuario);
		
		if(validar == true) {
			Acceso = 1;
		}
		
		return Acceso;
	}

}
