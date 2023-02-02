package com.company.Java_test.Past_2;

import java.util.stream.Stream;

public interface IPrimeNumberManager {

    Stream<Boolean> arePrimes(int[] var1);

    Stream<Integer> primesOnly(Stream<Integer> var1);

    Integer maxPrime(Stream<Integer> var1);
}
