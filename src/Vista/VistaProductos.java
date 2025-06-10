/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ProductoControlador;
import Controlador.CategoriaControlador;
import Modelo.Producto;
import Modelo.Categoria;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author COMPHP
 */
public class VistaProductos extends javax.swing.JPanel {

    private final ProductoControlador productoControlador;
    private Integer id_productoSeleccionado = null;
    private final CategoriaControlador categoriaControlador;
    private Integer idCategoriaSeleccionada = null;

    /**
     * Creates new form VistaProductos
     */
    public VistaProductos() {
        initComponents();
        this.productoControlador = new ProductoControlador();
        this.categoriaControlador = new CategoriaControlador();
        cargarDatosTabla();
        cargarCategorias();
    }

    private void limpiar() {
        textnombre_producto.setText("");
        textprecio_costo.setText("");
        textprecio_venta.setText("");
        textexistencia.setText("");
        textBuscarProducto.setText("");
        id_productoSeleccionado = null;
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
    }

    public void cargarDatosTabla() {
        //Obtener todas las categorias del controlador
        List<Producto> productos = productoControlador.obtenerTodosProductos();
        if (productos != null) {
            // obtener el modelo existente de la tabla
            DefaultTableModel model = (DefaultTableModel) tablaProducto.getModel();
            model.setRowCount(0);
            //llenar las filas con los datos de categorias  
            for (Producto prod : productos) {
                Object[] row = {
                    prod.getId_producto(),
                    prod.getNombre_producto(),
                    prod.getPrecio_costo(),
                    prod.getPrecio_venta(),
                    prod.getExistencia(),
                    prod.getId_categoria()
                };
                model.addRow(row);
            }
        }
    }

