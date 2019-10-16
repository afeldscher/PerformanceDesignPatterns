#pragma once

class PrimeFinder 
{
private:
    int _max_prime;
    bool is_prime(int n);

public:
    PrimeFinder(int max_prime);
    int find_primes();
};

