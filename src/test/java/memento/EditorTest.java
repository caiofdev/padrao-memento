package memento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EditorTest {

    private Editor editor;

    @BeforeEach
    void setUp() {
        editor = new Editor();
    }

    @Test
    void deveIniciarComConteudoVazio() {
        assertEquals("", editor.getConteudo());
    }

    @Test
    void deveConcatenarTextoAoEscrever() {
        editor.escrever("Olá");
        editor.escrever(" mundo");

        assertEquals("Olá mundo", editor.getConteudo());
    }

    @Test
    void deveLancarExcecaoAoEscreverTextoNulo() {
        assertThrows(IllegalArgumentException.class, () -> editor.escrever(null));
    }

    @Test
    void deveSalvarEstadoAtualEmMemento() {
        editor.escrever("Olá");

        EditorMemento memento = editor.salvar();

        assertEquals("Olá", memento.conteudo());
    }

    @Test
    void deveRestaurarEstadoDoMemento() {
        editor.escrever("Olá");
        EditorMemento memento = editor.salvar();
        editor.escrever(" mundo");

        editor.restaurar(memento);

        assertEquals("Olá", editor.getConteudo());
    }

    @Test
    void deveLancarExcecaoAoRestaurarMementoNulo() {
        assertThrows(IllegalArgumentException.class, () -> editor.restaurar(null));
    }
}
