
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InterleaveIterator<E> implements Iterator<E> {

  List<Iterator<E>> iters;

  public InterleaveIterator(List<Iterator<E>> iters) {
    this.iters = iters;
  }

  @Override
  public E next() {
    if (iters.isEmpty()) {
      return null;
    }
    Iterator<E> it = null;
    E elem = null;

    while (elem == null && !iters.isEmpty()) {
      it = iters.remove(0);
      if (it.hasNext()) {
        elem = it.next();
      }
    }

    if (it != null && it.hasNext()) {
      iters.add(it);
    }

    return elem;
  }

  @Override
  public boolean hasNext() {
    return !iters.isEmpty() && iters.get(0).hasNext();
  }

  public static void main(String[] args) {
    List<String> l1 = Arrays.asList("1", "2", "3");
    List<String> l2 = Arrays.asList("a", "b", "c", "d", "e");
    List<Iterator<String>> itlist = Lists.newArrayList(l1.iterator(), l2.iterator());

    InterleaveIterator<String> intit = new InterleaveIterator<>(itlist);

    while (intit.hasNext()) {
      System.out.println(intit.next());
    }
  }

}