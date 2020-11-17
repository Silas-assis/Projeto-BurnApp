package Atividade_N1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	public static void iniciar() {
		Scanner inputText = new Scanner(System.in);
		Scanner inputNumber = new Scanner(System.in);

		GerenciadorDeProdutos gerenciador = new GerenciadorDeProdutos();

		int opcao = 0;

		do {
			System.out.println();
			System.out.println("*******Menu Principal*******");
			System.out.println("Selecione uma op��o:");
			System.out.println("  1�) - Cadastrar um Produto.");
			System.out.println("  2�) - Consultar um Produto.");
			System.out.println("  3�) - Excluir um Produto.");
			System.out.println("  4�) - Listar Todos Produtos.");
			System.out.println("  5�) - Excluir Todos Produtos.");
			System.out.println("  6�) - Finalizar Programa.");
			System.out.print("Op��o: ");

			try {
				opcao = inputNumber.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Voc� digitou uma letra, por favor digite um n�mero.");
				inputNumber.next();
			}

			switch (opcao) {
			case 1:
				cadastrarProduto(inputText, inputNumber, gerenciador);
				break;

			case 2:
				consultarProduto(inputText, inputNumber, gerenciador);
				break;

			case 3:
				excluirProduto(inputText, inputNumber, gerenciador);
				break;

			case 4:
				listarTodosProdutos(gerenciador);
				break;

			case 5:
				excluirTodosProdutos(gerenciador);
				break;

			case 6:
				System.out.println("Encerrando Programa...");
				break;
			default:
				System.out.println("Op��o inv�lida.");
			}
		} while (opcao != 6);

		inputNumber.close();
		inputText.close();

	}

	private static void cadastrarProduto(Scanner inputText, Scanner inputNumber, GerenciadorDeProdutos gerenciador) {
		System.out.print("Informe o nome do produto:");
		String nome = inputText.nextLine();
		System.out.print("Informe o pre�o do produto:");
		double preco = inputNumber.nextDouble();

		Produto produto = new Produto(nome, preco);
		gerenciador.cadastrarProduto(produto);

	}

	private static void consultarProduto(Scanner inputText, Scanner inputNumber, GerenciadorDeProdutos gerenciador) {
		System.out.print("Informe o nome do produto:");
		String nome = inputText.nextLine();

		Produto produto = gerenciador.consultarProduto(nome);
		if (produto != null) {
			System.out.println("Existe o produto: " + produto.toString());
		} else {
			System.out.println("Produto " + nome + " n�o existe.");
		}

	}

	private static void excluirProduto(Scanner inputText, Scanner inputNumber, GerenciadorDeProdutos gerenciador) {
		if (!gerenciador.existeProduto()) {
			System.out.println("O sistema n�o possui produtos cadastrados.");
		} else {

			System.out.print("Informe o nome do produto que deseja excluir:");
			String nome = inputText.nextLine();

			Produto produto = gerenciador.consultarProduto(nome);

			if (produto != null) {
				gerenciador.excluirProduto(produto);
				System.out.println("O produto foi excluido");
			} else {
				System.out.println("O produto " + nome + " n�o existe.");
			}
		}
	}

	private static void listarTodosProdutos(GerenciadorDeProdutos gerenciador) {
		if (!gerenciador.existeProduto()) {
			System.out.println("O sistema n�o possui produtos cadastrados.");
		} else {
			gerenciador.listarTodosProdutos();
		}

	}

	private static void excluirTodosProdutos(GerenciadorDeProdutos gerenciador) {
		if (!gerenciador.existeProduto()) {
			System.out.println("O sistema n�o possui produtos cadastrados.");
		} else {
			gerenciador.excluirTodosProdutos();
		}
	}
}
