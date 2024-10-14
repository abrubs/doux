package br.com.doux.doux_projeto.entity;
import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table(name ="funcionarios")
public class Funcionarios {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigoFuncionario;
    private String nomeFuncionario;
    private String emailFuncionario;
    private long telefoneFuncionario;
    private String funcaoFuncionario;
    private String senhaFuncionario;
    private int prioridadeFuncionario;

    public long getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(long codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public long getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(long telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getFuncaoFuncionario() {
        return funcaoFuncionario;
    }

    public void setFuncaoFuncionario(String funcaoFuncionario) {
        this.funcaoFuncionario = funcaoFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    public int getPrioridadeFuncionario() {
        return prioridadeFuncionario;
    }

    public void setPrioridadeFuncionario(int prioridadeFuncionario) { this.prioridadeFuncionario = prioridadeFuncionario; }
}



