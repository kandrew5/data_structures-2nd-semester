import java.util.*;


public class MergeSort {
void merge(ArrayList<Integer> pin,int l, int m, int r)
{
	int n1=	m-l+1;//μεγεθος πρωτου υποπινακα
	int n2=r-m;//μεγεθος πρωτου υποπινακα
	int Pl[]=new int [n1];
	int Pr[]=new int [n2];
	for(int i=0;i<n1;i++)
	{
		Pl[i]=pin.get(l+i);//γεμιζουμε τον υποπινακα με το στοιχεια της λιστας
	
	}
	for(int j=0;j<n2;j++)
	{
		Pr[j]=pin.get(m+1+j);//γεμιζουμε τον υποπινακα με το στοιχεια της λιστας
	}
	int i=0;
	int j=0;
	int k=l;
	while(i<n1 && j<n2)//οσο και οι δυο υποπινακες εχουν στοιχεια
	{
		if(Pl[i]<Pr[j])//βαζουμε τον μεγαλυτερο αριθμο απο τους δυο υποπινακες
		{
			pin.set(k, Pl[i]);
			i++;
		}
		else
		{
			pin.set(k, Pr[j]);
			j++;
		}
		k++;
	}
	
	while(i<n1)//οταν τελειωσει ο πινακας 2 μεταφερουμε τα στοιχεια του πρωτου(ταξινομιμενου) υποπινακα στην λιστα
	{
		
		pin.set(k,Pl[i]);
		k++;
		i++;
	}
	while(j<n2)//οταν τελειωσει ο πινακας 1 μεταφερουμε τα στοιχεια του δευτερου(ταξινομιμενου) υποπινακα στην λιστα
	{
		pin.set(k,Pr[j]);
		k++;
		j++;
	}

}

void sort(ArrayList<Integer> pin, int start,int end)
{
	if(start<end)//μεχρι να χωριστει ο πινακας σε υποπινακες του ενος στοιχειου
	{
		int mid=(start+end)/2;
		sort(pin,start, mid);//αναδρομικη κληση της sort για τον αριστερο υποπινακα
		sort(pin, mid+1, end);//αναδρομικη κληση της sort για τον αριστερο υποπινακα
		merge(pin,start,mid,end);//κληση της merge για να ενωθουν οι δυο υποπινακες
	}	
}


}

