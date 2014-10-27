/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that
 * they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {

    class Number {
        public int value;
        public int index;

        public Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    // Version 1: sort array, then two point from head and tail
    public int[] twoSum(int[] numbers, int target) {
        Number[] nums = new Number[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = new Number(numbers[i], i + 1);
        }

        Arrays.sort(nums, new Comparator<Number>() {
            @Override
            public int compare(Number n1, Number n2) {
                return n1.value - n2.value;
            }
        });

        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            int sum = nums[i].value + nums[j].value;
            if (sum == target) {
                return new int[] { Math.min(nums[i].index, nums[j].index),
                        Math.max(nums[i].index, nums[j].index) };
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[] { -1, -1 };
    }

    /*
    // Version 2: using hashmap
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> numbersMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbersMap.containsKey(numbers[i])) {
                numbersMap.get(numbers[i]).add(i+1);
            } else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(i+1);
                numbersMap.put(numbers[i], l);
            }
        }

        int[] result = new int[] { -1, -1 };

        for (int i = 0; i < numbers.length; i++) {
            int expect = target - numbers[i];
            if (expect == numbers[i]) {
                List<Integer> indexes = numbersMap.get(expect);
                if (indexes.size() >= 2) {
                    result[0] = indexes.get(0);
                    result[1] = indexes.get(1);
                }
            } else {
                if (numbersMap.containsKey(expect)) {
                    result[0] = i + 1;
                    result[1] = numbersMap.get(expect).get(0);
                }
            }
        }

        Arrays.sort(result);
        return result;
    }
    */
}
