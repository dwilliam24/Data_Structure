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

    public static void mergeSort(int[] list, int from, int to) {
        int[] temp = new int[list.length];

        if (to == from)
            return;

        int middle = (from + to) / 2;
        mergeSort(list, from, middle);
        mergeSort(list, middle + 1, to);

        int i = from;
        int j = middle + 1;
        int k = from;

        while (i <= middle && j <= to) {
            if (list[i] < list[j])
                temp[k++] = list[i++];
            else
                temp[k++] = list[j++];
        }
        while (i <= middle)
            temp[k++] = list[i++];

        while (j <= to)
            temp[k++] = list[j++];

        for (k = from; k < to + 1; k++)
            list[k] = temp[k];
    }

    public static void quickSort(int[] list, int from, int to) {
        if (from >= to)
            return;

        int p = (from + to) / 2;
        int i = from;
        int j = to;

        while (i <= j) {
            if (list[i] <= list[p]) i++;
            else if (list[j] >= list[p]) j--;
            else {

                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;

                i++;
                j--;
            }
        }
        if (p < j) {
            int temp = list[j];
            list[j] = list[p];
            list[p] = temp;
            p = j;
        } else if (p > i) {
            int temp = list[i];
            list[i] = list[p];
            list[p] = temp;

            p = i;
        }
        quickSort(list, from, p - 1);
        quickSort(list, p + 1, to);
    }

    public static void heapSort(int[] list) {
        DS7_MinHeap<Integer> heap = new DS7_MinHeap<>();
        for (int j : list) {
            heap.insert(j);
        }

        for (int i = 0; i < list.length; i++)
            list[i] = heap.remove();
    }
}
