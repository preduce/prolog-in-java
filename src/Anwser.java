import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Anwser<V> implements Iterator<Map<V,Object>> {
	private Prolog<V> program;
	private Term question;
	private Environment<V> nextAnwser;
	private boolean isNextAnwser;
	private boolean endOfProgram;
	
	Anwser(Prolog<V> program, Term question) {
		this.question = question;
		this.program = program;
		nextAnwser = null;
		isNextAnwser = false;
		endOfProgram = false;
	}
	
	private boolean computeAnwser(){
		// Computes anwser and stores it in nextAnwser
		if(endOfProgram)
			return false;
		
		endOfProgram = true;
		return false;
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
		Environment<V> ret = new Environment<V>();
		/*
		if(isNextAnwser)
			return nextAnwser;
		isNextAnwser = false;
		if(!computeAnwser())
			throw new NoSuchElementException();
		return nextAnwser;
		*/
	}

	@Override
	public void remove() {
		return;
	}
}
