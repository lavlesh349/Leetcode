class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i=0;i<nums1.length;i++){
            nums1[i]=find(nums2,nums1[i]);
        }
        return nums1;
    }

    public int find(int[] nums2,int tar){
        int ans=0;
        boolean isfound=false;
        for(int i:nums2){
            if(i==tar)isfound=true;
            if(isfound && i>tar)return i;
        }
        return -1;
    }
}