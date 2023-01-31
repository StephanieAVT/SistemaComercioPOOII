package modelo;

import java.beans.PropertyChangeSupport;

public class Gerente {
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    int idGerente;
    String nome;
    String endereco;
    String dataNasc;
    String telefone;
    String email;
    String salario;
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;

    }
    public int getIdGerente() {
        return idGerente;
    }
    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    } 
    public String getNome() { 
        return nome;
    } 
    public void setNome(String nome) { 
        this.nome = nome;
    } 
    public String getTelefone() { 
        return telefone;
    } 
    public void setTelefone(String telefone) { 
        this.telefone = telefone;
    } 
    public String getSalario(){
        return salario;
    } 
    public void setSalario(String salario){
        this.salario = salario;
    }
    public String getDataNasc(){
        return dataNasc;
    }
    public void setDataNasc(String dataNasc){
        String oldDataNasc = this.dataNasc;
        this.dataNasc = dataNasc;
        changeSupport.firePropertyChange("dataNascimento", oldDataNasc, dataNasc);
    }
}

