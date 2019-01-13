import java.io.InputStream;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("i for Insert, s for search, d for delete, q to quit");
		String c = sc.nextLine();
		Trie trie = new Trie();
		while(c.equals("q")== false)
		{
			if(c.equals("i"))
			{
				System.out.println("Enter the word to insert: ");
				trie.addWord(sc.nextLine());
			}
			else if(c.equals("s"))
			{
				System.out.println("Enter the word to search: ");
				trie.showResults(sc.nextLine());
			}
			System.out.println("i for Insert, s for search, d for delete, q to quit");
			c = sc.nextLine();
		}

	}

}
