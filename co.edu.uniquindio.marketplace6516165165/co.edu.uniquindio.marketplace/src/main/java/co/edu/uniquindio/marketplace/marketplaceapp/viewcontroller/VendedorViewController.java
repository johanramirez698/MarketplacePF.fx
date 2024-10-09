package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplaceapp.controller.VendedorController;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.marketplace.marketplaceapp.utils.MarketplaceConstantes.*;

public class VendedorViewController {

    VendedorController vendedorController;
    ObservableList<VendedorDto> listaVendedores = FXCollections.observableArrayList();
    VendedorDto vendedorSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TableColumn<VendedorDto, String> tcNombre;

    @FXML
    private TableView<VendedorDto> tableVendedor;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtApellidos;

    @FXML
    private Button btnEliminarVendedor;

    @FXML
    private TableColumn<VendedorDto, String> tcApellidos;

    @FXML
    private TableColumn<VendedorDto, String> tcContrasena;

    @FXML
    private TextField txtCedula;

    @FXML
    private Button btnEliminarElemento;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn<VendedorDto, String> tcCedula;

    @FXML
    private TableColumn<VendedorDto, String> tcDireccion;

    @FXML
    private Button btnAgregarVendedor;

    @FXML
    private TableColumn<VendedorDto, String> tcUsuario;

    @FXML
    private Button btnActualizarVendedor;

    @FXML
    void initialize() {
        vendedorController = new VendedorController();
        initView();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        return action.isPresent() && action.get() == ButtonType.OK;
    }

    @FXML
    void onAgregarVendedor(ActionEvent event) {
        agregarVendedor();
    }

    private void agregarVendedor() {
        VendedorDto vendedorDto = crearVendedorDto();

        if (datosValidos(vendedorDto)) {
            if (vendedorController.agregarVendedor(vendedorDto)) {
                listaVendedores.add(vendedorDto);
                limpiarCampos();
            } else {
                mostrarMensaje("Error en la información", "Error agregando el elemento", "Revisa la información suministrada", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, ERROR, MENSAJE, Alert.AlertType.WARNING);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
    }

    private boolean datosValidos(VendedorDto vendedorDto) {
        return !(vendedorDto.nombre().isEmpty() || vendedorDto.apellidos().isEmpty() ||
                vendedorDto.cedula().isEmpty() || vendedorDto.usuario().isEmpty() ||
                vendedorDto.direccion().isEmpty() || vendedorDto.contrasena().isEmpty());
    }

    private VendedorDto crearVendedorDto() {
        return new VendedorDto(
                txtNombre.getText(),
                txtApellidos.getText(),
                txtCedula.getText(),
                txtDireccion.getText(),
                txtUsuario.getText(),
                txtContrasena.getText()
        );
    }

    @FXML
    void onEliminarVendedor(ActionEvent event) {
        eliminarVendedor();
    }

    private void eliminarVendedor() {
        boolean vendedorEliminado = false;
        if (vendedorSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Seguro de que quieres eliminar este vendedor?")) {
                vendedorEliminado = vendedorController.eliminarVendedor(vendedorSeleccionado.cedula());
                if (vendedorEliminado) {
                    listaVendedores.remove(vendedorSeleccionado);
                    vendedorSeleccionado = null;
                    tableVendedor.getSelectionModel().clearSelection();
                    limpiarCampos();
                    mostrarMensaje("Notificación", "Empleado eliminado", "El empleado se eliminó con éxito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Notificación", "El empleado no se eliminó", "El empleado no se pudo eliminar, verifique que el empleado exista.", Alert.AlertType.INFORMATION);
                }
            }
        } else {
            mostrarMensaje("Notificación", "Algo salió mal :(", "Verifique que haya seleccionado un empleado para poder eliminarlo", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onActualizarVendedor(ActionEvent event) {
        ActualizarVendedor();
    }

    private void ActualizarVendedor() {
        boolean vendedorActualizado = false;
        if (vendedorSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Seguro de que quieres actualizar este vendedor?")) {
                // Crear el VendedorDto con los datos actualizados
                VendedorDto vendedorDtoActualizado = new VendedorDto(
                        txtNombre.getText(),
                        txtApellidos.getText(),
                        txtCedula.getText(),
                        txtDireccion.getText(),
                        txtUsuario.getText(),
                        txtContrasena.getText()
                );

                // Llamar al controlador para actualizar el vendedor
                vendedorActualizado = vendedorController.actualizarVendedor(vendedorSeleccionado.cedula(), vendedorDtoActualizado);

                if (vendedorActualizado) {
                    // Actualizar el vendedor en la lista y la tabla
                    int index = listaVendedores.indexOf(vendedorSeleccionado);
                    listaVendedores.set(index, vendedorDtoActualizado); // Actualiza la lista con el nuevo VendedorDto
                    vendedorSeleccionado = vendedorDtoActualizado; // Actualiza el vendedor seleccionado
                    tableVendedor.refresh(); // Refresca la tabla para mostrar los cambios
                    limpiarCampos();
                    mostrarMensaje("Notificación", "Vendedor actualizado", "El vendedor se actualizó con éxito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Notificación", "El vendedor no se actualizó", "Verifique que el vendedor exista.", Alert.AlertType.INFORMATION);
                }
            }
        } else {
            mostrarMensaje("Notificación", "Algo salió mal :(", "Verifique que haya seleccionado un vendedor para poder actualizarlo", Alert.AlertType.WARNING);
        }
    }

    private void initView() {
        this.initDataBinding();
        this.obtenerVendedores();
        this.tableVendedor.getItems().clear();
        this.tableVendedor.setItems(listaVendedores);
        this.listenerSelection();
    }

    private void obtenerVendedores() {
        listaVendedores.addAll(vendedorController.obtenerVendedores());
    }

    private void listenerSelection() {
        this.tableVendedor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
            mostrarInformacionVendedor(vendedorSeleccionado);
        });
    }

    private void mostrarInformacionVendedor(VendedorDto vendedorSeleccionado) {
        if (vendedorSeleccionado != null) {
            this.txtNombre.setText(vendedorSeleccionado.nombre());
            this.txtApellidos.setText(vendedorSeleccionado.apellidos());
            this.txtCedula.setText(vendedorSeleccionado.cedula());
            this.txtDireccion.setText(vendedorSeleccionado.direccion());
            this.txtUsuario.setText(vendedorSeleccionado.usuario());
            this.txtContrasena.setText(vendedorSeleccionado.contrasena());
        }
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellidos()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
        tcUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().usuario()));
        tcContrasena.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().contrasena()));
    }
}