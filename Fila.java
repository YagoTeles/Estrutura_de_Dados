class No<T> {

    private T valor;
    private No<T> proximo = null;

    public No(T valor) {
        this.valor = valor;

    }

    public T getvalor() {
        return valor;
    }
    public void setvalor(T valor) {
        this.valor = valor;
    }
    public No<T> getproximo() {
        return proximo;
    }
    public void setproximo(No<T> proximo) {
        this.proximo = proximo;
    }

}


public class Fila<T> {
    private No<T> primeiro = null;
    private No<T> ultimo = null;

    public Fila() { }

    public void enqueue(T item) {
        No<T> novo = new No<T>(item);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setproximo(novo);
            ultimo = novo;
        }
    }

    public T dequeue() {
        if (primeiro != null) {
            No<T> item = primeiro;

            primeiro = primeiro.getproximo();
            item.setproximo(null);

            return item.getvalor();
        }

        return null;
    }

    public void exibir() {
        No<T> atual = primeiro;

        while (atual != null) {
            System.out.print(atual.getvalor().toString() + " ");
            atual = atual.getproximo();
        }

        System.out.println();
    }

}
