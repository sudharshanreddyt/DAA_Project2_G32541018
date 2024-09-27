# Project 2 
# Sudharshan Reddy Thammaiahgari (G32541018)

# 8.Merging Sorted Lists
You are given an array a[] of numbers, where a[i] is the size of the i-th list to merge.  You have to produce the sequence in which to merge the lists, and the total cost of merging all the lists.  Implementation Notes: Use a heap data structure.  (You don’t have to implement your own heal structure, you can simply use the inbuilt one in Java/C#.)

# Theoretical Analysis 
The problem can indeed be solved using a greedy approach in combination with a min-heap (also known as a priority queue). The key idea is to always merge the two smallest lists first, as merging smaller lists incurs the least cost. This approach ensures that the overall cost of merging all the lists is minimized.

Merging two lists with sizes m and n takes O(m+n) time. In a min-heap, both adding an element and removing an element take O(logn) time, where n is the number of elements in the heap. We are actually adding an array of n elements into the heap (priority queue), where each element represents the size of an individual array. Thus, inserting n elements into the min-heap takes O(nlogn) time.

For each merge, you extract two smallest elements from the heap, which takes O(log n) for each extraction. After merging, you insert the resulting merged list back into the heap, which again takes O(log n) time. Since there are n-1 merges, the total time complexity for all merge operations is O((n-1) * log n) ≈ O(nlogn)

Thus, the overall time complexity is O(nlogn).
