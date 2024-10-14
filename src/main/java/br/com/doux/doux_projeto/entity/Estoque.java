package br.com.doux.doux_projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name ="estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idEstoque;

    // Campo simples para idProduto, sem relacionamento com Produto
    private long idProduto;

    @Transient
    private Produtos produto;

    private long quantidadeDisponivel;
    private String dataUltimaAtualizacao;
    private int prioridadeEstoque;

    // Getters e Setters
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

    // Getter e Setter do Produto
    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
}
