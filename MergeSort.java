import java.util.*;


public class MergeSort {
void merge(ArrayList<Integer> pin,int l, int m, int r)
{
	int n1=	m-l+1;//������� ������ ���������
	int n2=r-m;//������� ������ ���������
	int Pl[]=new int [n1];
	int Pr[]=new int [n2];
	for(int i=0;i<n1;i++)
	{
		Pl[i]=pin.get(l+i);//��������� ��� ��������� �� �� �������� ��� ������
	
	}
	for(int j=0;j<n2;j++)
	{
		Pr[j]=pin.get(m+1+j);//��������� ��� ��������� �� �� �������� ��� ������
	}
	int i=0;
	int j=0;
	int k=l;
	while(i<n1 && j<n2)//��� ��� �� ��� ���������� ����� ��������
	{
		if(Pl[i]<Pr[j])//������� ��� ���������� ������ ��� ���� ��� ����������
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
	
	while(i<n1)//���� ��������� � ������� 2 ����������� �� �������� ��� ������(�������������) ��������� ���� �����
	{
		
		pin.set(k,Pl[i]);
		k++;
		i++;
	}
	while(j<n2)//���� ��������� � ������� 1 ����������� �� �������� ��� ��������(�������������) ��������� ���� �����
	{
		pin.set(k,Pr[j]);
		k++;
		j++;
	}

}

void sort(ArrayList<Integer> pin, int start,int end)
{
	if(start<end)//����� �� �������� � ������� �� ���������� ��� ���� ���������
	{
		int mid=(start+end)/2;
		sort(pin,start, mid);//���������� ����� ��� sort ��� ��� �������� ���������
		sort(pin, mid+1, end);//���������� ����� ��� sort ��� ��� �������� ���������
		merge(pin,start,mid,end);//����� ��� merge ��� �� ������� �� ��� ����������
	}	
}


}

