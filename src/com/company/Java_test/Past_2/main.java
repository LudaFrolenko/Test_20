package com.company.Java_test.Past_2;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class main {

    public main() {
    }

    public static void main(String[] args) {
        IPrimeNumberManager impl = new IPrimeNumberManagerImpl(new IPrimeNumberManagerImpl.EratosfenIPrimeImpl());
        int[] arrInt = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 89, 263, 300};
        Stream var10000 = impl.arePrimes(arrInt);
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
        System.out.println("-------------------------------");
        List<Integer> listOfIntegers = Arrays.asList(0, 1, 263, 3, 4, 56, 7, 89, 10);
        var10000 = impl.primesOnly(listOfIntegers.stream());
        var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
        System.out.println("-------------------------------");
        System.out.println(impl.maxPrime(listOfIntegers.stream()));
    }
}
