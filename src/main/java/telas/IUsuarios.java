/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import controller.UsuarioController;
import entidades.Usuario;
import static telas.Menu.ta;
import util.Maiusculo;
import util.Maximo;
import util.Util;

/**
 *
 * @author deividnn
 */
public class IUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form IUsuarios
     */
    public IUsuarios() {
        initComponents();

        txtusuario.setDocument(new Maiusculo(32));
        txtemail.setDocument(new Maximo(100));
        txtpesquisa.setDocument(new Maiusculo(32));
        cancelar();

        DefaultTableModel model = iniciaTabela();

        model.addColumn("CODIGO");
        model.addColumn("USUARIO");
        model.addColumn("EMAIL");
        model.addColumn("STATUS");
        model.addColumn("NIVEL");
        model.addColumn("USUARIO ALTERA");
        model.addColumn("DATA ALTERA");

        atualizaTabela(model);

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    bteditar.doClick();
                }
            }
        });

        tabela.addMouseWheelListener((MouseWheelEvent e) -> {
            JTable t = (JTable) e.getSource();
            JViewport vport = sc.getViewport();
            Point vp = vport.getViewPosition();
            vp.translate(0, e.getWheelRotation() * t.getRowHeight() * 3);
            t.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
        });
        tabela.requestFocus();
        selectAndScroll(tabela, 0);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lsenha = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        ldata = new javax.swing.JLabel();
        lusuario = new javax.swing.JLabel();
        cstatus = new javax.swing.JComboBox<>();
        cnivel = new javax.swing.JComboBox<>();
        txtsenha = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        sc = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btpesquisar = new javax.swing.JButton();
        txtpesquisa = new javax.swing.JTextField();
        ccampo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btatualizar = new javax.swing.JButton();
        btcancelar = new javax.swing.JButton();
        btsalvar = new javax.swing.JButton();
        bteditar = new javax.swing.JButton();
        btinserir = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("TELA DE USUARIOS");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        jLabel1.setText("USUARIO");

        jLabel2.setText("STATUS");

        jLabel4.setText("DATA ALTERA");

        jLabel3.setText("NIVEL");

        jLabel5.setText("EMAIL");

        jLabel6.setText("USUARIO ALTERA");

        lsenha.setText("SENHA");

        txtusuario.setText(".");
        txtusuario.setName("usuario"); // NOI18N

        txtemail.setText(".");

        ldata.setText(".");

        lusuario.setText(".");

        cstatus.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO", "BLOQUEADO" }));

        cnivel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cnivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "FUNCIONARIO" }));

        txtsenha.setText("jPasswordField1");
        txtsenha.setName("senha"); // NOI18N

        jLabel8.setText("CODIGO");

        txtcodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcodigo.setEnabled(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cnivel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lsenha)
                            .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(ldata, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addGap(5, 5, 5)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(cstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(cnivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lsenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(3, 3, 3)))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ldata, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        sc.setViewportView(tabela);

        btpesquisar.setText("PESQUISAR");
        btpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpesquisarActionPerformed(evt);
            }
        });

        txtpesquisa.setText(".");

        ccampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO", "USUARIO", "STATUS", "NIVEL", "EMAIL" }));
        ccampo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ccampoItemStateChanged(evt);
            }
        });

        jLabel9.setText("PESQUISAR POR:");

        btatualizar.setText("ATUALIZAR");
        btatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btatualizarActionPerformed(evt);
            }
        });

        btcancelar.setText("CANCELAR");
        btcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelarActionPerformed(evt);
            }
        });

        btsalvar.setText("SALVAR");
        btsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalvarActionPerformed(evt);
            }
        });

        bteditar.setText("EDITAR");
        bteditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteditarActionPerformed(evt);
            }
        });

        btinserir.setText("INSERIR");
        btinserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btinserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sc)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btinserir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bteditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btcancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btatualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccampo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btinserir)
                        .addComponent(bteditar)
                        .addComponent(btsalvar)
                        .addComponent(btcancelar)
                        .addComponent(btatualizar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ccampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btpesquisar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sc, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        Long id = (Long) tabela.getValueAt(tabela.getSelectedRow(), 0);
        if (id != null) {
            bteditar.setVisible(true);
            bteditar.setEnabled(true);
        } else {
            bteditar.setVisible(true);
            bteditar.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaMouseClicked


    private void btpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpesquisarActionPerformed
        // TODO add your handling code here:
        txtpesquisa.requestFocus();
        boolean ok = true;
        if (txtpesquisa.getText() == null) {
            txtpesquisa.setText("");
        }

        if (ok) {
            DefaultTableModel model = iniciaTabela();
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();

            String campo = "id";
            if (!ccampo.getSelectedItem().toString().equals("CODIGO")) {
                campo = ccampo.getSelectedItem().toString().toLowerCase();
            }

            List<Usuario> lista = new UsuarioController().pesquisar(txtpesquisa.getText(), campo);
            lista.forEach((Usuario u) -> {
                model.addRow(new Object[]{u.getId(),
                    u.getUsuario(),
                    u.getEmail(),
                    u.getStatus(),
                    u.getNivel(),
                    u.getUsuarioAltera(),
                    Util.datahoralegivel.format(u.getDataAltera())
                });
            });
            model.fireTableDataChanged();
            tabela.setDefaultEditor(Object.class, null);

        }
    }//GEN-LAST:event_btpesquisarActionPerformed

    private void ccampoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ccampoItemStateChanged
        // TODO add your handling code here:
        txtpesquisa.requestFocus();
    }//GEN-LAST:event_ccampoItemStateChanged

    private void btatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btatualizarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = iniciaTabela();
        atualizaTabela(model);
    }//GEN-LAST:event_btatualizarActionPerformed

    private void btcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelarActionPerformed
        // TODO add your handling code here:
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                cancelar();
            } else {
                // no option
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btcancelarActionPerformed

    private void btsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalvarActionPerformed
        // TODO add your handling code here:
        try {

            boolean ok = true;

            List<JTextField> txt = new ArrayList<>();
            txt.add(txtusuario);
            if (txtcodigo.getText() == null) {
                txtcodigo.setText("");
            }

            if (txtcodigo.getText().isEmpty()) {
                txt.add(txtsenha);
            }
            ok = Util.camposVazio(ok, txt);

            if (!txtemail.getText().isEmpty()) {
                ok = Util.emailValido(txtemail);
            }

            if (ok) {
                if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Usuario u = new Usuario();
                    u.setUsuario(txtusuario.getText());
                    u.setEmail(txtemail.getText());
                    u.setSenha(Util.md5(new String(txtsenha.getPassword())));
                    u.setNivel(cnivel.getSelectedItem().toString());
                    u.setStatus(cstatus.getSelectedItem().toString());
                    u.setUsuarioAltera(Menu.idusuario);
                    if (!txtcodigo.getText().isEmpty()) {
                        u.setId(new Long(txtcodigo.getText()));
                    }

                    if (u.getId() == null) {
                        if (new UsuarioController().salvar(u)) {
                            JOptionPane.showMessageDialog(null, "usuario salvo com sucesso");
                            esconderForm();

                            DefaultTableModel model = iniciaTabela();
                            atualizaTabela(model);
                        }
                    } else {
                        if (new UsuarioController().atualizar(u)) {
                            JOptionPane.showMessageDialog(null, "usuario salvo com sucesso");
                            esconderForm();

                            DefaultTableModel model = iniciaTabela();
                            atualizaTabela(model);
                        }
                    }
                } else {
                    // no option
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btsalvarActionPerformed

    private void bteditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditarActionPerformed
        // TODO add your handling code here:
        inserirEditar();
        lsenha.setVisible(false);
        txtsenha.setVisible(false);

        txtcodigo.setText("" + tabela.getValueAt(tabela.getSelectedRow(), 0));
        txtusuario.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 1));
        txtemail.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 2));
        cnivel.setSelectedItem((String) tabela.getValueAt(tabela.getSelectedRow(), 4));
        cstatus.setSelectedItem((String) tabela.getValueAt(tabela.getSelectedRow(), 3));
        lusuario.setText("" + tabela.getValueAt(tabela.getSelectedRow(), 5));

        Object obj = tabela.getValueAt(tabela.getSelectedRow(), 6);
        if (obj instanceof String) {
            ldata.setText(obj.toString());
        }

        txtusuario.requestFocus();
        mostrarForm();
        emedicao = true;
    }//GEN-LAST:event_bteditarActionPerformed

    private void btinserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btinserirActionPerformed
        // TODO add your handling code here:
        inserirEditar();
        txtusuario.setText("");
        txtemail.setText("");
        txtsenha.setText("");
        lusuario.setText("");
        txtcodigo.setText("");
        ldata.setText("");
        cstatus.setSelectedItem("ATIVO");
        cnivel.setSelectedItem("FUNCIONARIO");
        lsenha.setVisible(true);
        txtsenha.setVisible(true);
        txtusuario.requestFocus();
        mostrarForm();
        emedicao = true;
    }//GEN-LAST:event_btinserirActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        if (emedicao) {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair dessa tela?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                removertela();
                dispose();
            }
        } else {
            removertela();
            dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    public void removertela() {
        Menu.telas.remove(Menu.telas.getSelectedIndex());
           for (Component c : ta.getMenuComponents()) {
            if (c instanceof JMenuItem) {
                if (c.getName().equals(getTitle().trim())) {
                    ta.remove(c);
                    break;
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btatualizar;
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton bteditar;
    private javax.swing.JButton btinserir;
    private javax.swing.JButton btpesquisar;
    private javax.swing.JButton btsalvar;
    private javax.swing.JComboBox<String> ccampo;
    private javax.swing.JComboBox<String> cnivel;
    private javax.swing.JComboBox<String> cstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel ldata;
    private javax.swing.JLabel lsenha;
    private javax.swing.JLabel lusuario;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sc;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JPasswordField txtsenha;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

    public static boolean emedicao;

    private DefaultTableModel iniciaTabela() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tabela.setRowSorter(sorter);
        return model;
    }

    private void atualizaTabela(DefaultTableModel model) {

        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<Usuario> lista = new UsuarioController().lista();
        lista.forEach((u) -> {
            model.addRow(new Object[]{u.getId(),
                u.getUsuario(),
                u.getEmail(),
                u.getStatus(),
                u.getNivel(),
                u.getUsuarioAltera(),
                Util.datahoralegivel.format(u.getDataAltera())
            });
        });
        model.fireTableDataChanged();
        tabela.setDefaultEditor(Object.class, null);

    }

    private void inserirEditar() {
        btinserir.setEnabled(false);
        bteditar.setEnabled(false);
        btsalvar.setEnabled(true);
        btcancelar.setEnabled(true);
        btatualizar.setEnabled(false);
        btpesquisar.setEnabled(false);
    }

    private void cancelar() {
        emedicao = false;
        btinserir.setEnabled(true);
        esconderForm();
        btatualizar.setEnabled(true);
        btpesquisar.setEnabled(true);
        lsenha.setVisible(false);
        txtsenha.setVisible(false);
        txtusuario.requestFocus();

    }

    private void esconderForm() {
        panel.setVisible(false);
        bteditar.setVisible(false);
        btsalvar.setVisible(false);
        btcancelar.setVisible(false);
        btpesquisar.setEnabled(true);
        ccampo.setEnabled(true);
        txtpesquisa.setEnabled(true);
        btinserir.setEnabled(true);
        btatualizar.setEnabled(true);
        sc.setVisible(true);
    }

    private void mostrarForm() {
        panel.setVisible(true);
        bteditar.setVisible(true);
        btsalvar.setVisible(true);
        btcancelar.setVisible(true);
        btpesquisar.setEnabled(false);
        ccampo.setEnabled(false);
        txtpesquisa.setEnabled(false);
        btinserir.setEnabled(false);
        btatualizar.setEnabled(false);
        sc.setVisible(false);
    }

    public static void scrollToVisible(JTable table, int rowIndex) {
        scrollToVisible(table, rowIndex, 0);
    }

    public static void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof JViewport)) {
            return;
        }
    }

    public static Collection<Integer> getReverseSelectedRows(JTable table) {
        Set<Integer> rows = new TreeSet<>((Integer o1, Integer o2) -> o2.compareTo(o1));
        for (int r : table.getSelectedRows()) {
            rows.add(r);
        }

        return rows;
    }

    public static void selectAndScroll(JTable table, int rowIndex) {
        table.getSelectionModel().setSelectionInterval(rowIndex, rowIndex);
        scrollToVisible(table, rowIndex);
    }

}