import java.util.HashMap;
import java.util.Map;


public class Environment<V> extends HashMap<V, Object> {
	private static final long serialVersionUID = 1L;
	private static long nextVariableNumber = 0;
	private Map<Integer, Object> map = new HashMap<Integer, Object>(); 
	

}
