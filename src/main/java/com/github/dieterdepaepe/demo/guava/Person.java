package com.github.dieterdepaepe.demo.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Iterables;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        Preconditions.checkArgument(lastName.isEmpty());

        this.firstName = Preconditions.checkNotNull(firstName);
        this.lastName = lastName;
    }

    public Person(String fullname) {
        Iterable<String> namePieces = Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .split(fullname);
        this.firstName = Iterables.get(namePieces, 1);
        this.lastName = Iterables.get(namePieces, 0);
    }


    public int compareTo(Person o) {
        return ComparisonChain.start()
                .compare(firstName, o.firstName)
                .compare(lastName, o.lastName)
                .result();
    }

    @Override
    public String toString() {
        return Joiner.on(", ").join(lastName, firstName);
    }
}
