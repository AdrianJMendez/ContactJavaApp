package Models;

import com.example.abriendoventanas.Contacto;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;

public class StaticMethods {

    public static void LlenarComboBox(ComboBox<String> llenarCombo, ObservableList<String> infoCombo ){
        llenarCombo.setItems(infoCombo);
    }





}
