import java.io.*;
import java.util.*;
class DataSet{
	
		int Match = 0;
		int Missed = 0;
		int Wrong  = 0;
	
		List<String> Names = new ArrayList();
		List<String> Status = new ArrayList();
		HashMap ReferenceMap = new HashMap();
		List<String> Observed =  new ArrayList(); // removes repeats.
		public DataSet()
		{}
		
		public void reset()
		{
			Match = 0;
			Missed = 0;
			Wrong  = 0;
			Observed.clear();
		}
	
		public DataSet(String fileName)  throws IOException 
		{
			
				File file = new File(fileName);
	 
				BufferedReader bufRdr  = new BufferedReader(new FileReader(file));
				String line = null;
				
				int col = 0;
			 	int row = 0;
				//read each line of text file
				
				while((line = bufRdr.readLine()) != null)
				{	
					StringTokenizer st = new StringTokenizer(line,",");
					while (st.hasMoreTokens())
					{
						//get next token and store it in the array
						if(col == 0){
							Names.add(st.nextToken());
						}
						else if(col == 1){
							Status.add(st.nextToken());
						}else
						{
							boolean valid = false;
							
							
						}
						col++;
					}
					
							
							ReferenceMap.put(Names.get(row),Status.get(row));
					
					col = 0;
					row++;
				}
				
			
				
		}
		
		public void checkData(List<String> NameList)
		{
			for(int i = 0; i < NameList.size(); i++)
			{
				String key = NameList.get(i);
				
				if(!Observed.contains(key))
				{
				Observed.add(key);
				String value = (String)ReferenceMap.get(key);
				
			
				
				
				if(value != null){
						if( value.contains("c")){
						Match++;
						//System.out.println("Value "+key+ " , is a real name");
						
						}else if( value.contains("w")){
						Wrong++;
						//System.out.println("Value: "+key+ " , is not a name");
						}
					
					}else{
						Missed++;
						//System.out.println("Value: "+key+ " , not found in training dataset");
					}
				}
			}

			System.out.println("Correct Match with Training Data:" + Match);
			System.out.println("False Match with Training Data:" + Wrong);
			System.out.println("Not in the training set:" + Missed);

		}
			
}