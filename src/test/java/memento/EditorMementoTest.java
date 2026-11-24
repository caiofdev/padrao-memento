package memento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EditorMementoTest {

    @Test
    void deveRetornarConteudoArmazenado() {
        EditorMemento memento = new EditorMemento("Olá");

        assertEquals("Olá", memento.conteudo());
    }
}
