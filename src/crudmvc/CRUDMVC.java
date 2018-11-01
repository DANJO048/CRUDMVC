package crudmvc;

import Controlador.CtrlProducto;
import Controlador.CtrlVentas;
import Modelo.ConsultaVentas;
import Modelo.ConsultasProducto;
import Modelo.Producto;

import Modelo.Ventas;
import Vista.frmLogin;
import Vista.frmPreventa;
import Vista.frmProducto;
import Vista.frmRegistro;
import Vista.frmVentas;

/**
 *
 * @author Josué Vásquez
 */
public class CRUDMVC {

    public static void main(String[] args) {
        // TODO code application logic here
        
        /*Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        frmProducto frm = new frmProducto();
        
        Ventas modV = new Ventas();
        ConsultaVentas modVe = new ConsultaVentas();
        frmVentas frmV = new frmVentas();
        
        frmPreventa frmVe = new frmPreventa();*/
        
        //Usuarios usser = new Usuarios;
        //frmRegistro registro = new frmRegistro();
        //registro.setVisible(true);
        
        frmLogin Log = new frmLogin();
        Log.setTitle("LOGIN");
        Log.setLocationRelativeTo(null);
        Log.setVisible(true);
        
        /*CtrlProducto ctrl = new CtrlProducto(mod,modC,frm);
        ctrl.iniciar();
       //frm.setVisible(false);   
        
        //frmVe.setVisible(true);
        
        CtrlVentas ctrlV = new CtrlVentas(modV,modVe,frmV);
        ctrlV.iniciar();
        //frmV.setVisible(true);*/
        
    }
}
