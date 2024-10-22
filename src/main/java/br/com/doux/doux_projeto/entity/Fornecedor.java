package br.com.doux.doux_projeto.entity;
import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

 @Entity
 @Table(name ="fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idFornecedor;

     @Pattern(regexp= "\\S+", message = "O user não deve conter espaço")
    private String userFornecedor;

    @Email(message="O campo deve conter um email válido")
    private String emailFornecedor;
    private Long telefoneFornecedor;
    private String enderecoFornecedor;
    private Long cnpj;
    private String dataCadastro;
    private int prioridadeFornecedor;

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getUserFornecedor() {
        return userFornecedor;
    }

    public void setUserFornecedor(String userFornecedor) {
        this.userFornecedor = userFornecedor;
    }

    public String getEmailFornecedor() {
        return emailFornecedor;
    }

    public void setEmailFornecedor(String emailFornecedor) {
        this.emailFornecedor = emailFornecedor;
    }

    public Long getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(Long telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public String getEnderecoFornecedor() {
        return enderecoFornecedor;
    }

    public void setEnderecoFornecedor(String enderecoFornecedor) {
        this.enderecoFornecedor = enderecoFornecedor;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getPrioridadeFornecedor() {
        return prioridadeFornecedor;
    }

    public void setPrioridadeFornecedor(int prioridadeFornecedor) {
        this.prioridadeFornecedor = prioridadeFornecedor;
    }
  


 }
