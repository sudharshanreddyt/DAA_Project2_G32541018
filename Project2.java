import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Project2 {

    public static int mergeSequenceAndCost(int listSizes[]) {
        long startTime = System.nanoTime();

        if (listSizes.length < 2) {
            return 0;
        }

        int totalCost = 0;
        ArrayList<String> mergeSequence = new ArrayList<>();

        // Priority Queue to store lists based on their sizes (smallest first).
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        // Add all input array elements (list sizes) to the minHeap.
        for (int i = 0; i < listSizes.length; i++) {
            minHeap.add(listSizes[i]);
        }

        int mergeCount = 1;
        while (mergeCount < listSizes.length) {

            // Extract two smallest list sizes.
            int list1 = minHeap.poll();
            int list2 = minHeap.poll();

            // Calculate the merge cost of the two smallest lists.
            int mergeCost = list1 + list2;

            // Record the merging order.
            mergeSequence.add("Merged " + list1 + " and " + list2);

            // Accumulate total merge cost.
            totalCost = totalCost + mergeCost;

            // Add the merged lists cost back into the minHeap.
            minHeap.add(mergeCost);
            mergeCount++;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Duration for n = " + listSizes.length + " is : " + duration);
        return totalCost;
    }

    public static void main(String args[]) {
        int testArr[] = { 100, 1000, 10000, 100000, 1000000 };
        for (int size : testArr) {
            int a[] = generateRandomListWithSize(size);
            int totalCost = mergeSequenceAndCost(a);
            System.out.println("Final total cost: " + totalCost);
        }
    }

    public static int[] generateRandomListWithSize(int n) {
        Random r = new Random();
        int list[] = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = r.nextInt(100) + 1;
        }
        return list;
    }
}
