
public class Red_Black_Tree {
	private final int red=0;
	private final int black=1;
	private final Node nil= new Node(-1);//αρχικοποιούμε το nil δηλαδή τα φύλλα με τιμη -1
	Node root=nil;//αρχικοποίση ριζας
		
	public class Node
	{
		int key, color=black;
		Node left=nil, right=nil, parent=nil;
		Node(int key)//constructor της Node που θέτει στο key το στοιχείο που εισάγουμε
		{
			this.key=key;
		}
	}
	void insert(int y) 
    {
		Node node= new Node(y);
        Node temp = root;
        if (root == nil)//αν το δεντρο ειναι αδειανο 
        {
            root = node;//το καινουριο στοιχειο γινεται ριζα
            node.color = black;
            node.parent = nil;
        }
        else
        {
            node.color = red;//οι κομβοι που εισαγωνται ειναι παντα κοκκινοι
            while (true)
            {
                if (node.key < temp.key)//ελεγχος αν το στοιχειο που εισαγουμε ειναι μικροτερο το απο το στοιχειο που βρισκομαστε
                {
                    if (temp.left == nil)//αν το στοιχειο ειναι φυλλο
                    {
                        temp.left = node;//αντικαθιστουμε το φυλλο με τον καινουριο κομβο
                        node.parent = temp;
                        break;
                    }
                    else
                    {
                        temp = temp.left;//αλλιως η temp μεταβλητη μας παιρνει την τιμη του αριστερου στοιχειου
                    }
                }
                else if (node.key >= temp.key)//ελεγχος αν το στοιχειο που εισαγουμε ειναι μεγαλυτερο η ισο  το απο το στοιχειο που βρισκομαστε
                {
                    if (temp.right == nil)//αν το στοιχειο ειναι φυλλο
                    {
                        temp.right = node;//αντικαθιστουμε το φυλλο με τον καινουριο κομβο
                        node.parent = temp;
                        break;
                    }
                    else
                    {
                        temp = temp.right;//αλλιως η temp μεταβλητη μας παιρνει την τιμη του δεξιου στοιχειου
                    }
                }
            }
            fixTree(node);//καλουμε την μεθοδο fixTree για να κανει τα απαραιτητα rotates
        }
    }
	void fixTree(Node x)
	{
		while(x.parent.color==red &&x.color==red)//ελεγχουμε την συνθηκη κοκκινο παιδι κοκκινος πατερας
		{
			Node y=nil;
			if(x.parent==x.parent.parent.left)
			{
				y=x.parent.parent.right;
				if(y.color==red && y!=nil)//θειος κοκκινος
				{
					x.parent.color=black;//εναλλαγη χρωματων     case 1.1
					x.parent.parent.color=red;
					y.color=black;
					root.color=black;//σε περιπτωση που το recolor γινει στην ριζα
					x=x.parent.parent;
					continue;
				}
				if(x==x.parent.right)//μαυρος θειος και το χ ειναι εσωτερικο παιδι αρα θελουμε διπλο rotate    case 2.1
				{
					x=x.parent;//το rotate γινεται για τον πατερα του παιδιου που εχει το προβλημα
					rotateL(x);
				}
				x.parent.color=black;
				x.parent.parent.color=red;
				rotateR(x.parent.parent);//απλο rotate    case3.1
			}
			else //if(x.parent==x.parent.parent.left)
			{
				y=x.parent.parent.left;
				if(y.color==red && y != nil)//θειος κοκκινος          
				{
					x.parent.color=black;//εναλλαγη χρωματων        case 1.2
					x.parent.parent.color=red;
					y.color=black;
					root.color=black;//σε περιπτωση που το recolor γινει στην ριζα
					x=x.parent.parent;
					continue;
				}
				if(x==x.parent.left)//μαυρος θειος και το χ ειναι εσωτερικο παιδι αρα θελουμε διπλο rotate        case 2.2
				{
					x=x.parent;//το rotate γινεται για τον πατερα του παιδιου που εχει το προβλημα    
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
			if(p.parent!=nil)//αρχικα σιγουρευομαστε οτι δεν κανουμε rotate στην ριζα
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
				else {//rotate ριζας
		            Node right = root.right;//right=uncle
		            root.right = right.left;
		            right.left.parent = root;
		            root.parent = right;
		            right.left = root;
		            right.parent = nil;//πατερας καινουριας ριζας -1
		            root = right;//θετουμε την καινουρια ριζα
			}
			
		}
					
					
		void rotateR(Node p)
	    {
	        if (p.parent!=nil)//αρχικα σιγουρευομαστε οτι δεν κανουμε rotate στην ριζα
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
	        else//rotate ριζας
	        {
	            Node left=root.left;//left=uncle
	            root.left=root.left.right;
	            left.right.parent=root;
	            root.parent=left;
	            left.right=root;
	            left.parent=nil;//πατερας καινουριας ριζας -1
	            root=left;//θετουμε την καινουρια ριζα
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
			Node x =new Node(y);//φτιαχνουμε καινουριο κομβο και του αναθετουμε την τιμη y
			boolean success=false;
			Node temp=root;
			while(temp!=nil)//οσο δεν ειμαστε σε φυλλο
			{
				if(x.key<temp.key)
				{
					temp=temp.left;
				}
				else if(x.key>temp.key)
				{
					temp=temp.right;
				}
				else if(x.key==temp.key)//αν βρηκαμε το στοιχειο
				{
					success=true;
					return success;
				}
			}
			return success;
		}
}
				
				
				
				
		
