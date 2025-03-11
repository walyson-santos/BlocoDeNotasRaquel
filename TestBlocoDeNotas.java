import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlocoDeNotasTest {

    private BlocoDeNotas bloco;
    @BeforeEach
    void setUp()
    {
        bloco = new BlocoDeNotas();
    }
    @Test
    void adicionarAnotacao() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        assertEquals(1, bloco.buscaAnotacao(1).getId());
    }

    @Test
    void adicionaValorVazio() throws Exception
    {
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.adicionarAnotacao("");
        });

        assertEquals("Anotação vazia", exception.getMessage());
    }

    @Test
    void adicionaValorJaExistente() throws Exception
    {
        bloco.adicionarAnotacao("Ir ao mercado");
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.adicionarAnotacao("Ir ao mercado");
        });

        assertEquals("Essa tarefa já existe", exception.getMessage());
    }

    @Test
    void editarAnotacao() throws Exception
    {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.editarAnotacao(1, "Ir ao cinema");
        assertEquals("Ir ao cinema", bloco.buscaAnotacao(1).getTexto());
    }

    @Test
    void editarAnotacaoNaoExistente() throws Exception
    {
        bloco.adicionarAnotacao("Ir ao mercado");
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.editarAnotacao(2, "Ir ao cinema");
        });

        assertEquals("Essa anotação não existe", exception.getMessage());
    }
    @Test
    void editarAnotacaoParaVazio() throws Exception
    {
        bloco.adicionarAnotacao("Ir ao mercado");
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.editarAnotacao(1, "");
        });

        assertEquals("Anotação vazia", exception.getMessage());
    }
    @Test
    void editarAnotacaoJaRemovida() throws Exception
    {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.deletaAnotacao(1);
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.editarAnotacao(1, "Ir ao cinema");
        });

        assertEquals("Essa anotação não existe", exception.getMessage());
    }



    @Test
    void buscaAnotacao() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        assertEquals("Ir ao mercado", bloco.buscaAnotacao(1).getTexto());
    }

    @Test
    void buscarAnotacaoRemovida() throws Exception
    {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.deletaAnotacao(1);
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.buscaAnotacao(1);
        });

        assertEquals("Essa anotação não existe", exception.getMessage());
    }

    @Test
    void buscaAnotacaoNaoExistente() throws Exception
    {
        bloco.adicionarAnotacao("Ir ao mercado");
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.buscaAnotacao(2);
        });

        assertEquals("Essa anotação não existe", exception.getMessage());
    }

    @Test
    void recuperaTexto() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.adicionarAnotacao("Ir ao cinema");
        bloco.adicionarAnotacao("Ir ao colégio");

        assertEquals(3, bloco.recuperaTexto("Ir ao").size());
    }

    @Test
    void recuperaTextoComValoresDiferentes() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.adicionarAnotacao("Comer Pizza");
        bloco.adicionarAnotacao("Jogar bola");

        assertEquals(1, bloco.recuperaTexto("Ir ao").size());
    }

    @Test
    void recuperaTextoComLetras() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.adicionarAnotacao("Comer Pizza");
        bloco.adicionarAnotacao("Jogar bola");

        assertEquals(3, bloco.recuperaTexto("a").size());
    }

    @Test
    void listarQuantidadeCerta() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.adicionarAnotacao("Ir ao cinema");

        assertEquals(2, bloco.listar().size());
    }
    @Test
    void listarElementosCertos() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.adicionarAnotacao("Ir ao cinema");
        bloco.adicionarAnotacao("Ir ao colégio");

        assertEquals("Ir ao mercado", bloco.listar().getFirst().getTexto());
        assertEquals("Ir ao cinema", bloco.listar().get(1).getTexto());
        assertEquals("Ir ao colégio", bloco.listar().get(2).getTexto());
    }
    @Test
    void listarElementosNaoDeletados() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.adicionarAnotacao("Ir ao cinema");
        bloco.adicionarAnotacao("Ir ao colégio");
        bloco.deletaAnotacao(2);
        assertEquals(2, bloco.listar().size());
    }

    @Test
    void deletaAnotacao() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.deletaAnotacao(1);
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.buscaAnotacao(1);
        });

        assertEquals("Essa anotação não existe", exception.getMessage());
    }

    @Test
    void deletaAnotacaoNaoExiste() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.deletaAnotacao(2);
        });

        assertEquals("Essa anotação não existe", exception.getMessage());
    }

    @Test
    void deletaAnotacaoJaDeletada() throws Exception {
        bloco.adicionarAnotacao("Ir ao mercado");
        bloco.deletaAnotacao(1);
        Exception exception = assertThrows(Exception.class, () ->
        {
            bloco.deletaAnotacao(1);
        });

        assertEquals("Essa anotação não existe", exception.getMessage());
    }
}