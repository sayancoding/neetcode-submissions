class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String el : tokens){
            if(el.equals("+") || el.equals("-") || 
            el.equals("*") || el.equals("/") ){
                int second = st.pop();
                int first = st.pop();
                
                if(el.equals("+"))
                st.push(first + second);

                else if(el.equals("-"))
                st.push(first - second);

                else if(el.equals("*"))
                st.push(first * second);

                else if(el.equals("/"))
                st.push(first / second);

            }
            else{
                st.push(Integer.parseInt(el));
            }
        }

        return st.pop();
    }
}
