package com.egg_gacha.converter;

public interface Converter<T,S> {
    T convert(S source);
    S reverse(T target);
}
