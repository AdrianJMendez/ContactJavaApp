package Models;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class StaticMethods {

    public static void LlenarComboBox(ComboBox<String> llenarCombo, ObservableList<String> infoCombo ){
        llenarCombo.setItems(infoCombo);
    }





}
