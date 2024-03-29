import java.util.*;

public class WordSearch {

	public static boolean valueBool = false;

	public static boolean dfs(char[][] board, String word, int i, int j, int index) {
		if (index == word.length()) {
			return true;
		}
		if(i==-1 || i==board.length || j==-1 || j==board[0].length || board[i][j]!=word.charAt(index))
		{
			return false;
		}

		char temp = board[i][j];
		board[i][j] = '*';
		boolean found = dfs(board,word,i+1,j,index+1) || 
						dfs(board,word,i-1,j,index+1) ||
						dfs(board,word,i,j+1,index+1)||
						dfs(board,word,i,j-1,index+1);
		board[i][j] = temp;
		return found;
	}

	public static boolean exist(char[][] board, String word, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0) && dfs(board,word,i,j,0)) {
					return true;
					}
				}
			}
		return false;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		char a[][] = new char[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.next().charAt(0);
			}
		}

		String s = sc.next();

		System.out.print(exist(a, s, m, n));
		sc.close();
	}

}
