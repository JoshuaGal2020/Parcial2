package com.unab.edu.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.unab.edu.Conexion.ConexionBD;
import com.unab.edu.Entidades.Consulta;

public class ClsConsulta {
	
	ConexionBD conexion = new ConexionBD();
    Connection con = conexion.RetornarConexion();
    
    public ArrayList<Consulta> ListadoUSUARIOS() {
        ArrayList<Consulta> Lista = new ArrayList<>();

        try {

            CallableStatement consulta = con.prepareCall("call Sp_S_MostrarConsulta()");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
               Consulta user = new Consulta();
                user.setId(rs.getInt("Id"));
                user.setNombre(rs.getString("Nombre"));
                user.setApellido(rs.getString("Apellido"));
                Lista.add(user);
            }
        } catch (Exception e) {
            System.out.println("ERROR AQUI :v" + e);
        }

        return Lista;
    }
	public void EliminarConsulta(Consulta consulta) {
		
		try {
			CallableStatement statement = con.prepareCall("call Sp_D_consulta(?)");
			statement.setInt("Pid", consulta.getId());
			statement.executeQuery();
			System.out.println("Eliminado Exitoso");
			con.close();
			
		} catch (Exception e) {
			System.out.println("Hubo un error en ConsultaDAO/EliminarConsulta " + e);
		}
	}

}
