import java.io.*;
import java.util.*;
import java.lang.*;

public class main {

public static void main(String[] args) {
	ArrayList<Integer> prdt=new ArrayList<Integer>();
	ArrayList<String> pl=new ArrayList<String>();
	ArrayList<Integer> p=new ArrayList<Integer>();
	int i=0;
	Random rand = new Random();
	file file1 = new file();
	file1.opentxt("integers.txt");
	file1.readint(p);
	file1.closetxt();
	MergeSort en1 = new MergeSort();
	en1.sort(p, 0, p.size()-1);
	//System.out.println(p);
	SearchC se1 = new SearchC();
	/*long startTime= System.nanoTime();
	for(i=0;i<10000;i++)
	{
		int ad=rand.nextInt(500000);
		int a=se1.binaryS(p, ad);
	}
	System.out.println("Total Time= "+ (System.nanoTime()-startTime));*/
	Red_Black_Tree rdt= new Red_Black_Tree();
	file file2 =new file();
	file2.opentxt("integers.txt");
	file2.readint(prdt);
	file2.closetxt();
	i=0;
	while(i<=prdt.size()-1)
	{
		rdt.insert(prdt.get(i));
		i++;
	}
	System.out.println(rdt.root.key);
	/*long startTime= System.nanoTime();
	for(i=0;i<10000;i++)
	{
		int ad=rand.nextInt(500000);
		rdt.searchRDT(ad);
	}
	System.out.println("Total Time= "+ (System.nanoTime()-startTime));*/
	Tries tr1= new Tries();
	file file3 =new file();
	file3.opentxt("words.txt");
	file3.readString(pl);
	file3.closetxt();
	while(i<=pl.size()-1)
	{
		tr1.insert(pl.get(i));
		//System.out.println(pl.get(i));
		i++;
	}
			}
		
		}
