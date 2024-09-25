import java.util.*;

class MergeListInfo {
    // MergeList - stores the size of the list and the index of the list in the
    // array.
    int size;
    int index;

    MergeListInfo(int size, int index) {
        this.size = size;
        this.index = index;
    }
}

public class Project2 {

    public static int calculateMergeCost(int listSizes[]) {
        long startTime = System.nanoTime();

        if (listSizes.length < 2) {
            return 0;
        }

        int totalCost = 0;
        int mergeIndex = 0;
        int mergeSequence[] = new int[listSizes.length];

        // Priority Queue to store lists based on their sizes (smallest first).
        PriorityQueue<MergeListInfo> minHeap = new PriorityQueue<MergeListInfo>(new Comparator<MergeListInfo>() {
            public int compare(MergeListInfo l1, MergeListInfo l2) {
                return l1.size - l2.size;
            }
        });

        // Add all input array elements (sizes) to the minHeap.
        for (int i = 0; i < listSizes.length; i++) {
            minHeap.add(new MergeListInfo(listSizes[i], i));
        }

        int mergeCount = 1;
        while (mergeCount < listSizes.length) {

            // Extract two smallest lists.
            MergeListInfo list1 = minHeap.poll();
            MergeListInfo list2 = minHeap.poll();

            // Calculate the merge cost of the two smallest lists.
            int mergeCost = list1.size + list2.size;

            // Record the merging order.
            if (list1.index != -1) {
                mergeSequence[mergeIndex++] = list1.index;
            }
            if (list2.index != -1) {
                mergeSequence[mergeIndex++] = list2.index;
            }

            // Accumulate total merge cost.
            totalCost = totalCost + mergeCost;

            // Add the merged list back into the minHeap.
            MergeListInfo mergedList = new MergeListInfo(mergeCost, -1); // -1 to indicate this is a merged node.
            minHeap.add(mergedList);
            mergeCount++;
        }

        // Print the order of list merges.
        // System.out.println("Merge Order: ");
        // for (int i = 0; i < mergeIndex; i++) {
        // System.out.print(mergeSequence[i] + " ");
        // }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("\nDuration for n = " + listSizes.length + " is : " + duration);
        return totalCost;
    }

    public static void main(String args[]) {
        int testArr[] = { 10, 100, 1000, 10000, 100000, 1000000 };
        for (int size : testArr) {
            int a[] = generateRandomListWithSize(size);
            int totalCost = calculateMergeCost(a);
            System.out.println("\nFinal total cost: " + totalCost);
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
