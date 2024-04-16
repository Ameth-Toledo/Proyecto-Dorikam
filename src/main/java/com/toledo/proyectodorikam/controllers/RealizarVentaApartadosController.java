package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Apartar;
import com.toledo.proyectodorikam.models.Entregado;
import com.toledo.proyectodorikam.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

public class RealizarVentaApartadosController {

    @FXML
    private Button exitButton;

    @FXML
    private TextField nombreProductoTextField;

    @FXML
    private TextField fechaCompraTextField;

    @FXML
    private TextField cantidadApartadaTextField;

    @FXML
    private TextField lugarEntregaTextField;

    @FXML
    private TextField idProductoTextField;

    @FXML
    private Button confirmarButton;

    @FXML
    private ComboBox<String> pago;

    @FXML
    private TextField restanteProducto;

    @FXML
    private TextField montoAbonadoProducto;

    @FXML
    private Button buscarButton;

    @FXML
    private TextField categoriaProductoTextField;

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProducto = nombreProductoTextField.getText().trim();

        for (Apartar apartado : Apartar.getListaApartados()) {
            if (apartado.getProducto().equalsIgnoreCase(nombreProducto)) {
                mostrarAlertaInformacion("Producto encontrado");
                autorellenarInformacion(apartado);
                return;
            }
        }
        mostrarAlertaError("Producto no encontrado", "El producto no está en la lista.");
    }

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String nombreProducto = nombreProductoTextField.getText().trim();
        int cantidadApartada = Integer.parseInt(cantidadApartadaTextField.getText().trim());
        Apartar apartadoEncontrado = null;
        for (Apartar apartado : Apartar.getListaApartados()) {
            if (apartado.getProducto().equalsIgnoreCase(nombreProducto)) {
                apartadoEncontrado = apartado;
                break;
            }
        }
        if (apartadoEncontrado != null) {
            String productoApartado = apartadoEncontrado.getProducto();
            for (Producto producto : Producto.getListaProductos()) {
                if (producto.getNombre().equalsIgnoreCase(productoApartado)) {
                    double montoAbonado = Double.parseDouble(montoAbonadoProducto.getText().trim());
                    double precioProducto = producto.getPrecio();
                    double totalPagar = precioProducto - montoAbonado;
                    double restanteMultiplicado = Double.parseDouble(restanteProducto.getText().trim()) * cantidadApartada;

                    Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmAlert.setTitle("Confirmar Venta");
                    confirmAlert.setHeaderText(null);
                    confirmAlert.setContentText("Total a pagar: $" + totalPagar + "\n¿Desea confirmar la venta?");
                    Optional<ButtonType> result = confirmAlert.showAndWait();

                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        int stockActualizado = producto.getStock() - cantidadApartada;
                        producto.setStock(stockActualizado);
                        Apartar.getListaApartados().remove(apartadoEncontrado);

                        Entregado entregado = new Entregado(
                                nombreProducto,
                                idProductoTextField.getText(),
                                cantidadApartada,
                                montoAbonado,
                                restanteMultiplicado,
                                lugarEntregaTextField.getText(),
                                fechaCompraTextField.getText(),
                                categoriaProductoTextField.getText(),
                                pago.getValue()
                        );
                        Entregado.agregarEntregado(entregado);

                        mostrarAlertaInformation("Exito","Venta confirmada", totalPagar);
                        limpiarCampos();
                    }
                    return;
                }
            }
            mostrarAlertaError("Producto no encontrado", "El producto no está en la lista de productos.");
        } else {
            mostrarAlertaError("Producto no encontrado", "El producto no está en la lista de apartados.");
        }
    }


    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        cerrarVentana();
    }

    private void autorellenarInformacion(Apartar apartado) {
        idProductoTextField.setText(String.valueOf(apartado.getId()));
        fechaCompraTextField.setText(apartado.getFecha());
        lugarEntregaTextField.setText(apartado.getUbicacion());
        montoAbonadoProducto.setText(String.valueOf(apartado.getMontoAbonado()));
        restanteProducto.setText(String.valueOf(apartado.getMontoRestante()));
        cantidadApartadaTextField.setText(String.valueOf(apartado.getCantidadDeProductos()));
        categoriaProductoTextField.setText(apartado.getCategoria());
    }

    private void mostrarAlertaInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        nombreProductoTextField.clear();
        fechaCompraTextField.clear();
        cantidadApartadaTextField.clear();
        lugarEntregaTextField.clear();
        idProductoTextField.clear();
        montoAbonadoProducto.clear();
        restanteProducto.clear();
        categoriaProductoTextField.clear();
        pago.getSelectionModel().clearSelection();
    }

    @FXML
    void initialize() {
        pago.getItems().addAll("Efectivo", "Tarjeta", "Transferencia");

        nombreProductoTextField.setOnKeyPressed(this::handleEnterKey);
        idProductoTextField.setOnKeyPressed(this::handleEnterKey);
        montoAbonadoProducto.setOnKeyPressed(this::handleEnterKey);
        restanteProducto.setOnKeyPressed(this::handleEnterKey);
        lugarEntregaTextField.setOnKeyPressed(this::handleEnterKey);
        fechaCompraTextField.setOnKeyPressed(this::handleEnterKey);
        cantidadApartadaTextField.setOnKeyPressed(this::handleEnterKey);
        categoriaProductoTextField.setOnKeyPressed(this::handleEnterKey);

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
                montoAbonadoProducto.requestFocus();
            } else if (event.getSource() == montoAbonadoProducto) {
                restanteProducto.requestFocus();
            } else if (event.getSource() == restanteProducto) {
                lugarEntregaTextField.requestFocus();
            } else if (event.getSource() == lugarEntregaTextField) {
                fechaCompraTextField.requestFocus();
            } else if (event.getSource() == fechaCompraTextField) {
                cantidadApartadaTextField.requestFocus();
            } else if (event.getSource() == cantidadApartadaTextField) {
                categoriaProductoTextField.requestFocus();
            } else if (event.getSource() == categoriaProductoTextField) {
                confirmarButton.requestFocus();
            } else if (event.getSource() == confirmarButton) {
                OnMouseClickedConfirmarButton(null);
            }
        }
    }

    private void cerrarVentana() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
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
                    escritor.write("Le atendio: 𝑴𝒂𝒈𝒂𝒍𝒍𝒚 𝑻𝒐𝒍𝒆𝒅𝒐 𝑶𝒓𝒐𝒛𝒄𝒐" + System.lineSeparator());
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
                    escritor.write("CANTIDAD: " + cantidadApartadaTextField.getText() + System.lineSeparator());
                    escritor.write("FECHA DE LA VENTA: " + fechaCompraTextField.getText() + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("LUGAR DE ENTREGA: " + lugarEntregaTextField.getText() + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("MONTO ABONADO: " + montoAbonadoProducto.getText() + System.lineSeparator());
                    escritor.write("MONTO RESTANTE: " + restanteProducto.getText() + System.lineSeparator());
                    escritor.write("METODO DE PAGO: " + pago.getValue() + System.lineSeparator());
                    escritor.write("MONTO TOTAL: $" + totalVenta + System.lineSeparator());
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

    private void mostrarAlertaExito(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
