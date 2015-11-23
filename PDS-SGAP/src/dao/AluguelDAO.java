package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Aluguel;
import modelo.Avaliacao;
import modelo.Comentario;
import modelo.Produto;
import util.JPAUtil;

public class AluguelDAO {
    
    public void addAluguel(Aluguel aluguelAdicionar){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(aluguelAdicionar);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void removeAluguel(Aluguel aluguelExclusao){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.remove(aluguelExclusao);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void alterAluguel(Aluguel aluguelAlteracao){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(aluguelAlteracao);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<Aluguel> findAlugueis(){
        List<Aluguel> alugueis;
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Aluguel> query = manager.createQuery("SELECT a FROM Aluguel a", Aluguel.class);
        
        try {
            alugueis = query.getResultList();
        } catch (NoResultException e) {
            alugueis = null;
        }
        
        return alugueis;
    }
    
    public List<Aluguel>  findProdutoAlugado(Long locatario, String produto){ // busca produtos de um locador que estão alugados no momento
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<Aluguel> produtoRetorno; // = new ArrayList<>();
        
        try{
            String consulta = "CALL SP_BUSCA_MEUSPRODUTOSALUGADOS(:codigo, :produto)";
            Query query = manager.createNativeQuery(consulta, Aluguel.class);
            query.setParameter("codigo", Integer.parseInt(String.valueOf(locatario)));
            query.setParameter("produto", produto);
            
            produtoRetorno = query.getResultList();
        } catch (NoResultException ex) {
            produtoRetorno = null;
}
        manager.close();
        
        return  produtoRetorno;
    }
    
    public List<Aluguel> listaAluguelAndamento(Long codigo, String nome){ // para locatario
        EntityManager manager = JPAUtil.getEntityManager();
        List<Aluguel> alugueisAndamento = null;
        
        try{
            
            if(nome.equals("")){
                String consulta = "SELECT a FROM Aluguel a "
                                + "WHERE a.solicitacaoAluguel.locatario.codigo = :codigo "
                                + "AND a.dataDevolucao IS NULL"; 
                TypedQuery<Aluguel> query = manager.createQuery(consulta, Aluguel.class);
                query.setParameter("codigo", codigo);
                alugueisAndamento = query.getResultList();
            }
            else{
                String consulta = "SELECT a FROM Aluguel a "
                                + "WHERE a.solicitacaoAluguel.locatario.codigo = :codigo "
                                + "AND a.solicitacaoAluguel.produto.nome LIKE :nomeProduto "
                                + "AND a.dataDevolucao IS NULL";
            
                TypedQuery<Aluguel> query = manager.createQuery(consulta, Aluguel.class);
                query.setParameter("codigo", codigo);
                query.setParameter("nomeProduto", "%"+nome+"%");
                alugueisAndamento = query.getResultList();
            }
        }
        catch(TypeNotPresentException ex){
            ex.getCause();
        }
        
        manager.close();
        return alugueisAndamento;
    }
    
    public List<Aluguel> listaAluguelConcluido(Long codigo, String nome){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Aluguel> alugueisConcluido = null;
        
        try{
            
            if(nome.equals("")){
                String consulta = "SELECT a FROM Aluguel a "
                                + "WHERE a.solicitacaoAluguel.locatario.codigo = :codigo "
                                + "AND a.dataDevolucao IS NOT NULL"; 
                TypedQuery<Aluguel> query = manager.createQuery(consulta, Aluguel.class);
                query.setParameter("codigo", codigo);
                alugueisConcluido = query.getResultList();
            }
            else{
                String consulta = "SELECT a FROM Aluguel a "
                                + "WHERE a.solicitacaoAluguel.locatario.codigo = :codigo "
                                + "AND a.solicitacaoAluguel.produto.nome LIKE :nomeProduto "
                                + "AND a.dataDevolucao IS NOT NULL";
            
                TypedQuery<Aluguel> query = manager.createQuery(consulta, Aluguel.class);
                query.setParameter("codigo", codigo);
                query.setParameter("nomeProduto", "%"+nome+"%");
                alugueisConcluido = query.getResultList();
            }
        }
        catch(TypeNotPresentException ex){
            ex.getCause();
        }
        
        manager.close();
        return alugueisConcluido;
    }
    
    public double calculaReputacao(Produto produto){
        double reputacao;
        List<Avaliacao> avaliacoes;
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery("SELECT a.comentario.avaliacao FROM Aluguel a WHERE a.solicitacaoAluguel IN (SELECT s FROM SolicitacaoAluguel s WHERE s.produto = :produto)", Avaliacao.class);
        query.setParameter("produto", produto);
        
        try {
            avaliacoes = query.getResultList();
            int qtdePositivo = 0, qtdeNeutro = 0, qtdeNegativo = 0;
            for (Avaliacao avaliacao: avaliacoes) {
                switch (avaliacao){
                    case NEGATIVA: qtdeNegativo++;
                                   break;
                    case NEUTRA: qtdeNeutro++;
                                   break;
                    case POSITIVA: qtdePositivo++;
                                   break;
                }
            }
            reputacao = (double)(((double)(1*qtdePositivo) + (double)(0.75*qtdeNeutro) - (double)(0.25*qtdeNegativo))/((double) avaliacoes.size()));
            reputacao = reputacao * 100;
        } catch (NoResultException ex) {
            avaliacoes = null;
            reputacao = -1;
        }
        
        manager.close();
        return reputacao;
    }
}