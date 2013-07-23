import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Anwser<V> implements Iterator<Map<V,Object>> {

	protected Queue<Term<V>> questions = new PriorityQueue<Term<V>>();
	private Anwser<V> nextAnwser = null;
	private Term<V> question = null;
	private Prolog<V> program;
	private Environment<V> nextResult = null;
	private Iterator<Clause<V>> clauseIterator;
	private Iterator<Map<V, Object>> programIterator = null;
	private boolean isNextAnwser = false;
	private boolean endOfProgram = false;
	private Environment<V> currentEnv;
	
	Anwser(Prolog<V> program) {
		this.program = program;
		clauseIterator = program.getIteratorator();
		currentEnv = new Environment<V>();
	}
	
	Anwser(Prolog<V> program, Environment<V> env) {
		this.program = program;
		clauseIterator = program.getIteratorator();
		currentEnv = env;
	}
	
	Anwser<V> add_question(Term<V> question) {
		if (this.question == null)
			this.question = question;
		else
			questions.add(question);
		return this;
	}
	
	private boolean computeAnwser(){
		// Computes anwser and stores it in nextAnwser
		if (endOfProgram)
			return false;
		if (nextAnwser != null) {
			if (nextAnwser.hasNext()) {
				nextResult = nextAnwser.next();
				return true;
			} else {
				nextAnwser = null;
				return computeAnwser();
			}
		}
		
		if (programIterator == null) {
			// Computing the first anwser.
			if (clauseIterator.hasNext()) {
				Clause<V> nextClause = clauseIterator.next();
				programIterator = nextClause.match(question, currentEnv);
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
		Environment<V> firstAnwser = (Environment<V>) programIterator.next();
		if (this.questions.isEmpty()) {
			nextResult = firstAnwser;
		} else {
			//Next anwsers
			nextAnwser = new Anwser<V>(program, firstAnwser);
			for (Term<V> t: questions)
				nextAnwser.add_question(t);
			if (!nextAnwser.hasNext())
				return false;
			nextResult = nextAnwser.next();
		}
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
			return nextResult;
		isNextAnwser = false;
		if(!computeAnwser())
			throw new NoSuchElementException();
		return nextResult;
		
	}

	@Override
	public void remove() {
		return;
	}
}
