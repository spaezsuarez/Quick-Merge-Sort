package gui;

import java.util.ArrayList;
//Elementos Graficos
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
//Eventos
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;
//Controlador
import controllers.QuickSortController;


public class Menu extends JFrame implements ActionListener {

    
    private static final long serialVersionUID = 1L;
    
    private JTextField inputMaxSize;
    private JButton btnGraficar,btnLimpiar;
    private JLabel  txtMaxSize, txtTitle;
    private final int WIDTH, HEIGTH;

    private JPanel tablero;
    private Grafica graficador;

    private QuickSortController quickController;

    public Menu() {
        WIDTH = 1200;
        HEIGTH = 600;

        inputMaxSize = new JTextField();
        btnGraficar = new JButton("Graficar");
        btnLimpiar = new JButton("X");
        txtTitle = new JLabel("Dimensiones de la serie de arreglos");
        txtMaxSize = new JLabel("Cantidad Maxima de procesos: ");

        graficador = new Grafica("Merge y Quick Sort", "Proceso", "OE(N)");
        quickController = new QuickSortController();

    }

    public void initTemplate() {
        setLayout(null);
        setSize(new Dimension(WIDTH, HEIGTH));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        setVisible(true);

    }

    public void initComponents() {

        tablero = graficador.getGrafica();
        tablero.setSize(new Dimension(WIDTH, 400));
        tablero.setLocation(0, 0);
        getContentPane().add(tablero);

        txtTitle.setSize(new Dimension(300, 20));
        txtTitle.setFont(new Font("Arial", Font.BOLD, 15));
        txtTitle.setLocation(50, 450);
        add(txtTitle);
        

        txtMaxSize.setSize(new Dimension(300, 20));
        txtMaxSize.setLocation(30, 500);
        txtMaxSize.setFont(new Font("Arial", Font.BOLD, 15));
        add(txtMaxSize);

        inputMaxSize.setSize(new Dimension(50, 20));
        inputMaxSize.setLocation(250, 500);
        inputMaxSize.setHorizontalAlignment(JLabel.CENTER);
        add(inputMaxSize);

        btnGraficar.setSize(new Dimension(250, 50));
        btnGraficar.setFont(new Font("Arial", Font.BOLD, 20));
        btnGraficar.setLocation(475, 500);
        btnGraficar.addActionListener(this);
        add(btnGraficar);
        
        btnLimpiar.setSize(new Dimension(100,50));
        btnLimpiar.setLocation(800,500);
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 30));
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == btnGraficar) {
            
            ArrayList<Double> logx = new ArrayList<>();
            ArrayList<Double> logy = new ArrayList<>();

            int maxSize = 0;
            try {
                maxSize = Integer.parseInt(inputMaxSize.getText());

                for (int j = 1; j <= maxSize; j++) {
                    quickController.start(j);
                    logx.add(Double.parseDouble(String.valueOf(j)));
                    //logy.add(44 - (23 * j) + (13 * j* Math.log(j)));
                    logy.add((150*(Math.log(j)/Math.log(2))+1000));
                }
                graficador.crearGrafica("QuickSort", quickController.getRangeX(), quickController.getRangeY());
                graficador.agregarGrafica("Cota", logx, logy);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese Numeros", "Error", JOptionPane.ERROR_MESSAGE);
                inputMaxSize.setText("");
            }

        }else if(event.getSource() == btnLimpiar){
            graficador.resetSeries();
            quickController.resetRanges();
            tablero = graficador.getGrafica();
            repaint();
        }

    }

}
