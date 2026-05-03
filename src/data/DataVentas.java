package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import conexion.Conexion;
import entidades.Ventas;

public class DataVentas {
	Conexion c = new Conexion();

	public int insertarVenta(Ventas v) {
		PreparedStatement ps = null;
		try {
			ps = c.conectar().prepareStatement("INSERT INTO ventas VALUES(null,null,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, v.getCliente());
			ps.setDouble(2, v.getTotal());
			ps.setString(3, v.getMetodo());
			ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			 
			 if(rs.next()) {
				 return rs.getInt(1);
					 }
					
				 
			 

		} catch (Exception e) {
			
			
		}
		return 0;
		
	}

}
