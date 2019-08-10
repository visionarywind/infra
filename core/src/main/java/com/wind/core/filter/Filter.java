package com.wind.core.filter;

public interface Filter {

  String execute(Order order);

  void setNext(Filter filter);

  Filter getNext();

  Filter getLast();
}
