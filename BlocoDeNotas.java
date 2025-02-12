import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BlocoDeNotas {

    private ArrayList<Anotacao> notas = new ArrayList<>();

    public BlocoDeNotas() {

    }

    public Anotacao adicionarAnotacao(String texto){
        Anotacao nota = new Anotacao(texto, notas.size()+1);
        notas.add(nota);
        return nota;
    }


    public Anotacao buscarId(int id) {


        for (Anotacao anotacao : notas) {

            if (anotacao.getId() == id) {
                return anotacao;
            }
        }

        throw new NoSuchElementException("Anotação não encontrada com o ID: " + id);
    }

    public void deletar(int id ){
        Anotacao aSerDeletada = buscarId(id);
        aSerDeletada.setDeletar(true);
    }


}