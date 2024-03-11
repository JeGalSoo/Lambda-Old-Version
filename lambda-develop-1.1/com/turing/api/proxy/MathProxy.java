package com.turing.api.proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    public static Function<Integer,Integer> absInt = Math::abs;
    public static Function<Double,Double> absDouble = Math::abs;
    public static Function<Long,Long> absLong = Math::abs;
    public static Function<Float,Float> absFloat = Math::abs;

    public static BiFunction<Integer,Integer,Integer> maxInt = Math::max;
    public static BiFunction<Double,Double,Double> maxDouble = Math::max;
    public static BiFunction<Long,Long,Long> maxLong = Math::max;
    public static BiFunction<Float,Float,Float> maxFloat = Math::max;

    public static BiFunction<Integer,Integer,Integer> minInt = Math::min;
    public static BiFunction<Double,Double,Double> minDouble = Math::min;
    public static BiFunction<Long,Long,Long> minLong = Math::min;
    public static BiFunction<Float,Float,Float> minFloat = Math::min;


    public static Supplier<Integer> ceilInteger = ()->(int)(Math.random());
//    public static Supplier<Long> ceilLong = Math::ceil;
//    public static Supplier<Double> ceilDouble = Math::ceil;
//    public static Supplier<Float> ceilFloat = Math::ceil;
////
//    public static Supplier<Integer> floorInteger = Math::floor;
//    public static Supplier<Long> floorLong = Math::floor;
//    public static Supplier<Double> floorDouble = Math::floor;
//    public static Supplier<Float> floorFloat = Math::floor;

//    public static Supplier<Integer> roundInteger = (a)->(int)(Math.round(a));
//    public static Supplier<Long> roundLong = (a)->(long)(Math.round(a));
//    public static Supplier<Double> roundDouble = Math::round;
//    public static Supplier<Float> roundFloat = Math::round;

    public static Supplier<Double> randomDouble = Math::random;

    public static BiFunction<Integer,Integer,Integer> randomInt = (a,b) -> (int)(Math.random()*(b-a));
    public static BiFunction<Long,Long,Long> randomLong = (a,b) -> (long)(Math.random()*(b-a));
    public static BiFunction<Float,Float,Float> randomFloat = (a,b) -> (float)(Math.random()*(b-a));

//    public static Parse
}