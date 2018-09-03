/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.conexionMysql;
import modelo.Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class InsertarServiciosProced extends javax.swing.JInternalFrame {
    public static Connection connection;
    /**
     * Creates new form xd
     */
    public InsertarServiciosProced() throws SQLException {
        initComponents();
    }

    public void limpiarcajas() 
    {
    CajaIdServicio.setText("");
    CajaNombreServicio.setText("");
    CajaPrecio.setText("");        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel = new javax.swing.JLabel();
        jLabe2 = new javax.swing.JLabel();
        jLabe3 = new javax.swing.JLabel();
        CajaIdServicio = new javax.swing.JTextField();
        CajaNombreServicio = new javax.swing.JTextField();
        CajaPrecio = new javax.swing.JTextField();
        BtnInsertar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INSERTAR SERVICIOS ");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/spool-of-thread.png"))); // NOI18N

        jLabel.setText("ID SERVICIO");

        jLabe2.setText("NOMBRE SERVICIO");

        jLabe3.setText("PRECIO");

        CajaIdServicio.setToolTipText("Ingrese el ID SERVICIO");
        CajaIdServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CajaIdServicioKeyTyped(evt);
            }
        });

        CajaNombreServicio.setToolTipText("Ingrese el nombre del servicio");
        CajaNombreServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CajaNombreServicioKeyTyped(evt);
            }
        });

        CajaPrecio.setToolTipText("Ingrese el precio de el servicio");
        CajaPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CajaPrecioActionPerformed(evt);
            }
        });
        CajaPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CajaPrecioKeyTyped(evt);
            }
        });

        BtnInsertar2.setText("INSERTAR SERVICIO");
        BtnInsertar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertar2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/spool-of-thread (1).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel)
                        .addGap(86, 86, 86)
                        .addComponent(CajaIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabe3)
                                    .addComponent(jLabe2))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CajaNombreServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CajaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(BtnInsertar2)
                                .addGap(175, 175, 175)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel)
                            .addComponent(CajaIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabe2)
                            .addComponent(CajaNombreServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabe3)
                            .addComponent(CajaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26)
                .addComponent(BtnInsertar2)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int ServicioExistente(String Id) // metodo que permite validar si el id ya exixte en la BD para la insercion
    {
    int esta=0;
    
     String comandosql="SELECT * FROM `servicios` WHERE `idServicio`='"+Id+"'";
     Statement sentencia;
     ResultSet resultado;// GUARDA EL RESULTADO DE LA CONSULTA
     
         conexionMysql ConectBD1=new conexionMysql();// se crea un objeto de la clase conexionMysql
         ConectBD1.iniciarConexion();// el objeto inicia la conexion y se hace el llamado al metodo que se creo en el controlador
         Connection conn1=ConectBD1.getMyConnection();
        try {
            sentencia= conn1.createStatement();
            resultado = sentencia.executeQuery(comandosql);
          //  ResultSetMetaData meta = resultado.getMetaData();
             while (resultado.next()) 
            { 
                esta=1;
                JOptionPane.showMessageDialog(null, "El Id ya existe " +Id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertarServiciosProced.class.getName()).log(Level.SEVERE, null, ex);
        }
    return esta;
    }
    
    private void BtnInsertar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertar2ActionPerformed
        //METODO PARA EVITAR QUE LAS CAJAS NO SE ENVIEN VACIAS 
        int a;
        a=ServicioExistente(CajaIdServicio.getText());
        if (a==0){
        try{
            String c="";
            if(CajaIdServicio.getText().isEmpty()){
                c="IDSERVICIO";
            }
            if(CajaNombreServicio.getText().isEmpty()){
                c=c+",NOMBRE SERVICIO";
            }
            if(CajaPrecio.getText().isEmpty()){
                c=c+", PRECIO";
            }
            if(CajaIdServicio.getText().isEmpty() || CajaNombreServicio.getText().isEmpty() || CajaPrecio.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null,"Faltó ingresar información en los siguientes campos: "+c+".","Falta de información",JOptionPane.CANCEL_OPTION);
            limpiarcajas();
            }else{
            Clientes C;    
            
            conexionMysql ConectBD=new conexionMysql();// se crea un objeto de la clase conexionMysql
            ConectBD.iniciarConexion();// el objeto inicia la conexion y se hace el llamado al metodo que se creo en el controlador
            Connection conn=ConectBD.getMyConnection();// se crea una variable de
            CallableStatement sentenciaCargada = conn.prepareCall("{call INSERTAR_SERVICIOS(?,?,?)}");
            sentenciaCargada.setString(1,CajaIdServicio.getText()); // .registerOutParameter(CajitaIdpaciente.getText(), java.sql.Types.VARCHAR);
            sentenciaCargada.setString(2,CajaNombreServicio.getText());
            sentenciaCargada.setString(3,CajaPrecio.getText());
           // sentenciaCargada.setFloat(title, TOP_ALIGNMENT); .setString(3,CajaPrecio.getText());
            sentenciaCargada.execute();
            JOptionPane.showMessageDialog(null,"Servicio "+ CajaNombreServicio.getText() +" fue almacenado");
            ConectBD.Cerrar();
            limpiarcajas();
            }
        }
          catch (SQLException ex) {
          Logger.getLogger(InsertarServiciosProced.class.getName()).log(Level.SEVERE, null, ex);// nombre de la clase
         }
        }
    }//GEN-LAST:event_BtnInsertar2ActionPerformed
    
 
    private void CajaIdServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CajaIdServicioKeyTyped
        // TODO add your handling code here:
        char letra = evt.getKeyChar(); 
        if( !(Character.isDigit(letra))){  
       //getToolkit().beep();  
       evt.consume();}
    }//GEN-LAST:event_CajaIdServicioKeyTyped

    private void CajaNombreServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CajaNombreServicioKeyTyped
        // TODO add your handling code here:
        char letra = evt.getKeyChar(); 
        
        if( (Character.isWhitespace(letra)) ||  (Character.isAlphabetic(letra)) )
        {  
        }
        else
        {   //getToolkit().beep();  
            evt.consume();
        }
    }//GEN-LAST:event_CajaNombreServicioKeyTyped

    private void CajaPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CajaPrecioKeyTyped
        // TODO add your handling code here:
         char letra = evt.getKeyChar(); 
        if( !(Character.isDigit(letra))){  
       //getToolkit().beep();  
       evt.consume();}
        
        char tecla = evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            BtnInsertar2.doClick();
            CajaIdServicio.setText("");
            CajaNombreServicio.setText("");
            CajaPrecio.setText("");
        }
    }//GEN-LAST:event_CajaPrecioKeyTyped

    private void CajaPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CajaPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CajaPrecioActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInsertar2;
    private javax.swing.JTextField CajaIdServicio;
    private javax.swing.JTextField CajaNombreServicio;
    private javax.swing.JTextField CajaPrecio;
    private javax.swing.JLabel jLabe2;
    private javax.swing.JLabel jLabe3;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
