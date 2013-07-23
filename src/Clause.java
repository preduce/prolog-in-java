import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Clause<V> {
	private Prolog<V> program;
	private Term<V> leftTerm;
	private List<Term<V>> rightTerm;
	Clause(Prolog<V> program, Term<V> objects) {
		this.program = program;
		leftTerm = objects;
		rightTerm = new LinkedList<Term<V>>();
	}
	
	private boolean isSingleClause() {
		return rightTerm.isEmpty();
	}
	
	public Clause<V> impl(Term<V> term) {
		rightTerm.add(term);
		return this;
	}
	
	public Clause<V> _(Term<V> term) {
		rightTerm.add(term);
		return this;
	}
	private Iterator<Map<V,Object>> emptyIterator() {
		return (new LinkedList<Map<V,Object>>()).iterator();
	}
	private Iterator<Map<V,Object>> singleIterator(Environment<V> unified_env) {
		LinkedList<Map<V,Object>> list = new LinkedList<Map<V,Object>>();
		list.push((Map<V, Object>) unified_env);
		return list.iterator();
	}
	Iterator<Map<V,Object>> match(Term<V> t, Environment<V> env) {
		Environment<V> unified_env = leftTerm.unify(t, env);
		if (unified_env == null)
			return emptyIterator();
		if (isSingleClause())
			return singleIterator(unified_env);
		
		Anwser<V> ans = new Anwser<V>(this.program, unified_env);
		for (Term<V> question: this.rightTerm)
			ans.add_question(question);
		return ans;
	}
}
