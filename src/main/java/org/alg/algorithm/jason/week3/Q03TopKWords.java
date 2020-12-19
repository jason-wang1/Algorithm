package org.alg.algorithm.jason.week3;

import java.util.*;

public class Q03TopKWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> res = new Q03TopKWords().topKFrequent2(words, 3);
        System.out.println(res);
    }

    /**
     * 使用 Collections 的 sort 方法进行全排序，
     * 时间复杂度 O(NlogN)；
     * 除了哈希表以外，空间复杂度 O(N)
     */
    public List<String> topKFrequent1(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> res = new ArrayList<>(map.keySet());
        Collections.sort(res, (w1, w2) ->
                map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return res.subList(0, k);
    }


    /**
     * 使用堆排序
     * 时间复杂度 O(NlogK) + O(KlogK)
     * 除了哈希表以外，空间复杂度 O(2K)
     */
    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w2.compareTo(w1) : map.get(w1) - map.get(w2));

        for (String word : map.keySet()) {
            heap.add(word);
            if (heap.size() > k)
                heap.poll();
        }

        List<String> res = new ArrayList<>();
        while (!heap.isEmpty())
            res.add(heap.poll());
        Collections.reverse(res);
        return res;
    }
}
