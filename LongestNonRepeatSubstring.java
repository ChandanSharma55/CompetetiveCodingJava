import java.util.*;

public class LongestNonRepeatSubstring {

	public static int lengthOfLongestSubstring(String s) {

		int n = s.length();
        if(n==0)
            return 0;
        if(s.equals(" "))
            return 1;
        
        int size = 0, i=0,j=0;
        
        Hashtable<Character,Integer> map = new Hashtable<>();
        
        while(j<n)
        {
            if(map.containsKey(s.charAt(j)))
            {
                i = Math.max(map.get(s.charAt(j))+1 , i);
            }
            map.put(s.charAt(j),j);
            size = Math.max(size,j-i+1);    
            j++;
            
        }
        return size;
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.print(lengthOfLongestSubstring(s));
		sc.close();
	}
}
