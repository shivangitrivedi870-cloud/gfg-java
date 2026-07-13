class Solution {
    
  static boolean isValidAnswer(int arr[], int k, int maxPages) {
    int studentCount = 1;
    int pages = 0;

    for (int i = 0; i < arr.length; i++) {
        // Agar koi single book hi maxPages se badi hai, toh possible nahi hai
        if (arr[i] > maxPages) {
            return false;
        }

        if (pages + arr[i] <= maxPages) {
            pages = pages + arr[i];
        } else {
            studentCount++;
            if (studentCount > k) {
                return false;
            } else {
                pages = arr[i];
            }
        }
    }
    return true;
}
        
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            return -1;
        }

        int s = 0;
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            // CORRECTION: Overflow check karne ke liye
            if (Integer.MAX_VALUE - sum < arr[i]) {
                sum = Integer.MAX_VALUE;
            } else {
                sum += arr[i];
            }
            s = Math.max(s, arr[i]);
        }

        int e = sum;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (isValidAnswer(arr, k, mid)) {
                ans = mid;
                e = mid - 1; 
            } else {
                s = mid + 1; 
            }
        }
        return ans;
    }
}