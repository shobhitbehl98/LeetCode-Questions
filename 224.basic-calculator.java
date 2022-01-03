import java.util.Stack;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int sign = 1;
        int ans = 0;
        int curr=0;
        int i=0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                curr=s.charAt(i)-'0';
                while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
                     curr=(curr*10)+(s.charAt(i+1)-'0');
                     i++;
                }
                ans+=sign*curr;
                curr=0;
            }else if(s.charAt(i)=='+'){
                sign=1;
            }else if(s.charAt(i)=='-'){
                sign=-1;
            }else if(s.charAt(i)=='('){
                st.push(ans);
                st.push(sign);
                ans=0;
                sign=1;
            }else if(s.charAt(i)==')'){
                int psign=st.pop();
                int pval=st.pop();
                ans*=psign;
                ans+=pval;
            }
            i++;
        }
        return ans;
    }
}
// @lc code=end

