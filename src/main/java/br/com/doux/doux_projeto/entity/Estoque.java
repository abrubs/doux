package br.com.doux.doux_projeto.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table(name ="estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idEstoque;
    private long idProduto;
    private long quantidadeDisponivel;
    private String dataUltimaAtualizacao;
    private int prioridadeEstoque;

    public long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public long getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(long quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public int getPrioridadeEstoque() {
        return prioridadeEstoque;
    }

    public void setPrioridadeEstoque(int prioridadeEstoque) {
        this.prioridadeEstoque = prioridadeEstoque;
    }

    

}
 