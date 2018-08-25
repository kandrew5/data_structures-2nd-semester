import java.io.File;
import java.util.*;

public class file {
private Scanner x;

public void opentxt(String s)
{
	try
	{
		x=new Scanner(new File(s));//αρχικοποιουμε τον scanner μεσα στο αρχειο με ονομα "s"
	}
	catch(Exception e)
	{
		System.out.println("could not find file");
	}
}
public void readint(ArrayList<Integer> p1)
{
	while(x.hasNext())//οσο το επομενο στοιχειο του αρχειου δεν ειναι null 
	{
		try
		{
			p1.add(x.nextInt());//προσθετει στην λιστα τον επομενο ακεραιο που συνανταει
			x.nextLine();//πηγαινει ο scanner στην επομενη γραμμη του αρχειου
		}
		catch(NoSuchElementException h){}
	}
}


public void readString(ArrayList<String> p2)
{
	while(x.hasNext())//οσο το επομενο στοιχειο του αρχειου δεν ειναι null 
	{
		try
		{
			p2.add(x.next());//προσθετει στην λιστα τον επομενο string που συνανταει
			x.nextLine();//πηγαινει ο scanner στην επομενη γραμμη του αρχειου
		}
		catch(NoSuchElementException h){}
	}
	}

public void closetxt()
{
	x.close();//κλεινει τον scanner
}
}
