/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo;

hola 

//import Controlador1.ConexionMySql;
//import Modelos.Servicios;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADSI
 */
public class ActualizarServicios extends javax.swing.JInternalFrame {
    
public String comandosql="Select * from servicios";
DefaultTableModel TablaServicios; //Crea la Matris de la tabla
String NombresColumnas[]= new String[] {"ID SERVICIO","NOMBRE SERVICIO","PRECIO"};
    
    /**
     * Creates new form ActualizarServicios
     * @throws java.sql.SQLException
     */
    public ActualizarServicios() throws SQLException {
        TablaServicios=new DefaultTableModel(null,NombresColumnas);
      //  TablaServicios= new DefaultTableModel(null,)
        initComponents();
        MostrarInformacion();
    }
    
    public void limpiarcajas()//Limpia Cajas
    {
    CajaID.setText("");
    CajaNombreServic.setText("");
    CajaPrec.setText("");        
    }
    
    public void limpiarTabla()//Limpiar la Tabla
    {   int i,j=0,nfilas;
        nfilas=TablaServicios.getRowCount();
        System.out.println("el numero de filas detectadas es" + nfilas);
        for(i=0;i<nfilas;i++)
    {   TablaServicios.removeRow(j); // borra la primera fila y despues de cada borrado
        System.out.println("vamos en el borrado "+i); // la primera fila cambia y sigue hasta 
    }      // borrar todas las filas de la tabla
    
        nfilas=TablaServicios.getRowCount();
        etiNumFilas.setText("Hay "+nfilas+" registros en la tabla");    
    }        

    private void MostrarInformacion() {//Refresca la Informaciond de la Tabla
        int nFilas=0;
        try{
            ConexionMySql ConectBD=new ConexionMySql();
            Statement sentencia;
            ResultSet resultado;
            Object nuevafila[]= new Object[3]; //3 filas
            
            ConectBD.iniciarConexion();
            Connection conn=ConectBD.getMyConnection();
            sentencia= conn.createStatement();
            
            // JOptionPane.showMessageDialog(null,"La consulta sera"+comandosql);
            resultado = sentencia.executeQuery(comandosql);
            ResultSetMetaData meta = resultado.getMetaData();
            int columnas = meta.getColumnCount();  //Mientras haya registros 
            System.out.println("aqui vamos...");
            
            while (resultado.next()) 
            {  System.out.println("estoy dentro del while");
           /*
            nuevafila[0]=resultado.getObject(1);
            nuevafila[1]=resultado.getObject(2);
            nuevafila[2]=resultado.getObject(3);
            nuevafila[3]=resultado.getObject(4); */
            for (int i = 0; i < columnas; i++) 
                {nuevafila[i]=resultado.getObject(i+1);
                }        
                TablaServicios.addRow(nuevafila);
                System.out.println("fin del for");
            }
        ConectBD.Cerrar();
        nFilas=TablaServicios.getRowCount();
        etiNumFilas.setText("Hay "+nFilas+" registros en la tabla");
 //        JOptionPane.showMessageDialog(null,"La consulta fue realizada");
      } catch (SQLException ex) {
          Logger.getLogger(ActualizarServicios.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        OrdenId = new javax.swing.JButton();
        OrdenNombre = new javax.swing.JButton();
        OrdenPrecio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CajaNombreServic = new javax.swing.JTextField();
        CajaPrec = new javax.swing.JTextField();
        ActuServic = new javax.swing.JButton();
        etiNumFilas = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CajaID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ACTUALIZAR SERVICIOS");
        setToolTipText("");

        jTable1.setModel(TablaServicios);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        OrdenId.setBackground(new java.awt.Color(255, 255, 0));
        OrdenId.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        OrdenId.setForeground(new java.awt.Color(51, 51, 51));
        OrdenId.setText("POR ID");
        OrdenId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenIdActionPerformed(evt);
            }
        });

