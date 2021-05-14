package com.unab.edu.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.unab.edu.Conexion.ConexionBD;
import com.unab.edu.Entidades.Usuario;

public class ClsUsuario {
	

	ConexionBD conexion = new ConexionBD();
	Connection con = conexion.RetornarConexion();
	
	public boolean ValidarLogin(Usuario usu) {
		boolean verificar = false;
		try {
			CallableStatement consulta = con.prepareCall("call Sp_S_Login(?,?)");
			consulta.setString("PNombre", usu.getNombre());
			consulta.setString("PContrasena", usu.getContrasena());
			ResultSet resultado = consulta.executeQuery();
			System.out.println("Paso 1" + usu.getNombre());
			while(resultado.next()) {
				System.out.println("Paso 2");
				verificar = true;
			}
			System.out.println("Paso 3");
		} catch (Exception e) {
			System.out.println("> Usuario no encontrado.");
		}
		
		return verificar;
	}


}
