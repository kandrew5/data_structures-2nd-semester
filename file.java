import java.io.File;
import java.util.*;

public class file {
private Scanner x;

public void opentxt(String s)
{
	try
	{
		x=new Scanner(new File(s));//������������� ��� scanner ���� ��� ������ �� ����� "s"
	}
	catch(Exception e)
	{
		System.out.println("could not find file");
	}
}
public void readint(ArrayList<Integer> p1)
{
	while(x.hasNext())//��� �� ������� �������� ��� ������� ��� ����� null 
	{
		try
		{
			p1.add(x.nextInt());//��������� ���� ����� ��� ������� ������� ��� ���������
			x.nextLine();//�������� � scanner ���� ������� ������ ��� �������
		}
		catch(NoSuchElementException h){}
	}
}


public void readString(ArrayList<String> p2)
{
	while(x.hasNext())//��� �� ������� �������� ��� ������� ��� ����� null 
	{
		try
		{
			p2.add(x.next());//��������� ���� ����� ��� ������� string ��� ���������
			x.nextLine();//�������� � scanner ���� ������� ������ ��� �������
		}
		catch(NoSuchElementException h){}
	}
	}

public void closetxt()
{
	x.close();//������� ��� scanner
}
}
