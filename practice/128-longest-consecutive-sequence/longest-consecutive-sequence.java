class Solution {
    public int longestConsecutive(int[] arr) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],true);
            if(map.containsKey(arr[i]+1)){
                map.put(arr[i]+1,false);
            }
            if(map.containsKey(arr[i]-1)){
                map.put(arr[i],false);
            }
        }
        int max_count=0;
        for(int key:map.keySet()){
            if(!map.get(key))continue;
             int count=0;
             int i=key;
             while(map.containsKey(i)){
                 count++;
                 i++;
             }
             max_count=Math.max(max_count,count);
        }
        return max_count;
    }
}