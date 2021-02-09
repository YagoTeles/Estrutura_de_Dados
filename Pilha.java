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


public class Pilha<T> {
    private No<T> topo = null;

    public Pilha() {
    }

    public void push(T valor) {
        No<T> novoNo = new No<T>(valor);

        novoNo.setproximo(topo);
        topo = novoNo;
    }

    public Object pop() {
        if (topo != null) {
            No item = topo;

            topo = topo.getproximo();
            item.setproximo(null);

            return item.getvalor();
        }

        return null;
    }

    Object peek() {
        return topo.getvalor();
    }

    public void exibir() {
        No atual = topo;

        while (atual != null) {
            System.out.print(atual.getvalor().toString() + " ");
            atual = atual.getproximo();
        }

        System.out.println();
    }

}
