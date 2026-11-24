package memento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HistoricoTest {

    private Editor editor;
    private Historico historico;

    @BeforeEach
    void setUp() {
        editor = new Editor();
        historico = new Historico(editor);
    }

    @Test
    void deveIniciarComHistoricoVazio() {
        assertEquals(0, historico.tamanho());
    }

    @Test
    void deveArmazenarEstadoAoSalvar() {
        editor.escrever("Olá");

        historico.salvar();

        assertEquals(1, historico.tamanho());
    }

    @Test
    void deveRetornarTamanhoDoHistorico() {
        historico.salvar();
        historico.salvar();

        assertEquals(2, historico.tamanho());
    }

    @Test
    void deveDesfazerParaUltimoEstadoSalvo() {
        editor.escrever("Olá");
        historico.salvar();
        editor.escrever(" mundo");

        boolean desfeito = historico.desfazer();

        assertTrue(desfeito);
        assertEquals("Olá", editor.getConteudo());
        assertEquals(0, historico.tamanho());
    }

    @Test
    void naoDeveDesfazerComHistoricoVazio() {
        editor.escrever("Olá");

        boolean desfeito = historico.desfazer();

        assertFalse(desfeito);
        assertEquals("Olá", editor.getConteudo());
    }
}
