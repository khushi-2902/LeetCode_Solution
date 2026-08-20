// 

class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {

        // Find the light with the maximum green duration
        int maxLight = 0;

        for (int light : lights) {
            maxLight = Math.max(maxLight, light);
        }

        int maxPenalty = 0;

        // Calculate the waiting time for each car
        for (int time : arrivalTime) {
            int r = time % period;

            if (r >= maxLight) {
                maxPenalty = Math.max(maxPenalty, period - r);
            }
        }

        return maxPenalty;
    }
}