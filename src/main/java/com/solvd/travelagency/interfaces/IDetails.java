package com.solvd.travelagency.interfaces;

@FunctionalInterface
public interface IDetails<T, R> {
    R getDetail(T t);
}
