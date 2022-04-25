package com.example.javafxlavoroautonomo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ListView listaLibri = new ListView();
    @FXML
    private TextField titoloLibroSelezionato = new TextField();
    @FXML
    private TextField autoreLibroSelezionato = new TextField();
    @FXML
    private TextField genereLibroSelezionato = new TextField();
    @FXML
    private Button rimuovi = new Button();
    @FXML
    private Button modifica = new Button();
    @FXML
    private Button aggiungi = new Button();

    private Biblioteca biblioteca = new Biblioteca();

    @FXML
    protected void onAggiungiClick() {
        biblioteca.aggiungi(new Libro(titoloLibroSelezionato.getText(), autoreLibroSelezionato.getText(), genereLibroSelezionato.getText()));
    }

    @FXML
    protected void onRimuoviClick() {
        biblioteca.rimuovi(listaLibri.getSelectionModel().getSelectedIndex());
    }

    @FXML
    protected void onModificaClick() {
        biblioteca.modifica(listaLibri.getSelectionModel().getSelectedIndex(), new Libro(titoloLibroSelezionato.getText(), autoreLibroSelezionato.getText(), genereLibroSelezionato.getText()));
    }

    @FXML
    protected void onListaClick() {
        titoloLibroSelezionato.setText(biblioteca.getLibro(listaLibri.getSelectionModel().getSelectedIndex()).getTitolo());
    }

    public void initialize() {
        listaLibri.setItems(biblioteca.libriUI);
    }
}