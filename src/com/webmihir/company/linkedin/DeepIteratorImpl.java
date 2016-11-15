package com.webmihir.company.linkedin;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class DeepIteratorImpl<T> implements Iterator<T>
{
  private final Deque<Iterator<Data<T>>> sources = new LinkedList<Iterator<Data<T>>>(); // Will act as our stack
  private Iterator<Data<T>> lastSource = null; // only needed to implement remove()
  private boolean hasPeek = false; // this.next() should return this.peek
  private T peek;
  // A common mistake is to omit hasPeek, and use (peek == null) as a sentinel instead,
  // which won't handle a collection that contains a null element. It's a small mistake.

  public DeepIteratorImpl(Collection<Data<T>> root) {
    if (root != null)
      sources.push(root.iterator());
  }

  public boolean hasNext() {
    while (!hasPeek) {
      if (sources.isEmpty())
        return false;
      Iterator<Data<T>> source = sources.peek();
      if (!source.hasNext()) // we've exhausted this level
        sources.pop(); // go back up to the previous level (if any)
      else {
        Data<T> next = source.next();
        if (next.isCollection()) {
          sources.push(next.getCollection().iterator());
        } else {
          peek = next.getElement();
          hasPeek = true;
        }
      }
    }
    return true; // and hasPeek == true
  }

  public T next() {
    if (!hasNext())
      throw new NoSuchElementException();
    lastSource = sources.peek();
    hasPeek = false;
    return peek;
  }

  public void remove() {
    if (lastSource == null) // this.next() has never returned anything
      throw new IllegalStateException();
    lastSource.remove(); // may throw UnsupportedOperationException
  }
}
