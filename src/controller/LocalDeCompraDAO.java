package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;
import model.LocalDeCompra;

public class LocalDeCompraDAO {
	
	public void create(LocalDeCompra localDeCompra) throws Exception {
		String sql = "INSERT INTO local_de_compra(nome, endereco, telefone, email, dia_de_promocao) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexao com o bd
			conn = ConnectionFactory.createConnectionToMySQL();
			//Criando uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionando valores esperados pela query
			pstm.setString(1, localDeCompra.getNome());
			pstm.setString(2, localDeCompra.getEndereco());
			pstm.setString(3, localDeCompra.getTelefone());
			pstm.setString(4, localDeCompra.getEmail());
			pstm.setInt(5, localDeCompra.getDiaDePromocao());
			
			//Executando a query
			pstm.execute();
			System.out.println("\nLocal de Compra criado com sucesso!");
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

	public List<LocalDeCompra> listarLocaisDeCompra() throws Exception {
		String sql = "SELECT * FROM local_de_compra";

		List<LocalDeCompra> locaisDeCompra = new ArrayList<LocalDeCompra>();

		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que recupera os dados do bd
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				LocalDeCompra localDeCompra= new LocalDeCompra();

				localDeCompra.setCodigo(rset.getInt("codigo"));
				localDeCompra.setNome(rset.getString("nome"));
				localDeCompra.setEndereco(rset.getString("endereco"));
				localDeCompra.setTelefone(rset.getString("telefone"));
				localDeCompra.setEmail(rset.getString("email"));
				localDeCompra.setDiaDePromocao(rset.getInt("dia_de_promocao"));

				locaisDeCompra.add(localDeCompra);
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

		return locaisDeCompra;
	}

	public void update(LocalDeCompra localDeCompra) throws Exception {
		String sql = "UPDATE local_de_compra SET nome = ?, endereco = ?, telefone = ?, email = ?, dia_de_promocao = ? WHERE codigo = " + localDeCompra.getCodigo();

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, localDeCompra.getNome());
			pstm.setString(2, localDeCompra.getEndereco());
			pstm.setString(3, localDeCompra.getTelefone());
			pstm.setString(4, localDeCompra.getEmail());
			pstm.setInt(5, localDeCompra.getDiaDePromocao());
			pstm.execute();
			System.out.println("\nLocal de Compra alterado com sucesso!");
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
		String sql = "DELETE FROM local_de_compra WHERE codigo = " + codigo;

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.execute(sql);
			System.out.println("\nLocal de Compra deletado com sucesso!");
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
		String sql = "DELETE FROM local_de_compra WHERE nome = \"" + nome + "\"";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.execute(sql);
			System.out.println("\nLocal de Compra deletado com sucesso!");
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
