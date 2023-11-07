package view;

import com.formdev.flatlaf.FlatLightLaf;
import entity.Alumno;
import entity.Conexion;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class BaseDatosFrame extends javax.swing.JFrame {

    private Conexion con;
    private DefaultTableModel modelTab;

    public BaseDatosFrame() {
        initComponents();
        txtBuscar.putClientProperty("JTextField.placeholderText",
                "Buscar...");
        con = new Conexion("octubre", "alumno");
        modelTab = (DefaultTableModel) tblDatos.getModel();

        checkBD();
    }

    // Juego de booleanos
    private void checkBD() {
        if (con.isExistBd()) {
            btnCrearBd.setEnabled(false);

            if (con.isExistTable()) {
                btnCrearTab.setEnabled(false);
                for (Component component : pnlDatos.getComponents()) {
                    component.setEnabled(true);
                }
                llenarTabla();
            } else {
                btnCrearTab.setEnabled(true);
                for (Component component : pnlDatos.getComponents()) {
                    component.setEnabled(false);
                }
            }
        } else {
            btnCrearTab.setEnabled(false);
            btnCrearBd.setEnabled(true);
        }

    }

    private String datoString(String dato) {
        String aTemp = null;

        do {
            aTemp = JOptionPane.showInputDialog(this, "Ingresa " + dato,
                    "",
                    JOptionPane.INFORMATION_MESSAGE);
        } while (aTemp.isEmpty());

        return aTemp;
    }

    private int datoInt(String dato) {
        String aTemp;
        int matTemp;

        do {
            aTemp = JOptionPane.showInputDialog(this, "Ingresa " + dato,
                    "",
                    JOptionPane.INFORMATION_MESSAGE);
        } while (aTemp.isEmpty());
        matTemp = Integer.parseInt(aTemp);
        return matTemp;
    }

    private void llenarTabla() {
        Object[] obj;
        modelTab.setRowCount(0);

        for (Alumno consultarRegistro : con.consultarRegistros()) {
            obj = new Object[3];

            obj[0] = consultarRegistro.getMatricula();
            obj[1] = consultarRegistro.getNombre();
            obj[2] = consultarRegistro.getCarrera();

            modelTab.addRow(obj);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearBd = new javax.swing.JButton();
        btnCrearTab = new javax.swing.JButton();
        pnlDatos = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnActua = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnCrearBd.setText("Crear base de datos");
        btnCrearBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBdActionPerformed(evt);
            }
        });

        btnCrearTab.setText("Crear Tabla");
        btnCrearTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTabActionPerformed(evt);
            }
        });

        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos alumno"));

        btnInsert.setText("Insertar alumno");
        btnInsert.setEnabled(false);
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnActua.setText("Actualizar alumno");
        btnActua.setEnabled(false);
        btnActua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuaActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar alumno");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtBuscar.setEnabled(false);

        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Carrera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);
        if (tblDatos.getColumnModel().getColumnCount() > 0) {
            tblDatos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblDatos.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(106, 106, 106)))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnActua)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearBd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearTab)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearBd)
                    .addComponent(btnCrearTab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBdActionPerformed
        con.crearBase("Octubre");
        checkBD();
    }//GEN-LAST:event_btnCrearBdActionPerformed

    private void btnCrearTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTabActionPerformed
        con.crearTabla("alumno");
        checkBD();
    }//GEN-LAST:event_btnCrearTabActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        Alumno aTemp = new Alumno(datoInt("matricula"),
                datoString("nombre del alumno"),
                datoString("carrera"));
        con.crearRegistro(aTemp);
        llenarTabla();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnActuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuaActionPerformed
        System.out.println(modelTab.getValueAt(tblDatos.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_btnActuaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int id = Integer.parseInt(modelTab.getValueAt(tblDatos.getSelectedRow(), 0).toString());
        con.consultarRegistros(id);
    }//GEN-LAST:event_btnBuscarActionPerformed
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaseDatosFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActua;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearBd;
    private javax.swing.JButton btnCrearTab;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsert;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
