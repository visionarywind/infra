package com.wind.algothrim;

/**
 * Created by shanfeng on 2018/7/14.
 */
public class Sorts {
    public static int partition(int[] array, int start, int end) {
        int key = array[end];
        int index = start;
        for (int i=start; i!=end; i++) {
            if (array[i] <= key) {
                swap(array, i, index);
                index ++;
            }
        }

        array[end] = array[index];
        array[index] = key;

        return index;
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pos = partition(array, start, end);
            quickSort(array, start, pos-1);
            quickSort(array, pos+1, end);
        }
    }

    public static void heapSort(int[] array, int start, int size) {
        if (size > 1) {
            buildMaxHeap(array, start, size);

            for (int i=size; i!=start; i--) {
                swap(array, start, i);
                heapVerify(array, start, i-1, 0);
            }
        }

    }

    public static void buildMaxHeap(int[] array, int start, int size) {
        if (size > 1) {
            for (int i=size/2; i>=0; i--) {
                heapVerify(array, start, size, i);
            }
        }
    }

    public static void heapVerify(int[] array, int start, int size, int index) {
        int left = 2*index + 1;
        int right = 2*index + 2;
        int largest = index;
        if (left <= start + size && array[left] > array[largest]) {
            largest = left;
        }
        if (right <= start + size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(array, largest, index);
            heapVerify(array, start, size, largest);
        }
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
