public class ArvoreDeBusca<T> {
//-----------------------------------
    public class No <T> {
        public T valor;
        public No<T> esquerda;
        public No<T> direita;

        public No(T valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }
//-----------------------------------
    private No raiz;

    public ArvoreDeBusca() {
        raiz = null;
    }

    public void adicionar(T valor) {
        if (raiz == null) {
            raiz = new No(valor);
        }
        else {
            adicionar(valor, raiz);
        }
    }

    private void adicionar(T valor, No raiz) {
        if (valor.toString().compareTo(raiz.valor.toString()) < 0 ) {
            if (raiz.esquerda == null) {
                raiz.esquerda = new No(valor);
            }
            else {
                adicionar(valor, raiz.esquerda);
            }
        }
        else if (valor.toString().compareTo(raiz.valor.toString()) > 0) {
            if (raiz.direita == null) {
                raiz.direita = new No(valor);
            }
            else {
                adicionar(valor, raiz.direita);
            }
        }
    }

    public boolean pesquisar(T valor) {
        if (raiz == null) {
            return false;
        }
        else {
            return pesquisar(valor, raiz);
        }
    }

    private boolean pesquisar(T valor, No<T> raiz) {
        if (valor == raiz.valor) {
            return true;
        }
        else if (valor.toString().compareTo(raiz.valor.toString()) < 0) {
            if (raiz.esquerda == null) {
                return false;
            }
            else {
                return pesquisar(valor, raiz.esquerda);
            }
        }
        else if (valor.toString().compareTo(raiz.valor.toString()) > 0) {
            if (raiz.direita == null) {
                return false;
            }
            else {
                return pesquisar(valor, raiz.direita);
            }
        }

        return false;
    }

    public void remover(T valor) {
        if (raiz != null) {
            remover(valor, raiz, null);
        }
    }

    private void remover(T valor, No<T> raiz, No<T> pai) {

        if (valor.toString().compareTo(raiz.valor.toString()) == 0) {
            if (raiz.esquerda == null && raiz.direita == null) {
                if (raiz == pai.esquerda)
                    pai.esquerda = null;
                else
                    pai.direita = null;
            }

            else if (raiz.esquerda != null && raiz.direita == null) {
                if (raiz == pai.esquerda)
                    pai.esquerda = raiz.esquerda;
                else
                    pai.direita = raiz.esquerda;
            }

            else if (raiz.esquerda == null && raiz.direita != null) {
                if (raiz == pai.esquerda)
                    pai.esquerda = raiz.direita;
                else
                    pai.direita = raiz.direita;
            }

            else if (raiz.esquerda != null && raiz.direita != null) {
                raiz.valor = menorValor(raiz.direita);
                remover(raiz.valor, raiz.direita, raiz);
            }

        }
        else if (valor.toString().compareTo(raiz.valor.toString())<0) {
            if (raiz.esquerda != null)
                remover(valor, raiz.esquerda, raiz);
        }

        else if (valor.toString().compareTo(raiz.valor.toString()) > 0) {
            if (raiz.direita != null)
                remover(valor, raiz.direita, raiz);
        }

    }

    private T menorValor(No<T> raiz) {
        if (raiz.esquerda == null)
            return raiz.valor;
        else
            return menorValor(raiz.esquerda);
    }

    public void exibirPreOrdem() {
        if (raiz != null) {
            exibirPreOrdem(raiz);
            System.out.println();
        }
    }

    private void exibirPreOrdem(No<T> raiz) {
        System.out.print(raiz.valor + " ");

        if (raiz.esquerda != null) {
            exibirPreOrdem(raiz.esquerda);
        }

        if (raiz.direita != null) {
            exibirPreOrdem(raiz.direita);
        }
    }

    public void exibirEmOrdem() {
        if (raiz != null) {
            exibirEmOrdem(raiz);
            System.out.println();
        }
    }

    private void exibirEmOrdem(No<T> raiz) {
        if (raiz.esquerda != null) {
            exibirEmOrdem(raiz.esquerda);
        }

        System.out.print(raiz.valor + " ");

        if (raiz.direita != null) {
            exibirEmOrdem(raiz.direita);
        }
    }

    public void exibirPosOrdem() {
        if (raiz != null) {
            exibirPosOrdem(raiz);
            System.out.println();
        }
    }

    private void exibirPosOrdem(No<T> raiz) {
        if (raiz.esquerda != null) {
            exibirPosOrdem(raiz.esquerda);
        }

        if (raiz.direita != null) {
            exibirPosOrdem(raiz.direita);
        }

        System.out.print(raiz.valor + " ");
    }
}