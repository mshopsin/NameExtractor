//Simply call
//java Debugger sample.txt NameExtractor


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.lang.reflect.*;
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

		//Call Extractor

		System.out.println("Methods");
		 try {
            Class c = Class.forName(args[1]);
            
     		Extractor ne = (Extractor)c.newInstance();
            
            Method m[] = c.getDeclaredMethods();
             Object arglist[] = new Object[0];
            for (int i = 0; i < m.length; i++)
            {
            	System.out.println(m[i].toString());
            	if(m[i].getName().equals(new String("test")))
            	{
            		m[i].invoke(ne,null);
            	}
            }
            
            /*
             Debugger methobj = new Debugger();
             Object arglist[] = new Object[0];
             Class partypes[] = new Class[0];
		     Method meth = c.getMethod("init", partypes);
			 Object retobj = meth.invoke(methobj, arglist);
             Integer retval = (Integer)retobj;
             System.out.println(retval.intValue());*/
             
          
            
         }
         catch (Throwable e) {
            System.err.println(e);
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