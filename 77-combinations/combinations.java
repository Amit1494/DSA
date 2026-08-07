class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> currentCombination = new ArrayList<>();
    // Total numbers available (1 to n)
    private int totalNumbers;
    // Target combination size
    private int combinationSize;

    /**
     * Generate all combinations of k numbers from 1 to n
     * @param n - upper bound of numbers (1 to n)
     * @param k - size of each combination
     * @return List of all possible combinations
     */
    public List<List<Integer>> combine(int n, int k) {
        this.totalNumbers = n;
        this.combinationSize = k;
        backtrack(1);
        return result;
    }

    /**
     * @param currentNumber - current number being considered for inclusion
     */
    private void backtrack(int currentNumber) {
        if (currentCombination.size() == combinationSize) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
      
        if (currentNumber > totalNumbers) {
            return;
        }
      
        currentCombination.add(currentNumber);
        backtrack(currentNumber + 1);
      
        currentCombination.remove(currentCombination.size() - 1);
      
        backtrack(currentNumber + 1);
    }
}