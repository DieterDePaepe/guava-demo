package com.github.dieterdepaepe.demo.guava;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;
import com.google.common.collect.TreeTraverser;
import com.google.common.io.Files;
import com.google.common.io.LineReader;
import com.google.common.math.IntMath;
import sun.nio.cs.StandardCharsets;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;

public class VariaDemo {
    public static void main(String[] args) throws IOException {
        Strings.isNullOrEmpty("hello");
        String harharhar = Strings.repeat("har", 3);

        Files.copy(new File("a"), new File("b"));
        Files.newReader(new File("a"), Charsets.UTF_8);
        Files.getFileExtension("file.shp");

        IntMath.checkedAdd(0, 1);
        //IntMath.checkedAdd(Integer.MAX_VALUE, 1); //Exception!
        IntMath.sqrt(5, RoundingMode.UP);

        Range<Integer> range = Range.open(0, 5);
        range.contains(2); //True
        range.contains(0); //False
        range.intersection(Range.closed(1, 10)); // [1..5[

        final Multimap<Object, Object> tree = ArrayListMultimap.create();
        tree.put("root", "c1");
        tree.put("root", "c2");
        tree.put("root", "c3");
        tree.put("c2", "c21");
        tree.put("c2", "c22");
        TreeTraverser<Object> traverser = new TreeTraverser<Object>() {
            @Override
            public Iterable<Object> children(Object node) {
                return tree.get(node);
            }
        };

        traverser.breadthFirstTraversal("root");
        //root, c1, c2, c3, c21, c22
        traverser.preOrderTraversal("root");
        //root, c1, c2, c21, c22, c3
        traverser.postOrderTraversal("root");
        //c1, c21, c22, c2, c3, root
    }
}
