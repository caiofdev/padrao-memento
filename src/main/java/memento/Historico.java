package memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class Historico {

    private final Editor editor;
    private final Deque<EditorMemento> estados = new ArrayDeque<>();

    public Historico(Editor editor) {
        this.editor = editor;
    }

    public void salvar() {
        estados.push(editor.salvar());
    }

    public boolean desfazer() {
        if (estados.isEmpty()) {
            return false;
        }
        editor.restaurar(estados.pop());
        return true;
    }

    public int tamanho() {
        return estados.size();
    }
}
