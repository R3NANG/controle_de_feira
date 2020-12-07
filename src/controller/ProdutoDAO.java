package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;
import model.Produto;

public class ProdutoDAO {

    public void create(Produto produto) throws Exception {
        String sql = "INSERT INTO produto(nome, precoUnitario, quantidade, precoTotal, ultima_data_de_compra, data_de_compra_atual, codigo_grupo_familiar, codigo_local_de_compra) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexao com o bd
            conn = ConnectionFactory.createConnectionToMySQL();
            //Criando uma PreparedStatement para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //Adicionando valores esperados pela query
            pstm.setString(1, produto.getNome());
            pstm.setDouble(2, produto.getPrecoUnitario());
            pstm.setInt(3, produto.getQuantidade());
            pstm.setDouble(4, produto.getPrecoTotal());
            pstm.setString(5, produto.getUltimaDataDeCompra());
            pstm.setString(6, produto.getDataDeCompraAtual());
            pstm.setInt(7, produto.getCodigoGrupoFamiliar());
            pstm.setInt(8, produto.getCodigoLocalDeCompra());

            //Executando a query
            pstm.execute();
            System.out.println("\nProduto criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Fechando as conexoes
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<Produto> listarProdutos() throws Exception {
        String sql = "SELECT * FROM produto";

        List<Produto> produtos = new ArrayList<Produto>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que recupera os dados do bd
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Produto produto = new Produto();

                produto.setCodigo(rset.getInt("codigo"));
                produto.setNome(rset.getString("nome"));
                produto.setPrecoUnitario(rset.getDouble("precoUnitario"));
                produto.setQuantidade(rset.getInt("quantidade"));
                produto.setPrecoTotal(rset.getDouble("precoTotal"));
                produto.setUltimaDataDeCompra(rset.getString("ultima_data_de_compra"));
                produto.setDataDeCompraAtual(rset.getString("data_de_compra_atual"));
                produto.setCodigoGrupoFamiliar(rset.getInt("codigo_grupo_familiar"));
                produto.setCodigoLocalDeCompra(rset.getInt("codigo_local_de_compra"));

                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rset != null) {
                    rset.close();
                }

                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return produtos;
    }

    public void update(Produto produto) throws Exception {
        String sql = "UPDATE produto SET nome = ?, precoUnitario = ?, quantidade = ?, ultima_data_de_compra = ?, data_de_compra_atual = ? WHERE codigo = " + produto.getCodigo();

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, produto.getNome());
            pstm.setDouble(2, produto.getPrecoUnitario());
            pstm.setInt(3, produto.getQuantidade());
            pstm.setString(4, produto.getUltimaDataDeCompra());
            pstm.setString(5, produto.getDataDeCompraAtual());
            pstm.execute();
            System.out.println("\nProduto alterado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int codigo) throws Exception {
        String sql = "DELETE FROM produto WHERE codigo = " + codigo;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.execute(sql);
            System.out.println("\nProduto deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(String nome) throws Exception {
        String sql = "DELETE FROM produto WHERE nome = \"" + nome + "\"";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.execute(sql);
            System.out.println("\nProduto deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
