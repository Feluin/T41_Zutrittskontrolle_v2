import application.PasswordUtils;
import application.fingerprint.FingerprintUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class Passwordtest
{
    @Test
    void passwordtest()
    {

        Assertions.assertEquals(30119, PasswordUtils.lastPrimeFactor((new Date(1970, 1, 1)).getTime()));
        Assertions.assertEquals(17, PasswordUtils.sumPrimeFactors((new Date(1970, 1, 1)).getTime()));
    }

    @Test
    void fingerprinttest()
    {
        Assertions.assertEquals(1, (int) FingerprintUtils.rightTrunctablePrime(9137));
        Assertions.assertEquals(1, (int) FingerprintUtils.twinPrime(11));
        Assertions.assertEquals(1, (int) FingerprintUtils.leftTrunctablePrime(7393));
        Assertions.assertEquals(1, (int) FingerprintUtils.primePalindrome(191));
        Assertions.assertEquals(1, (int) FingerprintUtils.rhondaNumber(34));
    }
}
