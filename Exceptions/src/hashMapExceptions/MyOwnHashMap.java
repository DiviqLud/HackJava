package hashMapExceptions;

import java.util.HashMap;
import java.util.Map;

public class MyOwnHashMap extends HashMap {

	private static final long serialVersionUID = 1L;
	private boolean flag;
	private Map<Object, Object> map = new HashMap<>();

	public MyOwnHashMap() {
		flag = false;
	}

	public MyOwnHashMap(boolean flag) {
		setFlag(flag);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public Object put(Object key, Object value) throws hashMapException {
		if (!flag) {
			throw new hashMapException();
		}
		else {
			return map.put(key, value);
		}
	}

	@Override
	public Object get(Object key) throws hashMapException {
		if (!flag) {
			throw new hashMapException();
		} else {
			return map.get(key);
		}

	}

}
