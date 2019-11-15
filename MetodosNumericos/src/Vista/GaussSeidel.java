/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gallo
 */
public class GaussSeidel extends javax.swing.JFrame {

    /**
     * Creates new form GaussSeidel
     */
    public GaussSeidel() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Gauss Seidel");
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Modelo/fondo.jpg"));
        this.jLabel1.setIcon(imagen);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        modelo.addColumn("X");
        modelo.addColumn("Y");
        modelo.addColumn("Z");
        modelo.addColumn("= d");
        Object filas[] = new Object[4];
        for (int i = 0; i < 3; i++) {
            modelo.addRow(filas);
        }
        jTextArea1.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnResolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Número de iteraciones:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 30));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 30, 30));

        jLabel3.setText("Ya deben estar ordenadas las 3 ecuaciones");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        btnResolver.setText("Resolver");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnResolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 90, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 210, 370, 340));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, 80));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Gauss Seidel");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 399, 613));

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    private DefaultTableModel checarOrden(double cof[][]) {
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("X");
//        modelo.addColumn("Y");
//        modelo.addColumn("Z");
//        modelo.addColumn("= d");
//
//        Object model[] = new Object[4];
//
//        //Acomodando la x
//        for (int i = 0; i < 3; i++) {
//
//            if (cof[i][0] > cof[i][1]) {
//
//                if (cof[i][0] > cof[i][2]) {
//                    for (int j = 0; j < 4; j++) {
//                        model[j] = cof[i][j];
//                    }
//                    modelo.addRow(model);
//                }
//
//            }
//        }
//
//        //Acomodando la y
//        for (int i = 0; i < 3; i++) {
//            if (cof[i][1] > cof[i][0]) {
//                if (cof[i][1] > cof[i][2]) {
//                    for (int j = 0; j < 4; j++) {
//                        model[j] = cof[i][j];
//                    }
//                    modelo.addRow(model);
//                }
//            }
//        }
//        
//        //acomodando la z
//        for (int i = 0; i < 3; i++) {
//            if (cof[i][2] > cof[i][0]) {
//                if (cof[i][2] > cof[i][1]) {
//                    for (int j = 0; j < 4; j++) {
//                        model[j] = cof[i][j];
//                    }
//                    modelo.addRow(model);
//                }
//            }
//        }
//        
//        return modelo;
//        
//        
//
//    
    private boolean checarOrden() {
        boolean bandera = true;
        double arreglo[][] = new double[3][4];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                arreglo[i][j] = Math.abs(Double.parseDouble(String.valueOf(jTable1.getValueAt(i, j))));
            }

        }
        //Para la ecuacion 1
        for (int i = 1; i < 3; i++) {
            if (arreglo[0][0] > arreglo[0][i]) {
                bandera = true;
            } else {
                bandera = false;
                return bandera;

            }
        }

        //Para la ecuacion 2
        if (arreglo[1][0] < arreglo[1][1] && arreglo[1][2] < arreglo[1][1]) {
            bandera = true;
        } else {
            bandera = false;
            return bandera;

        }

        //Para la ecuacion 3
        if (arreglo[2][0] < arreglo[2][2] && arreglo[2][1] < arreglo[2][2]) {
            bandera = true;
        } else {
            bandera = false;
            return bandera;
        }

        return bandera;
    }

    private void limpiar() {
        jTextArea1.setText("");
    }

    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        // TODO add your handling code here:
        try {
            double y = 0;
            double z = 0;
            double x = 0;

            int n = Integer.parseInt(jTextField1.getText());

            if (n > 51) {
                throw new Exception("Solo hasta 50 iteraciones");
            } else {
                if (!checarOrden()) {
                    throw new Exception("Las ecuaciones no estan en orden");

                } else {
                    limpiar();
                    for (int i = 0; i < n; i++) {
                        jTextArea1.append((i + 1) + ".-Iteracion\n");
                        x = (((Double.parseDouble(String.valueOf(jTable1.getValueAt(0, 3)))))
                                + (-1 * (Double.parseDouble(String.valueOf(jTable1.getValueAt(0, 1)))) * y)
                                + (-1 * (Double.parseDouble(String.valueOf(jTable1.getValueAt(0, 2)))) * z))
                                / (Double.parseDouble(String.valueOf(jTable1.getValueAt(0, 0))));
                        jTextArea1.append("x" + (i + 1) + " = " + x + "\n");

                        y = ((Double.parseDouble(String.valueOf(jTable1.getValueAt(1, 3))))
                                + (-1 * (Double.parseDouble(String.valueOf(jTable1.getValueAt(1, 0)))) * x)
                                + (-1 * (Double.parseDouble(String.valueOf(jTable1.getValueAt(1, 2))))) * z)
                                / (Double.parseDouble(String.valueOf(jTable1.getValueAt(1, 1))));
                        jTextArea1.append("y" + (i + 1) + " = " + y + "\n");

                        z = ((Double.parseDouble(String.valueOf(jTable1.getValueAt(2, 3))))
                                + (-1 * (Double.parseDouble(String.valueOf(jTable1.getValueAt(2, 0)))) * x)
                                + (-1 * (Double.parseDouble(String.valueOf(jTable1.getValueAt(2, 1))))) * y)
                                / (Double.parseDouble(String.valueOf(jTable1.getValueAt(2, 2))));

                        jTextArea1.append("z" + (i + 1) + " = " + z + "\n\n");

                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnResolverActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GaussSeidel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GaussSeidel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GaussSeidel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GaussSeidel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GaussSeidel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
