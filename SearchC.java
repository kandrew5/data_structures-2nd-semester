import java.util.ArrayList;

public class SearchC {
	
	int linearS(ArrayList<Integer> pin,int target )
	{
		int i;
		for(i=0;i<pin.size();i++)//����������� ��� �� �������� ��� ������
		{
			if(target==pin.get(i))//��������� �� �� �������� ����� �� ���������
			{
				return i;//���������� ��� ���� ��� ������ ��� ��������� �� ��������� ��������
			}
		}
		return -1;//��� ��� ������� �� �������� ���� ������ ���������� -1
	}
	
	int binaryS(ArrayList<Integer> pin,int target)
	{
		int mid=0;
		int l=0;
		int r=pin.size()-1;
		while(r>l)//��� �������� ����� �������� ��� ����� ��� ������ [l,r]
		{
			mid=(l+r)/2;//��������� �� ������ ��������
			if(pin.get(mid)==target)//�� �� ������ �������� ����� �� ���������
			{
				return mid;//��������� ��� ���� ��� ��������� ��� ������
			}
			else if(pin.get(mid)>target)//�� �� �������� �������� ����� ���������� ��� �� ���������
			{
				r=mid-1;//������ ��� ���� ��� ���������� ��������� �� ���� ��� ����� ���������+1
			}
			else//�� �� �������� �������� ����� ��������� ��� �� ���������
			{
				l=mid+1;//������ ��� ���� ��� ������������� ��������� �� ���� ��� ����� ��������� +1
			}
		}
		return -1;//�� �� �������� ��� ������� ���� ����� ��������� -1
		
	}
	
	int interpolationS(ArrayList<Integer> pin,int target)
	{
		double key=0;
		int Nkey=-1;
		int left=0;
		int right=pin.size()-1;
		boolean a = false;
		while(left<=right && target >=pin.get(left) && target<=pin.get(right))//��� ������� �� �������� [left,right] && �� ��������� �������� ��������� ������� ��� ��� ����� ��� ������ ��� left,right
		{
			key=(((double)target-pin.get(left))/(pin.get(right)-pin.get(left)))*(right-left) +left;//���������� �� key(������ casting �� double ����� � �������� ������ �� ������ ���������� ��������
			Nkey=(int)key;//������� ��� Nkey �� ������� ����� ��� key
			if(pin.get(Nkey)==target)//�� �� �������� ���� ���� Nkey ����� �� ��������� 
			{
				a=true;
				break;
			}
			if(pin.get(Nkey)<target)//�� �� �������� ���� ���� Nkey ����� ��������� ��� �� ��������� 
			{
				left=Nkey+1;//������ ��� ���� ��� ������������� ��������� �� ���� ��� Nkey +1
			}
			else//�� �� �������� ���� ���� Nkey ����� ���������� ��� �� ��������� 
			{
				right=Nkey-1;//������ ��� ���� ��� ���������� ��������� �� ���� ��� Nkey +1
			}
			
		}
		if(a)
		{
			return Nkey;//��������� ��� ���� ��� ��������� ���� �����
		}
		else
		{
			return -1;//��������� -1 �� �� �������� ��� ��������� ���� �����
		}
	}

}
