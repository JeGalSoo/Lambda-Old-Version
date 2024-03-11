package com.turing.api.proxy;

import java.util.Objects;
import java.util.function.Function;

public class TypeProxy {
    public static Function<?,String> string2 = String::valueOf;
    public static Function<String,Integer> integer = Integer::valueOf;
    public static Function<String,Double> doubleof = Double::valueOf;
    public static Function<String,Float> floatof = Float::valueOf;
    public static Function<String,Long> longof = Long::valueOf;
    public static Function<String,Short> shortof = Short::valueOf;
    public static Function<String,Boolean> booleanof = Boolean::valueOf;

}
