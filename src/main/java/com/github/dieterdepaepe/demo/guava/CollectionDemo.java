package com.github.dieterdepaepe.demo.guava;

import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.*;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        Iterable<Integer> integers = Arrays.asList(1, 2, 3);
        boolean allArePositive = Iterables.all(integers, new IsPositive());

        Iterable<Double> doubles = Arrays.asList(-3., -1.5, 1.5, 3.);
        Iterable<? extends Number> numbers = Iterables.concat(integers, doubles);

        Iterables.contains(numbers, 1);
        Iterables.getLast(numbers);
        Iterables.filter(numbers, new IsPositive());
        Iterable<? extends List<? extends Number>> partition = Iterables.partition(numbers, 2);


        Lists.newArrayList();
        Lists.newArrayList(1, 2, 3);
        Lists.newArrayList(numbers);
        Lists.reverse(Lists.charactersOf("Hello"));
        //Collections.reverse();


        Set<String> set1 = Sets.newHashSet("a", "b");
        Set<String> set2 = Sets.newHashSet("b", "c");
        Sets.union(set1, set2);
        Sets.difference(set1, set2);
        Set<List<String>> cartProduct = Sets.cartesianProduct(set1, set2);
        //[a, b], [a, c], [b, b], [b, c]
        Set<Set<String>> powerSet = Sets.powerSet(set1);
        //[], [a], [b], [a, b]


        Maps.newHashMap();
        Maps.toMap(Arrays.asList(1, 2), Functions.toStringFunction());
        // [1->"1", 2->"2"]


        ListMultimap<String, Integer> listMultimap = ArrayListMultimap.create();
        listMultimap.put("a", 1);
        listMultimap.put("a", 2);
        listMultimap.size(); // 2
        listMultimap.get("b"); //empty list
        listMultimap.keySet(); // [a]
        listMultimap.keys(); // [a, a]
        Map<String, Collection<Integer>> stringCollectionMap = listMultimap.asMap();
        Map<String, List<Integer>> stringListMap = Multimaps.asMap(listMultimap);


        SetMultimap<String, Integer> setMultimap = HashMultimap.create();
        setMultimap.put("a", 1);
        setMultimap.put("a", 2);
        //...
        Map<String, Collection<Integer>> stringCollectionMap1 = setMultimap.asMap();
        Map<String, Set<Integer>> stringSetMap = Multimaps.asMap(setMultimap);




        ImmutableList.of("a", "b");
        ImmutableList.copyOf(Arrays.asList("a", "b"));
        ImmutableList.builder()
                .add("a")
                .add("b")
                .build();
        //ImmutableSet, ImmutableMap is similar


        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("a", 1);
        BiMap<Integer, String> inverse = biMap.inverse();


        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("a", "b", 1);


        Collection<List<String>> permutations = Collections2.permutations(Arrays.asList("a", "b", "c"));
//        [a, b, c]
//        [a, c, b]
//        [c, a, b]
//        [c, b, a]
//        [b, c, a]
//        [b, a, c]

        Collection<String> strings1 =
                Collections2.transform(ImmutableSet.of("a", 1), Functions.toStringFunction());
    }

    private static class IsPositive implements Predicate<Number> {

        public boolean apply(Number number) {
            return number.doubleValue() >= 0;
        }
    }
}
