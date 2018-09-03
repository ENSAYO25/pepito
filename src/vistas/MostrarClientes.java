package vistas;

import controlador.conexionMysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author APRENDIZ
 */
public class MostrarClientes extends javax.swing.JInternalFrame {
    // YA FUNCIONA ACTUALIZAR CC Y VALIDAR SI ESTA REPETIDA 
    String  aux,cedulatempo,ccoculta; // se agrego la variable ccoculta aqui por q en la tablamousclike tambien se carga 
    public String comandosql="Select * from clientes"; // SENTENCIA QUE SE EJECUTARA
    public String filtroEstado="ACTIVO";    // VARIABLE DE TIPO STRING CREADA PARA GUARDAR EL ESTADO DEL CLIENTE
   DefaultTableModel modeloejemplo; // Para configurar la tabla que se creo
   String NombresColumnas[]= new String[] {"CEDULA ","NOMBRE ","APELLIDO","TELEFONO","CORREO","DIRECCION","GENERO","ESTADO"};

    
 
    public MostrarClientes() throws SQLException {
      modeloejemplo= new DefaultTableModel(null,NombresColumnas);
        initComponents();
     //llenarTabla();
       MostrarInformacion();
    }
   
    public void limpiarTabla() // metodo para limpiar la tabla
    { int i,j=0,nfilas;// variables creadas de tipo entero
      nfilas=modeloejemplo.getRowCount();
      System.out.println("el numero de filas detectadas es" + nfilas);
      for(i=0;i<nfilas;i++)
    { modeloejemplo.removeRow(j); // borra la primera fila y despues de cada borrado
      System.out.println("vamos en el borrado "+i); // la primera fila cambia y sigue hasta 
    }      // borrar todas las filas de la tabla
    
      nfilas=modeloejemplo.getRowCount();
      EtiNumeroRegistros.setText("Hay "+nfilas+" registros en la tabla"); // nombre de la etiqueta que muestra el numero de registros  
    }  

    public void MostrarInformacion() // metodo para mostrar informacion
   {
    System.out.println("ESTOY DENTRO DE MOSTRAR INFORMACION");
    int nFilas=0; // variable creada inicializada que guardara el numero de filas exixtentes en la tabla

    try {
         conexionMysql ConectBD=new conexionMysql();      // CODIGO QUE PERMITE LA CONEXION CON LA BD  
         Statement sentencia = null;                      // st  se debe importar cada uno
         ResultSet resultado; //rs 
         Object nuevafila[]= new Object[8];                 // numero de columnas que tendra la tabla SEGUN EL REGISTROS QUE SE QUIERA MOSTRAR
              
         ConectBD.iniciarConexion();                       // el objeto inicia la conexion y se hace el llamado al metodo que se creo en el controlador
         Connection conn=ConectBD.getMyConnection();
         sentencia= conn.createStatement();
     
         resultado = sentencia.executeQuery(comandosql);       // SE GUARDA EL RESULTADO DE LA SENTENCIA SQL CREADA
         System.out.println("el comando que se ejecuta es"+comandosql);
         ResultSetMetaData meta = resultado.getMetaData();    // importar
         int columnas = meta.getColumnCount();               // SE CREA una variable entera y recibe  el numero de COLUMNAS
         System.out.println("aqui vamos...");
         System.out.println("estoy POR FUERA DEL while!!!!");
         while (resultado.next() )                           // ciclo  se ejecuta mientras que halla registros
         {  System.out.println("estoy dentro del while!!!!");
            for (int i = 0; i < columnas; i++)               // ciclo for que permite saber el numero de columnas
                {nuevafila[i]=resultado.getObject(i+1);     // se guarda la nueva fila 
                }        
                modeloejemplo.addRow(nuevafila);           // se guarda en el motodo modeloejemplo el numero de filas
                System.out.println("fin del for");         // MENSAJE DE SALIDA
            
         }
         ConectBD.Cerrar();                                // se cierra el metodo
        nFilas=modeloejemplo.getRowCount();                // SE guarda EL NUMERO DE FILAS ala variable nfilas
         EtiNumeroRegistros.setText("Hay "+nFilas+" registros en la tabla");  // se asigna ala etiqueta el numero de filas para mostrar
 //        JOptionPane.showMessageDialog(null,"La consulta fue realizada");
      } catch (SQLException ex) {
          Logger.getLogger(MostrarClientes .class.getName()).log(Level.SEVERE, null, ex); // se debe importar 
      }
    }
    
