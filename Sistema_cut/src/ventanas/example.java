/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static ventanas.Exporta.cn;
import static ventanas.Exporta.jTable;


public class example extends javax.swing.JFrame {

 String tabla;   
    
ventanas.Conector cc = new ventanas.Conector();
static Connection cn = Conector.conexion();

    public example() {
        initComponents();
         Archivos.carpeta();
         Actualizar();
         setLocationRelativeTo(null);
         setResizable(false);
    }
  public static void Actualizar(){
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
            }jTable.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
}
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextField2.setEditable(false);

        jButton1.setText("Exportar a excell");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Selecciona elemento a exportar");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       File maestros = new File("c:\\Sistema\\BackUp\\maestros.csv");
       File laboratorio = new File("c:\\Sistema\\BackUp\\laboratorios.csv");
       
       
        if(jTextField2.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona una tabla");}
        else{
       
        //aqui obtiene un valor  para mostrarse    
        int row = jTable.getSelectedRow();   
        tabla=jTable.getValueAt(row, 0).toString();
        
        int x = JOptionPane.showConfirmDialog(null,"\t"+"Deseas exportar  "+tabla+"?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){
            
        
        String idBase=String.valueOf(jTable.getModel().getValueAt(jTable.getSelectedRow(),0));
        String direccion = jTextField2.getText();
        
       // if(!maestros.exists() || !laboratorio.exists() ){
            
             
       
    try {
         String sql = "select * from "+idBase+" into outfile '"+direccion+"' fields terminated by ',' enclosed by '\"' lines terminated by '\n'";
        Statement pst = null;
        pst = cn.prepareStatement(sql);
        pst.executeQuery(sql);
        JOptionPane.showMessageDialog(null,direccion);
    } catch (SQLException ex) {
       // Logger.getLogger(ExportarExcel.class.getCanonicalName()).log(Level.SEVERE, null, ex);
    }
      //  }else{
       
   // JOptionPane.showMessageDialog(null,"Ya existe el archivo");
     //   }
        }
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
      
        
      int row = jTable.getSelectedRow();
      String nombre=jTable.getValueAt(row, 0).toString();
      
      jTextField2.setText(nombre);
   
      
String archivo = jTextField2.getText();
jTextField2.setText("c:/Sistema/BackUp/"+archivo+".csv");
     
      
    }//GEN-LAST:event_jTableMouseClicked

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
            java.util.logging.Logger.getLogger(example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Archivos and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new example().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
