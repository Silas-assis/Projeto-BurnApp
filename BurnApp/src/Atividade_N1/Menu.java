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
			System.out.println("Selecione uma opção:");
			System.out.println("  1ª) - Cadastrar um Produto.");
			System.out.println("  2ª) - Consultar um Produto.");
			System.out.println("  3ª) - Excluir um Produto.");
			System.out.println("  4ª) - Listar Todos Produtos.");
			System.out.println("  5ª) - Excluir Todos Produtos.");
			System.out.println("  6ª) - Finalizar Programa.");
			System.out.print("Opção: ");

			try {
				opcao = inputNumber.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Você digitou uma letra, por favor digite um número.");
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
				System.out.println("Opção inválida.");
			}
		} while (opcao != 6);

		inputNumber.close();
		inputText.close();

	}

	private static void cadastrarProduto(Scanner inputText, Scanner inputNumber, GerenciadorDeProdutos gerenciador) {
		System.out.print("Informe o nome do produto:");
		String nome = inputText.nextLine();
		System.out.print("Informe o preço do produto:");
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
			System.out.println("Produto " + nome + " não existe.");
		}

	}

	private static void excluirProduto(Scanner inputText, Scanner inputNumber, GerenciadorDeProdutos gerenciador) {
		if (!gerenciador.existeProduto()) {
			System.out.println("O sistema não possui produtos cadastrados.");
		} else {

			System.out.print("Informe o nome do produto que deseja excluir:");
			String nome = inputText.nextLine();

			Produto produto = gerenciador.consultarProduto(nome);

			if (produto != null) {
				gerenciador.excluirProduto(produto);
				System.out.println("O produto foi excluido");
			} else {
				System.out.println("O produto " + nome + " não existe.");
			}
		}
	}

	private static void listarTodosProdutos(GerenciadorDeProdutos gerenciador) {
		if (!gerenciador.existeProduto()) {
			System.out.println("O sistema não possui produtos cadastrados.");
		} else {
			gerenciador.listarTodosProdutos();
		}

	}

	private static void excluirTodosProdutos(GerenciadorDeProdutos gerenciador) {
		if (!gerenciador.existeProduto()) {
			System.out.println("O sistema não possui produtos cadastrados.");
		} else {
			gerenciador.excluirTodosProdutos();
		}
	}
}
