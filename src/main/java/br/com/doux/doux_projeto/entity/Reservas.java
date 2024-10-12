package br.com.doux.doux_projeto.entity;
import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table(name ="reservas")
public class Reservas {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long IdReserva;
    private long IdCliente;
    private long IdProduto;
    private long Quantidade;
    private String DataReserva;
    private String StatusReserva;
    private int PrioridadeReserva;

    public long getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(long IdReserva) {
        this.IdReserva = IdReserva;
    }

    public long getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(long IdCliente) {
        this.IdCliente = IdCliente;
    }

    public long getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(long IdProduto) {
        this.IdProduto = IdProduto;
    }

    public long getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(long Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getDataReserva() {
        return DataReserva;
    }

    public void setDataReserva(String DataReserva) {
        this.DataReserva = DataReserva;
    }

    public String getStatusReserva() {
        return StatusReserva;
    }

    public void setStatusReserva(String StatusReserva) {
        this.StatusReserva = StatusReserva;
    }

    public int getPrioridadeReserva() {
        return PrioridadeReserva;
    }

    public void setPrioridadeReserva(int PrioridadeReserva) {
        this.PrioridadeReserva = PrioridadeReserva;
    }
}
