package banco;

import banco.Model.Funcao;
import java.util.ArrayList;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FuncaoTableModel extends AbstractTableModel {

    private List<String> cabecalho;

    //item - linhas da tabela
    private List<Funcao> listaFuncao;

    public void setListaFuncao(List<Funcao> listaFuncao) {
        this.listaFuncao = listaFuncao;
    }

    public List<Funcao> getListaFuncao() {
        return listaFuncao;
    }

    public FuncaoTableModel() {
        cabecalho = new ArrayList<>();
        listaFuncao = new ArrayList<>();

        cabecalho.add("ID");
        cabecalho.add("NOME");
        cabecalho.add("SALARIO BASE");
        cabecalho.add("VAGAS");
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }

    @Override
    public int getRowCount() {
        return listaFuncao.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //retornar o id
                return listaFuncao.get(rowIndex).getIdFuncao();
            case 1:
                //retornar o nome
                return listaFuncao.get(rowIndex).getNome();
            case 2:
                return listaFuncao.get(rowIndex).getSalariobase();
           case 3:
               return listaFuncao.get(rowIndex).getVagas();
            default:
                return null;
        }
    }

}
