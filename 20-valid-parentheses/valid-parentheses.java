class Solution {
    public boolean isValid(String str) {
        Stack<Character> st=new Stack<>();
        for(char ch:str.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            if(ch==')'){
                if(st.isEmpty() || st.peek()!='('){
                    return false;
                }
                st.pop();
            }
            if(ch=='}'){
                if(st.isEmpty() || st.peek()!='{'){
                    return false;
                }
                st.pop();
            }
            if(ch==']'){
                if(st.isEmpty() || st.peek()!='['){
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}