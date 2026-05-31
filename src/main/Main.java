import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Agenda agenda = new AgendaMap();
        Scanner scanner = new Scanner(System.in);

        try {
            agenda.recuperarDados();
        } catch (IOException e) {
            System.out.println("Nenhum arquivo encontrado. Iniciando agenda vazia.");
        }

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n=== AGENDA ===");
            System.out.println("1 - Cadastrar contato");
            System.out.println("2 - Pesquisar aniversariantes");
            System.out.println("3 - Remover contato");
            System.out.println("4 - Salvar dados");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Dia do aniversário: ");
                    int dia = Integer.parseInt(scanner.nextLine());

                    System.out.print("Mês do aniversário: ");
                    int mes = Integer.parseInt(scanner.nextLine());

                    agenda.cadastraContato(nome, dia, mes);

                    System.out.println("Contato cadastrado com sucesso!");
                    break;

                case 2:

                    System.out.print("Dia: ");
                    dia = Integer.parseInt(scanner.nextLine());

                    System.out.print("Mês: ");
                    mes = Integer.parseInt(scanner.nextLine());

                    Collection<Contato> encontrados =
                            agenda.pesquisaAniversariantes(dia, mes);

                    if (encontrados.isEmpty()) {
                        System.out.println("Nenhum aniversariante encontrado.");
                    } else {
                        System.out.println("Aniversariantes:");
                        for (Contato c : encontrados) {
                            System.out.println(c);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Nome do contato: ");
                    nome = scanner.nextLine();

                    try {
                        agenda.removeContato(nome);
                        System.out.println("Contato removido.");
                    } catch (ContatoInexistenteException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:

                    try {
                        agenda.salvarDados();
                        System.out.println("Dados salvos com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar dados.");
                    }

                    break;

                case 0:

                    try {
                        agenda.salvarDados();
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar ao sair.");
                    }

                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}