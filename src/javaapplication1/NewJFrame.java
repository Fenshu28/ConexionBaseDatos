package javaapplication1;

import entity.Cuadrado;
import entity.Rectangulo;

public class NewJFrame extends javax.swing.JFrame {

    private Cuadrado cua;
    private Rectangulo rect;

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        rbCuadrado = new javax.swing.JRadioButton();
        rbRectangulo = new javax.swing.JRadioButton();
        lbLado = new javax.swing.JLabel();
        txtLado = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        txtResultado = new javax.swing.JLabel();
        lbLado1 = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Seleccione una opción");

        buttonGroup1.add(rbCuadrado);
        rbCuadrado.setText("Cuadro");
        rbCuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCuadradoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbRectangulo);
        rbRectangulo.setText("Rectangulo");
        rbRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRectanguloActionPerformed(evt);
            }
        });

        lbLado.setText("Valor del lado:");

        txtLado.setText("4");

        btnCalcular.setText("Calcular area");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        txtResultado.setText("El area es de: ");

        lbLado1.setText("Valor de la altura:");

        txtAltura.setText("4");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 141, Short.MAX_VALUE)
                .addComponent(txtResultado)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbCuadrado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbRectangulo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbLado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCalcular)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbLado1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbCuadrado)
                            .addComponent(rbRectangulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbLado)
                            .addComponent(txtLado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbLado1)
                            .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtResultado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void calArear() {
        if (rbCuadrado.isSelected()) {
            cua = new Cuadrado(Integer.parseInt(txtLado.getText()));
            txtResultado.setText("El area es de: " + String.valueOf(cua.calArea()));
        } else {
            rect = new Rectangulo(Double.parseDouble(txtLado.getText()),Double.parseDouble(txtAltura.getText()));
            txtResultado.setText("El area es de: " + String.valueOf(rect.calArea()));
        }
    }
    
    private void cambCuad(boolean flag){
        txtLado.setVisible(flag);
        lbLado.setVisible(flag);
    }
    
    private void cambRect(boolean  flag){
        txtAltura.setVisible(flag);
        lbLado1.setVisible(flag);
    }

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        calArear();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void rbCuadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCuadradoActionPerformed
        cambCuad(true);
        cambRect(false);
    }//GEN-LAST:event_rbCuadradoActionPerformed

    private void rbRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRectanguloActionPerformed
        cambCuad(true);
        cambRect(true);
    }//GEN-LAST:event_rbRectanguloActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbLado;
    private javax.swing.JLabel lbLado1;
    private javax.swing.JRadioButton rbCuadrado;
    private javax.swing.JRadioButton rbRectangulo;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtLado;
    private javax.swing.JLabel txtResultado;
    // End of variables declaration//GEN-END:variables
}
