class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int sign = 1;
        int res = 0;
        int mem = 0;
        for(char c  : chars){
            if(Character.isDigit(c)){
                mem = 10 * mem + (c - '0');
            }
            else if(c == '+' || c =='-'){
                res += sign * mem;
                sign = Integer.parseInt(String.format("%s1",c));
                mem = 0;
                
            }
            else if(c=='('){
                stack.push(res);
                stack.push(sign);
                sign=1;
                res=0;
            }
            else if(c==')'){
                res += sign * mem;
                res *= stack.pop();
                res += stack.pop();
                mem = 0;
            }
        }
        res += sign * mem;
        return res; 
    }
}