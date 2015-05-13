package com.github.dieterdepaepe.demo.guava;


import com.google.common.collect.ImmutableList;

import java.util.Comparator;

public class OrderingDemo {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Wayne");
        Person person2 = new Person("Clark", "Kent");

        com.google.common.collect.Ordering<Person> ordering = new MyOrdering();
        Comparator<Person> comparator = ordering;

        // This is all we can do
        comparator.compare(person1, person2);

        ImmutableList<Person> people = ImmutableList.of(person1, person2);
        ordering.max(people);
        ordering.greatestOf(people, 2);
        ordering.nullsFirst().sortedCopy(people);
        ordering.isStrictlyOrdered(people);
    }

    private static class MyOrdering extends com.google.common.collect.Ordering<Person> {
        @Override
        public int compare(Person left, Person right) {
            return left.compareTo(right);
        }
    }
}
