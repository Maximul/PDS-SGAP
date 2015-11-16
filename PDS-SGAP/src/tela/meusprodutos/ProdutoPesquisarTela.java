package tela.meusprodutos;

import dao.CondominoDAO;
import modelo.tabela.TabelaModeloProduto;
import dao.ProdutoDAO;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Condomino;
import modelo.Produto;

public class ProdutoPesquisarTela extends javax.swing.JFrame {
    private List<Produto> produtos;
    private Produto produto;
    private Condomino condomino;
    /**
     * Creates new form PesquisarProdutos
     * @param condomino
     */
    public ProdutoPesquisarTela(Condomino condomino) {
        initComponents();
        this.condomino = condomino;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFlutuante = new javax.swing.JPopupMenu();
        miDetalhes = new javax.swing.JMenuItem();
        miAtualizar = new javax.swing.JMenuItem();
        miExcluir = new javax.swing.JMenuItem();
        pnCamposPesquisa = new javax.swing.JPanel();
        lNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        bPesquisar = new javax.swing.JButton();
        pnResultados = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbResultados = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        bCadastrar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        miDetalhes.setText("Ver Detalhes");
        miDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDetalhesActionPerformed(evt);
            }
        });
        menuFlutuante.add(miDetalhes);

        miAtualizar.setText("Atualizar");
        miAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAtualizarActionPerformed(evt);
            }
        });
        menuFlutuante.add(miAtualizar);

        miExcluir.setText("Excluir");
        miExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExcluirActionPerformed(evt);
            }
        });
        menuFlutuante.add(miExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Categoria");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        pnCamposPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Campos de Pesquisa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        lNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lNome.setText("Nome");

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });

        bPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bPesquisar.setText("Pesquisar");
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCamposPesquisaLayout = new javax.swing.GroupLayout(pnCamposPesquisa);
        pnCamposPesquisa.setLayout(pnCamposPesquisaLayout);
        pnCamposPesquisaLayout.setHorizontalGroup(
            pnCamposPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCamposPesquisaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfNome))
                    .addGroup(pnCamposPesquisaLayout.createSequentialGroup()
                        .addComponent(lNome)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCamposPesquisaLayout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addComponent(bPesquisar)
                .addGap(155, 155, 155))
        );
        pnCamposPesquisaLayout.setVerticalGroup(
            pnCamposPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposPesquisaLayout.createSequentialGroup()
                .addComponent(lNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnResultados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resultados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        tbResultados.setModel(new javax.swing.table.DefaultTableModel(
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
        tbResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbResultadosMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbResultados);

        javax.swing.GroupLayout pnResultadosLayout = new javax.swing.GroupLayout(pnResultados);
        pnResultados.setLayout(pnResultadosLayout);
        pnResultadosLayout.setHorizontalGroup(
            pnResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnResultadosLayout.setVerticalGroup(
            pnResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        bCadastrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        bCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnCamposPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(bCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCamposPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produtoLocal = new Produto();
        produtoLocal.setDescricao(tfNome.getText());
        produtos = produtoDAO.findProduto(condomino, produtoLocal);
        carregarTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        ProdutoCadastrarTela cadastrarProduto = new ProdutoCadastrarTela(condomino);
        cadastrarProduto.setVisible(true);
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void tbResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadosMouseReleased
        selecionarProduto(evt);
        realizarAcao(evt);
    }//GEN-LAST:event_tbResultadosMouseReleased

    private void miDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDetalhesActionPerformed
        verDetalhes();
    }//GEN-LAST:event_miDetalhesActionPerformed

    private void miAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAtualizarActionPerformed
        ProdutoAtualizarTela atualizarProduto = new ProdutoAtualizarTela(produto);
        atualizarProduto.setVisible(true);
    }//GEN-LAST:event_miAtualizarActionPerformed

    private void miExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro: " + produto.getNome() + "?", "Excluir Produto", JOptionPane.YES_NO_OPTION);
        if(resposta == JOptionPane.YES_OPTION){
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.removeProduto(produto);
        }
    }//GEN-LAST:event_miExcluirActionPerformed

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
        carregarTabela();
    }//GEN-LAST:event_bPesquisarActionPerformed

    private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            carregarTabela();
        }
    }//GEN-LAST:event_tfNomeKeyPressed
    
    private void selecionarProduto(MouseEvent evt) {
        int linha = tbResultados.rowAtPoint(evt.getPoint());
        if (linha >= 0) {
            tbResultados.setRowSelectionInterval(linha, linha);
            linha = tbResultados.getSelectedRow();
            this.produto = condomino.getProdutos().get(linha);
        }
    }
    
    private void realizarAcao(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1) { // Botão Esquerdo do Mouse
            if (evt.getClickCount() > 1) { // Se for mais de 2 cliques
                verDetalhes();
            }
        } else if (evt.getButton() == MouseEvent.BUTTON3) { //Botão Direito do Mouse
            menuFlutuante.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    
    private void verDetalhes(){
        ProdutoDetalhesTela detalhesProduto = new ProdutoDetalhesTela(produto);
        detalhesProduto.setVisible(true);
    }
    
    private void atualizarCondomino(){
        CondominoDAO condominoDAO = new CondominoDAO();
        condomino = condominoDAO.getCondominoById(condomino.getCodigo());
    }
    
    private void carregarProdutos(){
        atualizarCondomino();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produtoLocal = new Produto();
        produtoLocal.setNome(tfNome.getText());
        produtos = produtoDAO.findProduto(condomino, produtoLocal);
    }
    
    private void carregarTabela() {
        carregarProdutos();
        TabelaModeloProduto modelo = new TabelaModeloProduto(produtos);
        tbResultados.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bPesquisar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lNome;
    private javax.swing.JPopupMenu menuFlutuante;
    private javax.swing.JMenuItem miAtualizar;
    private javax.swing.JMenuItem miDetalhes;
    private javax.swing.JMenuItem miExcluir;
    private javax.swing.JPanel pnCamposPesquisa;
    private javax.swing.JPanel pnResultados;
    private javax.swing.JTable tbResultados;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}