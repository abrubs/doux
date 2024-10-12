package br.com.doux.doux_projeto.entity;
import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table(name ="fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long IdFornecedor;
    private String NomeFornecedor;
    private String EmailFornecedor;
    private Long TelefoneFornecedor;
    private String EnderecoFornecedor;
    private Long Cnpj;
    private String DataCadastro;
    private int PrioridadeFornecedor;

    public Long getIdFornecedor() {
        return IdFornecedor;
    }

    public void setIdFornecedor(Long IdFornecedor) {
        this.IdFornecedor = IdFornecedor;
    }

    public String getNomeFornecedor() {
        return NomeFornecedor;
    }

    public void setNomeFornecedor(String NomeFornecedor) {
        this.NomeFornecedor = NomeFornecedor;
    }

    public String getEmailFornecedor() {
        return EmailFornecedor;
    }

    public void setEmailFornecedor(String EmailFornecedor) {
        this.EmailFornecedor = EmailFornecedor;
    }

    public Long getTelefoneFornecedor() {
        return TelefoneFornecedor;
    }

    public void setTelefoneFornecedor(Long TelefoneFornecedor) {
        this.TelefoneFornecedor = TelefoneFornecedor;
    }

    public String getEnderecoFornecedor() {
        return EnderecoFornecedor;
    }

    public void setEnderecoFornecedor(String EndereçoFornecedor) {
        this.EnderecoFornecedor = EndereçoFornecedor;
    }

    public Long getCnpj() {
        return Cnpj;
    }

    public void setCnpj(Long Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(String DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public int getPrioridadeFornecedor() {
        return PrioridadeFornecedor;
    }

    public void setPrioridadeFornecedor(int PrioridadeFornecedor) {
        this.PrioridadeFornecedor = PrioridadeFornecedor;
    }
 }
