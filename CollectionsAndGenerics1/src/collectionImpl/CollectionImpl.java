package collectionImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CollectionImpl<E> implements Collection<E> {
	List<E> l = new ArrayList<E>();


	@Override
	public int size() {
		return l.size();
	}

	@Override
	public boolean isEmpty() {
		return l.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return l.contains(o);
	}

	@Override
	public Object[] toArray() {
		return l.toArray();
	}

	@Override
	public boolean add(Object e) {
		if (l.contains(e) || e == null) {
			l.remove(e);
			return false;
		}
		else {
			l.add((E) e);
			return true;
		}
	}

	@Override
	public boolean remove(Object o) {
		return l.remove(o);
	}

	@Override
	public boolean containsAll(Collection c) {
		return l.containsAll(c);
	}

	@Override
	public boolean addAll(Collection c) {
		return l.addAll(c);
	}

	@Override
	public boolean removeAll(Collection c) {
		return l.removeAll(c);
	}

	@Override
	public boolean removeIf(Predicate filter) {
		return l.removeIf(filter);
	}

	@Override
	public boolean retainAll(Collection c) {
		return l.retainAll(c);
	}

	@Override
	public void clear() {
		l.clear();

	}

	@Override
	public void forEach(Consumer<? super E> action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return l.toArray(a);
	}

	@Override
	public Spliterator<E> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<E> stream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<E> parallelStream() {
		// TODO Auto-generated method stub
		return null;
	}

}
