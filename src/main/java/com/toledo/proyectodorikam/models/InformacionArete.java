package com.toledo.proyectodorikam.models;
public class InformacionArete extends javafx.scene.control.ListCell<Arete> {
    @Override
    protected void updateItem(Arete arete, boolean empty){
        super.updateItem(arete, empty);

        if (empty || arete == null){
            setText(null);
            }else {
                setText(arete.toString());
        }
    }
}

