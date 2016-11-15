package com.webmihir.company.linkedin;

import java.util.Collection;


public interface Data<T> {
  // Does this Data hold a collection?
  public boolean isCollection();
  // Returns the collection contained by this Data, or null if it is a single element
  public Collection<Data<T>> getCollection();
  // Returns the single element contained by this Data, or null if it is a collection
  public T getElement();
}
