    package br.com.doux.doux_projeto.entity;
    import jakarta.persistence.Entity;
     import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;


     @Entity
     @Table(name ="Clientes")
    public class Clientes {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long idCliente;
        private String nomeCliente;
        private String nomeCompletoCliente;

        @Email(message="O campo deve conter um email válido")
        
        private String emailCliente;
        private Long telefoneCliente;

        @Pattern(regexp= "\\S+", message = "O user não deve conter espaço")
        private String userCliente;
        
        private String senhaCliente;
        private int prioridadeCliente;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCompletoCliente() {
        return nomeCompletoCliente;
    }

    public void setNomeCompletoCliente(String nomeCompletoCliente) {
        this.nomeCompletoCliente = nomeCompletoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Long getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(Long telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getUserCliente() {
        return userCliente;
    }

    public void setUserCliente(String userCliente) {
        this.userCliente = userCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public int getPrioridadeCliente() {
        return prioridadeCliente;
    }

    public void setPrioridadeCliente(int prioridadeCliente) {
        this.prioridadeCliente = prioridadeCliente;
    }

}