import java.util.Scanner;

class PrintSpacePermuatation{

	public static void printSubsets(String ip, String op) {
		if (ip.length() == 0) {
			System.out.println(op);
			return;
		}

		String op1 = op;
		String op2 = op;

		op1 += "_"+ip.charAt(0);
		op2 += ip.charAt(0);
		ip = ip.substring(1);
		printSubsets(ip, op1);
		printSubsets(ip, op2);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String ip = sc.next();

		String op = ip.substring(0,1);

		printSubsets(ip.substring(1), op);
		
		sc.close();
	}
}
