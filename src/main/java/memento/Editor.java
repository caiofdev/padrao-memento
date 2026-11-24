package memento;

public class Editor {

    private String conteudo = "";

    public void escrever(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("Texto não pode ser nulo");
        }
        conteudo = conteudo + texto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public EditorMemento salvar() {
        return new EditorMemento(conteudo);
    }

    public void restaurar(EditorMemento memento) {
        if (memento == null) {
            throw new IllegalArgumentException("Memento não pode ser nulo");
        }
        conteudo = memento.conteudo();
    }
}
