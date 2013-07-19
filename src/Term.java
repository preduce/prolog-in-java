
public class Term {
	private Object[] array;
	
	public Environment<Object> unify(Term term1, Term term2, Environment<Object> env) {
		return env;
	}
	
	public Object[] getObjectArray(){
		return array;
	}
	
	public static Term t() {
		return new Term();
	}
	public static Term t(Object a) {
		return new Term(a);
	}
	public static Term t(Object a, Object b) {
		return new Term(a,b);
	}
	public static Term t(Object a, Object b, Object c) {
		return new Term(a,b,c);
	}
	public static Term t(Object a, Object b, Object c, Object d) {
		return new Term(a,b,c,d);
	}
	public static Term t(Object a, Object b, Object c, Object d,
			Object e) {
		return new Term(a,b,c,d,e);
	}
	public static Term t(Object a, Object b, Object c, Object d,
			Object e, Object f) {
		return new Term(a,b,c,d,e,f);
	}
	public static Term t(Object a, Object b, Object c, Object d,
			Object e, Object f, Object g) {
		return new Term(a,b,c,d,e,f,g);
	}
	public Term() {
		array = new Object[]{};
	}
	public Term(Object a) {
		array = new Object[]{a};
	}
	public Term(Object a, Object b) {
		array = new Object[]{a,b};
	}
	public Term(Object a, Object b, Object c) {
		array = new Object[]{a,b,c};
	}
	public Term(Object a, Object b, Object c, Object d) {
		array = new Object[]{a,b,c,d};
	}
	public Term(Object a, Object b, Object c, Object d, Object e) {
		array = new Object[]{a,b,c,d,e};
	}
	public Term(Object a, Object b, Object c, Object d, Object e,
				Object f) {
		array = new Object[]{a,b,c,d,e,f};
	}
	public Term(Object a, Object b, Object c, Object d, Object e,
			Object f, Object g) {
		array = new Object[]{a,b,c,d,e,f,g};
	}
}
