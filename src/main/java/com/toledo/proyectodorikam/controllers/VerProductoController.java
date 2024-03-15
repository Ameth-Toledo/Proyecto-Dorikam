package com.toledo.proyectodorikam.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VerProductoController {

    @FXML
    private Button AreteMoñoButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button AreteRostroButton;

    @FXML
    private Button AreteManzanaButton;

    @FXML
    private Button AretePiñaButton;

    @FXML
    private Button AreteCorsalButton;

    @FXML
    private Button AretePerlaButton;

    @FXML
    private Button AreteHongoButton;

    @FXML
    private Button AreteMariposaButton;
    @FXML
    private ListView<String> VerInformacionProducto;
    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void OnMouseClickedAreteMoñoButton(MouseEvent event) {
        String Nombre       = "---" + " Nombre:" + " Arete-moño" + "      ---";
        String ID           = "---" + " ID:" + " 8F2342H2" + "                   ---";
        String Precio       = "---" + " Precio:" + " $98.50" + "                  ---";
        String Apartado     = "---" + "    •" +" 3 Pares" + "                       ---";
        String FechaEntrega = "---" + " 30 / 11 / 2024" + "                  ---";
        VerInformacionProducto.getItems().add(Nombre);
        VerInformacionProducto.getItems().add(ID);
        VerInformacionProducto.getItems().add(Precio);
        VerInformacionProducto.getItems().add(Apartado);
        VerInformacionProducto.getItems().add(FechaEntrega);
    }
    @FXML
    void OnMouseClickedAreteCorsalButton(MouseEvent event) {
        String Nombre       = "---" + " Nombre:" + " Arete-corsal" + "      ---";
        String ID           = "---" + " ID:" + " 9G2323Z3" + "                   ---";
        String Precio       = "---" + " Precio:" + " $198.50" + "                 ---";
        String Apartado     = "---" + "    •" +" 2 Pares" + "                       ---";
        String FechaEntrega = "---" + " 30 / 02 / 2024" + "                  ---";
        VerInformacionProducto.getItems().add(Nombre);
        VerInformacionProducto.getItems().add(ID);
        VerInformacionProducto.getItems().add(Precio);
        VerInformacionProducto.getItems().add(Apartado);
        VerInformacionProducto.getItems().add(FechaEntrega);
    }
    @FXML
    void OnMouseClickedAreteHongoButton(MouseEvent event) {
        String Nombre       = "---" + " Nombre:" + " Arete-Hongo" + "      ---";
        String ID           = "---" + " ID:" + " xxxx" + "                   ---";
        String Precio       = "---" + " Precio:" + " $xxx.50" + "                 ---";
        String Apartado     = "---" + "    •" +" 0 xxx" + "                       ---";
        String FechaEntrega = "---" + " 30 / xx / 2024" + "                  ---";
        VerInformacionProducto.getItems().add(Nombre);
        VerInformacionProducto.getItems().add(ID);
        VerInformacionProducto.getItems().add(Precio);
        VerInformacionProducto.getItems().add(Apartado);
        VerInformacionProducto.getItems().add(FechaEntrega);
    }
    @FXML
    void OnMouseClickedAreteManzanaButton(MouseEvent event) {
        String Nombre       = "---" + " Nombre:" + " Arete-manzana" + "      ---";
        String ID           = "---" + " ID:" + " ====" + "                   ---";
        String Precio       = "---" + " Precio:" + " $---.-0" + "                 ---";
        String Apartado     = "---" + "    •" +" 0 ....." + "                       ---";
        String FechaEntrega = "---" + " 30 / 12 / ...." + "                  ---";
        VerInformacionProducto.getItems().add(Nombre);
        VerInformacionProducto.getItems().add(ID);
        VerInformacionProducto.getItems().add(Precio);
        VerInformacionProducto.getItems().add(Apartado);
        VerInformacionProducto.getItems().add(FechaEntrega);
    }
    @FXML
    void OnMouseClickedAreteMariposaButton(MouseEvent event) {
        String Nombre       = "---" + " Nombre:" + " Arete-mariposa" + "      ---";
        String ID           = "---" + " ID:" + " ......" + "                   ---";
        String Precio       = "---" + " Precio:" + " ${{{.50" + "                 ---";
        String Apartado     = "---" + "    •" +" 0 Pares" + "                       ---";
        String FechaEntrega = "---" + " 30 / 12 / 2024" + "                  ---";
        VerInformacionProducto.getItems().add(Nombre);
        VerInformacionProducto.getItems().add(ID);
        VerInformacionProducto.getItems().add(Precio);
        VerInformacionProducto.getItems().add(Apartado);
        VerInformacionProducto.getItems().add(FechaEntrega);
    }
    @FXML
    void OnMouseClickedAretePerlaButton(MouseEvent event) {
        String Nombre       = "---" + " Nombre:" + " Arete-perla" + "      ---";
        String ID           = "---" + " ID:" + " 000000" + "                   ---";
        String Precio       = "---" + " Precio:" + " $000.50" + "                 ---";
        String Apartado     = "---" + "    •" +" 0 ---" + "                       ---";
        String FechaEntrega = "---" + " -- / 12 / 2024" + "                  ---";
        VerInformacionProducto.getItems().add(Nombre);
        VerInformacionProducto.getItems().add(ID);
        VerInformacionProducto.getItems().add(Precio);
        VerInformacionProducto.getItems().add(Apartado);
        VerInformacionProducto.getItems().add(FechaEntrega);
    }
    @FXML
    void OnMouseClickedAretePiñaButton(MouseEvent event) {
        String Nombre       = "---" + " Nombre:" + " Arete-piña" + "      ---";
        String ID           = "---" + " ID:" + " ----" + "                   ---";
        String Precio       = "---" + " Precio:" + " $---.50" + "                 ---";
        String Apartado     = "---" + "    •" +" 0 --" + "                       ---";
        String FechaEntrega = "---" + " 30 / 12 / ---" + "                  ---";
        VerInformacionProducto.getItems().add(Nombre);
        VerInformacionProducto.getItems().add(ID);
        VerInformacionProducto.getItems().add(Precio);
        VerInformacionProducto.getItems().add(Apartado);
        VerInformacionProducto.getItems().add(FechaEntrega);
    }
    @FXML
    void OnMouseClickedAreteRostroButton(MouseEvent event) {
        String Nombre       = "---" + " Nombre:" + " Arete-rostro" + "      ---";
        String ID           = "---" + " ID:" + " -----" + "                   ---";
        String Precio       = "---" + " Precio:" + " $---.00" + "                 ---";
        String Apartado     = "---" + "    •" +" 50 Pares" + "                       ---";
        String FechaEntrega = "---" + " 30 / -- / 2024" + "                  ---";
        VerInformacionProducto.getItems().add(Nombre);
        VerInformacionProducto.getItems().add(ID);
        VerInformacionProducto.getItems().add(Precio);
        VerInformacionProducto.getItems().add(Apartado);
        VerInformacionProducto.getItems().add(FechaEntrega);
    }
    @FXML
    void initialize() {
    }
}