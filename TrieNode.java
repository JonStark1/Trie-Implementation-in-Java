//import java.util.*;
public class TrieNode {
	private TrieNode[] children;
	private boolean isEnd;
	public TrieNode()
	{
		children = new TrieNode[26];
		for(int i = 0; i < 26; i++)
			children[i] = null;
		this.isEnd = false;
	}
	public TrieNode getChild(int n)
	{
		return this.children[n];
	}
	public TrieNode[] getChildren()
	{
		return this.children;
	}
	public void setChild(TrieNode node, int n)
	{
		this.children[n] = node;
	}
	public void deleteChild(int n)
	{
		if(this.children[n]!= null)
			this.children[n] = null;
		int flag = 0;
		for(int i = 0; i < 26; i++)
		{
			if(this.children[i]!= null) {
				flag = 1;
				break;
			}
		}
		if(flag == 0)
			this.isEnd = true;
	}
	public void setEndof(boolean b)
	{
		this.isEnd = b;
	}
	public Boolean isEndof()
	{
		return this.isEnd;
	}
	public void printAllChildren(String s)
	{
		//System.out.println("Entered here 1");
		if(this.isEndof() == true)
		{
			System.out.println(s);
		}
		int flag = 0;
		for(int i = 0; i < 26; i++)
		{
			//System.out.println("Entered here 2");
			TrieNode node = this.getChild(i);
			if(node != null)
			{
				flag = 1;
				//System.out.println("Entered here 3");
				String s1 = s + (char) ('a' + i);
				//System.out.print((char) ('a' + i));
				node.printAllChildren(s1);
			}			
		}
		if(flag == 0)
		{
			System.out.println("----------------");
			return;
		}
	}
}