        OrdenNombre.setBackground(new java.awt.Color(255, 255, 0));
        OrdenNombre.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        OrdenNombre.setForeground(new java.awt.Color(0, 0, 0));
        OrdenNombre.setText("POR NOMBRE");
        OrdenNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenNombreActionPerformed(evt);
            }
        });

        OrdenPrecio.setBackground(new java.awt.Color(255, 255, 0));
        OrdenPrecio.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        OrdenPrecio.setForeground(new java.awt.Color(0, 0, 0));
        OrdenPrecio.setText("POR PRECIO");
        OrdenPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenPrecioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("FILTRAR POR:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CAMPOS PARA ACTUALIZAR");

        CajaNombreServic.setEnabled(false);

        CajaPrec.setEnabled(false);

        ActuServic.setBackground(new java.awt.Color(153, 255, 153));
        ActuServic.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        ActuServic.setForeground(new java.awt.Color(0, 0, 0));
        ActuServic.setText("ACTUALIZAR SERVICIO");
        ActuServic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActuServicActionPerformed(evt);
            }
        });

        etiNumFilas.setText("#Cajas");

        jLabel3.setText("ID del Servicio:");

        jLabel4.setText("Nombre del Servicio");

        jLabel5.setText("Precio del Servicio");

        CajaID.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("ELIMINAR SERVICIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(OrdenId))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(CajaNombreServic)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(OrdenNombre)
                                                .addGap(46, 46, 46)
                                                .addComponent(OrdenPrecio)
                                                .addGap(10, 10, 10)))
                                        .addGap(26, 26, 26)
                                        .addComponent(ActuServic)
                                        .addGap(24, 24, 24))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CajaPrec, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CajaID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(etiNumFilas)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiNumFilas)
                    .addComponent(jButton1))
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrdenId)
                    .addComponent(OrdenNombre)
                    .addComponent(OrdenPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CajaNombreServic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ActuServic)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CajaPrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(CajaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OrdenIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenIdActionPerformed
        // Ordenar datos de la Tabla por el ID del Servicio
        comandosql="Select * from servicios order by idServicio";
        limpiarTabla();
        MostrarInformacion();
    }//GEN-LAST:event_OrdenIdActionPerformed

    private void OrdenNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenNombreActionPerformed
        // Ordenar datos de la Tabla por el Nombre del Servicio
        comandosql="Select * from servicios order by nombreServicio";
        limpiarTabla();
        MostrarInformacion();
    }//GEN-LAST:event_OrdenNombreActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Al dar Clic en alguna de las columnas de la Tabla Servicios los datos de esa columna se enviaran a las Cajas Correspondientes para actualizar.
        CajaNombreServic.enable();
        CajaPrec.enable();
        int filaElegida;
        System.out.println("La fila seleccionada es :"+jTable1.getSelectedRow());
        System.out.println("El valor obtenido es :"+ TablaServicios.getValueAt(jTable1.getSelectedRow(),0));
        CajaID.setText(""+TablaServicios.getValueAt(jTable1.getSelectedRow(),0));
        CajaNombreServic.setText(""+TablaServicios.getValueAt(jTable1.getSelectedRow(),1));
        CajaPrec.setText(""+TablaServicios.getValueAt(jTable1.getSelectedRow(),2));
    }//GEN-LAST:event_jTable1MouseClicked

    private void OrdenPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenPrecioActionPerformed
        // Ordenar datos de la Tabla por el Precio del Servicio
        comandosql="Select * from servicios order by precio";
        limpiarTabla();
        MostrarInformacion();
    }//GEN-LAST:event_OrdenPrecioActionPerformed

    public int ServicioExistente(String Nombre) // Metodo que permite validar si el Nombre ya exixte en la BD para la actualizacion
    {
    int esta=0;
     String comandosql="SELECT * FROM `servicios` WHERE `nombreServicio`='"+Nombre+"'";
     Statement sentencia;
     ResultSet resultado;// GUARDA EL RESULTADO DE LA CONSULTA
     
         ConexionMySql ConectBD1=new ConexionMySql();// se crea un objeto de la clase conexionMysql
         ConectBD1.iniciarConexion();// el objeto inicia la conexion y se hace el llamado al metodo que se creo en el controlador
         Connection conn1=ConectBD1.getMyConnection();
        try {
            sentencia= conn1.createStatement();
            resultado = sentencia.executeQuery(comandosql);
          //  ResultSetMetaData meta = resultado.getMetaData();
             while (resultado.next()) 
            { 
                esta=1;
                JOptionPane.showMessageDialog(null, "El Nombre ya existe " +Nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActualizarServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
    return esta;
    }
    
    
    private void ActuServicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActuServicActionPerformed
        // TODO add your handling code here:
        int a;
        a=ServicioExistente(CajaNombreServic.getText());
        if (a==0){
        try{
            String c="";
            if(CajaNombreServic.getText().isEmpty()){
                c=c+" Nombre Servicio";
            }
            if(CajaPrec.getText().isEmpty()){
                c=c+", Precio";
            }
            if(CajaNombreServic.getText().isEmpty() || CajaPrec.getText().isEmpty() ){ //Validar las Cajas para que no se envien Vacias
                JOptionPane.showMessageDialog(null,"Faltó ingresar información en los siguientes campos: "+c+".","Falta de información",JOptionPane.CANCEL_OPTION);
            }else{   
            Servicios C; 
            ConexionMySql ConectBD2=new ConexionMySql();// se crea un objeto de la clase conexionMysql
            ConectBD2.iniciarConexion();// el objeto inicia la conexion y se hace el llamado al metodo que se creo en el controlador
            Connection conn2=ConectBD2.getMyConnection();// se crea una variable de
            CallableStatement sentenciaCargada = conn2.prepareCall("{call ACTUALIZAR_SERVICIOS(?,?,?)}");
            sentenciaCargada.setString(1,CajaID.getText());
            sentenciaCargada.setString(2,CajaNombreServic.getText());
            sentenciaCargada.setString(3,CajaPrec.getText());
            // sentenciaCargada.setFloat(title, TOP_ALIGNMENT); .setString(3,CajaPrecio.getText());
            sentenciaCargada.execute();
            JOptionPane.showMessageDialog(null,"Servicio "+ CajaNombreServic.getText() +" fue actualizado");
            ConectBD2.Cerrar();
            limpiarcajas();
            }
        }
          catch (SQLException ex) {
          Logger.getLogger(ActualizarServicios.class.getName()).log(Level.SEVERE, null, ex);// nombre de la clase
        }
      }
    }//GEN-LAST:event_ActuServicActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActuServic;
    private javax.swing.JTextField CajaID;
    private javax.swing.JTextField CajaNombreServic;
    private javax.swing.JTextField CajaPrec;
    private javax.swing.JButton OrdenId;
    private javax.swing.JButton OrdenNombre;
    private javax.swing.JButton OrdenPrecio;
    private javax.swing.JLabel etiNumFilas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
