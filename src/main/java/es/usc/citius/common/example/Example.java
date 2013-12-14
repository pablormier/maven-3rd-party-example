package es.usc.citius.common.example;


import es.usc.citius.common.parallel.Parallel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Example {

    public static void main(String[] args){
        Set<String> elements = new HashSet<String>(Arrays.asList("A", "B", "C", "D"));
        Parallel.ForEach(elements, new Parallel.Action<String>() {
            @Override
            public void doAction(String s) {
                System.out.println("Processing element " + s + " on thread " + Thread.currentThread().getName());
            }
        });
    }
}
