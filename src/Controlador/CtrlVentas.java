package Controlador;

import Modelo.ConsultaVentas;
import Modelo.Ventas;
import Vista.frmVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Josué Vásquez
 */
public class CtrlVentas implements ActionListener {
    private Ventas modV;
    private ConsultaVentas modVe;
    private frmVentas frmV;
    
    public CtrlVentas (Ventas modV, ConsultaVentas modVe, frmVentas frmV)
    {
        this.modV = modV;
        this.modVe = modVe;
        this.frmV = frmV;
        this.frmV.btnFacturarVenta.addActionListener(this);
    }
    
    public void iniciar()
    {
        frmV.setTitle("Ventas");
        frmV.setLocationRelativeTo(null);
        frmV.txtFactura.setEnabled(false);
    }
    
    @Override
    public void actionPerformed (ActionEvent o)
    {
        if(o.getSource()==frmV.btnFacturarVenta)
        {
            modV.setNitV(frmV.txtNitV.getText());
            modV.setClienteV(frmV.txtClienteV.getText());
            modV.setDireccionV(frmV.txtDireccionV.getText());
            modV.setTotal_ventaV(Double.parseDouble(frmV.txtTotalVentaV.getText()));
            
            if(modVe.registrarV(modV))
            {
                JOptionPane.showMessageDialog(null, "Venta Realizada Exitosamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al realizar Venta");                     
            }
        }
    }
}
