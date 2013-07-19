import java.util.Iterator;
import java.util.Map;



public class Main {

	public static void main(String [ ] args){
		Prolog<Character> p = new Prolog<Character>();
		
		p.add(Term.t("F", 1));
		p.add(Term.t("F", 2));
		p.add(Term.t("F", 'X')).impl(Term.t("G",'X'))._(Term.t("H",'X'));
		p.add(Term.t("G", 10));
		p.add(Term.t("H", 10));
		
		Iterator<Map<Character, Object>> it = p.ask(Term.t());
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
