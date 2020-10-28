package controllers;

import algorithms.QuickSort;
import java.util.ArrayList;


public class QuickSortController {
    
    private ArrayList<Double> rangeX = new ArrayList<>(), rangeY = new ArrayList<>();
    private double[] numbers;
    private QuickSort quickSort;

    public QuickSortController() {
        quickSort = new QuickSort();
    }

    public ArrayList<Double> getRangeX() {
        return rangeX;
    }

    public ArrayList<Double> getRangeY() {
        return rangeY;
    }

    public void setNumRangeX(double x) {
        rangeX.add(x);
    }

    public void setNumRangeY(double y) {
        rangeY.add(y);
    }

    public void initNumbers(int n) {

        numbers = new double[50];

        for (int i = 0; i < 50; i++) {
            numbers[i] = Math.floor(Math.random() * (n - 0 + 1) + 0);;
        }
       

    }

    public void start(int n) {

        initNumbers(n);
        QuickSort.setContador(0);
        quickSort.sort(0,49,numbers);
        rangeX.add(Double.parseDouble(String.valueOf(n)));
        rangeY.add(QuickSort.getContador());

    }

    public void resetRanges() {
        rangeX.clear();
        rangeY.clear();
    }
}
