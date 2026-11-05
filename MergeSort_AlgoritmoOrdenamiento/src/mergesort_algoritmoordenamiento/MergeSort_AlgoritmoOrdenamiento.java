package mergesort_algoritmoordenamiento;

public class MergeSort_AlgoritmoOrdenamiento {

    public static void main(String[] args) {
        // Se inicia un arreglo
        int arr[] = {2, 6, 3, 1, 5, 4, 7};

        System.out.println("Array original:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Se ordena el arreglo
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nArray ordenado:");

        // Se muestra el arreglo ya ordenado
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Se divide el arreglo en dos partes
    public static void mergeSort(int arr[], int inicio, int fin) {
        if (inicio < fin) {

            int medio = (inicio + fin) / 2;

            // Se siguen dividiendo
            mergeSort(arr, inicio, medio);
            mergeSort(arr, medio + 1, fin);

            // Se juntan las partes en orden
            merge(arr, inicio, medio, fin);
        }
    }

    // Se compara y se acomodan los números de menor a mayor
    public static void merge(int arr[], int inicio, int medio, int fin) {
        int izquierda[] = new int[medio - inicio + 1];
        int derecha[] = new int[fin - medio];

        // Se copian los números en los arreglos temporales
        for (int i = 0; i < izquierda.length; i++) {
            izquierda[i] = arr[inicio + i];
        }

        for (int i = 0; i < derecha.length; i++) {
            derecha[i] = arr[medio + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = inicio;

        // Se comparan los números y colocamos el menor primero
        while (i < izquierda.length && j < derecha.length) {

            if (izquierda[i] <= derecha[j]) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;
            }

            k++;
        }

        // Se colocan los números que quedaron en la izquierda
        while (i < izquierda.length) {
            arr[k] = izquierda[i];
            i++;
            k++;
        }

        // Se colocan los números que quedaron en la derecha
        while (j < derecha.length) {
            arr[k] = derecha[j];
            j++;
            k++;
        }
    }
}