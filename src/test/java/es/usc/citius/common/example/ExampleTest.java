package es.usc.citius.common.example;


import es.usc.citius.common.parallel.Parallel;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void simpleTest(){
        Set<String> elements = new HashSet<String>(Arrays.asList("A", "B", "C", "D"));
        final Set<String> processed = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());
        Parallel.ForEach(elements, new Parallel.Action<String>() {
            @Override
            public void doAction(String s) {
                System.out.println("Processing element " + s + " on thread " + Thread.currentThread().getName());
                processed.add(s);
            }
        });
        assertEquals(elements, processed);
    }
}
