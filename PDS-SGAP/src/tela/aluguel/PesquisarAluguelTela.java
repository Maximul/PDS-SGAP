package tela.aluguel;

import dao.CategoriaDAO;
import modelo.lista.ListaModeloCategorias;
import modelo.tabela.TabelaModeloProdutosDisponiveisRenderer;
import modelo.tabela.TabelaModeloProdutosDisponiveis;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Produto;
import util.JPAUtil;
import dao.ProdutoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import modelo.Categoria;
import modelo.Condomino;

public class PesquisarAluguelTela extends javax.swing.JFrame {

    /**
     * Creates new form PesquisarProduto
     */
    
    private List<Produto> produtos = new ArrayList<>();
    
    private Categoria categoria= new Categoria();

    private List<Categoria> categorias = new ArrayList<>();

    private ProdutoDAO pDAO = new ProdutoDAO();
    private Produto produto = new Produto();
    private EntityManager manager = JPAUtil.getEntityManager(); 

    private Condomino condomino;
    
    public PesquisarAluguelTela(Condomino condomino) {
        initComponents();
        this.condomino = condomino;
    
        pesquisar();    
        preencherTabela();
        preencherCategoria(); 
        carregarMenuFlutuante();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        mPopup = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduto = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jlCategoria = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        bPesquisar = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        tbProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbProdutoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduto);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jlCategoria.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCategoriaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jlCategoria);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setText("Nome");

        bPesquisar.setText("Pesquisar");
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bPesquisar)
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(bPesquisar)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        pesquisar();    
        preencherTabela();
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
        // TODO add your handling code here:
        pesquisar();
        preencherTabela();
    }//GEN-LAST:event_bPesquisarActionPerformed

    private void tbProdutoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutoMouseReleased
        // TODO add your handling code 
        
        selecionarProduto(evt);
    //    realizarAcao(evt);
    }//GEN-LAST:event_tbProdutoMouseReleased

    private void jlCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlCategoriaMouseClicked
   
    private void preencherTabelaByCategoria(Categoria cateoria){
        this.produtos.clear();
        for (Produto p: pDAO.findProduto(categoria, manager)){
            if(p.isStatus()== true)    
                this.produtos.add(p) ;
        }
        preencherTabela();
    }
    private void preencherCategoria(){
        CategoriaDAO cDAO= new CategoriaDAO();
        this.categorias= cDAO.allCategorias();
        jlCategoria.setModel(new ListaModeloCategorias(this.categorias, true)); 
     
        jlCategoria.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                
                int index= jlCategoria.locationToIndex(e.getPoint());   
                
                if(jlCategoria.getModel().getElementAt(index).equals("TODOS")){
                    pesquisar();
                    preencherTabela();
                }
                else {
                    categoria= (Categoria)jlCategoria.getModel().getElementAt(index);
                    preencherTabelaByCategoria(categoria);
                }
            }
            
        });
        

    }
           
    private void selecionarProduto(MouseEvent evt) {

        int linha = tbProduto.rowAtPoint(evt.getPoint());
        int coluna = tbProduto.columnAtPoint(evt.getPoint());

        if (linha >= 0 ) { 
            
            tbProduto.getSelectionModel().setSelectionMode( ListSelectionModel.SINGLE_SELECTION);  
            tbProduto.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
            tbProduto.setCellSelectionEnabled(true);
            
            int indice=((linha)*4)+coluna;
            
            if (indice<this.produtos.size()){
                this.produto = this.produtos.get(indice);
                realizarAcao(evt);
            }
        }

    }
        private void carregarMenuFlutuante(){
        JMenuItem[] itens = {new JMenuItem("Detalhes do produto"), new JMenuItem("Solicitar aluguel")};
        
        itens[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaConsultar();
            }
        });
        
        itens[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaSolicitarAluguel();
            }
        });
        
        for (JMenuItem item : itens) {
            mPopup.add(item);
        }
    }
        
    private void realizarAcao(MouseEvent evt) {

        if (evt.getButton() == MouseEvent.BUTTON1) { 

            if (evt.getClickCount() > 1) { 
                telaConsultar();
            }

        } else if (evt.getButton() == MouseEvent.BUTTON3) { 
            mPopup.show(evt.getComponent(), evt.getX(), evt.getY());

        }

    }
    private void telaConsultar(){
        ConsultarProdutoTela telaConsultar= new ConsultarProdutoTela(this.produto, this.condomino);
        telaConsultar.setVisible(true);
    }
    private void telaSolicitarAluguel(){
        SolicitarAluguelTela telaSolicitarAluguel= new SolicitarAluguelTela(this.produto, this.condomino);
        telaSolicitarAluguel.setVisible(true);
    }
        
    private void preencherTabela() {
        
        //tbProduto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        
        tbProduto.setDefaultRenderer(JPanel.class, new TabelaModeloProdutosDisponiveisRenderer(this.produtos));
        
        tbProduto.setModel(new TabelaModeloProdutosDisponiveis(this.produtos));

        tbProduto.setRowHeight(180); 
    }
    
    private void pesquisar() {
        try {
            this.produtos.clear();
            this.produto.setNome(tfNome.getText());
            this.produtos = pDAO.findProduto(true, this.produto);
        
        } catch (Exception ex) {
            System.out.println("Erro ao pesquisar:" + ex.getCause());
        }
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
            java.util.logging.Logger.getLogger(PesquisarAluguelTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisarAluguelTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisarAluguelTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisarAluguelTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
           //     new PesquisarAluguelTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList jlCategoria;
    private javax.swing.JPopupMenu mPopup;
    private javax.swing.JTable tbProduto;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
