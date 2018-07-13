public class MainConsole {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		MainConsole m = new MainConsole();
		m.printXT(5);
		
	}
	
	public void printXT(int aNum) {
		Integer num[][] = new Integer[aNum][aNum];
		int count = 0;
		for(int i = 0; i < aNum; i++) {
			int tempRow = i;
			for(int j = 0; j < i; j++) {
				num[tempRow][j] = count++;
				tempRow--; j++;
			}
		}
		
		for(int a = 0; a < aNum; a++) {
			for(int b = 0; b < aNum; b++) {
				System.out.print(num[a][b] + " ");
			}
			System.out.println();
		}
	}	
}
