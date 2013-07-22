import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Anwser<V> implements Iterator<Map<V,Object>> {
	private Prolog<V> program;
	private Term question;
	private Environment<V> nextAnwser;
	private Iterator<Clause<V>> clauseIterator;
	private Iterator<Map<V, Object>> programIterator;
	private boolean isNextAnwser;
	private boolean endOfProgram;
	
	Anwser(Prolog<V> program, Term question) {
		this.question = question;
		this.program = program;
		clauseIterator = program.getIteratorator();
		programIterator = null;
		nextAnwser = null;
		isNextAnwser = false;
		endOfProgram = false;
	}
	
	private boolean computeAnwser(){
		// Computes anwser and stores it in nextAnwser
		if(endOfProgram)
			return false;
		
		if (programIterator == null) {
			// Computing the first anwser.
			if (clauseIterator.hasNext()) {
				Clause<V> nextClause = clauseIterator.next();
				programIterator = nextClause.match(question);
				return computeAnwser();
			} else {
				endOfProgram = true;
				return false;
			}
		}
		if (!programIterator.hasNext()) {
			programIterator = null;
			return computeAnwser();
		}
		nextAnwser = (Environment<V>) programIterator.next();
		return true;
	}
	
	@Override
	public boolean hasNext() {
		if(isNextAnwser)
			return true;
		isNextAnwser = computeAnwser();
		return isNextAnwser;
	}

	@Override
	public Environment<V> next() {
		// Avoid computing anwser twice for hasNext
		// and Next();
		if(isNextAnwser)
			return nextAnwser;
		isNextAnwser = false;
		if(!computeAnwser())
			throw new NoSuchElementException();
		return nextAnwser;
		
	}

	@Override
	public void remove() {
		return;
	}
}
