class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
            int si=0;
            int total_gas=0;
            int curr_gas=0;

            for(int i=0;i<gas.length;i++){
                total_gas+=(gas[i]-cost[i]);
                curr_gas+=(gas[i]-cost[i]);

                if(curr_gas<0){
                    si=i+1;
                    curr_gas=0;
                }
            }
            if(total_gas<0){
                return -1;
            }
            return si;
    }
}