import java.util.*;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		
		String[] tokens = path.split("/");
		Stack<String> stk = new Stack<>();
		for(String t:tokens)
		{
			if(!stk.isEmpty() && t.equals(".."))
				stk.pop();
			else if(!Arrays.asList("",".","..").contains(t))
				stk.push(t);
		}
		
		StringBuilder str = new StringBuilder();
		for(String s:stk)
		{
			str.append("/").append(s);
		}
		
		return str.length()==0?"/":str.toString();
	}

	public static void main(String args[]) {
		String path = "/a/./b/../../c/";
		System.out.print(simplifyPath(path));
	}
}
