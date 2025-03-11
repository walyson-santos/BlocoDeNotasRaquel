import java.util.Scanner;

public class Main {
    public static final BlocoDeNotas notas = new BlocoDeNotas();
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int option = 0;
        while (option !=5){
            menu();
            option = input.nextInt();
            switch (option){
                case 1:
                    adicionarNota();
                    break;
                case 2:
                    editarAnotacao();
                    break;
                case 3:
                    remover();
                case 4:
                    buscarId();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
            }
        };
    }

    public static void menu(){
        System.out.println("Menu");
        System.out.println("1 - adicionar");
        System.out.println("2 - editar anotações por id");
        System.out.println("3 - remover por id");
        System.out.println("4 - buscar por id");
        System.out.println("5 - sair");
        input.nextLine();
    }

    public static void adicionarNota(){
        System.out.println("Adicione o bloco de notas: ");
        String nota = input.next();
        notas.adicionarAnotacao(nota);
    }

    public static void editarAnotacao(){
        System.out.println("Digite o id do bloco de notas: ");
        int id = input.nextInt();
        System.out.println("Digite a nova nota: ");
        String novaNota = input.nextLine();
        notas.editarAnotacao(id, novaNota);
    }

    public static void remover(){
        System.out.println("Escolha o id do texto a ser removido: ");
        int id = input.nextInt();
        notas.deletarAnotacao(id);
    }

    public static void buscarId(){
       String texto = input.next();

       notas.buscarAnotacoes(texto);
    }

}
