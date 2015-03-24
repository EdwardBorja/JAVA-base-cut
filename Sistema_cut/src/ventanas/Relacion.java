/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edward
 */
public class Relacion extends javax.swing.JFrame {

    
    private String Tipo = "";
    private Clip clip;
    private String path="/Audio/";
    
    /**
     * Creates new form Relaion
     */
    public Relacion() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        actualizar();
        actualizarestudiante();
        actualizarmateria();
                
        
    }
    
     public void actualizar(){
     //ACTUALIZA TA LABLA
        //---------------------------------------------------------------------------
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ResultSetMetaData metadata= null;

        try{
            //establece el modelo de la tabla.
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTable1.setModel(modelo);
            //conectarse con la base de datos.
            String url = "jdbc:mysql://localhost:3306/sistema";
            String usuario = "root";
            String contraseña = "123";
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Relacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Relacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Relacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            //establece los valores de conexion.
            con = DriverManager.getConnection(url,usuario,contraseña);
            if ( con != null )
            System.out.println("Se ha establecido una conexión a la base de datos \n " + url );
            //ejecuta la consulta.
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM relacionem");
            //+ "// WHERE(`nombre`='usuario')");
        //obtiene informacion de la columnas.
        metadata = rs.getMetaData();
        //cantidad de columnas que tiene la tabla.

        int cantidadColumnas = metadata.getColumnCount();
        //establece el num de columnas
        for (int i = 1; i <= cantidadColumnas; i++) {
            modelo.addColumn(metadata.getColumnLabel(i));
        }while (rs.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i]=rs.getObject(i+1);
            }

            modelo.addRow(fila);
        }rs.close();
        con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
     
    
      public void actualizarmateria(){
     //ACTUALIZA TA LABLA
        //---------------------------------------------------------------------------
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ResultSetMetaData metadata= null;

        try{
            //establece el modelo de la tabla.
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTable2.setModel(modelo);
            //conectarse con la base de datos.
            String url = "jdbc:mysql://localhost:3306/sistema";
            String usuario = "root";
            String contraseña = "123";
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
            }
            //establece los valores de conexion.
            con = DriverManager.getConnection(url,usuario,contraseña);
            if ( con != null )
            System.out.println("Se ha establecido una conexión a la base de datos \n " + url );
            //ejecuta la consulta.
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT distinct (materia),codigo_materia FROM materias");
            //+ "// WHERE(`nombre`='usuario')");
        //obtiene informacion de la columnas.
        metadata = rs.getMetaData();
        //cantidad de columnas que tiene la tabla.

        int cantidadColumnas = metadata.getColumnCount();
        //establece el num de columnas
        for (int i = 1; i <= cantidadColumnas; i++) {
            modelo.addColumn(metadata.getColumnLabel(i));
        }while (rs.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i]=rs.getObject(i+1);
            }

            modelo.addRow(fila);
        }rs.close();
        con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
      
       public void actualizarestudiante(){
     //ACTUALIZA TA LABLA
        //---------------------------------------------------------------------------
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ResultSetMetaData metadata= null;

        try{
            //establece el modelo de la tabla.
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTable3.setModel(modelo);
            //conectarse con la base de datos.
            String url = "jdbc:mysql://localhost:3306/sistema";
            String usuario = "root";
            String contraseña = "123";
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
            }
            //establece los valores de conexion.
            con = DriverManager.getConnection(url,usuario,contraseña);
            if ( con != null )
            System.out.println("Se ha establecido una conexión a la base de datos \n " + url );
            //ejecuta la consulta.
            stmt = con.createStatement();
            rs = stmt.executeQuery("select distinct (estudiantes.codigo_estudiante),nombre,carrera,turno,semestre,materia,horario_inicio,horario_fin from estudiantes inner join relacionem inner join materias where estudiantes.codigo_estudiante=relacionem.codigo_estudiante and relacionem.codigo_materia=materias.codigo_materia and relacionem.codigo_materia=materias.codigo_materia");
            //+ "// WHERE(`nombre`='usuario')");root    123
            
        //obtiene informacion de la columnas.
        metadata = rs.getMetaData();
        //cantidad de columnas que tiene la tabla.

        int cantidadColumnas = metadata.getColumnCount();
        //establece el num de columnas
        for (int i = 1; i <= cantidadColumnas; i++) {
            modelo.addColumn(metadata.getColumnLabel(i));
        }while (rs.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i]=rs.getObject(i+1);
            }

            modelo.addRow(fila);
        }rs.close();
        con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
      
      
     public void sonido(String value)
    {        
       try
       {
   clip=AudioSystem.getClip();
   clip.open(AudioSystem.getAudioInputStream( getClass().getResourceAsStream( path +  value +".wav" ) ) );
          clip.start();
       }catch(Exception ex){
    System.err.println( ex.getMessage() );
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cmat = new javax.swing.JTextField();
        cest = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Relacion");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/panel-del-menu-de-la-ventana-icono-6573-32 - copia.png"))); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 112, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 220, 380));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/add.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 139, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/del.png"))); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 139, -1));

        cmat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmatKeyTyped(evt);
            }
        });
        getContentPane().add(cmat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 192, -1));

        cest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cestActionPerformed(evt);
            }
        });
        cest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cestKeyTyped(evt);
            }
        });
        getContentPane().add(cest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 191, -1));

        jLabel1.setText("Codigo materia:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel2.setText("Codigo Estudiante:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/edit.png"))); // NOI18N
        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 139, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/borra.png"))); // NOI18N
        jButton5.setText("Borrar campos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/exit.png"))); // NOI18N
        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 440, 110, 40));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 330, 170));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 590, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sonido("mous");
         dispose();
         Menu men1=new Menu();
         men1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cmat.getText().equals("") || cest.getText().equals("")){JOptionPane.showMessageDialog(null,"Hay campos vacios");
          }else{
        
        String Codigomat,Codigoest;
        

        Codigomat=cmat.getText();
        Codigoest=cest.getText();

        Connection con = null;
        Statement  stmt = null;
        ResultSet rs;

        try {
            String url = "jdbc:mysql://localhost:3306/sistema";
            String usuario = "root";
            String contrasena = "123";
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Relacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Relacion.class.getName()).log(Level.SEVERE, null, ex);
            }

            con = DriverManager.getConnection(url,usuario,contrasena);
            if ( con != null )
            System.out.println("Se ha establecido una conexión a la base de datos " +
                "\n " + url );

            stmt = con.createStatement();
            
             rs = stmt.executeQuery("SELECT * FROM relacionem WHERE `codigo_materia`='" + Codigomat + "' and `codigo_estudiante`='" + Codigoest + "'  ");
             
             
              if(!rs.next()){
            stmt.executeUpdate("INSERT INTO relacionem VALUES ( '" + Codigomat + "','" + Codigoest + "')");

            sonido("bleep");
            JOptionPane.showMessageDialog(null,"Se agregó la informacion exitosamente");
            }else{ JOptionPane.showMessageDialog(null,"ya existe");}
         
              System.out.println("Los valores han sido agregados a la base de datos ");
        }
        catch( SQLException e ) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Relacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        finally {
            if ( con != null ) {
                try    {
                    con.close();
                    stmt.close();
                } catch( Exception e ) {
                    System.out.println( e.getMessage());
                }
            }
        }

        cmat.setText("");
        cest.setText("");
      

        actualizar();
        actualizarmateria();
        actualizarestudiante();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(cmat.getText().equals("") || cest.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona un elemento de la tabla");
          }else{
        
        DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
        //Selecciona el valor de la columna 1
        String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));

        sonido("error");

        int x = JOptionPane.showConfirmDialog(null,"¿Estas seguro de eliminar?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){

            sonido("bleep");
            
            Connection con = null;
            Statement  stmt = null;

            try {
                String url = "jdbc:mysql://localhost:3306/sistema";
                String usuario = "root";
                String contrasena = "123";
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
                }

                con = DriverManager.getConnection(url,usuario,contrasena);
                if ( con != null )
                System.out.println("Se ha establecido una conexión a la base de datos " +
                    "\n " + url );
                stmt = con.createStatement();

                stmt.executeUpdate("DELETE FROM `relacionem` WHERE (`codigo_materia`='" + valor1 + "')");

            }
            catch( SQLException e ) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
            }

            finally {
                if ( con != null ) {
                    try    {
                        con.close();
                        stmt.close();
                    } catch( Exception e ) {
                        System.out.println( e.getMessage());
                    }
                }
            }
            JOptionPane.showMessageDialog(null,"Se eliminó la informacion exitosamente");
            actualizar();
            actualizarmateria();
            actualizarestudiante();
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
         DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
        //Selecciona el valor de la columna 1
        String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));

        sonido("error");

        int x = JOptionPane.showConfirmDialog(null,"¿Estas seguro de eliminar?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){
            sonido("bleep");

            Connection con = null;
            Statement  stmt = null;

            try {
                String url = "jdbc:mysql://localhost:3306/sistema";
                String usuario = "root";
                String contrasena = "123";
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
                }

                con = DriverManager.getConnection(url,usuario,contrasena);
                if ( con != null )
                System.out.println("Se ha establecido una conexión a la base de datos " +
                    "\n " + url );
                stmt = con.createStatement();

                stmt.executeUpdate("DELETE FROM `relacionem` WHERE (`codigo_materia`='" + valor1 + "')");

            }
            catch( SQLException e ) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
            }

            finally {
                if ( con != null ) {
                    try    {
                        con.close();
                        stmt.close();
                    } catch( Exception e ) {
                        System.out.println( e.getMessage());
                    }
                }
            }
            JOptionPane.showMessageDialog(null,"Se eliminó la informacion exitosamente");
            actualizar();
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(cmat.getText().equals("") || cest.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona un elemento de la tabla");
        }else{

            DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
            //Selecciona el valor de la columna 1
            String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));

            sonido("error");

            int x = JOptionPane.showConfirmDialog(null,"¿Estas seguro de editar?","Confirmar",JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){
                sonido("bleep");
                JOptionPane.showMessageDialog(null,"Se editó exitosamente");

             
                String Codigoest,Codigomat;
        

             Codigoest=cest.getText();
             Codigomat=cmat.getText();

              

                Connection con = null;
                Statement  stmt = null;

                try {
                    String url = "jdbc:mysql://localhost:3306/sistema";
                    String usuario = "root";
                    String contrasena = "123";
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                    } catch (InstantiationException ex) {
                        Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    con = DriverManager.getConnection(url,usuario,contrasena);
                    if ( con != null )
                    System.out.println("Se ha establecido una conexión a la base de datos " +
                        "\n " + url );

                    stmt = con.createStatement();
                    stmt.executeUpdate("UPDATE relacionem set `codigo_materia`='"+Codigomat+"' ,`codigo_estudiante`='"+Codigoest+"'  WHERE( `codigo_materia`='"+valor1+ "')");

                    System.out.println("Los valores han sido agregados a la base de datos ");
                }
                catch( SQLException e ) {
                    e.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
                }

                finally {
                    if ( con != null ) {
                        try    {
                            con.close();
                            stmt.close();
                        } catch( Exception e ) {
                            System.out.println( e.getMessage());
                        }
                    }
                }

                actualizar();
                actualizarmateria();
                actualizarestudiante();
            }

            cmat.setText("");
            cest.setText("");

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cmat.setText("");
        cest.setText("");
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         int row = jTable1.getSelectedRow();
      String id=jTable1.getValueAt(row, 0).toString();
      String disponible=jTable1.getValueAt(row, 1).toString();
     
      cmat.setText(id);
      cest.setText(disponible);
    }//GEN-LAST:event_jTable1MouseClicked

    private void cmatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmatKeyTyped
         String s1=String.valueOf(evt.getKeyChar());
        
        if(!(s1.matches("[0-9]"))){
        evt.consume();
        getToolkit().beep();
        }    
    }//GEN-LAST:event_cmatKeyTyped

    private void cestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cestKeyTyped
         String s1=String.valueOf(evt.getKeyChar());
        
        if(!(s1.matches("[0-9]"))){
        evt.consume();
        getToolkit().beep();
        }    
    }//GEN-LAST:event_cestKeyTyped

    private void cestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cestActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        sonido("error");
        int x = JOptionPane.showConfirmDialog(null,"¿Deseas salir del programa?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){
            sonido("bleep");
            dispose();

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Relacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cest;
    private javax.swing.JTextField cmat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
