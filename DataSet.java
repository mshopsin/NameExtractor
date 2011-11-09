import java.io.*;
import java.util.*;
	class DataSet{
	
		int Match = 0;
		int Missed = 0;
		int Wrong  = 0;
	
		List<String> Names = new ArrayList();
		List<String> Status = new ArrayList();
		public DataSet()
		{}
	
		public DataSet(String fileName)  throws IOException 
		{
		
			File file = new File(fileName);
 
			BufferedReader bufRdr  = new BufferedReader(new FileReader(file));
			String line = null;
			
			int col = 0;
		 
			//read each line of text file
			while((line = bufRdr.readLine()) != null)
			{	
			StringTokenizer st = new StringTokenizer(line,",");
			while (st.hasMoreTokens())
			{
				//get next token and store it in the array
				if(col == 1){
					Names.add(st.nextToken());
				}
				else{
					Status.add(st.nextToken());
				}
				col++;
			}
			col = 0;
			
			}
			
		}
		}