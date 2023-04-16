package com.example.Proyecto;

import Models.ContactList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;

public class PrincipalController extends ContactList implements Initializable {


    public TableColumn<Persona, String> colNombre;
    public TableColumn<Persona, String> colEmail;
    public TableColumn<Persona, Object> colTelefono;
    public Button btnAgregar;

    public ListView<String> Listfilter;
    public Label txtShowFav;
    public ImageView imgShowFav;

    @FXML
    private Button btneliminar;

    @FXML
    private Button btnmodificar;

    @FXML
    private TextField txtFiltrarNombre;

    @FXML
    private Label txtShowDireccion;

    @FXML
    private Label txtShowEmail;

    @FXML
    private Label txtShowNombre;

    @FXML
    private Label txtShowTelefono;

    @FXML
    private Label txtShowTipo;

    @FXML
    private ImageView imgUser;
 
    private LinkedList<ArrayList<Contacto>> listaContactos;
    public TableView<Contacto> tblPersonas;

    public ObservableList<Contacto> contactos;
    public ObservableList<Contacto> filtroPersonas;

    //Botones para filtrar
    @FXML
    private Button btnFav;


    @FXML
    private Button btnOthers;


    @FXML
    private Button btnTodos;





    private final String[] alfabeto={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    this.Listfilter.getItems().addAll(alfabeto);  //Inicializa la lista con las opciones de filtrar por letra
    contactos= FXCollections.observableArrayList();
    filtroPersonas=FXCollections.observableArrayList();
    this.tblPersonas.setItems(contactos);

    //Asociando el objeto con su columna correspondiente
    this.colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
    this.colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    this.colTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));

    }

    public void agregar(ActionEvent actionEvent) {

        try {
           //Cargamos la ventana de agregar

           FXMLLoader fxmlLoader=new FXMLLoader(PrincipalController.class.getResource("AddView.fxml"));
           Parent root=fxmlLoader.load();
           AddController controller =fxmlLoader.getController();
           //En este punto se deberia de extraer desde la lista principal hacia el observable list para actualizar.
           controller.initAtributtes(contactos);

           Scene scene=new Scene(root);
           Stage stage=new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setScene(scene);
           stage.showAndWait();

           Contacto contacto=controller.getContacto();

            if(contacto!=null){
                this.contactos.add(contacto);


                if(contacto.getNombre().toLowerCase().contains(this.txtFiltrarNombre.getText().toLowerCase())){
                    this.filtroPersonas.add(contacto);
                }
                this.tblPersonas.refresh();
            }

        } catch (IOException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }


    }

    @FXML
    void eliminar(ActionEvent event) {
        Contacto p=this.tblPersonas.getSelectionModel().getSelectedItem();


        if(p==null){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }else{
            this.contactos.remove(p);
            this.filtroPersonas.remove(p);
            this.tblPersonas.refresh();

            /**Al eliminar la persona seleccionada, los datos mostrados en pantalla derecha
             * vuelven a estar en blanco hasta que se seleccione otra persona
             */
            this.txtShowNombre.setText("");
            this.txtShowTelefono.setText("");
            this.txtShowDireccion.setText("");
            this.txtShowEmail.setText("");
            this.txtShowTipo.setText("");

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Se eliminado la persona");
            alert.showAndWait();

        }

    }

    @FXML
    void modificar(ActionEvent event) {

        Contacto p= this.tblPersonas.getSelectionModel().getSelectedItem();

        if(p==null){

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes selccionar una persona");
            alert.showAndWait();

        }else{

            try {

                FXMLLoader fxmlLoader=new FXMLLoader(PrincipalController.class.getResource("AddView.fxml"));
                Parent root=fxmlLoader.load();
                AddController controller =fxmlLoader.getController();
                controller.initAtributtes(contactos,p);

                Scene scene=new Scene(root);
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

               Contacto aux=controller.getContacto();

                if(aux!=null){

                    if(!aux.getNombre().toLowerCase().contains(this.txtFiltrarNombre.getText().toLowerCase())){
                        this.filtroPersonas.remove(aux);
                    }

                    /**Al Modificar la persona seleccionada, los datos mostrados en pantalla derecha
                     * vuelven a estar en blanco hasta que se seleccione otra persona
                     */
                    this.txtShowNombre.setText("");
                    this.txtShowTelefono.setText("");
                    this.txtShowDireccion.setText("");
                    this.txtShowEmail.setText("");
                    this.txtShowTipo.setText("");

                    this.tblPersonas.refresh();
                }

            } catch (IOException e) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }

        }


    }


    public void filtrarNombre(KeyEvent keyEvent) {

        String filtroNombre=this.txtFiltrarNombre.getText(); // capturando el texto escrito en la barra de busqueda
        if(filtroNombre.isEmpty()){
            this.tblPersonas.setItems(contactos); // si no hay nada escrito, entonces muestro todas las personas, seteo con el orignal

        }else{
            this.filtroPersonas.clear();
            for(Contacto p: this.contactos){
                if(p.getNombre().toLowerCase().contains(filtroNombre.toLowerCase())){
                    this.filtroPersonas.add(p);

                }
            }
            this.tblPersonas.setItems(filtroPersonas);
        }
    }



    public void ChangeScreen(MouseEvent mouseEvent) {
        Image imgfav= new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/favorito.png")));
        Image imgNofav= new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Nofavorito.png")));

        Contacto p= this.tblPersonas.getSelectionModel().getSelectedItem();
        this.txtShowNombre.setText(p.getNombre());
        this.txtShowTelefono.setText(p.getTelefono()+"");
        this.txtShowDireccion.setText(p.getDireccion());
        this.txtShowEmail.setText(p.getEmail());
        this.txtShowTipo.setText(p.getTipo());

        //Cambiando la imagen si es favorito o no

        if(p.isFavorito()){
            this.imgShowFav.setImage(imgfav);
        }else{
            this.imgShowFav.setImage(imgNofav);
        }
        //Cambiando la imagen del usuario.
        char letra=p.getNombre().toLowerCase().charAt(0);
        String imgnameUser=null;

        //Si el nombre empieza con una letra se carga su letra, de no ser asi se deja la imagen por defecto

        if( letra>='a' && letra<='z' ){
            imgnameUser="Images/"+letra+".png";

        }else{
            imgnameUser="Images/usuario.png";
        }
        Image imgUser= new Image(Objects.requireNonNull(getClass().getResourceAsStream(imgnameUser)));
        this.imgUser.setImage(imgUser);

    }




    /**Es metodo muestra todos los contactos que no inician con una letra**/
    public void ShowOthers(ActionEvent actionEvent) {
    }

    /**Este metodo muestra todos los contactos almacenados en una observable listo en
     * paralelo**/

    public void ShowAll(ActionEvent actionEvent) {
    }

    /**Este metodo muestra todos los contactos marcados como favoritos**/

    public void ShowFav(ActionEvent actionEvent) {
    }

    /**Este metodo se utiliza para poder filtrar todos los contactos
     * que inicien por una letra en especifico**/
    public void FilterByLetter(MouseEvent mouseEvent) {

        String filtro= this.Listfilter.getSelectionModel().getSelectedItem(); //Se obtiene la letra que el usuario selecciona de la lista

        /**Se utiliza el metodo get array para obtener el array seleccionado por el filtro
         * luego se castea a un observable list y este se pasa a la tabla para que se actualice
         */


    }
}