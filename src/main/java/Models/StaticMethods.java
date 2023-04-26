package Models;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class StaticMethods {

    public static void LlenarComboBox(ComboBox<String> llenarCombo, ObservableList<String> infoCombo ){
        llenarCombo.setItems(infoCombo);
    }
    public static boolean isNumeric(String s)
    {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }





}
