import java.io.*;
import java.util.*;

public class Max_Stack {
  public static class MaxStack {
    Stack<Integer> st;
    HashMap<Integer,Integer> hm;
    HashMap<Integer,Integer> hb;
    
    PriorityQueue<Integer> pq;
    public MaxStack() {
        st=new Stack<>();
        pq=new PriorityQueue<>(Collections.reverseOrder());
        hm=new HashMap<>();
        hb=new HashMap<>();
    }

    public void push(int x) {
       st.push(x);
       pq.add(x);
       if(hm.containsKey(x)){
           hm.put(x,hm.get(x)+1);
           hb.put(x,hb.get(x)+1);
       }else{
           hm.put(x,1);
           hb.put(x,1);
       }
    }

    public int pop() {
        if(st.size()==0){
            return -1;
        }
        int val=st.pop();
        hb.put(val,hm.get(val)-1);
        if(hm.get(val)<hb.get(val)){
            pop();
        }
     return val;
    }

    public int top() {
         if(st.size()==0){
            return -1;
        }
        int val=st.peek();
        if(hm.get(val)<hb.get(val)){
            st.pop();
            hb.put(val,hb.get(val)-1);
            top();
        }
      return st.peek();
    }

    public int peekMax() {
        if(pq.size()==0){
         return -1;   
        }
      int val=pq.peek();
      if(hb.get(val)<hm.get(val)){
        pq.remove();
        return peekMax();
      }
      return val;
    }

    public int popMax() {
      if(pq.size()==0){
         return -1;   
        }
      int val=pq.remove();
      if(hb.get(val)<hm.get(val)){
          return popMax();
      }
      return val;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MaxStack maxst = new MaxStack();

    while (read.ready()) {
      String []inp = read.readLine().split(" ");

      switch (inp[0]) {
        case "pop":
          System.out.println(maxst.pop());
          break;
        case "top":
          System.out.println(maxst.top());
          break;
        case "popMax":
          System.out.println(maxst.popMax());
          break;
        case "peekMax":
          System.out.println(maxst.peekMax());
          break;
        case "push":
          maxst.push(Integer.parseInt(inp[1]));
          break;
      }

    }

  }
}
