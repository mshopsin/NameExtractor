//Simply call
//java Debugger sample.txt NameExtractor



import java.io.*;
import java.util.*;
import java.lang.reflect.*;
public class Debugger{

	


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
		
		String input = new String("");
		
		DataSet ds;
		
		try {
		input = readWithStringBuffer(f);
		
		ds = new DataSet(args[1]);
			
		
		
		
		} finally {
		f.close();
		}
		//in order to read the csv file from the Golden Data set additional formating is neccasary
		
		input = input.replace(",c"," ");
		input = input.replace(",w"," ");
	
		//Call Extractor

		
		 try {
            Class c = Class.forName(args[2]);
            
     		Extractor ne = (Extractor)c.newInstance();
            HashMap map;
            
            Method m[] = c.getDeclaredMethods();
            boolean initilized = false;
            boolean ran = false;
            
            // Object arglist[] = new Object[0];
			for(int j = 0; j < 2; j++)
			{
				for (int i = 0; i < m.length; i++)
				{
					System.out.println(m[i].getName());
					
					if(m[i].getName().equals(new String("init")))
					{
						m[i].invoke(ne,null);
						initilized = true;
					}
					
					if(initilized && m[i].getName().equals(new String("getOperations")))
					{
						System.out.println("test");
						List<Operation> operations = (List<Operation>)m[i].invoke(ne,null);
						//Start run
						
						List<String> output = new ArrayList();
						for(int k = 0; k < operations.size(); k++)
						{
							
							List<String> add = operations.get(k).execute(input);
							
							input = "";
							for(int l = 0; l < add.size(); l++)
							{
								input += add.get(l);
								if(!((l - 1) == add.size()))
								{
									input += "|";
								}
							}
							ds.checkData(add);
							/*
							if(i == operations.size()-1)
							{
								output=add;
							}*/
							
						}
						//end run
					
					}
					/*
					if(!ran && initilized && m[i].getName().equals(new String("run")))
					{
						 Object arglist[] = new Object[1];
							arglist[0] = new String(input);
	
						List<String> NameList = (List<String>)m[i].invoke(ne,arglist);
						System.out.println(NameList.size());
						ds.checkData(NameList);
						ran = true;
					}*/
					/*
					if(ran && initilized && m[i].getName().equals(new String("getNameList")))
					{
						
	
						(List<String>)m[i].invoke(ne,null));
						
						
					}*/
					
				}
			}
            
            
            
            
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