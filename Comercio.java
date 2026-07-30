public interface ProdutoFisico {
    void calcularFrete();
}
 
public interface ProdutoDigital {
    void gerarLinkDownload();
}

public class LivroFisico implements ProdutoFisico {

    private String nome;

    public LivroFisico(String nome) {
        this.nome = nome;
    }

    @Override
    public void calcularFrete() {
        System.out.println("Livro: " + nome);
        System.out.println("Frete calculado: R$ 18,50");
    }
}

public class Ebook implements ProdutoDigital {

    private String nome;

    public Ebook(String nome) {
        this.nome = nome;
    }

    @Override
    public void gerarLinkDownload() {
        System.out.println("E-book: " + nome);
        System.out.println("Link de download enviado.");
    }
}

public class GerenciadorLoja {

    public void processarProdutoFisico(ProdutoFisico produto) {
        produto.calcularFrete();
    }

    public void processarProdutoDigital(ProdutoDigital produto) {
        produto.gerarLinkDownload();
    }

}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        GerenciadorLoja gerenciador = new GerenciadorLoja();

        System.out.println("===== LOJA VIRTUAL =====");
        System.out.println("1 - Livro Físico");
        System.out.println("2 - E-book");
        System.out.print("Escolha: ");

        int opcao = leitor.nextInt();
        leitor.nextLine();

        System.out.print("Nome do produto: ");
        String nome = leitor.nextLine();

        switch (opcao) {

            case 1:
                LivroFisico livro = new LivroFisico(nome);
                gerenciador.processarProdutoFisico(livro);
                break;

            case 2:
                Ebook ebook = new Ebook(nome);
                gerenciador.processarProdutoDigital(ebook);
                break;

            default:
                System.out.println("Essa opção é inválida.");
        }

        leitor.close();
    }
}
































































