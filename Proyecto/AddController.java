package Proyecto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static Models.StaticMethods.LlenarComboBox;

public class AddController implements Initializable {

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnSalir;

    @FXML
    private ComboBox<?> cmbTipo;

    @FXML
    private RadioButton rdFavorito;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    private Contacto contacto;

    public ObservableList<Contacto> contactos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initAtributtes(ObservableList<Contacto> contactos){
        this.contactos=contactos;
    }

    public void initAtributtes(ObservableList<Contacto> contactos, Contacto contacto){
        this.contactos=contactos;
        this.contacto=contacto;
        this.txtNombre.setText(contacto.getNombre());
        this.txtDireccion.setText(contacto.getDireccion());
        this.txtTelefono.setText(contacto.getTelefono()+"");
        this.txtEmail.setText(contacto.getEmail());
    }


    public void salir(ActionEvent actionEvent) {
        this.contacto=null;
        Stage stage=(Stage) this. btnGuardar.getScene().getWindow();  // cerrar la ventana
        stage.close();
    }

    public void guardar(ActionEvent actionEvent) {

        String nombre=this.txtNombre.getText();
        double telefono= Double.parseDouble(this.txtTelefono.getText());
        String email=this.txtEmail.getText();
        String direccion=this.txtDireccion.getText();
        String tipo= (String) this.cmbTipo.getSelectionModel().getSelectedItem();
        boolean fav= rdFavorito.isSelected();



       Contacto contacto1=new Contacto(nombre,email,direccion,tipo,telefono,fav);


        if(!contactos.contains(contacto1)){
            // este if diferencia el boton guardar en los casos de crear o modificar
            //Modificar
            if(this.contacto!=null){
                this.contacto.setNombre(nombre);
                this.contacto.setDireccion(direccion);
                this.contacto.setEmail(email);
                this.contacto.setTelefono(telefono);


                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha modificado el contacto");
                alert.showAndWait();

            }else{
                //insertando persona nueva
                this.contacto=contacto1;
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha añadido correctamente");
                alert.showAndWait();
            }



            Stage stage=(Stage) this. btnGuardar.getScene().getWindow();  // cerrar la ventana
            stage.close();


        }else {

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }


    }


    public Contacto getContacto() {
        return contacto;
    }

    ObservableList<String> tiposList= FXCollections.observableArrayList("Familiar","Colega","Cliente");
    public void ListarTipos(Event event) {
        LlenarComboBox((ComboBox<String>) cmbTipo,tiposList);
    }
}
