class Solution {
      
     public boolean isValidSolution(int[] arr, int k, int maxLength) {
    int painterCount = 1;
    int paintedLength = 0; // Naam sahi kiya
    
    for (int i = 0; i < arr.length; i++) {
        // Edge Case: Agar koi ek board hi maxLength se bada hai
        if (arr[i] > maxLength) {
            return false;
        }
        
        if (paintedLength + arr[i] <= maxLength) {
            paintedLength = paintedLength + arr[i];
        } else {
            painterCount++;
            if (painterCount > k) {
                return false;
            }
            // Naye painter ko current board allot kiya aur purana sum reset kiya
            paintedLength = arr[i]; 
        }
    }
    return true; 
}
    public int minTime(int[] arr, int k) {
        // code here
        int sum = 0;
        
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
            
        }
        int ans = -1; 
        int s = 0;
        int e = sum;
        
        while ( s <= e) {
            int mid = s + ( e-s ) / 2;
            
            if ( isValidSolution ( arr, k, mid)) {
                ans = mid;
                e = mid - 1;
            }
            else { 
                 s = mid + 1;
            
        }
    }
    
    return ans ;
    
  }
}
