package com.application.mapper;

public interface Mapper<E, D> {
    D map(E entity);
    Class<? extends E> getMyClass();
}