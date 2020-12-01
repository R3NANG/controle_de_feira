package model;

public class Produto {
    private int codigo;
    private String nome;
    private double precoUnitario;
    private int quantidade;
    private double precoTotal;
    private int codigoGrupoFamiliar;
    private int codigoLocalDeCompra;

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return this.precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return this.precoUnitario * this.getQuantidade();
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getCodigoGrupoFamiliar() {
        return this.codigoGrupoFamiliar;
    }

    public void setCodigoGrupoFamiliar(int codigoGrupoFamiliar) {
        this.codigoGrupoFamiliar = codigoGrupoFamiliar;
    }

    public int getCodigoLocalDeCompra() {
        return this.codigoLocalDeCompra;
    }

    public void setCodigoLocalDeCompra(int codigoLocalDeCompra) {
        this.codigoLocalDeCompra = codigoLocalDeCompra;
    }
}
