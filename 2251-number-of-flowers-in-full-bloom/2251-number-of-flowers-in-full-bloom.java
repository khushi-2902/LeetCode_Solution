import java.util.*;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        
        int[] start = new int[n];
        int[] end = new int[n];
        
        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int[] res = new int[people.length];
        
        for (int i = 0; i < people.length; i++) {
            int bloom = upperBound(start, people[i]);
            int dead = lowerBound(end, people[i]);
            res[i] = bloom - dead;
        }
        
        return res;
    }
    
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}