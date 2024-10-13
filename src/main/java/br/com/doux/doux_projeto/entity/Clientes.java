    package br.com.doux.doux_projeto.entity;
    import jakarta.persistence.Entity;
     import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;


     @Entity
     @Table(name ="Clientes")
    public class Clientes {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long idCliente;
        private String sobrenomeCliente;
        private String emailCliente;
        private Long telefoneCliente;
        private String nomeCliente;
        private String senhaCliente;
        private int prioridadeCliente;

        public Long getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(Long idCliente) {
            this.idCliente = idCliente;
        }

        public String getSobrenomeCliente() {
            return sobrenomeCliente;
        }

        public void setSobrenomeCliente(String sobrenomeCliente) {
            this.sobrenomeCliente = sobrenomeCliente;
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

        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
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