
import java.util.ArrayList;
import java.util.List;

public class BlocoDeNotas {
    private List<Anotacao> anotacoes;

    public BlocoDeNotas() {
        this.anotacoes = new ArrayList<>();
    }

    public Anotacao adicionarAnotacao(String nota) throws Exception {
        int id = anotacoes.size();
        anotacoes.add(new Anotacao(nota, id));
        return anotacoes.get(id);
    }

    public Anotacao editarAnotacao(int id, String novaNota) throws Exception {
        if(id >= anotacoes.size() || anotacoes.get(id).isDeletado()){
            throw new Exception("Anotacao não encontrada!");
        }

        anotacoes.get(id).setNota(novaNota);
        return anotacoes.get(id);

    }

    public List<Anotacao> buscarAnotacoes(String texto) throws Exception {
        List<Anotacao> resultados = new ArrayList<>();
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getNota().contains(texto) && !anotacao.isDeletado()) {
                resultados.add(anotacao);
            }
        }
        if (resultados.isEmpty())
        {
            throw new Exception("Não há anotações que contem esse texto!");
        }
        return resultados;
    }

    public void deletarAnotacao(int id) throws Exception{
        if(anotacoes.get(id).isDeletado() || id >= anotacoes.size())
        {
            throw new Exception("Anotacao não encontrada");
        }
        anotacoes.get(id).setDeletado(true);
    }

    public List<Anotacao> listarAnotacoes() {
        List<Anotacao> anotacoesNaoDeletadas = new ArrayList<>();
        for(Anotacao anotcao:anotacoes)
        {
            if(!anotcao.isDeletado())
            {
                anotacoesNaoDeletadas.add(anotcao);
            }
        }
        return anotacoesNaoDeletadas;
    }
}