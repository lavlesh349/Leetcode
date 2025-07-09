class Solution {
    public int possibleStringCount(String word) {
        int c=0;
        char temp=word.charAt(0);
        int count=1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)!=temp){
                c=c+count-1;
                count=1;
                temp=word.charAt(i);
            }
            else{
                count++;
            }
        }
        c=c+count-1;
        return c+1;
    }
}