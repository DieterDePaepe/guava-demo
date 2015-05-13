package com.github.dieterdepaepe.demo.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;

public class FunctionPredicateDemo {
    public static void main(String[] args) {
        Predicate<String> isVowel = Predicates.in(ImmutableList.of("a", "e", "i", "o", "u"));


        Function<String, String> firstLetter = new Function<String, String>() {
            public String apply(String input) {
                return input.substring(0, 1);
            }
        };

        Function<String, Boolean> isVowelFunction = Functions.forPredicate(isVowel);
        Function<String, Boolean> composedFunction = Functions.compose(isVowelFunction, firstLetter);

        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        ImmutableMap<String, Boolean> map =
                Maps.toMap(fruits, composedFunction);
        Functions.forMap(map, "a");
    }
}
