/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import ventanas.Conector;
import ventanas.Archivos;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class ExportarExcel extends javax.swing.JInternalFrame {
ventanas.Conector cc = new ventanas.Conector();
static Connection cn = Conector.conexion();
    /**
     * Creates new form Exportar
     */
    public ExportarExcel() {
        initComponents();
        llenar_lista();
        Archivos.carpeta();
        jButton1.setEnabled(false);
        jTextField1.setHorizontalAlignment(0);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        this.setLocation(((pantalla.width - ventana.width) / 2), ((pantalla.height - ventana.height) / 2));
  
    }
public static void llenar_lista(){
    String sql = "SHOW TABLES"; //WHERE 'TABLES_IN_ESTETICA' NOT LIKE 'users'";
    DefaultTableModel model = new DefaultTableModel();
    try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metadata = rs.getMetaData();   
            while(rs.next()){ 
               int cantidadColumnas = metadata.getColumnCount();
            for (int i = 1; i <= cantidadColumnas; i++) {
                model.addColumn(metadata.getColumnLabel(i));
            }while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }model.addRow(fila);
            }
            }jTable1.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Excel = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        Excel.setText("Exportar");
        Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcelActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Excel);

        setClosable(true);
        setIconifiable(true);
        setTitle("Exportar a Excel");

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setText("Nuevo Nombre:");

        jLabel2.setText("Ruta:");

        jTextField2.setEditable(false);

        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
if (evt.isPopupTrigger()){
           JTable source = (JTable)evt.getSource();
    int row = source.rowAtPoint( evt.getPoint() );
    int column = source.columnAtPoint( evt.getPoint() );
            if (!source.isRowSelected(row)) {
        source.changeSelection(row, column, false, false);
    }jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcelActionPerformed
String idBase=String.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0));
jTextField1.setText(idBase);
jTextField2.setText("");
jButton1.setEnabled(false);
    }//GEN-LAST:event_ExcelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String direccion = jTextField2.getText();
String idBase=String.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0));
String sql = "select * from "+idBase+" into outfile '"+direccion+"' fields terminated by ',' enclosed by '\"' lines terminated by '\n'";
//"SELECT * FROM users INTO OUTFILE 'F:\' FIELDS TERMINATED BY ',' enclosed by '\"' lines terminated by 'n' ";
try {
            Statement pst = null;
            pst = cn.prepareStatement(sql);
            pst.executeQuery(sql);
            JOptionPane.showMessageDialog(null,direccion);
        } catch (SQLException ex) {
            Logger.getLogger(ExportarExcel.class.getCanonicalName()).log(Level.SEVERE, null, ex);
        }
//backup();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

    }//GEN-LAST:event_jTextField1KeyReleased
/*public void backup(){
    Connection con=null;
Statement stmt=null;

//se inicia la conexion
try{
String url = "jdbc:mysql://localhost:3306/estetica"; 
String usuario = "root"; 
String contraseña = ""; 
            try { 
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(ExportarExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
    con = DriverManager.getConnection(url,usuario,contraseña); 
    if ( con != null ) 
        
    stmt = con.createStatement(); 
stmt.executeUpdate
("select * from users into outfile 'c:/users/christian/desktop/backup.csv' fields terminated by ',' enclosed by '\"' lines terminated by '\n'");
}catch( SQLException p ) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExportarExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
	              finally{ 
	                  if ( con != null ){ 
	                      try{ 
	                          con.close(); 
	                          stmt.close(); 
	                      }catch( Exception p ){ 
	                          System.out.println( p.getMessage()); 
	                      } 
	                  }       
}
}*/

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
            java.util.logging.Logger.getLogger(Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Archivos and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExportarExcel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Excel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
