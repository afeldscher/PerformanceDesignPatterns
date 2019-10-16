package com.aff39;

import static java.lang.Math.sqrt;

public class PrimeFinder {
    private Integer iter;
    private Integer max_prime;

    public PrimeFinder(Integer iter, Integer max_prime) {
        this.iter = iter;
        this.max_prime = max_prime;
    }

    private Boolean is_prime(Integer n) {
        Integer max_divisor = (int) sqrt(n);
        for (Integer i = 2; i <= max_divisor; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public Integer find_primes() {
        Integer num_primes_found = 0;

        for (Integer n = 2; n <= max_prime; n++) {
            if (is_prime(n)) {
                num_primes_found++;
            }
        }

        return num_primes_found;
    }
}
