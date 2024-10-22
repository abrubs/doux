package br.com.doux.doux_projeto.entity;
import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

 @Entity
 @Table(name ="funcionarios")
public class Funcionarios {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigoFuncionario;
    private String nomeCompletoFuncionario;

    @Email(message="O campo deve conter um email válido")
    private String emailFuncionario;
    private long telefoneFuncionario;
    private String funcaoFuncionario;
    private String senhaFuncionario;
    private int prioridadeFuncionario;
     @Pattern(regexp= "\\S+", message = "O user não deve conter espaço")
    private String userFuncionario;

    public long getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(long codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNomeCompletoFuncionario() {
        return nomeCompletoFuncionario;
    }

    public void setNomeCompletoFuncionario(String nomeCompletoFuncionario) {
        this.nomeCompletoFuncionario = nomeCompletoFuncionario;
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

    public String getUserFuncionario() {
        return userFuncionario;
    }

    public void setUserFuncionario(String userFuncionario) {
        this.userFuncionario = userFuncionario;
    }

    public int getPrioridadeFuncionario() {
        return prioridadeFuncionario;
    }

    public void setPrioridadeFuncionario(int prioridadeFuncionario) { this.prioridadeFuncionario = prioridadeFuncionario; }
}



