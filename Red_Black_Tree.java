
public class Red_Black_Tree {
	private final int red=0;
	private final int black=1;
	private final Node nil= new Node(-1);//������������� �� nil ������ �� ����� �� ���� -1
	Node root=nil;//����������� �����
		
	public class Node
	{
		int key, color=black;
		Node left=nil, right=nil, parent=nil;
		Node(int key)//constructor ��� Node ��� ����� ��� key �� �������� ��� ���������
		{
			this.key=key;
		}
	}
	void insert(int y) 
    {
		Node node= new Node(y);
        Node temp = root;
        if (root == nil)//�� �� ������ ����� ������� 
        {
            root = node;//�� ��������� �������� ������� ����
            node.color = black;
            node.parent = nil;
        }
        else
        {
            node.color = red;//�� ������ ��� ���������� ����� ����� ��������
            while (true)
            {
                if (node.key < temp.key)//������� �� �� �������� ��� ��������� ����� ��������� �� ��� �� �������� ��� �����������
                {
                    if (temp.left == nil)//�� �� �������� ����� �����
                    {
                        temp.left = node;//�������������� �� ����� �� ��� ��������� �����
                        node.parent = temp;
                        break;
                    }
                    else
                    {
                        temp = temp.left;//������ � temp ��������� ��� ������� ��� ���� ��� ��������� ���������
                    }
                }
                else if (node.key >= temp.key)//������� �� �� �������� ��� ��������� ����� ���������� � ���  �� ��� �� �������� ��� �����������
                {
                    if (temp.right == nil)//�� �� �������� ����� �����
                    {
                        temp.right = node;//�������������� �� ����� �� ��� ��������� �����
                        node.parent = temp;
                        break;
                    }
                    else
                    {
                        temp = temp.right;//������ � temp ��������� ��� ������� ��� ���� ��� ������ ���������
                    }
                }
            }
            fixTree(node);//������� ��� ������ fixTree ��� �� ����� �� ���������� rotates
        }
    }
	void fixTree(Node x)
	{
		while(x.parent.color==red &&x.color==red)//��������� ��� ������� ������� ����� �������� �������
		{
			Node y=nil;
			if(x.parent==x.parent.parent.left)
			{
				y=x.parent.parent.right;
				if(y.color==red && y!=nil)//����� ��������
				{
					x.parent.color=black;//�������� ��������     case 1.1
					x.parent.parent.color=red;
					y.color=black;
					root.color=black;//�� ��������� ��� �� recolor ����� ���� ����
					x=x.parent.parent;
					continue;
				}
				if(x==x.parent.right)//������ ����� ��� �� � ����� ��������� ����� ��� ������� ����� rotate    case 2.1
				{
					x=x.parent;//�� rotate ������� ��� ��� ������ ��� ������� ��� ���� �� ��������
					rotateL(x);
				}
				x.parent.color=black;
				x.parent.parent.color=red;
				rotateR(x.parent.parent);//���� rotate    case3.1
			}
			else //if(x.parent==x.parent.parent.left)
			{
				y=x.parent.parent.left;
				if(y.color==red && y != nil)//����� ��������          
				{
					x.parent.color=black;//�������� ��������        case 1.2
					x.parent.parent.color=red;
					y.color=black;
					root.color=black;//�� ��������� ��� �� recolor ����� ���� ����
					x=x.parent.parent;
					continue;
				}
				if(x==x.parent.left)//������ ����� ��� �� � ����� ��������� ����� ��� ������� ����� rotate        case 2.2
				{
					x=x.parent;//�� rotate ������� ��� ��� ������ ��� ������� ��� ���� �� ��������    
					rotateR(x);
				}
				x.parent.color=black;
				x.parent.parent.color=red;
				rotateL(x.parent.parent);//          case 3.2
				}
					
			}
		}
		
		void rotateL(Node p)
		{
			if(p.parent!=nil)//������ �������������� ��� ��� ������� rotate ���� ����
			{
				if(p==p.parent.left)
				{
					p.parent.left=p.right;
				}
				else
				{
					p.parent.right=p.right;
				}
				p.right.parent=p.parent;
				p.parent=p.right;
				if(p.right.left!=nil)
				{
					p.right.left.parent=p;
				}
				p.right=p.right.left;
				p.parent.left=p;
			}
				else {//rotate �����
		            Node right = root.right;//right=uncle
		            root.right = right.left;
		            right.left.parent = root;
		            root.parent = right;
		            right.left = root;
		            right.parent = nil;//������� ���������� ����� -1
		            root = right;//������� ��� ��������� ����
			}
			
		}
					
					
		void rotateR(Node p)
	    {
	        if (p.parent!=nil)//������ �������������� ��� ��� ������� rotate ���� ����
	        {
	            if (p==p.parent.left) 
	            {
	                p.parent.left=p.left;
	            } else 
	            {
	                p.parent.right=p.left;
	            }

	            p.left.parent=p.parent;
	            p.parent=p.left;
	            if (p.left.right!=nil)
	            {
	                p.left.right.parent=p;
	            }
	            p.left=p.left.right;
	            p.parent.right=p;
	        } 
	        else//rotate �����
	        {
	            Node left=root.left;//left=uncle
	            root.left=root.left.right;
	            left.right.parent=root;
	            root.parent=left;
	            left.right=root;
	            left.parent=nil;//������� ���������� ����� -1
	            root=left;//������� ��� ��������� ����
	        }
	    }			
				
		/*public void printTree(Node node)
	    {
	        if (node == nil) {
	            return;
	        }
	        printTree(node.left);
	        System.out.print(((node.color==red)?"Color: Red ":"Color: Black ")+"Key: "+node.key+" Parent: "+node.parent.key+"  "+node.right.key+"   "+node.left.key+"\n");
	        printTree(node.right);
	    }*/
		
		public boolean searchRDT(int y)
		{
			Node x =new Node(y);//���������� ��������� ����� ��� ��� ���������� ��� ���� y
			boolean success=false;
			Node temp=root;
			while(temp!=nil)//��� ��� ������� �� �����
			{
				if(x.key<temp.key)
				{
					temp=temp.left;
				}
				else if(x.key>temp.key)
				{
					temp=temp.right;
				}
				else if(x.key==temp.key)//�� ������� �� ��������
				{
					success=true;
					return success;
				}
			}
			return success;
		}
}
				
				
				
				
		
