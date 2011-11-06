import java.util.ArrayList;
import java.util.List;
abstract class Extractor{

List<Operation> operations;
List<Name> FirstLast;

	List<Operation> getOperations()
	{
		return operations;
	}

	List<Name> getNames()
	{
		return FirstLast;
	}

	 abstract void init();
	 abstract void test();
	abstract String run(String start);
	/*
	{
		String input = start;
		for(int i = 0; i < operations.size(); i++)
		{
			input = operations.get(i).execute(input);
		}
		
		return input;		
	}*/

}

interface Operation{
	public String execute(String input);
}