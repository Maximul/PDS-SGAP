package tela;

import dao.CondominoDAO;
import modelo.Condomino;
import modelo.TipoUsuario;
import tela.solicitacao.AluguelPesquisarTela;
import tela.apartamento.ApartamentoPesquisarTela;
import tela.categoria.CategoriaPesquisarTela;
import tela.condomino.CondominoPesquisarTela;
import tela.meusprodutos.ProdutoPesquisarTela;
import tela.aluguel.SolicitacaoPesquisarTela;
import tela.minhassolicitacoes.alugueisConfirmados.MinhasSolicitacoesConfirmadasPesquisarTela;
import tela.minhassolicitacoes.todas.MinhasSolicitacoesPesquisarTela;
//import tela.minhassolicitacoes.MinhasSolicitacoesPesquisarTela;

public class Principal extends javax.swing.JFrame {
    private Condomino condomino;
    /**
     * Creates new form Principal
     * @param condomino
     */
    public Principal(Condomino condomino) {
        initComponents();
        this.condomino = condomino;
        menuCadastro.setVisible(false);
        verificaUsuario();
    }

    private void verificaUsuario(){
        if(this.condomino.getTipoUsuario() == TipoUsuario.ADMIN){
            menuCadastro.setVisible(true);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        mbMenu = new javax.swing.JMenuBar();
        menuAcesso = new javax.swing.JMenu();
        miSair = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        miPesquisarProdutos = new javax.swing.JMenuItem();
        miSolicitacoesProdutos = new javax.swing.JMenuItem();
        menuAluguel = new javax.swing.JMenu();
        miPesquisarAluguel = new javax.swing.JMenuItem();
        menuMinhasSolicitacoes = new javax.swing.JMenu();
        miTodas = new javax.swing.JMenuItem();
        miConfirmadas = new javax.swing.JMenuItem();
        miEmAvaliacao = new javax.swing.JMenuItem();
        miExpiradas = new javax.swing.JMenuItem();
        menuCadastro = new javax.swing.JMenu();
        miApartamento = new javax.swing.JMenuItem();
        miCategoria = new javax.swing.JMenuItem();
        miCondomino = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGAP - Sistema de Gerenciamento de Aluguel de Produtos");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        menuAcesso.setText("Acesso");

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        menuAcesso.add(miSair);

        mbMenu.add(menuAcesso);

        menuProdutos.setText("Meus Produtos");

        miPesquisarProdutos.setText("Pesquisar");
        miPesquisarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPesquisarProdutosActionPerformed(evt);
            }
        });
        menuProdutos.add(miPesquisarProdutos);

        miSolicitacoesProdutos.setText("Solicitações");
        miSolicitacoesProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSolicitacoesProdutosActionPerformed(evt);
            }
        });
        menuProdutos.add(miSolicitacoesProdutos);

        mbMenu.add(menuProdutos);

        menuAluguel.setText("Aluguel");

        miPesquisarAluguel.setText("Pesquisar Produto");
        miPesquisarAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPesquisarAluguelActionPerformed(evt);
            }
        });
        menuAluguel.add(miPesquisarAluguel);

        menuMinhasSolicitacoes.setText("Aluguel");

        miTodas.setText("Todas");
        miTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTodasActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miTodas);

        miConfirmadas.setText("Alugueis");
        miConfirmadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConfirmadasActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miConfirmadas);

        miEmAvaliacao.setText("Em avaliação");
        miEmAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEmAvaliacaoActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miEmAvaliacao);

        miExpiradas.setText("Expiradas");
        miExpiradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExpiradasActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miExpiradas);

        menuAluguel.add(menuMinhasSolicitacoes);

        mbMenu.add(menuAluguel);

        menuCadastro.setText("Cadastrar");

        miApartamento.setText("Apartamento");
        miApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miApartamentoActionPerformed(evt);
            }
        });
        menuCadastro.add(miApartamento);

        miCategoria.setText("Categoria");
        miCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoriaActionPerformed(evt);
            }
        });
        menuCadastro.add(miCategoria);

        miCondomino.setText("Condômino");
        miCondomino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCondominoActionPerformed(evt);
            }
        });
        menuCadastro.add(miCondomino);

        mbMenu.add(menuCadastro);

        setJMenuBar(mbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSairActionPerformed

    private void miPesquisarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPesquisarProdutosActionPerformed
        ProdutoPesquisarTela pesquisarProduto = new ProdutoPesquisarTela(condomino);
        pesquisarProduto.setVisible(true);
    }//GEN-LAST:event_miPesquisarProdutosActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        CondominoDAO condominoDAO = new CondominoDAO();
        condomino = condominoDAO.getCondominoById(condomino.getCodigo());
    }//GEN-LAST:event_formWindowGainedFocus

    private void miPesquisarAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPesquisarAluguelActionPerformed
        AluguelPesquisarTela pesquisarAluguel = new AluguelPesquisarTela(this.condomino);
        pesquisarAluguel.setVisible(true);
    }//GEN-LAST:event_miPesquisarAluguelActionPerformed

    private void miApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miApartamentoActionPerformed
        ApartamentoPesquisarTela apPesquisar = new ApartamentoPesquisarTela();
        apPesquisar.setVisible(true);
    }//GEN-LAST:event_miApartamentoActionPerformed

    private void miCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriaActionPerformed
        CategoriaPesquisarTela catPesquisar = new CategoriaPesquisarTela();
        catPesquisar.setVisible(true);
    }//GEN-LAST:event_miCategoriaActionPerformed

    private void miCondominoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCondominoActionPerformed
        CondominoPesquisarTela pesCondomino = new CondominoPesquisarTela();
        pesCondomino.setVisible(true);
    }//GEN-LAST:event_miCondominoActionPerformed

    private void miSolicitacoesProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSolicitacoesProdutosActionPerformed
        SolicitacaoPesquisarTela solicitacaoPesquisarTela = new SolicitacaoPesquisarTela(condomino);
        solicitacaoPesquisarTela.setVisible(true);
    }//GEN-LAST:event_miSolicitacoesProdutosActionPerformed

    private void miEmAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEmAvaliacaoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_miEmAvaliacaoActionPerformed

    private void miTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTodasActionPerformed
        // TODO add your handling code here:
        MinhasSolicitacoesPesquisarTela minhasSolicitacoes =  new MinhasSolicitacoesPesquisarTela(this.condomino);
        minhasSolicitacoes.setVisible(true);
    }//GEN-LAST:event_miTodasActionPerformed

    private void miConfirmadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConfirmadasActionPerformed
        // TODO add your handling code here:
        MinhasSolicitacoesConfirmadasPesquisarTela solicitacoesConfirmadasPesquisarTela = new MinhasSolicitacoesConfirmadasPesquisarTela(this.condomino);
        solicitacoesConfirmadasPesquisarTela.setVisible(true);
    }//GEN-LAST:event_miConfirmadasActionPerformed

    private void miExpiradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExpiradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miExpiradasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JMenu menuAcesso;
    private javax.swing.JMenu menuAluguel;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuMinhasSolicitacoes;
    private javax.swing.JMenu menuProdutos;
    private javax.swing.JMenuItem miApartamento;
    private javax.swing.JMenuItem miCategoria;
    private javax.swing.JMenuItem miCondomino;
    private javax.swing.JMenuItem miConfirmadas;
    private javax.swing.JMenuItem miEmAvaliacao;
    private javax.swing.JMenuItem miExpiradas;
    private javax.swing.JMenuItem miPesquisarAluguel;
    private javax.swing.JMenuItem miPesquisarProdutos;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miSolicitacoesProdutos;
    private javax.swing.JMenuItem miTodas;
    // End of variables declaration//GEN-END:variables
}