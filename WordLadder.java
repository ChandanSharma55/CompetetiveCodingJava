import java.util.*;

public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		Set<String> set = new HashSet<>();
		for(String value:wordList)
		{
			set.add(value);
		}
		if(!set.contains(endWord))
		{
			return 0;
		}
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		int depth = 0;
		while(!q.isEmpty())
		{
			depth += 1;
			int qLength = q.size();
			while(qLength != 0)
			{
				String curr = q.remove();
				for(int i=0;i<curr.length();i++)
				{
					StringBuilder temp = new StringBuilder(curr);
					for(char c='a';c<='z';c++)
					{
						temp.setCharAt(i, c);
						if(temp.toString().equals(curr))
							continue;
						else if(temp.toString().equals(endWord))
							return depth+1;
						else if(set.contains(temp.toString()))
						{
							q.add(temp.toString());
							set.remove(temp.toString());
						}
					}
				}
				qLength--;
			}
		}
		return 0;
		
	}

	public static void main(String args[]) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		//wordList.add("hit");
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		/*String beginWord = "a";
		String endWord = "c";
		List<String> wordList = new ArrayList<>();
		wordList.add("a");
		wordList.add("b");
		wordList.add("c");
		*/
		System.out.print(ladderLength(beginWord,endWord,wordList));

	}
}
