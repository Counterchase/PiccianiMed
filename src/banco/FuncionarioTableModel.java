package banco;

import banco.Model.Funcionario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

public class FuncionarioTableModel extends AbstractTableModel {

    private List<String> cabecalho;

    //item - linhas da tabela
    private List<Funcionario> listaFuncionarios;

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
    

    public FuncionarioTableModel() {
        cabecalho = new ArrayList<>();
        listaFuncionarios = new ArrayList<>();

        cabecalho.add("ID");
        cabecalho.add("NOME");
        cabecalho.add("RG");
        cabecalho.add("CPF");
        cabecalho.add("DATA DE NASCIMENTO");
        cabecalho.add("ID CLINICA");
        cabecalho.add("ID FUNCAO");
        cabecalho.add("TURNO");
    }

    public List<String> getCabecalho() {
        return cabecalho;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public void setCabecalho(List<String> cabecalho) {
        this.cabecalho = cabecalho;
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }

    @Override
    public int getRowCount() {
        return listaFuncionarios.size();
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
                return listaFuncionarios.get(rowIndex).getIdFuncionario();
            case 1:
                //retornar o nome
                return listaFuncionarios.get(rowIndex).getNome();
            case 2:
                return listaFuncionarios.get(rowIndex).getRg();
            case 3:
                return listaFuncionarios.get(rowIndex).getCpf();
            case 4:
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return sdf.format(listaFuncionarios.get(rowIndex).getDatanascimento().getTime());
            case 5:
                return listaFuncionarios.get(rowIndex).getIdclinica();
            case 6:
                return listaFuncionarios.get(rowIndex).getIdfuncao();
            case 7:
                return listaFuncionarios.get(rowIndex).getTurno();
            default:
                return null;
        }
    }

}
