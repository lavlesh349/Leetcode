class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] ans=new int[arr.length];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<2*arr.length;i++) {
			int idx=i%arr.length;
			while(!st.isEmpty() && arr[st.peek()]<arr[idx]) {
				ans[st.pop()]=arr[idx];
			}
            if(i<arr.length)
			st.push(i);
			
		}
		while(!st.isEmpty()) {
			ans[st.pop()]=-1;
		}
		return ans;
    }
}