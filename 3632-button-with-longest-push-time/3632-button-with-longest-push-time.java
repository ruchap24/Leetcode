class Solution {
    public int buttonWithLongestTime(int[][] events) {
    int lT= events[0][1];
    int lB = events[0][0];
    
    for(int i = 1; i < events.length; i++){
        int duration = events[i][1] - events[i-1][1];
        
        if(duration > lT || (duration == lT && events[i][0] < lB)){
            lT = duration;
            lB = events[i][0];
        }
    }
    
    return lB;
    }
}