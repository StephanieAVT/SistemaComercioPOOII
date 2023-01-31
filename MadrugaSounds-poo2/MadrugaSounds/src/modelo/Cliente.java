package modelo;


public class Cliente {
    String cpf;
    String rg;
    String nome;
    String endereco;
    String telefone;
    String email;
    public String getCpf() { 
        return cpf;
    } 
    public void setCpf(String cpf) { 
        this.cpf = cpf;
    } 
    public String getRg() { 
        return rg;
    } 
    public void setRg(String rg) { 
        this.rg = rg;
    }
    public String getNome() { 
        return nome;
    } 
    public void setNome(String nome) { 
        this.nome = nome;
    } 
    public String getEndereco() { 
        return endereco;
    } 
    public void setEndereco(String endereco) { 
        this.endereco = endereco;
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
}
