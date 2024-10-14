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
    private long CodigoFuncionario;
    private String NomeFuncionario;
    private String EmailFuncionario;
    private long TelefoneFuncionario;
    private String FuncaoFuncionario;
    private String SenhaFuncionario;
    private int PrioridadeFuncionario;

    public long getCodigoFuncionario() {
        return CodigoFuncionario;
    }

    public void setCodigoFuncionario(long CodigoFuncionario) {
        this.CodigoFuncionario = CodigoFuncionario;
    }

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public String getEmailFuncionario() {
        return EmailFuncionario;
    }

    public void setEmailFuncionario(String EmailFuncionario) {
        this.EmailFuncionario = EmailFuncionario;
    }

    public long getTelefoneFuncionario() {
        return TelefoneFuncionario;
    }

    public void setTelefoneFuncionario(long TelefoneFuncionario) {
        this.TelefoneFuncionario = TelefoneFuncionario;
    }

    public String getFuncaoFuncionario() {
        return FuncaoFuncionario;
    }

    public void setFuncaoFuncionario(String FuncaoFuncionario) {
        this.FuncaoFuncionario = FuncaoFuncionario;
    }

    public String getSenhaFuncionario() {
        return SenhaFuncionario;
    }

    public void setSenhaFuncionario(String SenhaFuncionario) {
        this.SenhaFuncionario = SenhaFuncionario;
    }

    public int getPrioridadeFuncionario() {
        return PrioridadeFuncionario;
    }

    public void setPrioridadeFuncionario(int PrioridadeFuncionario) {
        this.PrioridadeFuncionario = PrioridadeFuncionario;
    }


    
}



