package application;

import java.util.ArrayList;
import java.util.List;

public class PasswordUtils
{
    public static Integer lastPrimeFactor(long data){
        List<Long> longs = getprimeFactors(data);
        return longs.get(longs.size()-1).intValue();
    }
    public static Integer sumPrimeFactors(long data){
        return getprimeFactors(data).size();
    }
    private static List<Long> getprimeFactors(long data){
        List<Long> longs=new ArrayList<>();
        int i = 2;
        while (i< data)
        {
            while(data%i == 0) {
                longs.add(data);
                data = data/i;
            }
            i++;

        }
        if(data >2) {
            longs.add(data);
        }

    return longs;
    }

}
