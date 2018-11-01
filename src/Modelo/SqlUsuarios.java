package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Josué Vásquez
 */
public class SqlUsuarios extends Conexion{
    
    public boolean registrar(Usuarios usr)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO usuarios (usuario, password, nombre, correo, idTipo) VALUES(?,?,?,?,?)";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getCorreo());
            ps.setInt(5, usr.getIdTipo());
            ps.execute();
            return true;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally 
        {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } 
    }
    public int existeUsuario(String usuario)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT count(id) FROM usuarios WHERE usuario=?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if(rs.next())
            {
                return rs.getInt(1);
            }
            return 1;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        finally 
        {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } 
    }
        
    public boolean login(Usuarios usr)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT u.id, u.usuario, u.password, u.nombre, u.idTipo, t.nombre FROM usuarios AS u INNER JOIN  tipo_usuario AS t ON u.idTipo=t.id WHERE usuario=?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            if(rs.next())
            {
                if(usr.getPassword().equals(rs.getString(3)))
                {
                    String sqlUpdate = "UPDATE usuarios SET last_session = ? WHERE id = ? ";
                    ps = con.prepareStatement(sqlUpdate);
                    ps.setString(1, usr.getLast_session());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();
                    
                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setIdTipo(rs.getInt(5));
                    usr.setNombre_tipo(rs.getString(6));
                    return true;
                }
                else
                {
                    return false;
                }
            }
            return false;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally 
        {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } 
    }
    
    public boolean esEmail(String correo)
    {
        //Patron para validar el correo
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }
}
