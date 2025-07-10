class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1=version1.split("\\.");
        String[] s2=version2.split("\\.");
        int i=0;
        while(i<s1.length && i<s2.length){
            int n1=Integer.valueOf(s1[i]);
            int n2=Integer.valueOf(s2[i]);
            if(n1!=n2){
                return n1>n2?1:-1;
            }
            i++;
        }
        while(i<s1.length){
            if(Integer.valueOf(s1[i])!=0){
                return 1;
            }
            i++;
        }
        while(i<s2.length){
            if(Integer.valueOf(s2[i])!=0){
                return -1;
            }
            i++;
        }
        return 0;
    }
}