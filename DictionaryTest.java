package pa4;

public class DictionaryTest {
	public static void main(String[] args) {
		Dictionary D = new Dictionary();
		D.insert("123", "345");
		System.out.println(D.isEmpty());
		System.out.println(D.size());
		D.insert("798", "976");
		System.out.println(D.size());
		D.delete("123");
		System.out.println(D.size());
		System.out.println(D.lookup("798"));
		D.makeEmpty();
		System.out.println(D.isEmpty());
		D.insert("2", null);
		System.out.println(D.lookup("2"));
		System.out.println(D);
		D.insert("123", "45678");
		D.insert("4567", "2435678");
		System.out.println(D);
		//D.insert("123", "3456");
		D.delete("987545");
	}
}
