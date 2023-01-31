package modelo;

public class Produto {
    int idProduto;
    String marca;
    float valor;
    int CategoriaProduto_idCategoria;
    int qtdProd;
    String pesquisa;
    public int getIdProduto(){
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public float getValor(){
        return valor;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
    public int getCategoriaProduto_idCategoria(){
        return CategoriaProduto_idCategoria;
    }
    public void setCategoriaProduto_idCategoria(int CategoriaProduto_idCategoria){
        this.CategoriaProduto_idCategoria = CategoriaProduto_idCategoria;
    }
    public int getQtdProd(){
        return qtdProd;
    }
    public void setQtdProd(int qtdProd){
        this.qtdProd = qtdProd;
    }
    public String getPesquisa() {
        return pesquisa;
    }
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

}
