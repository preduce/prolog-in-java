import java.util.Iterator;
import java.util.LinkedList;


public class Prolog<V> {
	private LinkedList<Clause<V>> clauses;
	
	Prolog() {
		this.clauses = new LinkedList<Clause<V>>();
	}
	
	public Clause<V> add(Term<V> objects) {
		Clause<V> single = new Clause<V>(this, objects);
		clauses.add(single);
		return single;
	}
	
	public Anwser<V> ask(Term<V> question) {
		return (new Anwser<V>(this)).add_question(question);
	}
	Iterator<Clause<V>> getIteratorator(){
		return clauses.iterator();
	}
}
