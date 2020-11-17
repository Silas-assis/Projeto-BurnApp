package Atividade_N1;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeProdutos {
	private List<Produto> produtos = new ArrayList<>();

	public void cadastrarProduto(Produto produto) {
		produtos.add(produto);
	}

	public Produto consultarProduto(String nome) {
		return pegaProdutoPorNome(nome);
	}

	public void excluirProduto(Produto produto) {
		produtos.remove(produto);
	}

	public void listarTodosProdutos() {
		System.out.println("O sistema tem " + produtos.size() + " produtos cadastrado.");
		System.out.println("Produtos Cadastrados:");
		for (Produto p : produtos) {
			System.out.println(p);
		}
	}

	public void excluirTodosProdutos() {
		System.out.println("O sistema excluiu " + produtos.size() + " produtos.");
		produtos.clear();
	}

	public boolean existeProduto() {
		return !produtos.isEmpty();
	}

	private Produto pegaProdutoPorNome(String nomeProduto) {
		if (!existeProduto()) {
			return null;
		}

		Produto produto = null;

		for (Produto p : produtos) {
			if (p.getNome().equals(nomeProduto)) {
				produto = p;
			}
		}

		return produto;
	}
}
