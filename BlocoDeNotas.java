import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BlocoDeNotas {
    private List<Anotacao> anotacoes;

    public BlocoDeNotas() {
        this.anotacoes = new ArrayList<>();
    }

    public void adicionarAnotacao(String nota) {
        int id = anotacoes.size();
        anotacoes.add(new Anotacao(nota, id, LocalDate.now()));
    }

    public void editarAnotacao(int id, String novaNota) {
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getId() == id) {
                anotacao.setNota(novaNota);
                return;
            }
        }
    }

    public List<Anotacao> buscarAnotacoes(String texto) {
        List<Anotacao> resultados = new ArrayList<>();
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getNota().contains(texto)) {
                resultados.add(anotacao);
            }
        }
        return resultados;
    }

    public void deletarAnotacao(int id) {
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getId() == id) {
                anotacoes.remove(anotacao);
                return;
            }
        }
    }

    public List<Anotacao> listarAnotacoes() {
        return new ArrayList<>(anotacoes);
    }
}
