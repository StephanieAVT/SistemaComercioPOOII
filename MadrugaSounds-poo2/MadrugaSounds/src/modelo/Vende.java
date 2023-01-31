package modelo;

public class Vende {
    private int idVenda;
    private String data;
    private int Vendedor_idVendedor;
    private int Produto_idProduto;

    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the Vendedor_idVendedor
     */
    public int getVendedor_idVendedor() {
        return Vendedor_idVendedor;
    }

    /**
     * @param Vendedor_idVendedor the Vendedor_idVendedor to set
     */
    public void setVendedor_idVendedor(int Vendedor_idVendedor) {
        this.Vendedor_idVendedor = Vendedor_idVendedor;
    }

    /**
     * @return the Produto_idProduto
     */
    public int getProduto_idProduto() {
        return Produto_idProduto;
    }

    /**
     * @param Produto_idProduto the Produto_idProduto to set
     */
    public void setProduto_idProduto(int Produto_idProduto) {
        this.Produto_idProduto = Produto_idProduto;
    }
    
}
