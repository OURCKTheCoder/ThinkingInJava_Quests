import java.io.*;

public class ScreenReader {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(
			new InputStreamReader(System.in));
		String str = stdin.readLine();
		System.out.println(str);
	}
}
