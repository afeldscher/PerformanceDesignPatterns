package com.aff39;

// Adam Feldscher
// 10/9/2019
// I699
// Prime number test
// references: https://www.geeksforgeeks.org/c-program-to-check-whether-a-number-is-prime-or-not/
// Their algorithm actually is incorrect, because they do sqrt(n) and /2. Need to just do 1. Use 10 as example.

// The purpose of this program is to demonstrate run times using a prime finding algorithm.
// This is NOT an optimal implementation for finding primes, however we are trying to compare
// run times using the same algorithm so it will not matter.


public class Main {

    public static void main(String[] args) {
        Integer max_prime = 10000; // Correct up through 1013
        Integer num_primes_found = 0;
        Integer max_iter = 40;

        System.out.println("iter, ns, sec, primes found");

        for (Integer iter = 0; iter < max_iter; iter++) {
            Long start_time = System.nanoTime();

            PrimeFinder primeFinder = new PrimeFinder(iter, max_prime);
            num_primes_found = primeFinder.find_primes();

            Long end_time = System.nanoTime();
            System.out.println(iter + ", " + (end_time - start_time) + ", " + (end_time - start_time) / 1e9 + ", " + num_primes_found);
        }

    }
}
