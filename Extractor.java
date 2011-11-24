import java.util.ArrayList;
import java.util.List;
import java.util.*; 
abstract class Extractor{

List<Operation> operations;
//List<Name> FirstLast;
HashMap FirstLast = new HashMap();
List<String> Names = new ArrayList();
	

	 abstract void init();
	 abstract void test();
	abstract List<String> run(String start);
	List<Operation> getOperations()
	{
		return operations;
	}

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