package com.solvd.travelagency.interfaces;

@FunctionalInterface
public interface ISearch<T> {
    boolean search(T t);
}
