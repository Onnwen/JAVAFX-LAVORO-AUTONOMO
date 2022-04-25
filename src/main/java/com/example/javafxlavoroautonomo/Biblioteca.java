package com.example.javafxlavoroautonomo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Biblioteca {
    private Libro[] libri;
    private int libriTotali;
    public ObservableList<String> libriUI = FXCollections.observableArrayList();

    public Biblioteca() {
        libri = new Libro[100];
        libriTotali = 0;
        libriUI.add("Nessun libro");
    }

    public void aggiungi(Libro libro) {
        libri[libriTotali] = libro;
        libriTotali++;
        libriUI.add(libro.getTitolo());
        if (libriTotali == 1) {
            libriUI.remove(0);
        }
    }

    public void rimuovi(int indice) {
        libriTotali--;
        for(int i=indice; i<libriTotali; i++) {
            libri[i] = libri[i++];
        }
        libriUI.remove(indice);
        if (libriTotali==0) {
            libriUI.add("Nessun libro");
        }
    }

    public Libro getLibro(int indice) {
        return libri[indice];
    }

    public void modifica(int indice, Libro libro) {
        libri[indice] = libro;
        libriUI.set(indice, libro.getTitolo());
    }
}
