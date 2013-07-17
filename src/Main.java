import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;



public class Main {

	public static void main(String [ ] args){
		System.out.println("asdf");
		List<Integer> s = new LinkedList<Integer>();
		s.add(10);
		s.add(20);
		s.add(30);
		Iterator<Integer> it = s.iterator();
		
		System.out.println(it.next());
		System.out.println(it.next());
		it.next();
		it.next();
	}
}
