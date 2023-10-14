/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lenguajespracticalexico.frontend;

import com.lenguajespractica.parser.ParserAnalizer;
import com.lenguajespracticalexico.analisiLexico.AnalizadorLexico;
import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespracticalexico.graphiz.ManejoGrafica;
import com.lenguajespracticalexico.manejoArchivos.ManejoArchivo;
import com.lenguajespracticalexico.reportes.ManejoReportes;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

/**
 * @author luis
 */
public class VentanaParser extends javax.swing.JFrame {

    private ManejoArchivo manejoArchivo;
    private String path;
    private ColorJtextPane colorJtextPane;
    private DefaultTableModel defaultTableModel;
    private AnalizadorLexico analizadorLexico;
    private Utiles utiles;
    private ManejoReportes manejoReportes;
    private ManejoGrafica manejoGrafica;
    private List<Token> auxiTokens;

    /**
     * Creates new form VentanaParser
     */
    public VentanaParser() {
        initComponents();
        this.colorJtextPane = new ColorJtextPane(textPaneEditor);
        this.colorJtextPane.colors();
        this.manejoArchivo = new ManejoArchivo();
        this.analizadorLexico = new AnalizadorLexico();
        this.manejoReportes = new ManejoReportes();
        this.manejoGrafica = new ManejoGrafica(this.manejoArchivo);
        this.path = "";
        setTitle("Parser Editor");
        setLocationRelativeTo(null);
        this.utiles = new Utiles();

        utiles.setIconMenuItem(menuItemNewFile, "/img/descarga.png");
        utiles.setIconMenuItem(menuItemOpenFile, "/img/open.png");
        utiles.setIconMenuItem(menuItemSave, "/img/save.png");
        utiles.setIconMenuItem(menuItemSaveAs, "/img/saveAs.jpg");
        utiles.setIconMenuItem(menuItemListTokens, "/img/report.png");
        utiles.setIconMenuItem(btnAnalizaTokens, "/img/run.png", 15);
        super.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/iconParser.png")));

        LineNumberTextPane lineNumberTextPane = new LineNumberTextPane(textPaneEditor);
        scrollPane.setRowHeaderView(lineNumberTextPane);
        LineNumberTextPane lineNumberTextPane2 = new LineNumberTextPane(textPaneErrores);
        scrollPaneErrores.setRowHeaderView(lineNumberTextPane2);
        this.btnBackEditor.setVisible(false);
        this.txtFilter.setVisible(false);
        this.labelFilter.setVisible(false);
        posicionPuntero();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelEditor = new javax.swing.JPanel();
        scrollPaneErrores = new javax.swing.JScrollPane();
        textPaneErrores = new javax.swing.JTextPane();
        labelRowColumn = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        textPaneEditor = new javax.swing.JTextPane();
        panelReport = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTokens = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnAnalizaTokens = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnBackEditor = new javax.swing.JButton();
        btnSintactico = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jPanel2 = new javax.swing.JPanel();
        txtFilter = new javax.swing.JTextField();
        labelFilter = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemOpenFile = new javax.swing.JMenuItem();
        menuItemNewFile = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        menuItemSaveAs = new javax.swing.JMenuItem();
        menuGraphiz = new javax.swing.JMenu();
        mentuItenIdentificadores = new javax.swing.JMenuItem();
        menuItemWordKeys = new javax.swing.JMenuItem();
        menuItemLogicos = new javax.swing.JMenuItem();
        mentuItemAsignacion = new javax.swing.JMenuItem();
        menuItemComparacion = new javax.swing.JMenuItem();
        menuItemEnteros = new javax.swing.JMenuItem();
        menuItemDecimal = new javax.swing.JMenuItem();
        menuItemAritméticos = new javax.swing.JMenuItem();
        mentuItemBooleanas = new javax.swing.JMenuItem();
        menuItemSignos = new javax.swing.JMenuItem();
        menuItemComentario = new javax.swing.JMenuItem();
        menuItemStrings = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        menuItemListTokens = new javax.swing.JMenuItem();
        menuInfo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setEnabled(false);

        scrollPaneErrores.setToolTipText("Errores");

        textPaneErrores.setEditable(false);
        textPaneErrores.setForeground(new java.awt.Color(255, 0, 51));
        scrollPaneErrores.setViewportView(textPaneErrores);

        labelRowColumn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRowColumn.setText("Fila-Columna");

        textPaneEditor.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        scrollPane.setViewportView(textPaneEditor);

        javax.swing.GroupLayout panelEditorLayout = new javax.swing.GroupLayout(panelEditor);
        panelEditor.setLayout(panelEditorLayout);
        panelEditorLayout.setHorizontalGroup(
            panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneErrores)
                    .addComponent(labelRowColumn, javax.swing.GroupLayout.DEFAULT_SIZE, 1289, Short.MAX_VALUE)
                    .addComponent(scrollPane))
                .addContainerGap())
        );
        panelEditorLayout.setVerticalGroup(
            panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorLayout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelRowColumn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", panelEditor);

        tableTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "Fila-columna", "Patrón", "Ver gráfica"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTokens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTokensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTokens);

        javax.swing.GroupLayout panelReportLayout = new javax.swing.GroupLayout(panelReport);
        panelReport.setLayout(panelReportLayout);
        panelReportLayout.setHorizontalGroup(
            panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1289, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelReportLayout.setVerticalGroup(
            panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", panelReport);

        jToolBar1.setRollover(true);

        btnAnalizaTokens.setText("Analizar tokens");
        btnAnalizaTokens.setFocusable(false);
        btnAnalizaTokens.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAnalizaTokens.setPreferredSize(new java.awt.Dimension(120, 37));
        btnAnalizaTokens.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnalizaTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizaTokensActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAnalizaTokens);
        jToolBar1.add(jSeparator1);

        btnBackEditor.setText("Regresar al editor");
        btnBackEditor.setFocusable(false);
        btnBackEditor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBackEditor.setPreferredSize(new java.awt.Dimension(121, 37));
        btnBackEditor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBackEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackEditorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBackEditor);

        btnSintactico.setText("Análisis sintáctico");
        btnSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSintacticoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSintactico);
        jToolBar1.add(jSeparator2);

        txtFilter.setToolTipText("Buscar token");
        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
        });

        labelFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFilter.setText("Buscar token por lexema");
        labelFilter.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelFilter.setAlignmentY(0.3F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(693, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFilter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        menuFile.setText("File");

        menuItemOpenFile.setText("Abrir archivo");
        menuItemOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenFileActionPerformed(evt);
            }
        });
        menuFile.add(menuItemOpenFile);

        menuItemNewFile.setText("Nuevo archivo");
        menuItemNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewFileActionPerformed(evt);
            }
        });
        menuFile.add(menuItemNewFile);

        menuItemSave.setText("Guardar cambios");
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        menuFile.add(menuItemSave);

        menuItemSaveAs.setText("Guardar como");
        menuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(menuItemSaveAs);

        jMenuBar1.add(menuFile);

        menuGraphiz.setText(" Generate graph");

        mentuItenIdentificadores.setText("Identificadores");
        mentuItenIdentificadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentuItenIdentificadoresActionPerformed(evt);
            }
        });
        menuGraphiz.add(mentuItenIdentificadores);

        menuItemWordKeys.setText("Palabras reservadas");
        menuItemWordKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemWordKeysActionPerformed(evt);
            }
        });
        menuGraphiz.add(menuItemWordKeys);

        menuItemLogicos.setText("Logicos");
        menuItemLogicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogicosActionPerformed(evt);
            }
        });
        menuGraphiz.add(menuItemLogicos);

        mentuItemAsignacion.setText("Asignación");
        mentuItemAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentuItemAsignacionActionPerformed(evt);
            }
        });
        menuGraphiz.add(mentuItemAsignacion);

        menuItemComparacion.setText("Comparación");
        menuItemComparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemComparacionActionPerformed(evt);
            }
        });
        menuGraphiz.add(menuItemComparacion);

        menuItemEnteros.setText("Enteros");
        menuItemEnteros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEnterosActionPerformed(evt);
            }
        });
        menuGraphiz.add(menuItemEnteros);

        menuItemDecimal.setText("Decimales");
        menuItemDecimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDecimalActionPerformed(evt);
            }
        });
        menuGraphiz.add(menuItemDecimal);

        menuItemAritméticos.setText("Aritméticos");
        menuItemAritméticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAritméticosActionPerformed(evt);
            }
        });
        menuGraphiz.add(menuItemAritméticos);

        mentuItemBooleanas.setText("Booleanas");
        mentuItemBooleanas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentuItemBooleanasActionPerformed(evt);
            }
        });
        menuGraphiz.add(mentuItemBooleanas);

        menuItemSignos.setText("Signos (agrupación, otros)");
        menuItemSignos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSignosActionPerformed(evt);
            }
        });
        menuGraphiz.add(menuItemSignos);

        menuItemComentario.setText("Comentarios");
        menuItemComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemComentarioActionPerformed(evt);
            }
        });
        menuGraphiz.add(menuItemComentario);

        menuItemStrings.setText("Cadenas");
        menuItemStrings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemStringsActionPerformed(evt);
            }
        });
        menuGraphiz.add(menuItemStrings);

        jMenuBar1.add(menuGraphiz);

        menuReport.setText("Token report");

        menuItemListTokens.setText("Lista de tokens");
        menuItemListTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListTokensActionPerformed(evt);
            }
        });
        menuReport.add(menuItemListTokens);

        jMenuBar1.add(menuReport);

        menuInfo.setText("About");

        jMenuItem1.setText("Información-app");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuInfo.add(jMenuItem1);

        jMenuBar1.add(menuInfo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mentuItenIdentificadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentuItenIdentificadoresActionPerformed
        auxiTokens = manejoReportes.getIdentificadores(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_mentuItenIdentificadoresActionPerformed

    private void menuItemListTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListTokensActionPerformed
        // TODO add your handling code here:
        auxiTokens = analizadorLexico.getTokens();
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_menuItemListTokensActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        String msg = """
                Nombre de la aplicación: PARSER-PY
                Autor: Luis Baquiax
                Curso: Lenguajes formales de programación
                Año: 2023
                """;
        JOptionPane.showMessageDialog(this, msg, "App-parser-py", JOptionPane.INFORMATION_MESSAGE, null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnBackEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackEditorActionPerformed
        // TODO add your handling code here:
        this.jTabbedPane1.setSelectedIndex(0);
        this.btnAnalizaTokens.setVisible(true);
        this.btnBackEditor.setVisible(false);
        this.txtFilter.setVisible(false);
        this.labelFilter.setVisible(false);
    }//GEN-LAST:event_btnBackEditorActionPerformed

    private void menuItemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenFileActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            this.path = this.manejoArchivo.pathChoserOpen();
            this.textPaneEditor.setText(manejoArchivo.leerArchivo(path));
        } catch (IOException ex) {
            System.out.println("No se pudo abrir el archivo" + ex.getMessage());
        }
    }//GEN-LAST:event_menuItemOpenFileActionPerformed

    private void menuItemNewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewFileActionPerformed
        String[] opciones = {"SI", "NO"};
        int op = JOptionPane.showInternalOptionDialog(null,
                "¿Deseas guardar los cambios?",
                "Guardar cambios",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, opciones,
                opciones[0]);
        if (op == 0) {
            try {
                guardar();
                JOptionPane.showMessageDialog(null, "Se guardó el archivo con éxito.");
            } catch (IOException ex) {
                Logger.getLogger(VentanaParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.path = "";
        this.textPaneEditor.setText("");

    }//GEN-LAST:event_menuItemNewFileActionPerformed

    private void menuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveAsActionPerformed
        try {
            // TODO add your handling code here:
            guardarComo();
            JOptionPane.showMessageDialog(null, "Se guardó el archivo con éxito.");
        } catch (IOException ex) {
            Logger.getLogger(VentanaParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemSaveAsActionPerformed

    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
        try {
            // TODO add your handling code here:
            guardar();
            JOptionPane.showMessageDialog(null, "Se guardó el archivo con éxito.");
        } catch (IOException ex) {
            Logger.getLogger(VentanaParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemSaveActionPerformed

    private void tableTokensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTokensMouseClicked
        // TODO add your handling code here
        int columna = this.tableTokens.getSelectedColumn();
        int fila = this.tableTokens.getSelectedRow();
        if (fila >= 0 && columna == 4) {
            this.manejoGrafica.dibujar(auxiTokens.get(fila));
            GraficaFrame g = new GraficaFrame(auxiTokens.get(fila), utiles);
            g.setVisible(true);
        }
    }//GEN-LAST:event_tableTokensMouseClicked

    private void btnAnalizaTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizaTokensActionPerformed
        // TODO add your handling code here:
        this.analizadorLexico.analizarTokens(textPaneEditor.getText());
        this.auxiTokens = this.analizadorLexico.getTokens();
        this.textPaneErrores.setText(infTokensErrores());
    }//GEN-LAST:event_btnAnalizaTokensActionPerformed

    private void menuItemLogicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogicosActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getLogicos(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_menuItemLogicosActionPerformed

    private void menuItemDecimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDecimalActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getDecimales(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);

    }//GEN-LAST:event_menuItemDecimalActionPerformed

    private void menuItemWordKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemWordKeysActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getWordKeys(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_menuItemWordKeysActionPerformed

    private void mentuItemAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentuItemAsignacionActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getTokensAsignacion(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_mentuItemAsignacionActionPerformed

    private void menuItemEnterosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEnterosActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getEnteros(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_menuItemEnterosActionPerformed

    private void menuItemAritméticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAritméticosActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getTokensAritmeticos(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_menuItemAritméticosActionPerformed

    private void mentuItemBooleanasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentuItemBooleanasActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getBooleanas(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_mentuItemBooleanasActionPerformed

    private void menuItemSignosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSignosActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getTokensSignos(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_menuItemSignosActionPerformed

    private void menuItemComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemComentarioActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getTokensComentario(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_menuItemComentarioActionPerformed

    private void menuItemStringsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemStringsActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getTokensCadena(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_menuItemStringsActionPerformed

    private void menuItemComparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemComparacionActionPerformed
        // TODO add your handling code here:
        auxiTokens = manejoReportes.getTokensComparacion(analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_menuItemComparacionActionPerformed

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        // TODO add your handling code here:
        auxiTokens = manejoReportes.reportFilters(txtFilter.getText(), analizadorLexico.getTokens());
        llenarTabla(auxiTokens);
    }//GEN-LAST:event_txtFilterKeyReleased

    private void btnSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSintacticoActionPerformed
        // TODO add your handling code here:
        ParserAnalizer parser = new ParserAnalizer(this.auxiTokens);
        String text = "";
        for (int i = 0; i < parser.getErrores().size(); i++) {
            text+="Eror sintáctico, fila "+parser.getErrores().get(i).getFila()
                    + " columna: "+parser.getErrores().get(i).getColumna()+"\n";
        }
        if(parser.getErrores().isEmpty()){
            JOptionPane.showMessageDialog(null, "Se ha hecho el análisis correctamente");
        }
        this.textPaneErrores.setText(text);
    }//GEN-LAST:event_btnSintacticoActionPerformed

    /**
     * Servirá para encontrar la posición del puntero y eventualemente
     * actualizar su posición fila-columna
     */
    private void posicionPuntero() {
        textPaneEditor.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                int fila = 1, columna = 0;
                int ultimalinea = -1;
                String text = textPaneEditor.getText().replaceAll("\r", "");
                //String text = textPaneEditor.getText();

                for (int i = 0; i < pos; i++) {
                    //char == 10 -> salto de linea o nueva linea
                    if (text.charAt(i) == 10) {
                        fila++;
                        ultimalinea = i;
                    }
                }

                columna = pos - ultimalinea;
                labelRowColumn.setText("Fila: " + fila + " Columna: " + columna);
            }
        });

    }

    private void guardar() throws IOException {
        if ("".equals(path)) {
            guardarComo();
        } else {
            this.manejoArchivo.escribirArchivodeTexto(path, textPaneEditor.getText());
        }

    }

    private void guardarComo() throws IOException {
        String ruta = this.manejoArchivo.pathChoserSave();
        this.manejoArchivo.escribirArchivodeTexto(ruta + ManejoArchivo.FILTRO, textPaneEditor.getText());
    }

    private void llenarTabla(List<Token> tokens) {
        this.jTabbedPane1.setSelectedIndex(1);
        this.btnAnalizaTokens.setVisible(false);
        this.btnBackEditor.setVisible(true);
        this.txtFilter.setVisible(true);
        this.labelFilter.setVisible(true);
        defaultTableModel = (DefaultTableModel) tableTokens.getModel();
        defaultTableModel.setRowCount(0);
        for (Token token : tokens) {
            String data[] = new String[]{token.getCategoria(), token.getLexema(), "[" + token.getFila() + " , " + token.getColumna() + "]", token.getPatron(), "Ver gráfica"};
            defaultTableModel.addRow(data);
        }
    }

    private String infTokensErrores() {
        String info = "";
        for (Token tokenErrore : analizadorLexico.getTokenErrores()) {
            info += "Error léxico: " + tokenErrore.getLexema() + "\tFila: " + tokenErrore.getFila() + "\tColumna: " + tokenErrore.getColumna() + "\n";
        }
        return info;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizaTokens;
    private javax.swing.JButton btnBackEditor;
    private javax.swing.JButton btnSintactico;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelFilter;
    private javax.swing.JLabel labelRowColumn;
    private javax.swing.JMenuItem mentuItemAsignacion;
    private javax.swing.JMenuItem mentuItemBooleanas;
    private javax.swing.JMenuItem mentuItenIdentificadores;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuGraphiz;
    private javax.swing.JMenu menuInfo;
    private javax.swing.JMenuItem menuItemAritméticos;
    private javax.swing.JMenuItem menuItemComentario;
    private javax.swing.JMenuItem menuItemComparacion;
    private javax.swing.JMenuItem menuItemDecimal;
    private javax.swing.JMenuItem menuItemEnteros;
    private javax.swing.JMenuItem menuItemListTokens;
    private javax.swing.JMenuItem menuItemLogicos;
    private javax.swing.JMenuItem menuItemNewFile;
    private javax.swing.JMenuItem menuItemOpenFile;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JMenuItem menuItemSaveAs;
    private javax.swing.JMenuItem menuItemSignos;
    private javax.swing.JMenuItem menuItemStrings;
    private javax.swing.JMenuItem menuItemWordKeys;
    private javax.swing.JMenu menuReport;
    private javax.swing.JPanel panelEditor;
    private javax.swing.JPanel panelReport;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPaneErrores;
    private javax.swing.JTable tableTokens;
    private javax.swing.JTextPane textPaneEditor;
    private javax.swing.JTextPane textPaneErrores;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
