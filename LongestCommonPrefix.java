import java.util.*;
public class LongestCommonPrefix {

	static class Node {
		char c;
		int w;
		Node[] children;

		Node(char c) {
			this.c = c;
			this.w = 0;
			this.children = new Node[26];
		}
	}

	static Node root;

	public static void insert(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new Node(c);
			}
			curr.children[c - 'a'].w += 1;
			curr = curr.children[c - 'a'];
		}
	}

	public static String findLongestPrefix(int words) {
		Node curr = root;
		String result = "";
		boolean found = true;
		while (found) {
			found = false;
			for (int i = 0; i < 26; i++) {
				if (curr.children[i]!=null && curr.children[i].w == words) {
					result += curr.children[i].c;
					curr = curr.children[i];
					found = true;
					break;
				}
			}
		}

		return result;
	}

	static String longestCommonPrefix(String[] str) {
		root = new Node('\0');
		for (String value : str) {
			insert(value);
		}
		int words = str.length;
		return findLongestPrefix(words);
	}

	public static void main(String args[]) {
		/*Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int n = sc.nextInt();
			String[] str = new String[n];
			for(int j=0;j<n;j++)
			{
				str[i] = sc.next();
			}
			System.out.print(longestCommonPrefix(str));
		}*/
		
		System.out.print(longestCommonPrefix(new String[]{"flower","flow","flight"}));
		//sc.close();
	}
}
