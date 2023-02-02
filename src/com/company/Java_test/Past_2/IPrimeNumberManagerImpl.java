package com.company.Java_test.Past_2;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IPrimeNumberManagerImpl implements IPrimeNumberManager {

    private final IPrimeChecker iPrimeChecker;

    public IPrimeNumberManagerImpl(IPrimeChecker iPrimeChecker) {
        this.iPrimeChecker = iPrimeChecker;
    }

    public Stream<Boolean> arePrimes(int[] inputInts) {
        IntStream var10000 = Arrays.stream(inputInts);
        IPrimeChecker var10001 = this.iPrimeChecker;
        Objects.requireNonNull(var10001);
        return var10000.mapToObj(var10001::isPrime);
    }

    public Stream<Integer> primesOnly(Stream<Integer> inputInts) {
        IPrimeChecker var10001 = this.iPrimeChecker;
        Objects.requireNonNull(var10001);
        return inputInts.filter(var10001::isPrime);
    }

    public Integer maxPrime(Stream<Integer> inputInts) {
        IPrimeChecker var10001 = this.iPrimeChecker;
        Objects.requireNonNull(var10001);
        return inputInts.filter(var10001::isPrime).mapToInt((el) -> {
            return el;
        }).max().orElseThrow(NoSuchElementException::new);
    }

    static final class IPrimeCheckerImpl implements IPrimeChecker {
        IPrimeCheckerImpl() {
        }

        public boolean isPrime(int number) {
            if (number < 2) {
                return false;
            } else if (number % 2 == 0) {
                return number == 2;
            } else if (number % 3 == 0) {
                return number == 3;
            } else {
                for (int i = 5; i * i < number; i += 6) {
                    if (number % i == 0 || number % (i + 2) == 0) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    static final class EratosfenIPrimeImpl implements IPrimeChecker {
        EratosfenIPrimeImpl() {
        }

        public boolean isPrime(int number) {
            if (number < 2) {
                return false;
            } else {
                boolean[] isPrime = new boolean[number + 1];
                Arrays.fill(isPrime, true);

                for (int i = 2; i * i <= number; ++i) {
                    if (isPrime[i]) {
                        for (int j = i * 2; j <= number; j += i) {
                            isPrime[j] = false;
                        }
                    }
                }

                return isPrime[number];
            }
        }
    }
}
