import java.util.ArrayList;

public class SearchC {
	
	int linearS(ArrayList<Integer> pin,int target )
	{
		int i;
		for(i=0;i<pin.size();i++)//διατρεχουμε ολα τα στοιχεια του πινακα
		{
			if(target==pin.get(i))//ελεγχουμε αν το στοιχειο ειναι το ζητουμενο
			{
				return i;//επιστρεφει την θεση της λιστας που βρισκεται το ζητουμενο στοιχειο
			}
		}
		return -1;//αμα δεν υπαρχει το στοιχειο στον πινακα επιστρεφει -1
	}
	
	int binaryS(ArrayList<Integer> pin,int target)
	{
		int mid=0;
		int l=0;
		int r=pin.size()-1;
		while(r>l)//οσο υπαρχουν ακομα στοιχεια στο μερος της λιστας [l,r]
		{
			mid=(l+r)/2;//βρισκουμε το μεσαιο στοιχειο
			if(pin.get(mid)==target)//αν το μεσαιο στοιχειο ειναι το ζητουμενο
			{
				return mid;//επεστρεψε την θεση του στοιχειου που ζηταμε
			}
			else if(pin.get(mid)>target)//αν το κεντρικο στοιχειο ειναι μεγαλυτερο απο το ζητουμενο
			{
				r=mid-1;//αλλαξε την τιμη του δεξιοτερου στοιχειου σε αυτη του μεσου στοιχειου+1
			}
			else//αν το κεντρικο στοιχειο ειναι μικροτερο απο το ζητουμενο
			{
				l=mid+1;//αλλαξε την τιμη του αριστεροτερου στοιχειου σε αυτη του μεσου στοιχειου +1
			}
		}
		return -1;//αν το στοιχειο δεν υπαρχει στην λιστα επεστρεψε -1
		
	}
	
	int interpolationS(ArrayList<Integer> pin,int target)
	{
		double key=0;
		int Nkey=-1;
		int left=0;
		int right=pin.size()-1;
		boolean a = false;
		while(left<=right && target >=pin.get(left) && target<=pin.get(right))//οσο υπαρχει το διαστημα [left,right] && το ζητουμενο στοιχειο βρισκεται αναμεσα απο τις τιμες της λιστας στα left,right
		{
			key=(((double)target-pin.get(left))/(pin.get(right)-pin.get(left)))*(right-left) +left;//υπολογιζει το key(εχουμε casting σε double γιατι η διαιρεση μπορει να βγαλει αποτελεσμα δεκαδικο
			Nkey=(int)key;//θετουμε στο Nkey το ακεραιο μερος του key
			if(pin.get(Nkey)==target)//αν το στοιχειο στην θεση Nkey ειναι το ζητουμενο 
			{
				a=true;
				break;
			}
			if(pin.get(Nkey)<target)//αν το στοιχειο στην θεση Nkey ειναι μικροτερο απο το ζητουμενο 
			{
				left=Nkey+1;//αλλαξε την τιμη του αριστεροτερου στοιχειου σε αυτη του Nkey +1
			}
			else//αν το στοιχειο στην θεση Nkey ειναι μεγαλυτερο απο το ζητουμενο 
			{
				right=Nkey-1;//αλλαξε την τιμη του δεξιοτερου στοιχειου σε αυτη του Nkey +1
			}
			
		}
		if(a)
		{
			return Nkey;//επεστρεψε την θεση του στοιχειου στην λιστα
		}
		else
		{
			return -1;//επεστρεψε -1 αν το στοιχειο δεν βρισκεται στην λιστα
		}
	}

}
