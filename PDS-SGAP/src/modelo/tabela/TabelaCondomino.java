package modelo.tabela;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Condomino;

/**
 *
 * @author Bruna
 */
public class TabelaCondomino extends AbstractTableModel{
    public List<Condomino> condominos;
    public String[] colunas = {"Nome", "CPF", "Apartamento"};

    public TabelaCondomino(List<Condomino> condominos) {
        this.condominos = condominos;
    }

    @Override
    public int getRowCount() {
        return condominos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        Condomino condomino = condominos.get(linha);
        
        switch(coluna){
            case 0: return condomino.getNome();
            case 1: return condomino.getCpf();
            case 2: return condomino.getApartamento();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int coluna){
        return colunas[coluna];
    }

}