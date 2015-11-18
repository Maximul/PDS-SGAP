
package tela.solicitacao;

import modelo.lista.ListaModeloComentarios;
import dao.ProdutoDAO;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import modelo.Comentario;
import modelo.Condomino;
import modelo.ImagemProduto;
import modelo.Produto;
import modelo.painel.PainelModeloImagens;
import util.JPAUtil;

public class AluguelDetalhesTela extends javax.swing.JFrame {

    /**
     * Creates new form AluguelDetalhesTela
     */
    
    private Produto produto= new Produto();
    private ProdutoDAO dao= new ProdutoDAO();
    private List<Comentario> comentarios = new ArrayList<>();
    private Condomino condomino;
    private JPanel img;


    public AluguelDetalhesTela(Produto produto, Condomino condomino) {
        this.produto=produto;
        this.condomino=condomino;
        initComponents();
        carregarProduto();
    }
    
    public void preencherCampos(){
        
        tfDono.setText(this.produto.getCondomino().getNome());
        tfProduto.setText(this.produto.getNome());
        tfDescricao.setText(this.produto.getDescricao());

        SpinnerNumberModel spModel = new SpinnerNumberModel(produto.getQuantidade(), 1, produto.getQuantidade(), 1);  
        
        tfContato.setText(produto.getCondomino().getTelefones().get(0));
        spQuantidade.setModel(spModel);  
        spQuantidade.setValue( produto.getQuantidade());
        tfReputacao.setText("calcular reputação");
        img = img1;
        mudarCorPaineis();
    }
    
