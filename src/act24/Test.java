package act24;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test{

	public static void main(String[] args) {
		
		PriorityQueue<Rectangle> rec1 = new PriorityQueue<>();
		
		rec1.add(new Rectangle(10,10));
		rec1.add(new Rectangle(20,20));
		rec1.add(new Rectangle(30,30));
		rec1.add(new Rectangle(40,40));

		TreeMap<Rectangle, Rectangle> treemap = new TreeMap<>();

		treemap.put(new Rectangle(20,20), new Rectangle(30,30));
		treemap.put(new Rectangle(10,10), new Rectangle(40,40));

		TreeSet<Rectangle> treeset = new TreeSet<>();

		treeset.add(new Rectangle(40,20));
		treeset.add(new Rectangle(10,10));
		treeset.add(new Rectangle(30,30));

		System.out.println(rec1);
		System.out.println(treemap);
		System.out.println(treeset);

		
		
	}

}
