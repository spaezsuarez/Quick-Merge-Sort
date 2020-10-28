package algorithms;

public class QuickSort {

    private static double contador = 0;

    public static double getContador() {
        return contador;
    }

    public static void setContador(int c) {
        contador = c;
    }


    public void sort(int i, int j, double a[]) {

        int tempi = i;
        int tempj = j;
        double x = a[(int) (i + j) / 2];

        contador += 6;

        do {
            while (a[i] < x) {
                contador += 3;
                i++;
            }
            while (x < a[j]) {
                contador += 3;
                j--;
            }
            if (i < j) {
                contador += 5;
                cambio(a, i, j);
                i = i + 1;
                j = j - 1;
            }

            contador += 5;

        } while (i < j);

        contador += 1;

        if (i == j) {
            if (x < a[i]) {
                contador += 4;
                j = j - 1;
            } else {
                contador += 2;
                i = i + 1;
            }

            contador += 2;
        }
        contador++;

        if (j - 1 == tempi) {
            contador += 2;
            if (a[tempi] > a[j]) {
                contador += 3;
                cambio(a, tempi, j);
            }
            contador += 3;
        } else {
            if (j > tempi) {
                contador += 1;
                sort(tempi, j, a);
            }
            contador += 1;
        }
        contador += 2;

        if (i + 1 == tempj) {
            contador += 2;
            if (a[i] > a[tempj]) {
                contador += 3;
                cambio(a, i, tempj);
            }

            contador += 3;
        } else {
            if (i < tempj) {
                contador += 1;
                sort(i, tempj, a);
            }
            contador += 1;
        }

        contador += 2;

    }// quicksort

    public void cambio(double a[], int i, int j) {

        double t;
        t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
