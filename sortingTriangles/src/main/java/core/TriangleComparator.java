package core;

import java.util.Comparator;

public class TriangleComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle t1, Triangle t2) {
        if (t1.getArea() < t2.getArea()) {
            return 1;
        }
        else if (t1.getArea() > t2.getArea()) {
            return -1;
        }
        return 0;
    }
}
