import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    Scanner scanner = new Scanner(System.in);
    BancoDeDados bancoDeDados = new BancoDeDados();
    Produtos produtos = new Produtos();
    Funcionarios funcionarios = new Funcionarios();


    void adicionarProduto() {
        bancoDeDados.connect();
        produtos.createTable();
        List<String[]> lista = new ArrayList<>();
        while (true) {
            String[] produto = {"", "", ""};
            System.out.println("Digite o nome do produto (ou fim para sair): ");
            produto[0] = scanner.nextLine();
            //saída do loop
            if (produto[0].equalsIgnoreCase("fim")) {
                break;

            }
            bancoDeDados.close();
        }
    }
    void lerProduto(){
                    bancoDeDados.connect();
            System.out.println("Digite o nome do protudo a ser consultado: ");
            produtos.lerProduto(scanner.nextLine());
            bancoDeDados.close();
        }


    void deletarProduto() {
        bancoDeDados.connect();
        System.out.println("Digite o nome do produto a ser deletado: ");
        produtos.deleteProduto(scanner.nextLine());
        bancoDeDados.close();
    }

    void adicionarFuncionario(){
        List<String[]> lista = new ArrayList<>();
        bancoDeDados.connect();
        funcionarios.createTable();
            while(true) {
                String[] funcionario ={"", "", ""};
                System.out.println("Digite o nome do funcionário (ou fim para sair): ");
                funcionario[0] = scanner.nextLine();
                //saída do loop
                if (funcionario[0].equalsIgnoreCase("fim")) {
                    break;
                }
                System.out.println("Digite a telefone do funcionário");
                funcionario[1] = scanner.nextLine();
                System.out.println("Digite a data de contratação");
                funcionario[2] = scanner.nextLine();
                lista.add(funcionario);
            }
            funcionarios.inserirFuncionario(lista);

        bancoDeDados.close();
    }

    void lerFuncionario(){
        bancoDeDados.connect();

            System.out.println("Digite o nome do funcionário a ser consultado: ");
            funcionarios.lerFuncionario(scanner.nextLine());
            bancoDeDados.close();

        bancoDeDados.close();
    }
    void deletarFuncionário(){
        bancoDeDados.connect();
            System.out.println("Digite o nome do funcionario a ser consultado: ");
            funcionarios.lerFuncionario(scanner.nextLine());
            bancoDeDados.close();

    }

    void imprimirMenu(){
        System.out.println("Escolha uma opção:");
        System.out.println("1- Inserir produto");
        System.out.println("2- Deletar produto");
        System.out.println("3- Consultar produto");
        System.out.println("4- Inserir funcionário");
        System.out.println("5- Consultar funcionário");
        System.out.println("6- Deletar funcionário");
        System.out.println("7- Sair");
    }
}
