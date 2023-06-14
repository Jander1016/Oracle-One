package com.alura.jdbc.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.alura.jdbc.controller.CategoryController;
import com.alura.jdbc.controller.ProductController;
import com.alura.jdbc.model.Category;
import com.alura.jdbc.model.Product;

public class ControlDeStockFrame extends JFrame {

  private static final long serialVersionUID = 1L;

  private JLabel labelNombre, labelDescripcion, labelCantidad, labelCategoria;
  private JTextField textoNombre, textoDescripcion, textoCantidad;
  private JComboBox<Category> comboCategoria;
  private JButton botonGuardar, botonModificar, botonLimpiar, botonEliminar, botonReporte;
  private JTable table;
  private DefaultTableModel model;
  private ProductController productController;
  private CategoryController categoryController;

  public ControlDeStockFrame() {
    super("Products");

    this.categoryController = new CategoryController();
    this.productController = new ProductController();

    Container container = getContentPane();
    setLayout(null);

    configurarCamposDelFormulario(container);

    configurarTablaDeContenido(container);

    configurarAccionesDelFormulario();
  }

  private void configurarTablaDeContenido(Container container) {
    table = new JTable();

    model = (DefaultTableModel) table.getModel();
    model.addColumn("Identificador del Producto");
    model.addColumn("Nombre del Producto");
    model.addColumn("Descripción del Producto");
    model.addColumn("Cantidad");
    model.addColumn("Id Category");

    loadTable();

    table.setBounds(10, 205, 760, 280);

    botonEliminar = new JButton("Eliminar");
    botonModificar = new JButton("Modificar");
    botonReporte = new JButton("Ver Reporte");
    botonEliminar.setBounds(10, 500, 80, 20);
    botonModificar.setBounds(100, 500, 80, 20);
    botonReporte.setBounds(190, 500, 80, 20);

    container.add(table);
    container.add(botonEliminar);
    container.add(botonModificar);
    container.add(botonReporte);

    setSize(800, 600);
    setVisible(true);
    setLocationRelativeTo(null);
  }

  private void configurarCamposDelFormulario(Container container) {
    labelNombre = new JLabel("Nombre del Producto");
    labelDescripcion = new JLabel("Descripción del Producto");
    labelCantidad = new JLabel("Cantidad");
    labelCategoria = new JLabel("Categoría del Producto");

    labelNombre.setBounds(10, 10, 240, 15);
    labelDescripcion.setBounds(10, 50, 240, 15);
    labelCantidad.setBounds(10, 90, 240, 15);
    labelCategoria.setBounds(10, 130, 240, 15);

    labelNombre.setForeground(Color.BLACK);
    labelDescripcion.setForeground(Color.BLACK);
    labelCategoria.setForeground(Color.BLACK);

    textoNombre = new JTextField();
    textoDescripcion = new JTextField();
    textoCantidad = new JTextField();
    comboCategoria = new JComboBox<>();
    comboCategoria.addItem(new Category(0,"Selected Category"));

    // TODO
    var categories = this.categoryController.categoryList();
     categories.forEach(category -> comboCategoria.addItem(category));

    textoNombre.setBounds(10, 25, 265, 20);
    textoDescripcion.setBounds(10, 65, 265, 20);
    textoCantidad.setBounds(10, 105, 265, 20);
    comboCategoria.setBounds(10, 145, 265, 20);

    botonGuardar = new JButton("Guardar");
    botonLimpiar = new JButton("Limpiar");
    botonGuardar.setBounds(10, 175, 80, 20);
    botonLimpiar.setBounds(100, 175, 80, 20);

    container.add(labelNombre);
    container.add(labelDescripcion);
    container.add(labelCantidad);
    container.add(labelCategoria);
    container.add(textoNombre);
    container.add(textoDescripcion);
    container.add(textoCantidad);
    container.add(comboCategoria);
    container.add(botonGuardar);
    container.add(botonLimpiar);
  }

  private void configurarAccionesDelFormulario() {
    botonGuardar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        safeProduct();
        limpiarTabla();
        loadTable();
      }
    });

    botonLimpiar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cleanForm();
      }
    });

    botonEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteProduct();
        limpiarTabla();
        loadTable();
      }
    });

    botonModificar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        updateProductSelected();
        limpiarTabla();
        loadTable();
      }
    });

    botonReporte.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        abrirReporte();
      }
    });
  }

  private void abrirReporte() {
    new ReporteFrame(this);
  }

  private void limpiarTabla() {
    model.getDataVector().clear();
  }

  private boolean hasSelectedRow() {
    return table.getSelectedRowCount() == 0 || table.getSelectedColumnCount() == 0;
  }

  private void updateProductSelected() {
    if (hasSelectedRow()) {
      JOptionPane.showMessageDialog(this, "Por favor, selected item");
      return;
    }

    Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
            .ifPresentOrElse(fila -> {
              Integer id = Integer.valueOf ( model.getValueAt(table.getSelectedRow(), 0).toString());
              String name_product = (String) model.getValueAt(table.getSelectedRow(), 1);
              String description = (String) model.getValueAt(table.getSelectedRow(), 2);
              Integer quantity = Integer.valueOf (model.getValueAt(table.getSelectedRow(), 3).toString());
              Integer id_category = Integer.valueOf (model.getValueAt(table.getSelectedRow(), 4).toString());

              var rowUpdated = this.productController.updateProduct(name_product, description, quantity, id, id_category);

              JOptionPane.showMessageDialog(this, String.format("%d item updated successful!", rowUpdated));
            }, () -> JOptionPane.showMessageDialog(this, "Please, selected item"));
  }
  private void deleteProduct () {
    if (hasSelectedRow()) {
      JOptionPane.showMessageDialog(this, "Please, select item");
      return;
    }

    Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
            .ifPresentOrElse(fila -> {
              Integer id = Integer.valueOf ( model.getValueAt(table.getSelectedRow(), 0).toString());

              var rowsDelete = this.productController.deleteProductById(id);

              model.removeRow(table.getSelectedRow());

              JOptionPane.showMessageDialog(this, rowsDelete + " Item deleted successfully!");
            }, () -> JOptionPane.showMessageDialog(this, "Por favor, selected item"));

  }

  private void loadTable () {
    var products = this.productController.listingProduct();
    try {
      products.forEach(product -> model.addRow(new Object[]{
              product.getId(),
              product.getName_product(),
              product.getDescription(),
              product.getQuantity(),
              product.getCategory_id()
      }));
    } catch (Exception e) {
      throw e;
    }
  }

  private void safeProduct () {
    if (textoNombre.getText().isBlank() || textoDescripcion.getText().isBlank()) {
      JOptionPane.showMessageDialog(this, "Los campos Nombre y Descripción son requeridos.");
      return;
    }

    Integer quantityInt;

    try {
      quantityInt = Integer.parseInt(textoCantidad.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, String
              .format("El campo cantidad debe ser numérico dentro del rango %d y %d.", 0, Integer.MAX_VALUE));
      return;
    }

    var category = (Category) comboCategoria.getSelectedItem();

    var product = new Product(textoNombre.getText(),textoDescripcion.getText(),quantityInt, category.getId_category());



    this.productController.safeProduct(product, category.getId_category());

    JOptionPane.showMessageDialog(this, "Register successful!");

    this.cleanForm();
  }

  private void cleanForm() {
    this.textoNombre.setText("");
    this.textoDescripcion.setText("");
    this.textoCantidad.setText("");
    this.comboCategoria.setSelectedIndex(0);
  }

}
