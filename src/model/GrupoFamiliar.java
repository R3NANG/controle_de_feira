package model;
import controller.ProdutoDAO;

public class GrupoFamiliar {
    private int codigo;
    private String nome;
    private double gastos;
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

    public double getGastos() throws Exception {
        for(Produto produto : produtoDAO.listarProdutos()) {
            if(produto.getCodigoGrupoFamiliar() == this.getCodigo()) {
                this.gastos += produto.getPrecoTotal();
            }
        }
        //this.setGastos(this.gastos);
        return this.gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }
}
