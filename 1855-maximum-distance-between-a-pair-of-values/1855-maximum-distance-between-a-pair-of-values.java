class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int max = 0;

        for (int i = 0; i < nums1.length; i++) {

            int start = i;
            int end = nums2.length - 1;
            int ans = -1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (nums2[mid] >= nums1[i]) {
                    ans = mid;
                    start = mid + 1;  // try to go farther
                } else {
                    end = mid - 1;
                }
            }

            if (ans != -1) {
                max = Math.max(max, ans - i);
            }
        }

        return max;
    }
}