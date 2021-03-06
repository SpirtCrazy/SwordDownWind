package basePackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class readText {
	private static Vector<String> vc = new Vector<String>();
	public static Vector<String> read(String filepath){
		String encoding = "GBK";
		File file = new File(filepath);
		if(file.isFile() && file.exists()){
			try {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file),encoding);
				BufferedReader bufferedReader = new BufferedReader(isr);
				String lineText = null;
				try {
					while((lineText = bufferedReader.readLine()) != null){
						vc.add(lineText);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vc;
	}
}
