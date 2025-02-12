import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int opcao = 0;
        while( opcao != 0){

            menu();
            opcao = input.nextInt();
        }

    }
    public static void menu(){
        System.out.println("Esse aqui é o menu do bloco de notas");
        System.out.println("1. adicionar novas anotações, editar anotações existentes (encontradas pelo indice);");
        System.out.println("2. editar anotações - mudar o texto da anotação (encontrar a partir do índice);");
        System.out.println("3. buscar anotações a partir de um texto de busca (pode ser parcial e deve retornar todas as anotações que tem aquela substring); ");
        System.out.println("4. deleção logica de anotacao pelo indice;");
        System.out.println("5. listar todas as anotações pela ordem em que foram adicionadas.");
        System.out.println("6. sair.");

    }

    public static void adicionar(String texto){
        BlocoDeNotas blocoDeNotas = new BlocoDeNotas();
        blocoDeNotas.adicionarAnotacao(texto);

    }
}
