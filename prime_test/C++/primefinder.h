#pragma once

class PrimeFinder 
{
private:
    int _max_prime;

public:
    PrimeFinder(int max_prime);
    int find_primes();
};

