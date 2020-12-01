package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;
import model.GrupoFamiliar;

public class GrupoFamiliarDAO {

    public void create(GrupoFamiliar grupoFamiliar) throws Exception {
        String sql = "INSERT INTO grupo_familiar(nome, gastos) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexao com o bd
            conn = ConnectionFactory.createConnectionToMySQL();
            //Criando uma PreparedStatement para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //Adicionando valores esperados pela query
            pstm.setString(1, grupoFamiliar.getNome());
            pstm.setDouble(2, grupoFamiliar.getGastos());

            //Executando a query
            pstm.execute();
            System.out.println("\nGrupo Familiar criado com sucesso!");
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

    public List<GrupoFamiliar> listarGruposFamiliares() throws Exception {
        String sql = "SELECT * FROM grupo_familiar";

        List<GrupoFamiliar> gruposFamiliares = new ArrayList<GrupoFamiliar>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que recupera os dados do bd
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                GrupoFamiliar grupoFamiliar = new GrupoFamiliar();

                grupoFamiliar.setCodigo(rset.getInt("codigo"));
                grupoFamiliar.setNome(rset.getString("nome"));
                grupoFamiliar.setGastos(rset.getDouble("gastos"));

                gruposFamiliares.add(grupoFamiliar);
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

        return gruposFamiliares;
    }

    public void update(GrupoFamiliar grupoFamiliar) throws Exception {
        String sql = "UPDATE grupo_familiar SET nome = ?, gastos = ? WHERE codigo = " + grupoFamiliar.getCodigo();

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, grupoFamiliar.getNome());
            pstm.setDouble(2, grupoFamiliar.getGastos());
            pstm.execute();
            System.out.println("\nGrupo Familiar alterado com sucesso!");
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
        String sql = "DELETE FROM grupo_familiar WHERE codigo = " + codigo;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.execute(sql);
            System.out.println("\nGrupo Familiar deletado com sucesso!");
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
        String sql = "DELETE FROM grupo_familiar WHERE nome = \"" + nome + "\"";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.execute(sql);
            System.out.println("\nGrupo Familiar deletado com sucesso!");
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
