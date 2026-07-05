class Solution {

    int getLowerBound(int[] arr, int target) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ans = n;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    int getUpperBound(int[] arr, int target) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ans = n;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    int countFreq(int[] arr, int target) {

        int lbIndex = getLowerBound(arr, target);
        int ubIndex = getUpperBound(arr, target);

        int ans = ubIndex - lbIndex;

        return ans;
    }
}