/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.meusProdutos;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import modelo.Categoria;

/**
 *
 * @author Everton Soares
 */
public class AdicionarCategorias extends javax.swing.JFrame {
    private final Vector CheckBoxCategorias = new Vector<Object>();
    private List<Categoria> categorias;
    private List<Categoria> categoriasSelecionadas;
    
    /**
     * Creates new form AdicionarCategorias
     * @param categoriasSelecionadas
     * @param categorias
     */
    public AdicionarCategorias(List<Categoria> categoriasSelecionadas, List<Categoria> categorias) {
        this.categoriasSelecionadas = categoriasSelecionadas;
        this.categorias = categorias;
        initComponents();
        
        carregarJListCheckBox();
        categoriasJaSelecionadas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCategorias = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCategorias = new javax.swing.JList();
        bOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelCategorias.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jScrollPane1.setViewportView(listaCategorias);

        javax.swing.GroupLayout painelCategoriasLayout = new javax.swing.GroupLayout(painelCategorias);
        painelCategorias.setLayout(painelCategoriasLayout);
        painelCategoriasLayout.setHorizontalGroup(
            painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCategoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelCategoriasLayout.setVerticalGroup(
            painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCategoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bOK.setText("OK");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(bOK)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bOK)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        dispose();
    }//GEN-LAST:event_bOKActionPerformed

    private void categoriasJaSelecionadas(){
        if (!categoriasSelecionadas.isEmpty()) {
            for (Categoria categoria: categoriasSelecionadas) {
                for (int j=0; j < categorias.size(); j++) {
                    if (categoria.getCodigo() == categorias.get(j).getCodigo()) {
                        ((JCheckBox) listaCategorias.getModel().getElementAt(j)).setSelected(true);
                    }
                }
            }
        }
    }
    
    private void carregarJListCheckBox(){
        if (categorias != null){
            listaCategorias.setCellRenderer(new checkBoxCellRenderer());
            for(Categoria categoria: categorias){
                CheckBoxCategorias.add(new JCheckBox(categoria.getDescricao()));
            }
            listaCategorias.setListData(CheckBoxCategorias);
            listaCategorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listaCategorias.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){
                    int index = listaCategorias.locationToIndex(e.getPoint());
                    if (index != -1) {
                        JCheckBox checkBox = (JCheckBox) listaCategorias.getModel().getElementAt(index);
                        if (checkBox.isSelected()) {
                            categoriasSelecionadas.remove(categorias.get(index));
                            checkBox.setSelected(false);
                        } else {
                            categoriasSelecionadas.add(categorias.get(index));
                            checkBox.setSelected(true);
                        }
                    }
                    repaint();
                }
            });
        }
    }
    
    private static class checkBoxCellRenderer implements ListCellRenderer<Object>{
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
            JCheckBox checkBox = (JCheckBox) value;
            return checkBox;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaCategorias;
    private javax.swing.JPanel painelCategorias;
    // End of variables declaration//GEN-END:variables
}
