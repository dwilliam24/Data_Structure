public class DS7_Sorts {
    public static void selectionSort(int[] list) {
        for (int a = 0; a < list.length; a++) {
            int minIndex = a;
            for (int b = a + 1; b < list.length; b++) {
                if (list[b] < list[minIndex])
                    minIndex = b;
            }

            int temp = list[minIndex];
            list[minIndex] = list[a];
            list[a] = temp;
        }

    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j = i;
            while (j > 0 && list[j - 1] > temp) {
                list[j] = list[j - 1];
                j = j - 1;
            }
            list[j] = temp;
        }
    }

    public static void mergeSort(int[] a, int b, int c) {

    }

    public static void quickSort(int[] a, int b, int c) {

    }

    public static void heapSort(int[] list) {
        DS7_MinHeap<Integer> heap = new DS7_MinHeap<>();
        int b = list.length;
        for (int j : list) {
            heap.insert(j);
        }

        for (int i = 0; i < b; i++)
            list[i] = heap.remove();
    }
}
