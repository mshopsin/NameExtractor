import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
public class Debugger{
	public static void main(String args[]) throws IOException {
		String path = args[0];
		
		
		FileReader f = new FileReader(path);
		
		try {
		String out = readWithStringBuffer(f);
		System.out.println(out);
		} finally {
		f.close();
		}

	
	}
	
	static String readWithStringBuffer(Reader fr)
		throws IOException {
		
		BufferedReader br = new BufferedReader(fr);
		String line;
		StringBuffer result = new StringBuffer();
		while ((line = br.readLine()) != null) 
		{
			result.append(line);
		}
		
		return result.toString();
	}
}