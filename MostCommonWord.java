import java.util.*;
class MostCommonWord {
	
	public static String toLowerCase(String s)
	{
		String x="";
		
		for(int i=0;i<s.length();i++)
		{
			x+=Character.toLowerCase(s.charAt(i));
		}
		return x;
	}
    public static String mostCommonWord(String paragraph, String[] banned) {
        
    	HashMap<String,Integer> bMap = new HashMap<>();
        HashMap<String,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>(Arrays.asList('!',',','\'','\"',';','.','?',' '));
        
        for(String value:banned)
        {
            bMap.put(value,1);
        }
        
        String newParagraph[] = {""};
        
        /*for(int i=0;i<paragraph.length();i++)
        {
            if(!set.contains(paragraph.charAt(i)))
            {
                if(paragraph.charAt(i) == ' ')
                    newParagraph+=paragraph.charAt(i);
                else
                    newParagraph+=Character.toLowerCase(paragraph.charAt(i));
            }
        }*/
        
        int c=0;
        for(int i=0;i<paragraph.length();i++)
        {
            if(set.contains(paragraph.charAt(i)))
            {
                String temp = paragraph.substring(c,i);
                if(!(temp.isBlank() || temp.isEmpty()))
                {
                	temp = toLowerCase(temp);
                	map.put(temp, map.getOrDefault(temp,0)+1);
                }
                c=i+1;
            }
        }
        int max = 0;
        String result="";
        for(Map.Entry entry : map.entrySet())
        {
            if((int)entry.getValue()>max && !bMap.containsKey((String)entry.getKey()))
            {
                max = (int)entry.getValue();
                result = (String)entry.getKey();
            }
                
        }
        return result;
    }
    
    public static void main(String args[])
    {
    	Scanner sc=new Scanner(System.in);
    	
    	String p = "a, a, a, a, b,b,b,c, c";
    	String[] b = {"a"};
    	System.out.print(mostCommonWord(p,b));
    	sc.close();
    }
}