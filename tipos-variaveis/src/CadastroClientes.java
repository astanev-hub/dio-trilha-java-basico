
import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    private String nome;
    private int idade;
    private char sexo;

    public Cliente(String nome, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Sexo: " + sexo;
    }
}

public class CadastroClientes {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar um novo Cliente");
            System.out.println("2 - Listar os Clientes cadastrados");
            System.out.println("3 - Excluir algum Cliente");
            System.out.println("4 - Encerrar o programa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void cadastrarCliente() {
        System.out.print("Nome Completo (máximo 40 caracteres): ");
        String nome = scanner.nextLine();
        if (nome.length() > 40) {
            System.out.println("Nome muito longo! O máximo permitido é 40 caracteres.");
            return;
        }

        System.out.print("Idade (máximo 99): ");
        int idade = scanner.nextInt();
        if (idade < 0 || idade > 99) {
            System.out.println("Idade inválida! Deve ser entre 0 e 99.");
            return;
        }

        System.out.print("Sexo (M/F): ");
        char sexo = scanner.next().toUpperCase().charAt(0);
        if (sexo != 'M' && sexo != 'F') {
            System.out.println("Sexo inválido! Deve ser 'M' ou 'F'.");
            return;
        }

        clientes.add(new Cliente(nome, idade, sexo));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\nClientes Cadastrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }
    }

    private static void excluirCliente() {
        listarClientes();
        if (clientes.isEmpty()) {
            return;
        }

        System.out.print("Digite o número do cliente que deseja excluir: ");
        int indice = scanner.nextInt() - 1;

        if (indice < 0 || indice >= clientes.size()) {
            System.out.println("Número inválido! Tente novamente.");
            return;
        }

        clientes.remove(indice);
        System.out.println("Cliente excluído com sucesso!");
    }
}