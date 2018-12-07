/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Model;

/**
 *
 * @author IFMS
 */
public class Funcao {
    
    Integer idFuncao;
    String nome;
    Integer salariobase;
    Integer Vagas;

    public Integer getSalariobase() {
        return salariobase;
    }

    public Integer getVagas() {
        return Vagas;
    }

    public void setVagas(Integer Vagas) {
        this.Vagas = Vagas;
    }

    public void setSalariobase(Integer salariobase) {
        this.salariobase = salariobase;
    }



    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Override
    public String toString() {
        return getNome();
    }
    
    
}
