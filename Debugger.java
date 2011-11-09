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
	int Match = 0;
	int Missed = 0;
	int Wrong  = 0;

	public static void main(String args[]) throws IOException {
	
		if(args.length != 3)
		{
			System.out.println("Too few arguments");
			System.out.println("java Debugger [Input file] [Test Data Set] [Extractor]");
			System.out.println("java Debugger sample.txt GoldenData.csv NameExtractor");
			return;
		}
	
	
		String path = args[0];
		
		
		FileReader f = new FileReader(path);
		String out = new String("");
		
		try {
		out = readWithStringBuffer(f);
		
		} finally {
		f.close();
		}

		//Call Extractor

		
		 try {
            Class c = Class.forName(args[1]);
            
     		Extractor ne = (Extractor)c.newInstance();
            
            Method m[] = c.getDeclaredMethods();
            boolean initilized = false;
            boolean ran = false;
            
            // Object arglist[] = new Object[0];
			for(int j = 0; j < 2; j++)
			{
				for (int i = 0; i < m.length; i++)
				{
					
					
					if(m[i].getName().equals(new String("init")))
					{
						m[i].invoke(ne,null);
						initilized = true;
					}
					
					if(!ran && initilized && m[i].getName().equals(new String("run")))
					{
						 Object arglist[] = new Object[1];
							arglist[0] = new String(out);
	
						System.out.println(m[i].invoke(ne,arglist));
						
						ran = true;
					}
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