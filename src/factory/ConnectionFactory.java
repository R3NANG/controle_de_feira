package factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	//Nome do usuario do mysql
	private static final String USERNAME = "root";
	
	//Senha do bd
	private static final String PASSWORD = "1122334455Mysql";
	
	//Caminho do bd
	private static final String DATABASE_URL = "jdbc:mysql://localhost/bd_controle_de_feira?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	//Conexao com o bd
	public static Connection createConnectionToMySQL() throws Exception {
		//Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Cria a conexao com o bd
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String args[]) throws Exception {
		//Recuperar uma conexao com o bd
		Connection con = createConnectionToMySQL();
		
		//Testar se a conexao eh nula
		if(con != null) {
			System.out.println("Conexao Obtida com Sucesso!");
			con.close();
		}
	}
}
