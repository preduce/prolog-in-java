import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;


public class Prolog<Variable> {
	private LinkedList<Clause> clauses;
	
	Prolog() {
		this.clauses = new LinkedList<Clause>();
	}
	
	public Clause add(Array term) {
		Clause single = new Clause(term);
		clauses.add(single);
		return single;
	}
	
	public Iterator<Map<Variable, Object>> ask() {
		throw new UnsupportedOperationException();
	}
}
