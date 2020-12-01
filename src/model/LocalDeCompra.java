package model;
import java.util.Calendar;

public class LocalDeCompra {
	private int codigo;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private int diaDePromocao;
	
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

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDiaDePromocao() {
		return this.diaDePromocao;
	}

	public void setDiaDePromocao(int diaDePromocao) {
		this.diaDePromocao = diaDePromocao;
	}

	public void verificarDiaDePromocao() {
		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == getDiaDePromocao()) {
			System.out.println("\nHoje eh Dia de Promocao em " + getNome() + ", aproveite!");
		}
	}
}
