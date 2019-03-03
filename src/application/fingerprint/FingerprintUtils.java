package application.fingerprint;

public class FingerprintUtils
{
    public static Integer twinPrime(Integer fingerprint)
    {
        return isPrime(fingerprint) && (isPrime(fingerprint + 2) || isPrime(fingerprint - 2)) ? 1 : 0;
    }

    private static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)
        {
            return false;
        }
        if (n <= 3)
        {
            return true;
        }

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
        {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6)
        {
            if (n % i == 0 || n % (i + 2) == 0)
            {
                return false;
            }
        }

        return true;
    }

    private static boolean oneDigit(int num)
    {
        // comparison operation is faster than
        // division operation. So using following
        // instead of "return num / 10 == 0;"
        return (num >= 0 && num < 10);
    }


    private static boolean isPalUtil(int num,
        int dupNum)
    {
        if (oneDigit(num))
        {
            return (num == (dupNum) % 10);
        }

        if (!isPalUtil(num / 10, dupNum))
        {
            return false;
        }

        dupNum /= 10;
        return (num % 10 == (dupNum) % 10);
    }


    public static Integer primePalindrome(Integer fingerprint)
    {
        if (fingerprint < 0)
        {
            fingerprint = -fingerprint;
        }

        int dupNum = fingerprint;

        return isPalUtil(fingerprint, dupNum)?1:0;
    }

    public static Integer leftTrunctablePrime(Integer fingerprint)
    {
        int temp = fingerprint, cnt = 0, temp1;

        while (temp != 0)
        {

            cnt++;

            temp1 = temp % 10;

            if (temp1 == 0)
            {
                return 0;
            }
            temp = temp / 10;
        }

        boolean isPrime[] = new boolean[fingerprint + 1];
        sieveOfEratosthenes(fingerprint, isPrime);

        for (int i = cnt; i > 0; i--)
        {

            int mod = power(10, i);

            if (!isPrime[fingerprint % mod])
            {
                return 0;
            }
        }
        return 1;
    }

    private static int power(int x,
        int y)
    {
        if (y == 0)
        {
            return 1;
        } else if (y % 2 == 0)
        {
            return power(x, y / 2)
                * power(x, y / 2);
        } else
        {
            return x * power(x, y / 2)
                * power(x, y / 2);
        }
    }

    public static Integer rightTrunctablePrime(Integer fingerprint)
    {
        // Generating primes using Sieve
        if(fingerprint==0)return 0;
        boolean isPrime[] = new boolean[fingerprint + 1];
        sieveOfEratosthenes(fingerprint, isPrime);
        while (fingerprint != 0)
        {

            if (isPrime[fingerprint])
            {
                fingerprint = fingerprint / 10;
            } else
            {
                return 0;
            }
        }
        return 1;
    }

    public static Integer rhondaNumber(Integer fingerprint)
    {
        //TODO
        return 1;
    }

    private static void sieveOfEratosthenes
        (int n,
            boolean isPrime[])
    {

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++)
        {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++)
        {
            // If isPrime[p] is not
            // changed, then it
            // is a prime
            if (isPrime[p])
            {
                // Update all multiples of p
                for (int i = p * 2; i <= n; i += p)
                {
                    isPrime[i] = false;
                }
            }
        }
    }

}
