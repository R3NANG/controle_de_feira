package aplicacao;
import controller.GrupoFamiliarDAO;
import controller.LocalDeCompraDAO;
import controller.ProdutoDAO;
import model.GrupoFamiliar;
import model.LocalDeCompra;
import model.Produto;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(System.in);
		int op = 0, op1 = 0, op2 = 0, op3 = 0;
		GrupoFamiliarDAO grupoFamiliarDAO = new GrupoFamiliarDAO();
		LocalDeCompraDAO localDeCompraDAO = new LocalDeCompraDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();

		//Verificando se eh dia de promocao em algum Local de Compra
		for(LocalDeCompra localDeCompraPromocao : localDeCompraDAO.listarLocaisDeCompra()) {
			localDeCompraPromocao.verificarDiaDePromocao();
		}

		do {
			System.out.println("\n======MENU PRINCIPAL======");
			System.out.println("1 - Criar.");
			System.out.println("2 - Listar.");
			System.out.println("3 - Editar.");
			System.out.println("4 - Deletar.");
			System.out.println("5 - Exibir Relatorio de Inflacao.");
			System.out.println("0 - Encerrar o Programa.");
			System.out.printf("Digite sua Opcao: ");
			op = Integer.parseInt(entrada.nextLine());

			switch (op) {
				case 1:
					do {
						System.out.println("\nOpcoes de Criacao:");
						System.out.println("1 - Grupo Familiar.");
						System.out.println("2 - Local de Compra.");
						System.out.println("3 - Produto.");
						System.out.println("0 - Voltar ao Menu Principal.");
						System.out.printf("Digite sua Opcao: ");
						op1 = Integer.parseInt(entrada.nextLine());

						switch (op1) {
							case 1:
								String nome;
								System.out.printf("\nDigite o Nome do Grupo Familiar: ");
								nome = entrada.nextLine();

								GrupoFamiliar grupoFamiliar = new GrupoFamiliar();
								grupoFamiliar.setNome(nome);
								grupoFamiliarDAO.create(grupoFamiliar);
								break;

							case 2:
								String nome1, endereco, telefone, email;
								int  diaDePromocao;
								System.out.printf("\nDigite o Nome do Local de Compra: ");
								nome1 = entrada.nextLine();
								System.out.printf("Digite o Endereco do Local de Compra: ");
								endereco = entrada.nextLine();
								System.out.printf("Digite o Telefone do Local de Compra: ");
								telefone = entrada.nextLine();
								System.out.printf("Digite o Email do Local de Compra: ");
								email = entrada.nextLine();
								System.out.printf("| 1 - Domingo | 2 - Segunda | 3 - Terca | 4 - Quarta | 5 - Quinta | 6 - Sexta | 7 - Sabado |\n");
								System.out.printf("Digite o Dia de Promocao do Local de Compra utilizando a base acima: ");
								diaDePromocao = Integer.parseInt(entrada.nextLine());

								LocalDeCompra localDeCompra = new LocalDeCompra();
								localDeCompra.setNome(nome1);
								localDeCompra.setEndereco(endereco);
								localDeCompra.setTelefone(telefone);
								localDeCompra.setEmail(email);
								localDeCompra.setDiaDePromocao(diaDePromocao);
								localDeCompraDAO.create(localDeCompra);
								break;

							case 3:
								int codigo;
								System.out.printf("\nDigite o Codigo do Grupo Familiar para quem você vai cadastrar o Produto: ");
								codigo = Integer.parseInt(entrada.nextLine());

								for(GrupoFamiliar grupoFamiliar1 : grupoFamiliarDAO.listarGruposFamiliares()) {
									if(grupoFamiliar1.getCodigo() == codigo) {
										int codigo1;
										System.out.printf("Digite o Codigo do Local de Compra para qual você vai cadastrar o Produto: ");
										codigo1 = Integer.parseInt(entrada.nextLine());

										for(LocalDeCompra localDeCompra1 : localDeCompraDAO.listarLocaisDeCompra()) {
											if(localDeCompra1.getCodigo() == codigo1) {
												String nome2;
												double precoUnitario;
												int quantidade;
												System.out.printf("\nDigite o Nome do Produto: ");
												nome2 = entrada.nextLine();
												System.out.printf("Digite o Preco do Produto: ");
												precoUnitario = Double.parseDouble(entrada.nextLine());
												System.out.printf("Digite a Quantidade de Produtos: ");
												quantidade = Integer.parseInt(entrada.nextLine());

												Produto produto = new Produto();
												produto.setNome(nome2);
												produto.setPrecoUnitario(precoUnitario);
												produto.setQuantidade(quantidade);
												produto.setCodigoGrupoFamiliar(grupoFamiliar1.getCodigo());
												produto.setCodigoLocalDeCompra(localDeCompra1.getCodigo());
												produtoDAO.create(produto);
												break;
											}
										}
									}
								}
								break;

							case 0:
								System.out.println("\nVoltando ao Menu Principal...");
								break;

							default:
								System.out.println("\nOpcao Invalida.");
								break;
						}
					} while (op1 != 0);
					break;

				case 2:
					do {
						System.out.println("\nOpcoes de Listagem:");
						System.out.println("1 - Grupo Familiar.");
						System.out.println("2 - Local de Compra.");
						System.out.println("3 - Produto.");
						System.out.println("0 - Voltar ao Menu Principal.");
						System.out.printf("Digite sua Opcao: ");
						op1 = Integer.parseInt(entrada.nextLine());

						switch (op1) {
							case 1:
								do {
									System.out.println("\nOpcoes de por onde voce pode Listar:");
									System.out.println("1 - Listar por Codigo.");
									System.out.println("2 - Listar por Nome.");
									System.out.println("0 - Voltar ao Menu Anterior.");
									System.out.printf("Digite sua Opcao: ");
									op2 = Integer.parseInt(entrada.nextLine());

									switch (op2) {
										case 1:
											int codigo1;
											System.out.printf("\nDigite o Codigo do Grupo Familiar a ser Listado: ");
											codigo1 = Integer.parseInt(entrada.nextLine());

											for(GrupoFamiliar grupoFamiliar2 : grupoFamiliarDAO.listarGruposFamiliares()) {
												if(grupoFamiliar2.getCodigo() == codigo1) {
													System.out.println("\nCodigo do Grupo Familiar: " + grupoFamiliar2.getCodigo());
													System.out.println("Nome do Grupo Familiar: " + grupoFamiliar2.getNome());
													System.out.println("Gastos do Grupo Familiar: " + grupoFamiliar2.getGastos());
													break;
												}
											}
											break;

										case 2:
											String nome;
											System.out.printf("\nDigite o Nome do Grupo Familiar a ser Listado: ");
											nome = entrada.nextLine();

											for(GrupoFamiliar grupoFamiliar2 : grupoFamiliarDAO.listarGruposFamiliares()) {
												if(grupoFamiliar2.getNome().equals(nome)) {
													System.out.println("\nCodigo do Grupo Familiar: " + grupoFamiliar2.getCodigo());
													System.out.println("Nome do Grupo Familiar: " + grupoFamiliar2.getNome());
													System.out.println("Gastos do Grupo Familiar: " + grupoFamiliar2.getGastos());
												}
											}
											break;

										case 0:
											System.out.println("\nVoltando ao Menu Anterior...");
											break;

										default:
											System.out.println("\nOpcao Invalida.");
											break;
									}
								} while (op2 != 0);
								break;

							case 2:
								do {
									System.out.println("\nOpcoes de por onde voce pode Listar:");
									System.out.println("1 - Listar por Codigo.");
									System.out.println("2 - Listar por Nome.");
									System.out.println("0 - Voltar ao Menu Anterior.");
									System.out.printf("Digite sua Opcao: ");
									op2 = Integer.parseInt(entrada.nextLine());

									switch (op2) {
										case 1:
											int codigo;
											System.out.printf("\nDigite o Codigo do Local de Compra a ser Listado: ");
											codigo = Integer.parseInt(entrada.nextLine());

											for(LocalDeCompra localDeCompra : localDeCompraDAO.listarLocaisDeCompra()) {
												if(localDeCompra.getCodigo() == codigo) {
													System.out.println("\nCodigo do Local de Compra: " + localDeCompra.getCodigo());
													System.out.println("Nome do Local de Compra: " + localDeCompra.getNome());
													System.out.println("Endereco do Local de Compra: " + localDeCompra.getEndereco());
													System.out.println("Telefone do Local de Compra: " + localDeCompra.getTelefone());
													System.out.println("Email do Local de Compra: " + localDeCompra.getEmail());
													System.out.println("Dia de Promocao do Local de Compra: " + localDeCompra.getDiaDePromocao());
													break;
												}
											}
											break;

										case 2:
											String nome;
											System.out.printf("\nDigite o Nome do Local de Compra a ser Listado: ");
											nome = entrada.nextLine();

											for(LocalDeCompra localDeCompra : localDeCompraDAO.listarLocaisDeCompra()) {
												if(localDeCompra.getNome().equals(nome)) {
													System.out.println("\nCodigo do Local de Compra: " + localDeCompra.getCodigo());
													System.out.println("Nome do Local de Compra: " + localDeCompra.getNome());
													System.out.println("Endereco do Local de Compra: " + localDeCompra.getEndereco());
													System.out.println("Telefone do Local de Compra: " + localDeCompra.getTelefone());
													System.out.println("Email do Local de Compra: " + localDeCompra.getEmail());
													System.out.println("Dia de Promocao do Local de Compra: " + localDeCompra.getDiaDePromocao());
												}
											}
											break;

										case 0:
											System.out.println("\nVoltando ao Menu Anterior...");
											break;

										default:
											System.out.println("\nOpcao Invalida.");
											break;
									}
								} while (op2 != 0);
							break;

							case 3:
								do {
									System.out.println("\nOpcoes de por onde voce pode Listar:");
									System.out.println("1 - Listar por Codigo.");
									System.out.println("2 - Listar por Nome.");
									System.out.println("0 - Voltar ao Menu Anterior.");
									System.out.printf("Digite sua Opcao: ");
									op2 = Integer.parseInt(entrada.nextLine());

									switch (op2) {
										case 1:
											int codigo;
											System.out.printf("\nDigite o Codigo do Produto a ser Listado: ");
											codigo = Integer.parseInt(entrada.nextLine());

											for(Produto produto : produtoDAO.listarProdutos()) {
												if(produto.getCodigo() == codigo) {
													System.out.println("\nCodigo do Produto: " + produto.getCodigo());
													System.out.println("Nome do Produto: " + produto.getNome());
													System.out.println("Preco do Produto: " + produto.getPrecoUnitario());
													System.out.println("Quantidade de Produtos: " + produto.getQuantidade());
													System.out.println("Preco Total de Produtos: " + produto.getPrecoTotal());
													System.out.println("Codigo do Grupo Familiar do Produto: " + produto.getCodigoGrupoFamiliar());
													System.out.println("Codigo do Local de Compra do Produto: " + produto.getCodigoLocalDeCompra());
													break;
												}
											}
											break;

										case 2:
											String nome;
											System.out.printf("\nDigite o Nome do Produto a ser Listado: ");
											nome = entrada.nextLine();

											for(Produto produto : produtoDAO.listarProdutos()) {
												if(produto.getNome().equals(nome)) {
													System.out.println("\nCodigo do Produto: " + produto.getCodigo());
													System.out.println("Nome do Produto: " + produto.getNome());
													System.out.println("Preco do Produto: " + produto.getPrecoUnitario());
													System.out.println("Quantidade de Produtos: " + produto.getQuantidade());
													System.out.println("Preco Total de Produtos: " + produto.getPrecoTotal());
													System.out.println("Codigo do Grupo Familiar do Produto: " + produto.getCodigoGrupoFamiliar());
													System.out.println("Codigo do Local de Compra do Produto: " + produto.getCodigoLocalDeCompra());
												}
											}
											break;

										case 0:
											System.out.println("\nVoltando ao Menu Anterior...");
											break;

										default:
											System.out.println("\nOpcao Invalida.");
											break;
									}
								} while (op2 != 0);
								break;

							case 0:
								System.out.println("\nVoltando ao Menu Principal...");
								break;

							default:
								System.out.println("\nOpcao Invalida.");
								break;
						}
					} while (op1 != 0);
					break;

				case 3:
					do {
						System.out.println("\nOpcoes de Alterecao:");
						System.out.println("1 - Grupo Familiar.");
						System.out.println("2 - Local de Compra.");
						System.out.println("3 - Produto.");
						System.out.println("0 - Voltar ao Menu Principal.");
						System.out.printf("Digite sua Opcao: ");
						op1 = Integer.parseInt(entrada.nextLine());

						switch (op1) {
							case 1:
								do {
									System.out.println("\nOpcoes de por onde voce pode fazer a Alteracao:");
									System.out.println("1 - Alterar por Codigo.");
									System.out.println("2 - Alterar por Nome.");
									System.out.println("0 - Voltar ao Menu Anterior.");
									System.out.printf("Digite sua Opcao: ");
									op2 = Integer.parseInt(entrada.nextLine());

									switch (op2) {
										case 1:
											int codigo;
											System.out.printf("\nDigite o Codigo do Grupo Familiar a ser Alterado: ");
											codigo = Integer.parseInt(entrada.nextLine());

											for(GrupoFamiliar grupoFamiliar : grupoFamiliarDAO.listarGruposFamiliares()) {
												if(grupoFamiliar.getCodigo() == codigo) {
													do {
														System.out.println("\nOpcoes do que pode ser Alterado:");
														System.out.println("1 - Nome do Grupo Familiar.");
														System.out.println("0 - Confirmar e Voltar ao Menu Anterior.");
														System.out.printf("Digite sua Opcao: ");
														op3 = Integer.parseInt(entrada.nextLine());

														switch (op3) {
															case 1:
																String nome;
																System.out.printf("\nDigite o novo nome do Grupo Familiar: ");
																nome = entrada.nextLine();
																grupoFamiliar.setNome(nome);
																break;

															case 0:
																grupoFamiliarDAO.update(grupoFamiliar);
																System.out.println("\nConfirmado e Voltando ao Menu Anterior...");
																break;

															default:
																System.out.println("\nOpcao Invalida.");
																break;
														}
													} while (op3 != 0);
													break;
												}
											}
											break;

										case 2:
											String nome;
											System.out.printf("\nDigite o Nome do Grupo Familiar a ser Alterado: ");
											nome = entrada.nextLine();

											for(GrupoFamiliar grupoFamiliar : grupoFamiliarDAO.listarGruposFamiliares()) {
												if(grupoFamiliar.getNome().equals(nome)) {
													do {
														System.out.println("\nOpcoes do que pode ser Alterado:");
														System.out.println("1 - Nome do Grupo Familiar.");
														System.out.println("0 - Confirmar e Voltar ao Menu Anterior.");
														System.out.printf("Digite sua Opcao: ");
														op3 = Integer.parseInt(entrada.nextLine());

														switch (op3) {
															case 1:
																String nomeAlterado;
																System.out.printf("\nDigite o novo nome do Grupo Familiar: ");
																nomeAlterado = entrada.nextLine();
																grupoFamiliar.setNome(nomeAlterado);
																break;

															case 0:
																grupoFamiliarDAO.update(grupoFamiliar);
																System.out.println("\nConfirmado e Voltando ao Menu Anterior...");
																break;

															default:
																System.out.println("\nOpcao Invalida.");
																break;
														}
													} while (op3 != 0);
													break;
												}
											}
											break;

										case 0:
											System.out.println("\nVoltando ao Menu Anterior...");
											break;

										default:
											System.out.println("\nOpcao Invalida.");
											break;
									}
								} while (op2 != 0);
								break;

							case 2:
								do {
									System.out.println("\nOpcoes de por onde voce pode fazer a Alteracao:");
									System.out.println("1 - Alterar por Codigo.");
									System.out.println("2 - Alterar por Nome.");
									System.out.println("0 - Voltar ao Menu Anterior.");
									System.out.printf("Digite sua Opcao: ");
									op2 = Integer.parseInt(entrada.nextLine());

									switch (op2) {
										case 1:
											int codigo;
											System.out.printf("\nDigite o Codigo do Local de Compra a ser Alterado: ");
											codigo = Integer.parseInt(entrada.nextLine());

											for(LocalDeCompra localDeCompra : localDeCompraDAO.listarLocaisDeCompra()) {
												if(localDeCompra.getCodigo() == codigo) {
													do {
														System.out.println("\nOpcoes do que pode ser Alterado:");
														System.out.println("1 - Nome do Local de Compra.");
														System.out.println("2 - Endereco do Local de Compra.");
														System.out.println("3 - Telefone do Local de Compra.");
														System.out.println("4 - Email do Local de Compra.");
														System.out.println("5 - Dia de Promocao do Local de Compra.");
														System.out.println("0 - Confirmar e Voltar ao Menu Anterior.");
														System.out.printf("Digite sua Opcao: ");
														op3 = Integer.parseInt(entrada.nextLine());

														switch (op3) {
															case 1:
																String nome;
																System.out.printf("\nDigite o novo nome do Local de Compra: ");
																nome = entrada.nextLine();
																localDeCompra.setNome(nome);
																break;

															case 2:
																String endereco;
																System.out.printf("\nDigite o novo endereco do Local de Compra: ");
																endereco = entrada.nextLine();
																localDeCompra.setEndereco(endereco);
																break;

															case 3:
																String telefone;
																System.out.printf("\nDigite o novo telefone do Local de Compra: ");
																telefone = entrada.nextLine();
																localDeCompra.setTelefone(telefone);
																break;

															case 4:
																String email;
																System.out.printf("\nDigite o novo email do Local de Compra: ");
																email = entrada.nextLine();
																localDeCompra.setEmail(email);
																break;

															case 5:
																int diaDePromocao;
																System.out.printf("\nDigite o novo dia de promocao do Local de Compra: ");
																diaDePromocao = Integer.parseInt(entrada.nextLine());
																localDeCompra.setDiaDePromocao(diaDePromocao);
																break;

															case 0:
																localDeCompraDAO.update(localDeCompra);
																System.out.println("\nConfirmado e Voltando ao Menu Anterior...");
																break;

															default:
																System.out.println("\nOpcao Invalida.");
																break;
														}
													} while (op3 != 0);
													break;
												}
											}
											break;

										case 2:
											String nome;
											System.out.printf("\nDigite o Nome do Local de Compra a ser Alterado: ");
											nome = entrada.nextLine();

											for(LocalDeCompra localDeCompra : localDeCompraDAO.listarLocaisDeCompra()) {
												if(localDeCompra.getNome().equals(nome)) {
													do {
														System.out.println("\nOpcoes do que pode ser Alterado:");
														System.out.println("1 - Nome do Local de Compra.");
														System.out.println("2 - Endereco do Local de Compra.");
														System.out.println("3 - Telefone do Local de Compra.");
														System.out.println("4 - Email do Local de Compra.");
														System.out.println("5 - Dia de Promocao do Local de Compra.");
														System.out.println("0 - Confirmar e Voltar ao Menu Anterior.");
														System.out.printf("Digite sua Opcao: ");
														op3 = Integer.parseInt(entrada.nextLine());

														switch (op3) {
															case 1:
																String nomeAlterado;
																System.out.printf("\nDigite o novo nome do Local de Compra: ");
																nomeAlterado = entrada.nextLine();
																localDeCompra.setNome(nomeAlterado);
																break;

															case 2:
																String endereco;
																System.out.printf("\nDigite o novo endereco do Local de Compra: ");
																endereco = entrada.nextLine();
																localDeCompra.setEndereco(endereco);
																break;

															case 3:
																String telefone;
																System.out.printf("\nDigite o novo telefone do Local de Compra: ");
																telefone = entrada.nextLine();
																localDeCompra.setTelefone(telefone);
																break;

															case 4:
																String email;
																System.out.printf("\nDigite o novo email do Local de Compra: ");
																email = entrada.nextLine();
																localDeCompra.setEmail(email);
																break;

															case 5:
																int diaDePromocao;
																System.out.printf("\nDigite o novo dia de promocao do Local de Compra: ");
																diaDePromocao = Integer.parseInt(entrada.nextLine());
																localDeCompra.setDiaDePromocao(diaDePromocao);
																break;

															case 0:
																localDeCompraDAO.update(localDeCompra);
																System.out.println("\nConfirmado e Voltando ao Menu Anterior...");
																break;

															default:
																System.out.println("\nOpcao Invalida.");
																break;
														}
													} while (op3 != 0);
													break;
												}
											}
											break;

										case 0:
											System.out.println("\nVoltando ao Menu Anterior...");
											break;

										default:
											System.out.println("\nOpcao Invalida.");
											break;
									}
								} while (op2 != 0);

							case 3:
								do {
									System.out.println("\nOpcoes de por onde voce pode fazer a Alteracao:");
									System.out.println("1 - Alterar por Codigo.");
									System.out.println("2 - Alterar por Nome.");
									System.out.println("0 - Voltar ao Menu Anterior.");
									System.out.printf("Digite sua Opcao: ");
									op2 = Integer.parseInt(entrada.nextLine());

									switch (op2) {
										case 1:
											int codigo;
											System.out.printf("\nDigite o Codigo do Produto a ser Alterado: ");
											codigo = Integer.parseInt(entrada.nextLine());

											for(Produto produto : produtoDAO.listarProdutos()) {
												if(produto.getCodigo() == codigo) {
													do {
														System.out.println("\nOpcoes do que pode ser Alterado:");
														System.out.println("1 - Nome do Produto.");
														System.out.println("2 - Preco do Produto.");
														System.out.println("3 - Quantidade de Produtos.");
														System.out.println("0 - Confirmar e Voltar ao Menu Anterior.");
														System.out.printf("Digite sua Opcao: ");
														op3 = Integer.parseInt(entrada.nextLine());

														switch (op3) {
															case 1:
																String nome;
																System.out.printf("\nDigite o novo nome do Produto: ");
																nome = entrada.nextLine();
																produto.setNome(nome);
																break;

															case 2:
																double precoUnitario;
																System.out.printf("\nDigite o novo preco do Produto: ");
																precoUnitario = Double.parseDouble(entrada.nextLine());
																produto.setPrecoUnitario(precoUnitario);
																break;

															case 3:
																int quantidade;
																System.out.printf("\nDigite a nova quantidade de Produtos: ");
																quantidade = Integer.parseInt(entrada.nextLine());
																produto.setQuantidade(quantidade);
																break;

															case 0:
																produtoDAO.update(produto);
																System.out.println("\nConfirmado e Voltando ao Menu Anterior...");
																break;

															default:
																System.out.println("\nOpcao Invalida.");
																break;
														}
													} while (op3 != 0);
													break;
												}
											}
											break;

										case 2:
											String nome;
											System.out.printf("\nDigite o Nome do Produto a ser Alterado: ");
											nome = entrada.nextLine();

											for(Produto produto : produtoDAO.listarProdutos()) {
												if(produto.getNome().equals(nome)) {
													do {
														System.out.println("\nOpcoes do que pode ser Alterado:");
														System.out.println("1 - Nome do Produto.");
														System.out.println("2 - Preco do Produto.");
														System.out.println("3 - Quantidade de Produtos.");
														System.out.println("0 - Confirmar e Voltar ao Menu Anterior.");
														System.out.printf("Digite sua Opcao: ");
														op3 = Integer.parseInt(entrada.nextLine());

														switch (op3) {
															case 1:
																String nomeAlterado;
																System.out.printf("\nDigite o novo nome do Produto: ");
																nomeAlterado = entrada.nextLine();
																produto.setNome(nomeAlterado);
																break;

															case 2:
																double precoUnitario;
																System.out.printf("\nDigite o novo preco do Produto: ");
																precoUnitario = Double.parseDouble(entrada.nextLine());
																produto.setPrecoUnitario(precoUnitario);
																break;

															case 3:
																int quantidade;
																System.out.printf("\nDigite a nova quantidade de Produtos: ");
																quantidade = Integer.parseInt(entrada.nextLine());
																produto.setQuantidade(quantidade);
																break;

															case 0:
																produtoDAO.update(produto);
																System.out.println("\nConfirmado e Voltando ao Menu Anterior...");
																break;

															default:
																System.out.println("\nOpcao Invalida.");
																break;
														}
													} while (op3 != 0);
													break;
												}
											}
											break;

										case 0:
											System.out.println("\nVoltando ao Menu Anterior...");
											break;

										default:
											System.out.println("\nOpcao Invalida.");
											break;
									}
								} while (op2 != 0);
								break;

							case 0:
								System.out.println("\nVoltando ao Menu Principal...");
								break;

							default:
								System.out.println("\nOpcao Invalida.");
								break;
						}
					} while (op1 != 0);
					break;

				case 4:
					do {
						System.out.println("\nOpcoes para Deletar:");
						System.out.println("1 - Grupo Familiar.");
						System.out.println("2 - Local de Compra.");
						System.out.println("3 - Produto.");
						System.out.println("0 - Voltar ao Menu Principal.");
						System.out.printf("Digite sua Opcao: ");
						op1 = Integer.parseInt(entrada.nextLine());

						switch (op1) {
							case 1:
								do {
									System.out.println("\nOpcoes de por onde voce pode Deletar:");
									System.out.println("1 - Deletar por Codigo.");
									System.out.println("2 - Deletar por Nome.");
									System.out.println("0 - Voltar ao Menu Anterior.");
									System.out.printf("Digite sua Opcao: ");
									op2 = Integer.parseInt(entrada.nextLine());

									switch (op2) {
										case 1:
											int codigo;
											System.out.printf("\nDigite o Codigo do Grupo Familiar a ser Deletado: ");
											codigo = Integer.parseInt(entrada.nextLine());
											GrupoFamiliarDAO grupoFamiliarDAO1 = new GrupoFamiliarDAO();
											grupoFamiliarDAO1.delete(codigo);
											break;

										case 2:
											String nome;
											System.out.printf("\nDigite o Nome do Grupo Familiar a ser Deletado: ");
											nome = entrada.nextLine();
											GrupoFamiliarDAO grupoFamiliarDAO2 = new GrupoFamiliarDAO();
											grupoFamiliarDAO2.delete(nome);
											break;

										case 0:
											System.out.println("\nVoltando ao Menu Anterior...");
											break;

										default:
											System.out.println("\nOpcao Invalida.");
											break;
									}
								} while (op2 != 0);
								break;

							case 2:
								do {
									System.out.println("\nOpcoes de por onde voce pode Deletar:");
									System.out.println("1 - Deletar por Codigo.");
									System.out.println("2 - Deletar por Nome.");
									System.out.println("0 - Voltar ao Menu Anterior.");
									System.out.printf("Digite sua Opcao: ");
									op2 = Integer.parseInt(entrada.nextLine());

									switch (op2) {
										case 1:
											int codigo;
											System.out.printf("\nDigite o Codigo do Local de Compra a ser Deletado: ");
											codigo = Integer.parseInt(entrada.nextLine());
											LocalDeCompraDAO localDeCompraDAO1 = new LocalDeCompraDAO();
											localDeCompraDAO1.delete(codigo);
											break;

										case 2:
											String nome;
											System.out.printf("\nDigite o Nome do Local de Compra a ser Deletado: ");
											nome = entrada.nextLine();
											LocalDeCompraDAO localDeCompraDAO2 = new LocalDeCompraDAO();
											localDeCompraDAO2.delete(nome);
											break;

										case 0:
											System.out.println("\nVoltando ao Menu Anterior...");
											break;

										default:
											System.out.println("\nOpcao Invalida.");
											break;
									}
								} while (op2 != 0);
								break;

							case 3:
								do {
									System.out.println("\nOpcoes de por onde voce pode Deletar:");
									System.out.println("1 - Deletar por Codigo.");
									System.out.println("2 - Deletar por Nome.");
									System.out.println("0 - Voltar ao Menu Anterior.");
									System.out.printf("Digite sua Opcao: ");
									op2 = Integer.parseInt(entrada.nextLine());

									switch (op2) {
										case 1:
											int codigo;
											System.out.printf("\nDigite o Codigo do Produto a ser Deletado: ");
											codigo = Integer.parseInt(entrada.nextLine());
											ProdutoDAO produtoDAO1 = new ProdutoDAO();
											produtoDAO1.delete(codigo);
											break;

										case 2:
											String nome;
											System.out.printf("\nDigite o Nome do Produto a ser Deletado: ");
											nome = entrada.nextLine();
											ProdutoDAO produtoDAO2 = new ProdutoDAO();
											produtoDAO2.delete(nome);
											break;

										case 0:
											System.out.println("\nVoltando ao Menu Anterior...");
											break;

										default:
											System.out.println("\nOpcao Invalida.");
											break;
									}
								} while (op2 != 0);
								break;

							case 0:
								System.out.println("\nVoltando ao Menu Principal...");
								break;

							default:
								System.out.println("\nOpcao Invalida.");
								break;
						}
					} while (op1 != 0);
					break;

				case 5:
					produtoDAO.compararInflacao();
					break;

				case 0:
					System.out.println("\nEncerrando o Programa...");
					break;

				default:
					System.out.println("\nOpcao Invalida.");
					break;
			}
		} while (op != 0);
	}
}