    public void preencherComentarios(){
        //FALTA FAZER O DAO DE COMENTARIO
        EntityManager manager = JPAUtil.getEntityManager();
          
        String consulta="select p from Comentario p where produto_codigo = :codigo";
        TypedQuery<Comentario> query =manager.createQuery(consulta, Comentario.class);
        query.setParameter("codigo", this.produto.getCodigo());
        query.setMaxResults(10);
        
        this.comentarios = query.getResultList();
        this.jlComentarios.setModel(new ListaModeloComentarios(comentarios));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        lNome2 = new javax.swing.JLabel();
        lNome4 = new javax.swing.JLabel();
        tfDono = new javax.swing.JLabel();
        lNome6 = new javax.swing.JLabel();
        tfReputacao = new javax.swing.JLabel();
        bAlugar = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        bCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jlComentarios = new javax.swing.JList();
        spQuantidade = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        tfDescricao = new javax.swing.JLabel();
        tfProduto = new javax.swing.JLabel();
        painelImagens = new javax.swing.JPanel();
        imgPrincipal = new javax.swing.JPanel();
        img1 = new javax.swing.JPanel();
        img2 = new javax.swing.JPanel();
        img3 = new javax.swing.JPanel();
        tfContato = new javax.swing.JLabel();
        lNome7 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Produto");

        lNome2.setText("Quantidade");

        lNome4.setText("Reputação:");

        tfDono.setText("DONO PRODUTO");

        lNome6.setText("Dono");

        tfReputacao.setText("calcular reptação");

        bAlugar.setText("Alugar");
        bAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlugarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Avaliações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jlComentarios.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jlComentarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        spQuantidade.setEnabled(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel4.setToolTipText("");

        tfDescricao.setText("descricao");

        tfProduto.setText("NOME DO PRODUTO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDescricao)
                    .addComponent(tfProduto))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfProduto)
                .addGap(7, 7, 7)
                .addComponent(tfDescricao)
                .addContainerGap())
        );

        painelImagens.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Imagens", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        painelImagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                painelImagensMouseReleased(evt);
            }
        });

        imgPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        imgPrincipal.setLayout(new java.awt.BorderLayout());

        img1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                img1MouseReleased(evt);
            }
        });
        img1.setLayout(new java.awt.BorderLayout());

        img2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                img2MouseReleased(evt);
            }
        });
        img2.setLayout(new java.awt.BorderLayout());

        img3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                img3MouseReleased(evt);
            }
        });
        img3.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout painelImagensLayout = new javax.swing.GroupLayout(painelImagens);
        painelImagens.setLayout(painelImagensLayout);
        painelImagensLayout.setHorizontalGroup(
            painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImagensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(img1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        painelImagensLayout.setVerticalGroup(
            painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(painelImagensLayout.createSequentialGroup()
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        tfContato.setText("DONO PRODUTO");

        lNome7.setText("Contato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(bAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCancelar)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lNome2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lNome4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfReputacao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lNome6)
                                            .addComponent(lNome7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfContato, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfDono, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNome2)
                            .addComponent(spQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNome6)
                            .addComponent(tfDono))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfContato)
                            .addComponent(lNome7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNome4)
                            .addComponent(tfReputacao)))
                    .addComponent(painelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAlugar)
                    .addComponent(bCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlugarActionPerformed
        // TODO add your handling code here:
        telaAlugarProduto();
        dispose();
    }//GEN-LAST:event_bAlugarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void img1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img1MouseReleased
        img = img1;
        realizarAcao(evt);
    }//GEN-LAST:event_img1MouseReleased

    private void img2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img2MouseReleased
        img = img2;
        realizarAcao(evt);
    }//GEN-LAST:event_img2MouseReleased

    private void img3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img3MouseReleased
        img = img3;
        realizarAcao(evt);
    }//GEN-LAST:event_img3MouseReleased

    private void painelImagensMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelImagensMouseReleased
        img = null;
        mudarCorPaineis();
    }//GEN-LAST:event_painelImagensMouseReleased
    private void realizarAcao(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1) {
            mudarCorPaineis();
        }
    }
    public void telaAlugarProduto (){
        AluguelSolicitarTela telaAlugarProduto =  new AluguelSolicitarTela(this.produto, this.condomino);
        telaAlugarProduto.setVisible(true);
    }

    private void mudarCorPaineis(){
        imgPrincipal.removeAll();
        imgPrincipal.repaint();
        img1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        img3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        img2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        if (img != null) {
            if (img.getComponents().length > 0) {
                PainelModeloImagens newImage = new PainelModeloImagens();
                newImage.setBfImage(((PainelModeloImagens) img.getComponent(0)).getBfImage());
                imgPrincipal.add(newImage);
                imgPrincipal.revalidate();
                img.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
            }
        }
    }
    
    private void carregarProduto(){
        carregarImagens();
        preencherCampos();
        preencherComentarios();
    }
    
    private void carregarImagens(){
        img1.removeAll();
        img2.removeAll();
        img3.removeAll();
        int cont = 1;
        for (ImagemProduto imagem: produto.getImagensProduto()) {
            PainelModeloImagens painelImg = carregarImagem(imagem);
            switch(cont){
                case 1: mostrarImagem(img1, painelImg);
                        break;
                case 2: mostrarImagem(img2, painelImg);
                        break;
                case 3: mostrarImagem(img3, painelImg);
                        break;
            }
            cont ++;
        }
    }
    
    private PainelModeloImagens carregarImagem(ImagemProduto imagem){
        BufferedImage imagemLocal;
        PainelModeloImagens painelRetorno;
        try {
            imagemLocal = ImageIO.read(new ByteArrayInputStream(imagem.getImagem()));
            painelRetorno = new PainelModeloImagens();
            painelRetorno.setBfImage(imagemLocal);
        } catch (IOException ex) {
            painelRetorno = null;
        }
        return painelRetorno;
    }
    
    private void mostrarImagem(JPanel painel, PainelModeloImagens imagemPainel){
        painel.add(imagemPainel);
        painel.revalidate();
    }
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
            java.util.logging.Logger.getLogger(AluguelDetalhesTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AluguelDetalhesTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AluguelDetalhesTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AluguelDetalhesTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new AluguelDetalhesTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bAlugar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JPanel img1;
    private javax.swing.JPanel img2;
    private javax.swing.JPanel img3;
    private javax.swing.JPanel imgPrincipal;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JList jlComentarios;
    private javax.swing.JLabel lNome2;
    private javax.swing.JLabel lNome4;
    private javax.swing.JLabel lNome6;
    private javax.swing.JLabel lNome7;
    private javax.swing.JPanel painelImagens;
    private javax.swing.JSpinner spQuantidade;
    private javax.swing.JLabel tfContato;
    private javax.swing.JLabel tfDescricao;
    private javax.swing.JLabel tfDono;
    private javax.swing.JLabel tfProduto;
    private javax.swing.JLabel tfReputacao;
    // End of variables declaration//GEN-END:variables
}