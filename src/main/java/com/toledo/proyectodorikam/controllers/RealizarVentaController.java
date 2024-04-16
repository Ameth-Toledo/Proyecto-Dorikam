package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Apartar;
import com.toledo.proyectodorikam.models.Producto;
import com.toledo.proyectodorikam.models.Venta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;


public class RealizarVentaController {

    @FXML
    private Button exitButton;

    @FXML
    private TextField nombreProductoTextField;

    @FXML
    private TextField fechaCompraTextField;

    @FXML
    private TextField nombreClienteTextField;

    @FXML
    private TextField lugarEntregaTextField;

    @FXML
    private TextField idProductoTextField;

    @FXML
    private TextField precioProductoTextField11;

    @FXML
    private TextField cantidadComprar;

    @FXML
    private Button confirmarButton;

    @FXML
    private ComboBox<String> pago;

    @FXML
    private Button buscarButton;

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProducto = nombreProductoTextField.getText();
        Producto productoEncontrado = buscarProductoPorNombre(nombreProducto);

        if (productoEncontrado != null) {
            llenarInformacionProducto(productoEncontrado);
            mostrarAlertaExito("Exito", "Producto encontrado: " + productoEncontrado.getNombre());

            int cantidadApartada = contarProductosApartados(productoEncontrado);
            if (cantidadApartada > 0) {
                mostrarAlertaWarning("Productos apartados" , "Hay " + cantidadApartada + " productos apartados.");
            }
        } else {
            mostrarAlertaError("Error", "El producto no existe.");
        }
    }

    private Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : Producto.getListaProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private int contarProductosApartados(Producto producto) {
        int cantidadApartada = 0;
        for (Apartar apartado : Apartar.getListaApartados()) {
            if (apartado.getProducto().equalsIgnoreCase(producto.getNombre())) {
                cantidadApartada += apartado.getCantidadDeProductos();
            }
        }
        return cantidadApartada;
    }


    private void llenarInformacionProducto(Producto producto) {
        idProductoTextField.setText(producto.getId());
        precioProductoTextField11.setText(String.valueOf(producto.getPrecio()));
        fechaCompraTextField.setText(String.valueOf(producto.getFecha()));
        nombreProductoTextField.setText(String.valueOf(producto.getNombre()));
        lugarEntregaTextField.setText(String.valueOf(producto.getUbicacion()));
    }

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String idProducto = idProductoTextField.getText();
        int cantidad = Integer.parseInt(cantidadComprar.getText());
        String nombreProducto = nombreProductoTextField.getText();
        String fechaCompra = fechaCompraTextField.getText();
        String nombreCliente = nombreClienteTextField.getText();
        String lugarEntrega = lugarEntregaTextField.getText();
        double precioProducto = Double.parseDouble(precioProductoTextField11.getText());

        Producto producto = buscarProducto(idProducto);

        if (producto != null) {
            if (producto.getStock() >= cantidad) {
                double totalPagar = producto.getPrecio() * cantidad;
                String mensaje = "Total a pagar: $" + totalPagar + "\n¿Desea confirmar la venta?";
                if (confirmarVenta(mensaje)) {
                    Venta venta = new Venta(producto, cantidad, pago.getValue(), nombreProducto, fechaCompra, nombreCliente, lugarEntrega, precioProducto);
                    venta.listaVentas.add(venta);
                    producto.setStock(producto.getStock() - cantidad);

                    mostrarAlertaInformation("Venta realizada", "La venta se ha realizado correctamente.", totalPagar);
                } else {
                    mostrarAlertaError("Venta cancelada", "La venta ha sido cancelada.");
                }
            } else {
                mostrarAlertaError("Error", "No hay suficiente stock para realizar la venta.");
            }
        } else {
            mostrarAlertaError("Error", "El producto no existe.");
        }
        System.out.println("venta");
        for (Venta p : Venta.getListaVentas()) {
            System.out.println(p.toString());
        }
    }

    private Producto buscarProducto(String id) {
        for (Producto producto : Producto.getListaProductos()) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    Stage callExit = new Stage();
    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-administrador-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callExit.setTitle("Menu: \"Realizar Venta\"");
        callExit.setScene(scene);
        callExit.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callExit.show();
        cerrarVentana();
    }

    public void cerrarVentana() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        pago.getItems().addAll("Efectivo", "Tarjeta", "Transferencia");

        nombreProductoTextField.setOnKeyPressed(this::handleEnterKey);
        precioProductoTextField11.setOnKeyPressed(this::handleEnterKey);
        fechaCompraTextField.setOnKeyPressed(this::handleEnterKey);
        nombreClienteTextField.setOnKeyPressed(this::handleEnterKey);
        lugarEntregaTextField.setOnKeyPressed(this::handleEnterKey);
        idProductoTextField.setOnKeyPressed(this::handleEnterKey);

        confirmarButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                OnMouseClickedConfirmarButton(null);
            }
        });
    }

    private void handleEnterKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            event.consume();
            if (event.getSource() == nombreProductoTextField) {
                idProductoTextField.requestFocus();
            } else if (event.getSource() == idProductoTextField) {
                precioProductoTextField11.requestFocus();
            } else if (event.getSource() == precioProductoTextField11) {
                lugarEntregaTextField.requestFocus();
            } else if (event.getSource() == lugarEntregaTextField) {
                fechaCompraTextField.requestFocus();
            } else if (event.getSource() == fechaCompraTextField) {
                nombreClienteTextField.requestFocus();
            } else if (event.getSource() == nombreClienteTextField) {
                confirmarButton.requestFocus();
            } else if (event.getSource() == confirmarButton) {
                OnMouseClickedConfirmarButton(null);
            }
        }
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarAlertaExito(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarAlertaWarning(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    private void mostrarAlertaInformation(String title, String contenido, double totalVenta) {
        String idVenta = generarIDUnico();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenido);

        ButtonType botonDescargar = new ButtonType("Descargar Comprobante", ButtonBar.ButtonData.LEFT);
        alert.getButtonTypes().add(botonDescargar);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == botonDescargar) {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar comprobante");
            fileChooser.setInitialFileName("comprobante de venta.txt");
            File archivo = fileChooser.showSaveDialog(null);

            if (archivo != null) {
                try {
                    FileWriter escritor = new FileWriter(archivo);
                    escritor.write("\"𝓓𝓞𝓡𝓘𝓚𝓐𝓜\"" + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("Le atendio: 𝑴𝒂𝒈𝒂𝒍𝒍𝒚 𝑻𝒐𝒍𝒆𝒅𝒐 𝑶𝒓𝒐𝒛𝒄𝒐"+System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("𝐃𝐞𝐭𝐚𝐥𝐥𝐞𝐬 𝐝𝐞 𝐥𝐚 𝐯𝐞𝐧𝐭𝐚 :" + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("_________________________________________" + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("- ID VENTA: " + idVenta + System.lineSeparator());
                    escritor.write("_________________________________________" + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("ID PRODUCTO: " + idProductoTextField.getText() + System.lineSeparator());
                    escritor.write("NOMBRE DEL PRODUCTO: " + nombreProductoTextField.getText() + System.lineSeparator());
                    escritor.write("CANTIDAD: " + cantidadComprar.getText() + System.lineSeparator());
                    escritor.write("FECHA DE LA VENTA: " + fechaCompraTextField.getText() + System.lineSeparator());
                    escritor.write("NOMBRE DEL CLIENTE: " + nombreClienteTextField.getText() + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("LUGAR DE ENTREGA: " + lugarEntregaTextField.getText() + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("PRECIO DEL PRODUCTO: " + precioProductoTextField11.getText() + System.lineSeparator());
                    escritor.write("FORMA DE PAGO: " + pago.getValue() + System.lineSeparator());
                    escritor.write("TOTAL: $" + totalVenta + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("𝑺𝒖𝒄𝒖𝒓𝒔𝒂𝒍𝒆𝒔 𝒖𝒃𝒊𝒄𝒂𝒅𝒂𝒔 𝒆𝒏: \n✅ 12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n📍GoogleMaps: https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA ");
                    escritor.write(System.lineSeparator());
                    escritor.write("\n✅ Chiapa de Corzo 2 9, Las Torres, 29045 Tuxtla Gutiérrez, Chis. \n📍GoogleMaps: https://maps.app.goo.gl/D3m1aZAk4fR3WJpR9" + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.close();
                    mostrarAlertaExito("Éxito", "Comprobante descargado correctamente como '" + archivo.getName() + "'.");
                } catch (IOException e) {
                    e.printStackTrace();
                    mostrarAlertaError("Error", "No se pudo guardar el comprobante.");
                }
            }
        }
    }

    private String generarIDUnico() {
        String uuid = UUID.randomUUID().toString();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            char ramdomChar = (char) (random.nextInt(26) + 'A');
            sb.append(ramdomChar);
        }

        for (int i = 0; i < 8; i++) {
            sb.append(uuid.charAt(i));
        }
        return sb.toString();
    }

    private boolean confirmarVenta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Venta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        ButtonType buttonTypeConfirmar = new ButtonType("Confirmar");
        ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeConfirmar, buttonTypeCancelar);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == buttonTypeConfirmar;
    }
}
