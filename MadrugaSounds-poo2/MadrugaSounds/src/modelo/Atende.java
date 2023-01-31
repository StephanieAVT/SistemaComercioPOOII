package modelo;

public class Atende {
    private int codAtendimento;
    private String data;
    private int Vendedor_idVendedor;
    private String Cliente_cpf;

    public int getCodAtendimento() {
        return codAtendimento;
    }

    public void setCodAtendimento(int codAtendimento) {
        this.codAtendimento = codAtendimento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getVendedor_idVendedor() {
        return Vendedor_idVendedor;
    }

    public void setVendedor_idVendedor(int Vendedor_idVendedor) {
        this.Vendedor_idVendedor = Vendedor_idVendedor;
    }

    public String getCliente_cpf() {
        return Cliente_cpf;
    }

    public void setCliente_cpf(String Cliente_cpf) {
        this.Cliente_cpf = Cliente_cpf;
    }
}