    public int ClienteExistente(String id) // metotod que permite validar si el id ya exixte en la BD para la insercion
    {
    int esta=0;
    
     String comandosql2="Select * from clientes where id_cliente= "+ id;
     Statement sentencia;
     ResultSet resultado;// GUARDA EL RESULTADO DE LA CONSULTA
     
         conexionMysql ConectBD1=new conexionMysql();// SE MODIFICA EL NOMBRE DEL OBJETO por que estamos en un mismo jframe
         ConectBD1.iniciarConexion();// el objeto inicia la conexion y se hace el llamado al metodo que se creo en el controlador
         Connection conn1=ConectBD1.getMyConnection();
        try {
            sentencia= conn1.createStatement();  // sin esta sentencia no funciona
            resultado = sentencia.executeQuery(comandosql2);
          //  ResultSetMetaData meta = resultado.getMetaData();
             while (resultado.next()) 
            { 
                esta=1;
              // JOptionPane.showMessageDialog(null, "El Id ya existe " +id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
         ConectBD1.Cerrar();
        return esta;
    }
    
     public void limpiarCajas(){//METODO PARA LIMPIAR LAS CAJAS
     
         caja6Direccion.setText("");
         caja2Nombre.setText("");
         caja3Apellido.setText("");
         caja4Telefono.setText("");
         caja5Correo.setText("");
         caja1Cedula.setText("");   
     }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnID = new javax.swing.JButton();
        btnNombre = new javax.swing.JButton();
        btnApellido = new javax.swing.JButton();
        EtiNumeroRegistros = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        caja1Cedula = new javax.swing.JTextField();
        caja2Nombre = new javax.swing.JTextField();
        caja3Apellido = new javax.swing.JTextField();
        caja4Telefono = new javax.swing.JTextField();
        caja5Correo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        caja6Direccion = new javax.swing.JTextField();
        btnActualizarDatos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboGenero = new javax.swing.JComboBox<>();
        jComboEstado = new javax.swing.JComboBox<>();
        btnEstado = new javax.swing.JToggleButton();
        btnLimpiarTabla = new javax.swing.JButton();
        btnRadioValidarcc = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        cedulaOculta = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MOSTRAR Y ACTUALIZAR CLIENTES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/refresh.png"))); // NOI18N

        jTable1.setModel(modeloejemplo);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnID.setText("CC");
        btnID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDActionPerformed(evt);
            }
        });

        btnNombre.setText("NOMBRE");
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });

        btnApellido.setText("APELLIDO");
        btnApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApellidoActionPerformed(evt);
            }
        });

        EtiNumeroRegistros.setText("jLabel1");

        jLabel1.setText("EDITE LOS DATOS QUE DESEE ACTUALIZAR");

        jLabel2.setText("CEDULA");

        caja1Cedula.setEnabled(false);
        caja1Cedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                caja1CedulaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                caja1CedulaFocusLost(evt);
            }
        });

        caja2Nombre.setToolTipText("Ingrese el nombre del Cliente");
        caja2Nombre.setNextFocusableComponent(caja3Apellido);
        caja2Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caja2NombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja2NombreKeyTyped(evt);
            }
        });

        caja3Apellido.setNextFocusableComponent(caja4Telefono);
        caja3Apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caja3ApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja3ApellidoKeyTyped(evt);
            }
        });

        caja4Telefono.setNextFocusableComponent(caja5Correo);
        caja4Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caja4TelefonoActionPerformed(evt);
            }
        });
        caja4Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja4TelefonoKeyTyped(evt);
            }
        });

        caja5Correo.setNextFocusableComponent(caja6Direccion);

        jLabel3.setText("NOMBRE");

        jLabel4.setText("APELLIDO");

        jLabel5.setText("TELEFONO");

        jLabel6.setText("EMAIL");

        jLabel7.setText("DIRECCIÓN");

        jLabel8.setText("GENERO");

        caja6Direccion.setNextFocusableComponent(jComboGenero);

        btnActualizarDatos.setText("ACTUALIZAR DATOS");
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });

        jLabel9.setText("ESTADO");

        jComboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        jComboGenero.setNextFocusableComponent(jComboEstado);

        jComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        jComboEstado.setNextFocusableComponent(btnActualizarDatos);

        btnEstado.setText("ACTIVO/INACTIVO");
        btnEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadoMouseClicked(evt);
            }
        });
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        btnLimpiarTabla.setText("LIMPIAR TABLA");
        btnLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTablaActionPerformed(evt);
            }
        });

        btnRadioValidarcc.setSelected(true);
        btnRadioValidarcc.setToolTipText("PERMITE ACTUALIZAR LA CEDULA");
        btnRadioValidarcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioValidarccMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/refresh (1).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caja2Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caja3Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caja4Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(caja1Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRadioValidarcc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(caja5Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(caja6Direccion)
                            .addComponent(jComboGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(103, 103, 103))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnNombre)
                .addGap(66, 66, 66)
                .addComponent(btnApellido)
                .addGap(32, 32, 32)
                .addComponent(btnEstado)
                .addGap(31, 31, 31)
                .addComponent(btnLimpiarTabla)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EtiNumeroRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(31, 31, 31)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnActualizarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addComponent(cedulaOculta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(EtiNumeroRegistros)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnID)
                    .addComponent(btnNombre)
                    .addComponent(btnApellido)
                    .addComponent(btnEstado)
                    .addComponent(btnLimpiarTabla))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cedulaOculta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caja5Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caja6Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jComboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(caja1Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(caja2Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnRadioValidarcc))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caja3Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(caja4Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarDatos)
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDActionPerformed
       comandosql="Select * from clientes where estadoClient='"+filtroEstado+"' order by id_cliente";
        //System.out.println("EL COMANDO ES "+comandosql);     
