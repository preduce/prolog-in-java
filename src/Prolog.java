import java.util.Iterator;
import java.util.LinkedList;


public class Prolog<Variable> {
	private LinkedList<Clause<Variable>> clauses;
	
	Prolog() {
		this.clauses = new LinkedList<Clause<Variable>>();
	}
	
	public Clause<Variable> add(Term objects) {
		Clause<Variable> single = new Clause<Variable>(this, objects);
		clauses.add(single);
		return single;
	}
	
	public Anwser<Variable> ask(Term question) {
		return new Anwser<Variable>(this, question);
	}
	Iterator<Clause<Variable>> getIteratorator(){
		return clauses.iterator();
	}
}