    private void cargarCategorias() {
        try {
// Obtener las categorías desde el controlador
            List<Categoria> categorias
                    = categoriaControlador.obtenerTodasCategorias();
// Limpiar el combo box por si tiene datos
            comboCategoria.removeAllItems();
// Agregar cada categoría al combo box
            for (Categoria cat : categorias) {
                comboCategoria.addItem(cat.getNombre_categoria());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar las categorías: " + e.getMessage());
        }
    }

    private void eventoComboCategorias() {
        comboCategoria.addActionListener(e -> {
            // Obtener el índice seleccionado
            int indiceSeleccionado = comboCategoria.getSelectedIndex();

            if (indiceSeleccionado >= 0) { // Verificar que se haya seleccionado algo
                try {
                    // Obtener la lista de categorías desde el controlador o memoria
                    List<Categoria> categorias = categoriaControlador.obtenerTodasCategorias();

                    // Obtener el objeto de categoría correspondiente al índice seleccionado
                    Categoria categoriaSeleccionada = categorias.get(indiceSeleccionado);

                    // Actualizar la variable global con el ID de la categoría seleccionada
                    idCategoriaSeleccionada = categoriaSeleccionada.getId_categoria();

                    // Mostrar el ID seleccionado en la consola (puedes quitar esta línea)
                    System.out.println("ID de la categoría seleccionada: " + idCategoriaSeleccionada);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al seleccionar categoría: " + ex.getMessage());
                }
            }
        });
    }

    private void seleccionarCategoriaEnCombo(Integer idCategoria) {
        try {
            // Obtener las categorías desde el controlador
            List<Categoria> categorias = categoriaControlador.obtenerTodasCategorias();

            // Recorrer las categorías y buscar la que coincida con el ID
            for (int i = 0; i < categorias.size(); i++) {
                Categoria categoria = categorias.get(i);
                if (categoria.getId_categoria() == idCategoria) {
                    comboCategoria.setSelectedIndex(i);
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al seleccionar categoría: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jlabel1 = new javax.swing.JLabel();
        textnombre_producto = new javax.swing.JTextField();
        jlabel2 = new javax.swing.JLabel();
        textprecio_costo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textprecio_venta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textexistencia = new javax.swing.JTextField();
        textBuscarProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(102, 102, 102));
        setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jlabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jlabel1.setForeground(new java.awt.Color(255, 255, 255));
        jlabel1.setText("Nombre");

        textnombre_producto.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        textnombre_producto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textnombre_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textnombre_productoActionPerformed(evt);
            }
        });

        jlabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jlabel2.setForeground(new java.awt.Color(255, 255, 255));
        jlabel2.setText("Precio_costo");

        textprecio_costo.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        textprecio_costo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textprecio_costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textprecio_costoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio_venta");

        textprecio_venta.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        textprecio_venta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textprecio_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textprecio_ventaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Existencia");

        textexistencia.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        textexistencia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textexistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textexistenciaActionPerformed(evt);
            }
        });

        textBuscarProducto.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        textBuscarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarProductoActionPerformed(evt);
            }
        });
        textBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBuscarProductoKeyTyped(evt);
            }
        });

        tablaProducto.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Precio costo", "Precio venta", "Existencia", "Categorias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseCliked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProducto);

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Categoria");

        comboCategoria.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventoComboCategoria(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar (2).png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/actualizar (1).png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/borrar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionbtnEliminar(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/escoba (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccionbtnLimpiarProducto(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logo pequeño.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Guardar");

        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Actualizar");

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Eliminar");

        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Limpiar");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/salvar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionbtnGuardar(evt);
            }
        });

        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/reporte (1)_1.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Reportes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel8)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlabel2)
                                    .addComponent(jlabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textprecio_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textnombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel5)
                            .addComponent(textBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textprecio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textexistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textnombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(textprecio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textprecio_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textexistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textnombre_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textnombre_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textnombre_productoActionPerformed

    private void textprecio_costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textprecio_costoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textprecio_costoActionPerformed

    private void textprecio_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textprecio_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textprecio_ventaActionPerformed

    private void textexistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textexistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textexistenciaActionPerformed

    private void accionbtnGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionbtnGuardar
        String nombre_producto = textnombre_producto.getText();
        String precio_costoStr = textprecio_costo.getText();
        String precio_ventaStr = textprecio_venta.getText();
        String existenciaStr = textexistencia.getText();
        int id_categoria = idCategoriaSeleccionada;

        if (!nombre_producto.isEmpty() && !precio_costoStr.isEmpty() && !precio_ventaStr.isEmpty() && !existenciaStr.isEmpty()) {

            float precio_costo = Float.parseFloat(precio_costoStr.trim().replace(",", "."));
            float precio_venta = Float.parseFloat(precio_ventaStr.trim().replace(",", "."));
            int existencia = Integer.parseInt(existenciaStr.trim());
            try {

                productoControlador.crearProducto(
                        nombre_producto,
                        precio_costo,
                        precio_venta,
                        existencia,
                        id_categoria);
                limpiar();
                cargarDatosTabla();
                cargarCategorias();

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Error en los datos: " + e.getMessage(),
                        "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor, llene todos los campos obligatorios correctamente.",
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_accionbtnGuardar

    private void accionbtnEliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionbtnEliminar
        int filaSeleccionada = tablaProducto.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idProducto = (int) tablaProducto.getValueAt(filaSeleccionada, 0);
            productoControlador.eliminarProducto(idProducto);
            cargarDatosTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Selecciona una fila para eliminar.",
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_accionbtnEliminar

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // Obtenemos los valores de los campos de texto
        String nombre_producto = textnombre_producto.getText();
        float precio_costo = Float.parseFloat(textprecio_costo.getText());
        float precio_venta = Float.parseFloat(textprecio_venta.getText());
        int existencia = Integer.parseInt(textexistencia.getText());
        int id_categoria = idCategoriaSeleccionada;

// Verificamos que todos los campos estén llenos y el id del producto esté seleccionado
        if (id_productoSeleccionado != null
                && !nombre_producto.isEmpty()
                && id_categoria >= 0) {

            try {
                // Llamamos al controlador para actualizar el producto
                productoControlador.actualizarProducto(id_productoSeleccionado,
                        nombre_producto, precio_costo, precio_venta, existencia, id_categoria);

                cargarDatosTabla(); // Vuelve a cargar los datos en la tabla después de actualizar
                limpiar(); // Limpia los campos
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Error en los datos: " + e.getMessage(),
                        "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor, llene todos los campos obligatorios.",
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tablaProductosMouseCliked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseCliked
        if (evt.getClickCount() == 2) {
            int filaSelecionada = tablaProducto.getSelectedRow();

            if (filaSelecionada != -1) {
                id_productoSeleccionado = (Integer) tablaProducto.getValueAt(filaSelecionada, 0);
                String nombre_producto = (String) tablaProducto.getValueAt(filaSelecionada, 1);
                Float precio_costo = (Float) tablaProducto.getValueAt(filaSelecionada, 2);
                Float precio_venta = (Float) tablaProducto.getValueAt(filaSelecionada, 3);
                Integer existencia = (Integer) tablaProducto.getValueAt(filaSelecionada, 4);
                Integer id_categoria = (Integer) tablaProducto.getValueAt(filaSelecionada, 5);

                textnombre_producto.setText(nombre_producto);
                textprecio_costo.setText(String.valueOf(precio_costo));
                textprecio_venta.setText(String.valueOf(precio_venta));
                textexistencia.setText(String.valueOf(existencia));

                // Seleccionar la categoría correspondiente en el combo
                seleccionarCategoriaEnCombo(id_categoria);
                idCategoriaSeleccionada = id_categoria;

                btnEliminar.setEnabled(false);
                btnGuardar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tablaProductosMouseCliked

    private void textBuscarProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarProductoKeyTyped
        String textoBusqueda = textBuscarProducto.getText().trim().toLowerCase();
        List<Producto> productos = productoControlador.obtenerTodosProductos();

        DefaultTableModel modelo = (DefaultTableModel) tablaProducto.getModel();
        modelo.setRowCount(0);
        if (productos != null) {
            for (Producto prod : productos) {
                try {
                    String nombre_producto = prod.getNombre_producto().toLowerCase();
                    String precio_costo = String.valueOf(prod.getPrecio_costo()).toLowerCase();
                    String precio_venta = String.valueOf(prod.getPrecio_venta()).toLowerCase();
                    String existencia = String.valueOf(prod.getExistencia()).toLowerCase();

                    if (textoBusqueda.isEmpty()
                            || nombre_producto.contains(textoBusqueda)
                            || precio_costo.contains(textoBusqueda)
                            || precio_venta.contains(textoBusqueda)
                            || existencia.contains(textoBusqueda)) {

                        Object[] fila = {
                            prod.getId_producto(),
                            prod.getNombre_producto(),
                            prod.getPrecio_costo(),
                            prod.getPrecio_venta(),
                            prod.getExistencia()
                        };
                        modelo.addRow(fila);
                    }
                } catch (NullPointerException e) {
                    System.out.println("Error al procesar el producto: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_textBuscarProductoKeyTyped

    private void textBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarProductoActionPerformed

    private void AccionbtnLimpiarProducto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccionbtnLimpiarProducto
        // TODO add your handling code here:
        textnombre_producto.setText("");
        textprecio_costo.setText("");
        textprecio_venta.setText("");
        textexistencia.setText("");
        textBuscarProducto.setText("");
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_AccionbtnLimpiarProducto

    private void eventoComboCategoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventoComboCategoria
        // TODO add your handling code here:
        // TODO add your handling code here:
        comboCategoria.addActionListener(e -> {
            // Obtener el índice seleccionado
            int indiceSeleccionado = comboCategoria.getSelectedIndex();

            if (indiceSeleccionado >= 0) { // Verificar que se haya seleccionado algo
                try {
                    // Obtener la lista de categorías desde el controlador o memoria
                    List<Categoria> categorias = categoriaControlador.obtenerTodasCategorias();

                    // Obtener el objeto de categoría correspondiente al índice seleccionado
                    Categoria categoriaSeleccionada = categorias.get(indiceSeleccionado);

                    // Actualizar la variable global con el ID de la categoría seleccionada
                    idCategoriaSeleccionada = categoriaSeleccionada.getId_categoria();

                    // Mostrar el ID seleccionado en la consola (puedes quitar esta línea)
                    System.out.println("ID de la categoría seleccionada: " + idCategoriaSeleccionada);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al seleccionar categoría: " + ex.getMessage());
                }
            }
        });
    }//GEN-LAST:event_eventoComboCategoria

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField textBuscarProducto;
    private javax.swing.JTextField textexistencia;
    private javax.swing.JTextField textnombre_producto;
    private javax.swing.JTextField textprecio_costo;
    private javax.swing.JTextField textprecio_venta;
    // End of variables declaration//GEN-END:variables
}
