/*
 * LeetCode 2349 - Design a Number Container System (Medium)
 * Topic: Classes, objects, methods
 *
 * Design:
 *  - indexToNumber:   index  -> number currently stored there
 *  - numberToIndices: number -> sorted set of indices holding that number
 *                     (TreeSet, so the smallest index is first())
 * change(index, number): if the index already holds a number, remove the index from that
 * number's set first, then store the new number and add the index to its set.
 * find(number): smallest index, or -1 if none.
 *
 * Time: change O(log n), find O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 14_LC2349_DesignNumberContainerSystem_Medium.java
 */
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class NumberContainers {

    private final Map<Integer, Integer> indexToNumber = new HashMap<>();
    private final Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (oldNumber == number) {
                return;
            }
            TreeSet<Integer> oldSet = numberToIndices.get(oldNumber);
            oldSet.remove(index);
            if (oldSet.isEmpty()) {
                numberToIndices.remove(oldNumber);
            }
        }
        indexToNumber.put(index, number);
        numberToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> set = numberToIndices.get(number);
        return (set == null || set.isEmpty()) ? -1 : set.first();
    }

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10)); // -1
        nc.change(2, 10);
        nc.change(1, 10);
        nc.change(3, 10);
        nc.change(5, 10);
        System.out.println(nc.find(10)); // 1
        nc.change(1, 20);
        System.out.println(nc.find(10)); // 2
        System.out.println(nc.find(20)); // 1
    }
}
