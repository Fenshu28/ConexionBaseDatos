package all;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Validador extends javax.swing.JFrame {

    public Validador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLetras = new javax.swing.JTextField();
        txtNumeros = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnValidLet = new javax.swing.JButton();
        btnValidNum = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Validador");
        setResizable(false);

        txtLetras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLetrasKeyTyped(evt);
            }
        });

        txtNumeros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumerosKeyTyped(evt);
            }
        });

        jLabel1.setText("Solo letras");

        jLabel2.setText("Solo números");

        btnValidLet.setText("Validar");
        btnValidLet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidLetActionPerformed(evt);
            }
        });

        btnValidNum.setText("Validar");
        btnValidNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidNumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtLetras)
                    .addComponent(txtNumeros, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidLet)
                    .addComponent(btnValidNum))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidLet))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidNum))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLetrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLetrasKeyTyped
        if (!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLetrasKeyTyped

    private void btnValidLetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidLetActionPerformed
        try {
            String s = JOptionPane.showInputDialog(this, "Digite el caracter que quiere contar:");
            JOptionPane.showMessageDialog(this, s + " aparece " + valid(txtLetras.getText(), s) + " veces");
        } catch (Exception e) {
            if(e.getMessage().contains("null"))
                JOptionPane.showMessageDialog(this, "No se pudo realizar la busqueda por que hay campos vacíos. ", "Error", JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "No se pudo realizar la busqueda por: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }

    }//GEN-LAST:event_btnValidLetActionPerformed

    private void btnValidNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidNumActionPerformed
        try {
            String s = JOptionPane.showInputDialog(this, "Digite el caracter que quiere contar:");
            JOptionPane.showMessageDialog(this, s + " aparece " + valid(txtNumeros.getText(), s) + " veces");
        } catch (Exception e) {
            if(e.getMessage().contains("null"))
                JOptionPane.showMessageDialog(this, "No se pudo realizar la busqueda por que hay campos vacíos. ", "Error", JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "No se pudo realizar la busqueda por: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_btnValidNumActionPerformed

    private void txtNumerosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumerosKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumerosKeyTyped

    public int valid(String s, String rg) {
        String regex = rg;
        String encontrado = "";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(s);
        int n = 0;

        try {
            while (coincidencia.find()) {
                encontrado += coincidencia.group() + " ";
                n++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return n;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Validador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnValidLet;
    private javax.swing.JButton btnValidNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtLetras;
    private javax.swing.JTextField txtNumeros;
    // End of variables declaration//GEN-END:variables
}
