
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
    public class ListaDinamica<T> {

        private No<T> primeiro = null;
        private No<T> ultimo = null;
        private int tamanho = 0;

        public ListaDinamica() { }

        public void adicionar(T valor) {
            No<T> NovoNo = new No<T>(valor);
            if (this.tamanho == 0) {
                this.primeiro = NovoNo;
                this.ultimo = NovoNo;
            }
            else {
                this.ultimo.setproximo(NovoNo);
                this.ultimo = this.ultimo.getproximo();
            }

            this.tamanho++;
        }

        public T buscar(int x) {
            if (this.tamanho == 0) return null;
            int atual = 0;
            No<T> atualNo = this.primeiro;
            while (atual < x) {
                atual++;
                atualNo = atualNo.getproximo();
            }

            return atualNo.getvalor();
        }

        public int gettamanho() {
            return this.tamanho;
        }
        public void exibir(){
            No atual = primeiro;

            while (atual != null) {
                System.out.print(atual.getvalor() + " ");
                atual = atual.getproximo();
            }

            System.out.println();
        }

    }

