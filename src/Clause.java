import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Clause<V> {
	private Prolog<V> program;
	private Term leftTerm;
	private List<Term> rightTerm;
	Clause(Prolog<V> program, Term objects) {
		this.program = program;
		leftTerm = objects;
		rightTerm = new LinkedList<Term>();
	}
	
	private boolean isSingleClause() {
		return rightTerm.isEmpty();
	}
	
	public Clause<V> impl(Term term) {
		rightTerm.add(term);
		return this;
	}
	
	public Clause<V> _(Term term) {
		rightTerm.add(term);
		return this;
	}
	Iterator<Map<V,Object>> match(Term t) {
		// TODO
		return program.ask(t);
	}
}
