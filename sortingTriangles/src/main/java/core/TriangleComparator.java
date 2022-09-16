package core;

import java.util.Comparator;

public class TriangleComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle t1, Triangle t2) {
        if (t1.calculateAreaByHeron(t1.getFirstSide(),
                t1.getSecondSide(),
                t1.getThirdSide()) <
                t2.calculateAreaByHeron(t2.getFirstSide(),
                t2.getSecondSide(),
                t2.getThirdSide())) {
            return 1;
        }
        else if (t1.calculateAreaByHeron(t1.getFirstSide(),
                t1.getSecondSide(),
                t1.getThirdSide()) >
                t2.calculateAreaByHeron(t2.getFirstSide(),
                        t2.getSecondSide(),
                        t2.getThirdSide())) {
            return -1;
        }
        return 0;
    }
}
