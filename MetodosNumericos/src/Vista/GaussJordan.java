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
public class GaussJordan extends javax.swing.JFrame {

    int n;
    DefaultTableModel modelo = new DefaultTableModel();
    Boolean bandera = false;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    /**
     * Creates new form GaussJordan
     */
    public GaussJordan() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Gauss Jordan");
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Modelo/fondo.jpg"));
        this.jLabel2.setIcon(imagen);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRellenarMatriz = new javax.swing.JButton();
        txtNIncognitas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Gauss Jordan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 110, 30));

        jButton3.setBackground(new java.awt.Color(102, 255, 255));
        jButton3.setText("Resolver Sistema");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, 30));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 360, 240));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "X"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 370, 160));

        btnRellenarMatriz.setBackground(new java.awt.Color(102, 255, 255));
        btnRellenarMatriz.setText("Rellenar Matriz");
        btnRellenarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRellenarMatrizActionPerformed(evt);
            }
        });
        getContentPane().add(btnRellenarMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 30));
        getContentPane().add(txtNIncognitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 50, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Número de Incognitas:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRellenarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRellenarMatrizActionPerformed
        // TODO add your handling code here:
        try {
            limpiartextarea();
            this.setN(Integer.parseInt(txtNIncognitas.getText()));
            n = this.getN();

            if (n <= 1) {
                throw new Exception("Ingreso un número de incognitas invalido");
            } else if (n <= 5) {

                Object columna[] = new Object[n + 1];

                for (int i = 0; i < n + 1; i++) {
                    if (i < n) {
                        columna[i] = "X" + (i + 1);
                    } else {
                        columna[i] = "d";
                    }
                }

                modelo = new DefaultTableModel(columna, n);
                jTable1.setModel(modelo);

            }else{
                throw new Exception("Solo hasta 5 incognitas");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnRellenarMatrizActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            int n = this.getN();
            double equis[][] = new double[n][n];
            double des[] = new double[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    equis[i][j] = Double.parseDouble(String.valueOf(jTable1.getValueAt(i, j)));

                }
                des[i] = Double.parseDouble(String.valueOf(jTable1.getValueAt(i, n)));
            }

            des = this.getSolution(equis, des);
            for (int i = 0; i < n; i++) {
                jTextArea1.append("x" + (i + 1) + " = " + (des[i] = Math.round(des[i])) + "\n");
            }

        } catch (Exception e) {

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpiartextarea();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GaussJordan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GaussJordan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GaussJordan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GaussJordan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GaussJordan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRellenarMatriz;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtNIncognitas;
    // End of variables declaration//GEN-END:variables

    private double[] getSolution(double[][] equis, double[] des) {
        int n = this.getN();
        for (int i = 0; i < n; i++) {
            double d, c = 0;
            d = equis[i][i]; // seleccionamos el pivote
            jTextArea1.append(Double.toString(1 / d) + "*Fila " + (i + 1) + "\n"); //muestra el pivote seleccionado y porque
            //fila se multiplicara
            for (int j = 0; j < n; j++) { //convertimos en 1 el pivote que se selecciono
                equis[i][j] = ((equis[i][j]) / d);
            }

            des[i] = ((des[i]) / d);

            //se imprimen las operaciones en la matriz aumentada
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    jTextArea1.append(Double.toString(equis[j][k]) + "\t");

                }

                jTextArea1.append("|\t" + Double.toString(des[j]) + "\n");
            }

            jTextArea1.append("\n\n");

            for (int x = 0; x < n; x++) {
                if (i != x) {
                    c = equis[x][i];
                    jTextArea1.append("-" + Double.toString(c) + " * Fila" + (i + 1) + "+ Fila " + (x + 1) + "\n");

                    for (int y = 0; y < n; y++) { //se hacen cero los elementos de la columna que no sean el pivote
                        equis[x][y] = equis[x][y] - c * equis[i][y];
                    }
                    des[x] = des[x] - c * des[i];

                    //se muestran las operaciones realizadas en la matriz aumentada
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            jTextArea1.append(Double.toString(equis[j][k]) + "\t");
                        }
                        jTextArea1.append("|\t" + Double.toString(des[j]) + "\n");
                    }

                    jTextArea1.append("\n\n");
                }
            }//fin

        }

        return des;
    }

    private void limpiartextarea() {
        jTextArea1.setText("");
    }
}
