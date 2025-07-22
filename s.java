class Solution {
    /**
     * Calculates the maximum profit from buying and selling stock multiple times.
     * LeetCode 122: Best Time to Buy and Sell Stock II
     *
     * @param prices Array of stock prices on consecutive days.
     * @return The maximum achievable profit.
     */
    public int maxProfit(int[] prices) {
        // If we have less than 2 days, we can't make a transaction.
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0; // Initialize total profit

        // Loop starting from the second day (index 1)
        for (int i = 1; i < prices.length; i++) {
            // Check if the price increased from the previous day to the current day
            if (prices[i] > prices[i - 1]) {
                // If yes, add the profit from this single-day increase
                // (This simulates buying yesterday and selling today)
                maxProfit += prices[i] - prices[i - 1];
            }
            // If prices[i] <= prices[i-1], do nothing (no profit opportunity here)
        }

        // Return the total accumulated profit
        return maxProfit;
    }
}

//
import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;
    private boolean hasPeeked;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.hasPeeked = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            if (iterator.hasNext()) {
                nextElement = iterator.next();
                hasPeeked = true;
            } else {
                return null;
            }
        }
        return nextElement;
    }

    @Override
    public Integer next() {
        if (!hasPeeked) {
            return iterator.next();
        }
        Integer result = nextElement;
        hasPeeked = false;
        nextElement = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}