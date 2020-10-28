package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;
import javax.swing.*;

public class Grafica {

    private JFreeChart graficadorLineaRecta,graficadorPuntos;
    private XYSeriesCollection datos;
    
   
    public Grafica(String titulo,String labelX,String labelY){
        
        this.datos = new XYSeriesCollection();
        this.graficadorLineaRecta = ChartFactory.createXYLineChart(titulo,labelX,labelY,datos,PlotOrientation.VERTICAL,true,false,false);
        this.graficadorPuntos = ChartFactory.createScatterPlot(titulo, labelY, labelY, datos);
    }

    public void agregarGrafica(String id,ArrayList<Double> x, ArrayList<Double> y){
        XYSeries a = new XYSeries(id);
        for(int i = 0; i < x.size(); i++){
            a.add(x.get(i),y.get(i));
        }
        this.datos.addSeries(a);
    }

    public void crearGrafica(String id,ArrayList<Double> x, ArrayList<Double> y){
        datos.removeAllSeries();
        agregarGrafica(id,x,y);
    }

    public JPanel getGrafica(){
        
        return new ChartPanel(this.graficadorPuntos);
    }
    
    public XYSeriesCollection getDatos(){
        return datos;
    }
    
    public void resetSeries(){
        this.datos.removeAllSeries();
    }

}