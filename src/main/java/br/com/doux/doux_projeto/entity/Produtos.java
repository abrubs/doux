package br.com.doux.doux_projeto.entity;
import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table(name ="produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigoProduto;
    private String categoriaProduto;
    private String nomeProduto;
    private String fornecedor;
    private String marca;
    private long estoqueAtual;
    private String descricaoProduto;
    private double preco;
    private int prioridadeProduto;

    public long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(long estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getPrioridadeProduto() {
        return prioridadeProduto;
    }

    public void setPrioridadeProduto(int prioridadeProduto) {
        this.prioridadeProduto = prioridadeProduto;
    }

  

}