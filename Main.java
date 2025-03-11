import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlocoDeNotas bloco = new BlocoDeNotas();
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n--- Bloco de Notas ---");
            System.out.println("1. Adicionar Anotação");
            System.out.println("2. Editar Anotação");
            System.out.println("3. Buscar Anotação");
            System.out.println("4. Listar Anotações");
            System.out.println("5. Deletar Anotação");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            try {
                if (opcao == 1) {
                    System.out.print("Digite o texto da anotação: ");
                    String texto = scanner.nextLine();
                    Anotacao nova = bloco.adicionarAnotacao(texto);
                    System.out.println("Anotação adicionada com ID: " + nova.getId());
                }
                else if (opcao == 2) {
                    System.out.print("Digite o ID da anotação que deseja editar: ");
                    int idEdicao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o novo texto: ");
                    String novoTexto = scanner.nextLine();
                    Anotacao anotacaoEditada =  bloco.editarAnotacao(idEdicao, novoTexto);
                    System.out.println("Anotação editada com sucesso! Resultado da edição");
                    System.out.println(anotacaoEditada.getTexto());
                }
                else if (opcao == 3) {
                    System.out.print("Digite o ID da anotação que deseja buscar: ");
                    int idBusca = scanner.nextInt();
                    Anotacao encontrada = bloco.buscaAnotacao(idBusca);
                    System.out.println("Anotação encontrada: " + encontrada.getTexto());
                }
                else if (opcao == 4) {
                    System.out.println("\nLista de anotações:");
                    for (Anotacao a : bloco.listar()) {
                        System.out.println(a.getId() + ": " + a.getTexto());
                    }
                }
                else if (opcao == 5) {
                    System.out.print("Digite o ID da anotação que deseja deletar: ");
                    int idDeletar = scanner.nextInt();
                    bloco.deletaAnotacao(idDeletar);
                    System.out.println("Anotação deletada!");
                }
                else if (opcao == 6) {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}