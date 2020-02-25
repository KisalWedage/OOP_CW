package lk.kisal.RentalStore.Comparator;

import lk.kisal.RentalStore.POJO.Vehical;

import java.util.Comparator;

public class IDComparator implements Comparator<Vehical> {
    @Override
    public int compare(Vehical o1, Vehical o2) {
        return o1.getMake().compareTo(o2.getMake());
    }

}
