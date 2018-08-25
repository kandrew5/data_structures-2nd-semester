import java.util.HashMap;

public class Tries {
	
	private class NodeT
	{
		String key;//������ ��� �����
		HashMap<String, NodeT> kiddo;//������������� �� Hashmap ��� ����� map �� string �� ����������� ����� NodeT 
		boolean endofword;//boolean ��������� ��� ������� �� ������� ���� ��� ��������� �� �� ������ key
		
		NodeT(String key, HashMap<String, NodeT> kiddo)//constructor ��� �� NodeT
		{
			this.key=key;
			this.kiddo=kiddo;
			endofword=false;//������������� ��� ��������� �� false
		}
	}
		
		private NodeT root= new NodeT(null, new HashMap<>());//������������� ��� ���� �� ���� null
		
		public void insert(String key)
		{
			NodeT temp= root;
			int i=0;
			int length=key.length();
			String index;
			
			
			for(i=0;i<length;i++)//��� � ���� ���� ����� ����������
			{
				index=Character.toString(key.charAt(i));
				if(temp.kiddo.containsKey(index))//� containsKey ������� �� ������� ��� �� ������ ��� ���� ����
				{
					temp=temp.kiddo.get(index);
					continue;
				}
				else
				{
					break;
				}	
			}
		
			while(i<length)//���� ����� ��� ������ ������ ������� ����������(�� ����� ������) ����������� ��� ��� �� �������� ��������
			{
				index=Character.toString(key.charAt(i));
				temp.kiddo.put(index, new NodeT(null, new HashMap<>()));
				temp=temp.kiddo.get(index);
				i++;
			}
		temp.endofword=true;
	}

	public boolean searchT(String key)
	{
		boolean success=false;
		NodeT temp=root;
 		int i=0;
		int length=key.length();
		String index;
		for(i=0;i<length;i++)
		{
			index=Character.toString(key.charAt(i));
			if(temp.kiddo.containsKey(index)==false)
			{
				break;
			}
			if(temp.kiddo.containsKey(index))
			{
				temp=temp.kiddo.get(index);
				continue;
			}
		}
		if(i==length && temp.endofword)//���� ���� ���� ��������� � ���� ��� � endofword ����� true �� ������ ���� �� ��������
		{
			success=true;
			System.out.println("the bool value is true");			
		}
		else{System.out.println("the bool value is false");}
		return success;
	}
 
	public void deleteT(String key)
	{
		int length=key.length();
		if(length>0)
		{
			deleteHelp(root,key,0);
		}
	}	
		private boolean deleteHelp(NodeT x, String key, int i)
		{
			if(x!=null)
			{
				if(i==key.length() && x.endofword==true)//�� ���� ��������� � ���� ��� � endofword ����� true
				{
					x.endofword=false;
					if(x.kiddo!=null)//�� ��� ���� ������ ���� ����� 
					{
						return x.kiddo.isEmpty();//��������� true
					}
				}		
				else
				{
					String index=Character.toString(key.charAt(i));
					i++;
					if(deleteHelp(x.kiddo.get(index),key,i))//���������� ����� ��� deleteHelp
					{
						x.kiddo.remove(index);//���� �� � �������� ���� ����� true �������� �� ��������
						return x.endofword==false && x.kiddo.isEmpty();
					}	
				}
			}
				return false;
		}
}
	
