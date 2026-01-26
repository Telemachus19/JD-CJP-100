package Lab02.ArrayExercises;

import java.util.HashSet;
import java.util.Set;

public class ArrayExercise {

    public static void main(String[] args) {
        int NumberOfElements = 1000;
        int[] arr = new int[NumberOfElements];
        int value;
        int target = 768, index = -1;
        Set<Integer> usedIntegers = new HashSet<>();
        int maximum, minimum;
        // Ensuring that each number is unique
        for (int i = 0; i < NumberOfElements; i++) {
            do {
                value = (int) (Math.random() * NumberOfElements);
            } while (usedIntegers.contains(value));
            usedIntegers.add(value);
            arr[i] = value;
        }
        // Finding Maximum & Minimum
        maximum = minimum = arr[0];
        for (int i = 1; i < NumberOfElements; i++) {
            maximum = Math.max(maximum, arr[i]);
            minimum = Math.min(minimum, arr[i]);
        }
        System.out.println("Maximum: " + maximum);
        System.out.println("Minimum: " + minimum);
        // Linear Search
        System.out.println("----Start of Linear Search----");
        long startTime = System.nanoTime();
        for (int i = 0; i < NumberOfElements; i++) {
            if (arr[i] == target) {
                index = i;
                System.out.println("target found at index: " + index);
            }
        }
        if (index == -1) {
            System.out.println("target not found");
        }
        long elapsedTime = System.nanoTime();
        System.out.println("Time Taken (Linear Search): " + (elapsedTime - startTime));
        System.out.println("----End of Linear Search----");

        // Merge Sort
        ArrayExerciseUtil.mergeSort(arr, 0, arr.length - 1);
        ArrayExerciseUtil.printArray(arr);

        System.out.println("----Start of Binary Search----");
        startTime = System.nanoTime();
        index = ArrayExerciseUtil.binarySearch(arr, 0, arr.length, target);
        elapsedTime = System.nanoTime();

        System.out.println("target found at index: " + index);
        System.out.println("Time Taken (Binary Search): " + (elapsedTime - startTime));

    }
}
