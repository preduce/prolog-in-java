import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Array;

public class Clause {
	private Array leftTerm;
	private List<Array> rightTerm;
	Clause(Array term) {
		leftTerm = term;
		rightTerm = new LinkedList<Array>();
	}
	
	private boolean isSingleClause() {
		return rightTerm.isEmpty();
	}
	
	public Clause impl(Array term) {
		rightTerm.add(term);
		return this;
	}
	
	public Clause _(Array term) {
		rightTerm.add(term);
		return this;
	}
}
