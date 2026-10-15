package negocio;

import modelo.Nodo;

public class ArbolBinario<T> {
    private Nodo<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void crearRaiz(T dato) {
        if (esVacio()) {
            raiz = new Nodo<>(dato);
        } else {
            System.out.println("El árbol ya tiene una raíz.");
        }
    }

    public boolean agregarIzquierdo(Nodo<T> padre, T dato) {
        if (padre != null && padre.getIzquierdo() == null) {
            padre.setIzquierdo(new Nodo<>(dato));
            return true;
        }
        return false; // Posición ocupada o padre nulo
    }

    public boolean agregarDerecho(Nodo<T> padre, T dato) {
        if (padre != null && padre.getDerecho() == null) {
            padre.setDerecho(new Nodo<>(dato));
            return true;
        }
        return false;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo<T> nodo) {
        if (nodo == null)
            return 0;
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(Nodo<T> nodo) {
        if (nodo == null)
            return 0;
        if (nodo.esHoja())
            return 1;
        return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo<T> nodo) {
        if (nodo == null)
            return -1; // Árbol vacío
        if (nodo.esHoja())
            return 0; // Árbol con un solo nodo tiene altura 0 (aristas)
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }

    public void mostrarArbol() {
        mostrarArbolRecursivo(raiz, "", true);
    }

    private void mostrarArbolRecursivo(Nodo<T> nodo, String prefijo, boolean esIzquierdo) {
        if (nodo != null) {
            System.out.println(prefijo + (esIzquierdo ? "├── " : "└── ") + nodo.getDato());
            mostrarArbolRecursivo(nodo.getIzquierdo(), prefijo + (esIzquierdo ? "│   " : "    "), true);
            mostrarArbolRecursivo(nodo.getDerecho(), prefijo + (esIzquierdo ? "│   " : "    "), false);
        }
    }
}
