import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BlocoDeNotas {

    private ArrayList<Anotacao> notas = new ArrayList<>();

    public BlocoDeNotas() {

    }

    public Anotacao adicionarAnotacao(String texto, int id){
        Anotacao nota = new Anotacao(texto, notas.size()+1);
        notas.add(nota);
        return nota;
    }


    public Anotacao buscarId(int id) {

        Anotacao[] anotacoes = new Anotacao[0];
        for (Anotacao anotacao : anotacoes) {

            if (anotacao.getId() == id) {
                return anotacao;
            }
        }

        throw new NoSuchElementException("Anotação não encontrada com o ID: " + id);
    }


}