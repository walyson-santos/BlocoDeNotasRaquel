import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

class AnotacaoTest {

    private Anotacao anotacao;

    @BeforeEach
    void setUp() throws Exception {
        anotacao = new Anotacao(1, "Treino");
    }
    @Test
    void getTexto(){
        assertEquals("Treino", anotacao.getTexto());
    }

    @Test
    void getId() {
        assertEquals(1, anotacao.getId());
    }


    @Test
    void setTexto() throws Exception {
        anotacao.setTexto("Jogar futebol");
        assertEquals("Jogar futebol", anotacao.getTexto());
    }

    @Test
    void getDeletado() {
        assertFalse(anotacao.getDeletado());
    }

    @Test
    void setDeletado() {
        anotacao.setDeletado();
        assertTrue(anotacao.getDeletado());
    }

    @Test
    void contemTexto() {
        String valorTest = "Treinar";
        assertTrue(anotacao.contemTexto(valorTest));
    }
}