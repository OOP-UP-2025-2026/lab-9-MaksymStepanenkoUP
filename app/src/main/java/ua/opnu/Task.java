package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {

            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; ) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); ) {
            String s = list.get(i);
            if (s != null && s.length() == 4) {
                list.add(i, "****");
                i += 2;
            } else {
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return true;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int val = queue.remove();
            stack.push(val);
            queue.add(val);  // повертаємо в чергу
        }

        boolean palindrome = true;
        for (int i = 0; i < size; i++) {
            int original = queue.remove();
            int reversed = stack.pop();
            if (original != reversed) {
                palindrome = false;
            }
            queue.add(original);
        }
        return palindrome;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.size() <= 1) {
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num < 0) {
                stack.push(num);
            } else {
                queue.offer(num);
            }
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        int positiveCount = 0;
        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num >= 0) {
                positiveCount++;
            }
            queue.offer(num);
        }

        for (int i = 0; i < positiveCount; i++) {
            queue.offer(queue.poll());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int val = queue.remove();
            if (val % 2 == 0) {
                queue.add(val);
            } else {
                stack.push(val);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.removeLast());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> seen = new HashSet<>();
        for (String value : map.values()) {
            if (!seen.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                result.put(key, value);
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> reversed = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            reversed.put(entry.getValue(), entry.getKey());
        }
        return reversed;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (Integer value : map.values()) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        int minFreq = Integer.MAX_VALUE;
        int rareValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            if (count < minFreq || (count == minFreq && val < rareValue)) {
                minFreq = count;
                rareValue = val;
            }
        }

        return rareValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer num : list) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        for (Integer count : freq.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

}
