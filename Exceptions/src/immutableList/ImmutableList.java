package immutableList;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class ImmutableList<E extends Serializable> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;

	public ImmutableList(Collection<? extends E> collection)
			throws ImmutableException {
		Iterator<? extends E> iter = collection.iterator();
		while (iter.hasNext()) {
			this.add(iter.next());
		}
	}

	public void addElement(E element) throws ImmutableException {
		throw new ImmutableException("Can't add an element. I'm immutable");
	}

	public void removeElement(E element) throws ImmutableException {
		throw new ImmutableException("Can't remove an element. I'm immutable");
	}

	@SuppressWarnings("unchecked")
	public E getElement(int index) {
		Object clone = SerializationUtils.clone(this.get(index));
		return (E) clone;
	}

	@SuppressWarnings("unchecked")
	@SafeVarargs
	public static <E extends Serializable> ImmutableList<Integer> asList(
			E... arguments) throws ImmutableException {
		List<E> list = new ArrayList<E>();
		for (int i = 0; i < arguments.length; i++) {
			list.add(arguments[i]);
		}
		ImmutableList<E> inst = new ImmutableList<E>(list);
		return (ImmutableList<Integer>) inst;
	}

	public static void main(String[] args) throws ImmutableException {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(6);
		list.add(7);

		ImmutableList<Integer> inst = new ImmutableList<Integer>(list);

		for (int i = 0; i < inst.size(); i++) {
			System.out.println(inst.get(i));
		}
		
		inst = ImmutableList.asList(5, 6, 7);

		for (int i = 0; i < inst.size(); i++) {
			System.out.println(inst.get(i));
		}

	}
}
