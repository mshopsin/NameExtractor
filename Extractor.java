import java.util.ArrayList;
import java.util.List;
import java.util.*; 
abstract class Extractor{

List<Operation> operations = new ArrayList();
//List<Name> FirstLast;
HashMap FirstLast = new HashMap();
List<String> Names = new ArrayList();
	
	 abstract List<Operation> getOperations();
	 abstract void init();
	 abstract void test();
	abstract List<String> run(String start);
	

	List<String> getNameList()
	{
		return Names;
	}

	HashMap getNames()
	{
		return FirstLast;
	}

}

interface Operation{
	public List<String> execute(String input);
}