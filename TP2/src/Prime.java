public class Prime {
    private static boolean isPrime(int n ){
        if( n == 2 || n == 3 )
            return true;
        if( n == 1 || n % 2 == 0 )
            return false;
        for(int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;
        return true;
    }
    public static int nextPrime(int n ){

        if( n % 2 == 0 )
            n++;
        while(!isPrime(n))
            n+=2;

        return n;
    }

    public static int findMaxPrimeBefore(int ceil){
        if(ceil % 2 != 0)
            ceil -=2;
        if(ceil % 2 == 0)
            ceil--;
        while(ceil != 1 && !isPrime(ceil))
            ceil -= 2;
        return ceil;
    }
}

