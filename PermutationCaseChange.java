import java.util.*;
class PermutationCaseChange{

	static HashSet<String> h = new HashSet<>();
	public static void printSubsets(String ip, String op) {
		if (ip.length() == 0) {
			h.add(op);
			return;
		}

		String op1 = op;
		String op2 = op;

		char c = ip.charAt(0);
		op1 += Character.isDigit(c)?c:(Character.isLowerCase(c)?Character.toUpperCase(c):Character.toLowerCase(c));
		op2 += c;
		ip = ip.substring(1);
		printSubsets(ip, op1);
		printSubsets(ip, op2);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String ip = sc.next();
		String op = "";
		printSubsets(ip, op);
		
		for(String value:h)
		{
			System.out.println(value);
		}
		
		sc.close();
	}
}
