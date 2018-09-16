// Server side component used to execute commands and returning result
// MainProtocol.java


import java.lang.*;
import java.io.*;
public class MainProtocol {
	String sa,sb;
//	String sb,sa;

	public String processInput(String args) {
		try {
		sb = new String();
		sa  = new String();
		Runtime rt=Runtime.getRuntime();
		Process p=rt.exec("cmd /c "+ args);
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((sb = br.readLine()) != null)
		{
		sa += sb ;
		//	sa +=";
		}

		p.waitFor();
		if(p.exitValue()==1){
			System.out.println("process failed");

		}
		else if(p.exitValue()==0){
			System.out.println("process complete");
			System.out.println("LOG:" +sa);
		}

		} catch(Exception e) {
		System.out.println("You have an error" + e.getMessage());
		}

		return sa ;
	}
}
