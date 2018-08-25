import java.util.HashMap;

public class Tries {
	
	private class NodeT
	{
		String key;//γραμμα της λεξης
		HashMap<String, NodeT> kiddo;//αρχικοποιουμε το Hashmap που κανει map τα string με αντικειμενα τυπου NodeT 
		boolean endofword;//boolean μεταβλητη που δειχνει αν υπαρχει λεξη που τελειωνει με το γραμμα key
		
		NodeT(String key, HashMap<String, NodeT> kiddo)//constructor για το NodeT
		{
			this.key=key;
			this.kiddo=kiddo;
			endofword=false;//αρχικοποιουμε την μεταβλητη με false
		}
	}
		
		private NodeT root= new NodeT(null, new HashMap<>());//αρχικοποιουμε την ριζα με τιμη null
		
		public void insert(String key)
		{
			NodeT temp= root;
			int i=0;
			int length=key.length();
			String index;
			
			
			for(i=0;i<length;i++)//οσο η λεξη εχει ακομα χαρακτηρες
			{
				index=Character.toString(key.charAt(i));
				if(temp.kiddo.containsKey(index))//η containsKey ελεγχει αν υπαρχει ηδη το γραμμα για αλλη λεξη
				{
					temp=temp.kiddo.get(index);
					continue;
				}
				else
				{
					break;
				}	
			}
		
			while(i<length)//οταν πλεον δεν εχουμε αλλους κοινους χαρακτηρες(με αλλες λεξεις) προσθετουμε ενα ενα τα υπολοιπα στοιχεια
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
		if(i==length && temp.endofword)//μονο οταν εχει τελειωσει η λεξη και η endofword ειναι true θα εχουμε βρει το στοιχειο
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
				if(i==key.length() && x.endofword==true)//αν εχει τελειωσει η λεξη και η endofword ειναι true
				{
					x.endofword=false;
					if(x.kiddo!=null)//αν δεν εχει κανενα αλλο παιδι 
					{
						return x.kiddo.isEmpty();//επεστρεψε true
					}
				}		
				else
				{
					String index=Character.toString(key.charAt(i));
					i++;
					if(deleteHelp(x.kiddo.get(index),key,i))//αναδρομικη κληση της deleteHelp
					{
						x.kiddo.remove(index);//μονο αν η παραπανω τιμη ειναι true αφαιρεσε το στοιχειο
						return x.endofword==false && x.kiddo.isEmpty();
					}	
				}
			}
				return false;
		}
}
	
