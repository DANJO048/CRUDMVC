package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Josué Vásquez
 */
public class ConsultaVentas extends Conexion {
    public boolean registrarV(Ventas pro)
    {
        PreparedStatement psV = null;
        Connection conV = getConexion();
        String sqlV = "INSERT INTO ventas (nit, cliente, direccion, total_venta) VALUES (?,?,?,?)";
        
        try
        {
            psV = conV.prepareStatement(sqlV);
            psV.setString(1, pro.getNitV());
            psV.setString(2, pro.getClienteV());
            psV.setString(3, pro.getDireccionV());
            psV.setDouble(4, pro.getTotal_ventaV());
            psV.execute();
            return true;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return false;
        }
        finally
        {
            try
            {
                conV.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            } 
        }
    }
}
