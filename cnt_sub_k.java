import java.util.*;

public class Main {

	public static int solution(String s, int k){
		// write your code here
		HashMap<Character,Integer> chota=new HashMap<>();
		HashMap<Character,Integer> bada=new HashMap<>();
		int c=0;
		int b=0;
		int r=0;
		int ans=0;
		while(b<s.length()){
		    while(bada.size()<=k){
		        if(bada.size()==k&&!bada.containsKey(s.charAt(b))){
		            b--;
		            break;
		        }
		       bada.put(s.charAt(b),bada.getOrDefault(s.charAt(b),0)+1);
		       b++;
		    }
		    while(chota.size()<=k-1){
		        if(chota.size()==k-1&&!chota.containsKey(s.charAt(c))){
		            c--;
		            break;
		        }
		       chota.put(s.charAt(c),bada.getOrDefault(s.charAt(c),0)+1);
		       c++;
		    }
		    while(true){
		        
		         ans+=b-c;
 		        bada.put(s.charAt(r),bada.get(s.charAt(r))-1);
		        if(bada.get(s.charAt(r))==0){
		            bada.remove(s.charAt(r));
		        }
		        if(bada.size()<k)break;
		        
    
    		    chota.put(s.charAt(r),chota.get(s.charAt(r))-1);
		        if(chota.get(s.charAt(r))==0){
		            chota.remove(s.charAt(r));
		        }
		        if(chota.size()<k-1)break;
		        
		        r++;
		    }
		}
		

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
