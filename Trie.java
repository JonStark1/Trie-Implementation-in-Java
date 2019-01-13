import java.util.*;
public class Trie {
	private TrieNode root;
	public Trie()
	{
		this.root = new TrieNode();
	}
	public Trie(TrieNode node)
	{
		this.root = node;
	}
	public TrieNode getRoot()
	{
		return this.root;
	}
	public void addWord(String s)
	{
		char s1 = Character.toLowerCase(s.charAt(0));
		System.out.println("String to be added is : "+ s);
		if(s.length() == 1)
		{
			TrieNode testNode = new TrieNode();
			if(this.root.getChild(s1-'a')!= null)
			{
				System.out.println("Word already in the trie, try adding other word.");
				return;
			}
			this.root.setChild(testNode, s1-'a');
			testNode.setEndof(true);
			System.out.println("Added one word.");
			return;
		}
		if(this.root.getChild(s1 - 'a') == null)
		{
			Trie test = new Trie();
			test.addWord(s.substring(1, s.length()));
			this.root.setChild(test.getRoot(), s1-'a');
			return;
			
		}
		Trie testTrie = new Trie(this.root.getChild(s1-'a'));
		testTrie.addWord(s.substring(1, s.length()));
		this.root.setChild(testTrie.getRoot(), s1-'a');
	}
	
	public void showResults(String s)
	{
		char s1 = Character.toLowerCase(s.charAt(0));
		TrieNode node = this.root;
		for(int i = 0; i < s.length(); i++)
		{
			s1 = Character.toLowerCase(s.charAt(i));
			if(node.getChild(s1-'a') == null)
				return;
			node = node.getChild(s1-'a'); 
		}
		node.printAllChildren(s);
		/*if(s.length() == 1)
		{
			if(this.root.getChild(s1-'a') != null)
				System.out.println(s1);
			return;
		}
		if(this.root.getChild(s1-'a') == null)
		{
			return;
			//System.out.println("");
		}
		if(this.root.isEndof() == true)
		{
			System.out.println();
		}
		System.out.print(s1);
		Trie testTrie = new Trie(this.root.getChild(s1-'a'));
		testTrie.showResults(s.substring(1, s.length()));*/
	}
}
