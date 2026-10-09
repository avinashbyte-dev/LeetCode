
class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int maxPrime = 0;

        for (int i = 0; i < n; i++) {
            int a = nums[i][i];
            int b = nums[i][n - 1 - i];

            if (isPrime(a)) {
                maxPrime = Math.max(maxPrime, a);
            }

            if (isPrime(b)) {
                maxPrime = Math.max(maxPrime, b);
            }
        }

        return maxPrime;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}