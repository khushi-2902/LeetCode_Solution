class Solution {
    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int energy = 0;
        int initialEnergy = 0;

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

            // if current energy is not enough
            if (energy < minimum) {

                initialEnergy += (minimum - energy);
                energy = minimum;
            }

            // perform task
            energy -= actual;
        }

        return initialEnergy;
    }
}