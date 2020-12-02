package model;
import controller.ProdutoDAO;

public class Produto {
    private int codigo;
    private String nome;
    private double precoUnitario;
    private int quantidade;
    private double precoTotal;
    private String ultimaDataDeCompra;
    private String dataDeCompraAtual;
    private int codigoGrupoFamiliar;
    private int codigoLocalDeCompra;
    ProdutoDAO produtoDAO = new ProdutoDAO();

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

    public String getUltimaDataDeCompra() {
        return this.ultimaDataDeCompra;
    }

    public void setUltimaDataDeCompra(String ultimaDataDeCompra) {
        this.ultimaDataDeCompra = ultimaDataDeCompra;
    }

    public String getDataDeCompraAtual() {
        return this.dataDeCompraAtual;
    }

    public void setDataDeCompraAtual(String dataDeCompraAtual) {
        this.dataDeCompraAtual = dataDeCompraAtual;
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

    public void compararInflacao() throws Exception {
        System.out.println("\nRelatório de Variação da Inflação x Variação dos Preços dos Produtos.");
        AcessarInflacaoIBGE acessarInflacaoIBGE = new AcessarInflacaoIBGE();
        acessarInflacaoIBGE.getValoresInflacao();

        for(Produto produto : produtoDAO.listarProdutos()) {
            System.out.println("\nNome do Produto: " + produto.getNome());
            System.out.println("Preco do Produto: " + produto.getPrecoUnitario());
        }
    }
}
