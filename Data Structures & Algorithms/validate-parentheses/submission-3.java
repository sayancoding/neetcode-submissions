class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.size() > 0){
                    if((ch == ')' && st.peek() == '(') ||
                        (ch == '}' && st.peek() == '{') ||
                        (ch == ']' && st.peek() == '[')
                    ){ 
                        st.pop();
                    }
                    else{
                        st.push(ch);
                    }
                }
                else
                    st.push(ch);
            }
        }
        return st.size() == 0 ? true : false;
    }
}
