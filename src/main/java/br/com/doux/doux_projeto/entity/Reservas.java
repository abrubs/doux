package br.com.doux.doux_projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
 @Table(name ="reservas")
public class Reservas {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idReserva;

    private long idCliente;
    private long idProduto;
    private long quantidade;
    private String dataReserva;
    private String statusReserva;
    private int prioridadeReserva;

    @Transient
    private Produtos produto;

    @Transient
    private Clientes cliente;

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdProduto() { return idProduto; }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(String statusReserva) {
        this.statusReserva = statusReserva;
    }

    public int getPrioridadeReserva() {
        return prioridadeReserva;
    }

    public void setPrioridadeReserva(int prioridadeReserva) {
        this.prioridadeReserva = prioridadeReserva;
    }

    public Produtos getProduto() { return produto; }

    public Clientes getCliente() { return cliente; }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}
