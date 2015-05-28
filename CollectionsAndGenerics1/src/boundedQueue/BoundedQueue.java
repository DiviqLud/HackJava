package boundedQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BoundedQueue implements Queue<Integer>{
	Queue<Integer> q;
	private int size;
	
	public BoundedQueue(int size) {
		q = new LinkedList<Integer>();
		this.size = size;
	}
	
	@Override
	public int size() {
		return q.size();
	}

	@Override
	public boolean isEmpty() {
		return q.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return q.contains(o);
	}

	@Override
	public Iterator<Integer> iterator() {
		return q.iterator();
	}

	@Override
	public Object[] toArray() {
		return q.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return q.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		return q.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return q.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		return q.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return q.removeAll(c);
	}

	@Override
	public boolean removeIf(Predicate<? super Integer> filter) {
		return q.removeIf(filter);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return q.retainAll(c);
	}

	@Override
	public void clear() {
		q.clear();
		
	}

	@Override
	public Spliterator<Integer> spliterator() {
		return q.spliterator();
	}

	@Override
	public Stream<Integer> stream() {
		return q.stream();
	}

	@Override
	public Stream<Integer> parallelStream() {
		return q.parallelStream();
	}

	@Override
	public void forEach(Consumer<? super Integer> action) {
		q.forEach(action);
		
	}

	@Override
	public boolean add(Integer e) {
		return q.add(e);
	}

	@Override
	public boolean offer(Integer e) {
		if (size() < this.size) {
			q.offer(e);
		}
		else {
			q.poll();
			q.offer(e);
		}
		return true;
	}

	@Override
	public Integer remove() {
		return q.remove();
	}

	@Override
	public Integer poll() {
		return q.poll();
	}

	@Override
	public Integer element() {
		return q.element();
	}

	@Override
	public Integer peek() {
		return q.peek();
	}

	public void printElements() {
		int x;
		while (size() != 0) {
			x = q.element();
			System.out.print(x + " ");
			q.poll();
		}
	}
	
	
	
	

}
