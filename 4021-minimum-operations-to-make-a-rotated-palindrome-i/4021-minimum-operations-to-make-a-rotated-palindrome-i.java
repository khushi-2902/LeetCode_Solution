class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int min = Integer.MAX_VALUE;

        for (int k = 0; k < n; k++) {

            int count = k;  // k left rotations

            for (int i = 0; i < n / 2; i++) {

                // Characters at mirrored positions after rotation
                char ch1 = s.charAt((i + k) % n);
                char ch2 = s.charAt((n - 1 - i + k) % n);

                int diff = Math.abs(ch1 - ch2);

                count += Math.min(diff, 26 - diff);
            }

            min = Math.min(min, count);
        }

        return min;
    }
}