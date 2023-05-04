package api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {
	
	
	static Properties prop;
	static File file;
	static FileInputStream fis;
		
	public static String readProperty(String fileName, String key) throws IOException{
		
		file=new File(System.getProperty("user.dir"+"src/test/java/api/resources/"+fileName));
		
		fis=new FileInputStream(file);
		prop.load(fis);
		
		String value=prop.get(key).toString();
		return value;
		

	}
	
	

}
