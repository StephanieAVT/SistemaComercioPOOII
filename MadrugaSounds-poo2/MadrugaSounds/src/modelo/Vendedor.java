package modelo;

public class Vendedor {
    int idVendedor;
    String nome;
    String dataNasc;
    String telefone;
    String email;
    String endereco;
    String salario;
    int Gerente_idGerente;

    public int getIdVendedor() {
        return idVendedor;
    }
    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getSalario() {
        return salario;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }
    public int getGerente_idGerente() {
        return Gerente_idGerente;
    }
    public void setGerente_idGerente(int Gerente_idGerente) {
        this.Gerente_idGerente = Gerente_idGerente;
    }
    
}
