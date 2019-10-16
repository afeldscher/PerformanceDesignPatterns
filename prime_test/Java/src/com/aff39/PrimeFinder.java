package com.aff39;

import static java.lang.Math.sqrt;

public class PrimeFinder {
    private Integer iter;
    private Integer max_prime;

    public PrimeFinder(Integer iter, Integer max_prime) {
        this.iter = iter;
        this.max_prime = max_prime;
    }

    public Integer find_primes() {
        Integer num_primes_found = 0;

        for (Integer n = 2; n <= max_prime; n++) {
            //This will get floored. Its ok, because if the integer above the sqrt is a divisor,
            // the other integer divisor would have had to have been below the sqrt
//            Integer max_divisor = (int) sqrt(n);
            Boolean is_prime = true;

            for (Integer i = 2; i <= (int) sqrt(n); i++) {
                if (n % i == 0) {
                    is_prime = false;
                    break;
                }
            }

            if (is_prime) {
                num_primes_found++;
            }
        }

        return num_primes_found;
    }
}