//  modeloejemplo.
     limpiarTabla();   
     MostrarInformacion();
    }//GEN-LAST:event_btnIDActionPerformed

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        comandosql="Select * from clientes where estadoClient='"+filtroEstado+"' order by nombreClient";
        limpiarTabla();   
        MostrarInformacion();
    }//GEN-LAST:event_btnNombreActionPerformed

    private void btnApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApellidoActionPerformed
         comandosql="Select * from clientes where estadoClient='"+filtroEstado+"' order by ApellidoClient";
        limpiarTabla();   
        MostrarInformacion();
    }//GEN-LAST:event_btnApellidoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int  filaElegida;
         System.out.println("La fila seleccionada es :"+jTable1.getSelectedRow()); // trae el numero de la fila donde se da click, se cuenta desde LA POSICION CERO
         System.out.println("El valor obtenido es :"+  modeloejemplo.getValueAt(jTable1.getSelectedRow(),0));
         ccoculta=(""+modeloejemplo.getValueAt(jTable1.getSelectedRow(),0)); // se carga la variable con la cc QUE TRAE LA la BD
         caja1Cedula.setText(""+modeloejemplo.getValueAt(jTable1.getSelectedRow(),0));
         caja2Nombre.setText(""+modeloejemplo.getValueAt(jTable1.getSelectedRow(),1));
         caja3Apellido.setText(""+modeloejemplo.getValueAt(jTable1.getSelectedRow(),2));
         caja4Telefono.setText(""+modeloejemplo.getValueAt(jTable1.getSelectedRow(),3));
         caja5Correo.setText(""+modeloejemplo.getValueAt(jTable1.getSelectedRow(),4));
         caja6Direccion.setText(""+modeloejemplo.getValueAt(jTable1.getSelectedRow(),5));
         jComboGenero.setSelectedItem(""+modeloejemplo.getValueAt(jTable1.getSelectedRow(),6));
         jComboEstado.setSelectedItem(""+modeloejemplo.getValueAt(jTable1.getSelectedRow(),7));
    }//GEN-LAST:event_jTable1MouseClicked

    private void caja4TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caja4TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caja4TelefonoActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        
        int esta=0;
        System.out.println("BTN ACTUALIZAR");
        if(btnRadioValidarcc.isSelected()==false)
        {
            esta=ClienteExistente(caja1Cedula.getText());
        }
        try{
            System.out.println("ESTOY EN EL TRY");
           // String cedulatempo= caja1Cedula.getText();
            String c="";
             if(caja1Cedula.getText().isEmpty()){  //codigo que permite validar que ningun campo este vacio 
                c=c+"No. cedula \n";
            }
            if(caja2Nombre.getText().isEmpty()){
                c=c+"No. nombre \n";
            }
            if(caja3Apellido.getText().isEmpty()){
                c=c+"  apellido";
            }
            if(caja4Telefono.getText().isEmpty()){
                c=c+"  telefono";
            }
            if(caja5Correo.getText().isEmpty()){
                c=c+"  Correo";
            }
            if(caja6Direccion.getText().isEmpty()){
                c=c+"  direccion";
            }
            if(esta==1){
                c=c+"  CEDULA REPETIDA";
            }
            if(caja1Cedula.getText().isEmpty() || caja2Nombre.getText().isEmpty() || caja3Apellido.getText().isEmpty() || caja4Telefono.getText().isEmpty() ||
               caja5Correo.getText().isEmpty() || caja6Direccion.getText().isEmpty() || esta==1){
                JOptionPane.showMessageDialog(null,"Faltó ingresar información en los siguientes campos: "+c+".","Falta de información",JOptionPane.CANCEL_OPTION);
           
            }else{
                
            conexionMysql ConectBD2=new conexionMysql();// se crea un objeto de la clase conexionMysql
            ConectBD2.iniciarConexion();// el objeto inicia la conexion y se hace el llamado al metodo que se creo en el controlador
            Connection conn2=ConectBD2.getMyConnection();// se crea una variable de
            CallableStatement sentenciaCargada = conn2.prepareCall("{call ACTUALIZAR_2(?,?,?,?,?,?,?,?,?)}"); // SE AGREGO OTRO parametro de emvio ccoculto
            sentenciaCargada.setString(1,ccoculta); // SE emvia al procedur la CC de la DB PARA EL UPDATE
            sentenciaCargada.setString(2,caja1Cedula.getText()); // SE emvia al preodur la cc   que INGRESEN 
            sentenciaCargada.setString(3,caja2Nombre.getText());
            sentenciaCargada.setString(4,caja3Apellido.getText());
            sentenciaCargada.setString(5,caja4Telefono.getText());
            sentenciaCargada.setString(6,caja5Correo.getText());
            sentenciaCargada.setString(7,caja6Direccion.getText());
            sentenciaCargada.setString(8,jComboGenero.getSelectedItem().toString());
            sentenciaCargada.setString(9,jComboEstado.getSelectedItem().toString());
            sentenciaCargada.execute();
            System.out.println("ANTES LIMPIAR TABLA");
            limpiarTabla();
            System.out.println("ANTES MOSTRAR INFORMACION");
            MostrarInformacion(); // mostrar la informacion ya actualizada
            JOptionPane.showMessageDialog(null,"Cliente "+ caja2Nombre.getText() +" fue actualizado");
            limpiarCajas();  // limpiar las cajas despues de actualizar
            ConectBD2.Cerrar();
           
            }
        }
            catch (SQLException ex) {
                System.out.println("ME FUI AL CATCH");
            Logger.getLogger(IngresarCliente.class.getName()).log(Level.SEVERE, null, ex);// nombre de la clase
        }
        
        //cedulaOculta.setText("");
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        // CODIGO QUE PERMITE VER LOS CLIENTES POR ESTADO activo inactivo
        if(btnEstado.isSelected()==true){
        filtroEstado="INACTIVO";//  NOTA validar el ingreso en mayuscula en la bd falta
        btnEstado.setText("VER SOLO INACTIVOS");
        }
        if(btnEstado.isSelected()==false)
        {
          filtroEstado="ACTIVO";
          btnEstado.setText("VER SOLO ACTIVOS");
        }
         limpiarTabla();
         MostrarInformacion();
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void btnEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadoMouseClicked
        
    }//GEN-LAST:event_btnEstadoMouseClicked

    private void btnLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTablaActionPerformed
       limpiarTabla(); // llamado al metodo para limpiar la tabla
    }//GEN-LAST:event_btnLimpiarTablaActionPerformed

    private void btnRadioValidarccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioValidarccMouseClicked
        // metodo para validar si el radio buton esta seleccionado para actualizar la CC
        if(btnRadioValidarcc.isSelected())
        { 
            caja1Cedula.enable(false);
        }
        else
        {cedulatempo=caja1Cedula.getText();// si la cc ya exite se le asigna lamisma cc
        caja1Cedula.enable(true);
        }
    }//GEN-LAST:event_btnRadioValidarccMouseClicked

    private void caja1CedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_caja1CedulaFocusLost
        // codigo que permite saber si la caja1Cedula esta seleccionada
        //JOptionPane.showMessageDialog(null,"TE HAS SALIDO DE LA CAJA CEDULA");
        int esta; // variable
      esta=  ClienteExistente(caja1Cedula.getText()); // se le asigna a la variable esta el metodo para saber si la cedula ya existe
        
        if(esta==1)
        {
           JOptionPane.showMessageDialog(null,"ESE NUMERO DE CEDULA, YA EXISTE");
           caja1Cedula.setText(cedulatempo); // si la la cc ya existe se asigna la misma cc a la caja1Cedula
        } 
                  
         btnRadioValidarcc.setSelected(true);
         caja1Cedula.enable(false);
    }//GEN-LAST:event_caja1CedulaFocusLost

    private void caja2NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja2NombreKeyTyped
        // TODO add your handling code here:
        char num = evt.getKeyChar();
        if (Character.isDigit(num)) { // codigo que permite el ingreso de solo TEXTO 
           evt.consume();
        }
  
    }//GEN-LAST:event_caja2NombreKeyTyped

    private void caja3ApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja3ApellidoKeyTyped
        // TODO add your handling code here:
        char num = evt.getKeyChar();
        if (Character.isDigit(num)) { // codigo que permite el ingreso de solo TEXTO 
           evt.consume();
        }
    }//GEN-LAST:event_caja3ApellidoKeyTyped

    private void caja4TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja4TelefonoKeyTyped
        // TODO add your handling code here:
         int num = evt.getKeyChar();
        if (Character.isAlphabetic(num)) { // codigo que permite el ingreso de solo NUMEROS
           evt.consume();
        }
    }//GEN-LAST:event_caja4TelefonoKeyTyped

    private void caja1CedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_caja1CedulaFocusGained
        // CUANDO ENTRO A LA CAJA
        
        //cedulatempo=caja1Cedula.getText();
        
    }//GEN-LAST:event_caja1CedulaFocusGained

    private void caja2NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja2NombreKeyReleased
        aux=caja2Nombre.getText().toUpperCase();
        caja2Nombre.setText(aux);
    }//GEN-LAST:event_caja2NombreKeyReleased

    private void caja3ApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja3ApellidoKeyReleased
        aux=caja3Apellido.getText().toUpperCase();
        caja3Apellido.setText(aux);
    }//GEN-LAST:event_caja3ApellidoKeyReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EtiNumeroRegistros;
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JButton btnApellido;
    private javax.swing.JToggleButton btnEstado;
    private javax.swing.JButton btnID;
    private javax.swing.JButton btnLimpiarTabla;
    private javax.swing.JButton btnNombre;
    private javax.swing.JRadioButton btnRadioValidarcc;
    private javax.swing.JTextField caja1Cedula;
    private javax.swing.JTextField caja2Nombre;
    private javax.swing.JTextField caja3Apellido;
    private javax.swing.JTextField caja4Telefono;
    private javax.swing.JTextField caja5Correo;
    private javax.swing.JTextField caja6Direccion;
    private javax.swing.JLabel cedulaOculta;
    private javax.swing.JComboBox<String> jComboEstado;
    private javax.swing.JComboBox<String> jComboGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
