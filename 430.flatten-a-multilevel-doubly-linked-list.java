/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)return head;
       Node j=head;
       LinkedList<Node> li=new LinkedList<>(); 
       while(j!=null){
           if(j.child!=null){
               if(j.next!=null){
               Node y=j.next;
               y.prev=null;
               j.next=null;
               li.addFirst(y);
               }
               Node t=j.child;
               j.child=null;
               j.next=t;
               t.prev=j;
           }
           if(j.next==null){
               break;
           }
           j=j.next;
       }
        
        while(li.size()>0){
            Node r=li.removeFirst();
            j.next=r;
            r.prev=j;
            j=flatten(r);
            while(j.next!=null){
               j=j.next;
            }
        }
        
        return head;
    }
    
   
}
// @lc code=end

