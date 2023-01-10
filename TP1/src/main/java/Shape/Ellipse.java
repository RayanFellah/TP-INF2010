package Shape;

import Point.Point2d;

import java.util.ArrayList;
import java.util.Collection;

public class Ellipse extends BaseShape {
    /** TODO
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        super();
        Double a = widthDiameter / 2.0;
        Double b = heightDiameter / 2.0;

        // x^2 / a + y^2 = 1;
        for(Double i = -a; i <= a; i += 0.5)
            for(Double  j = -b; j <= b; j+= 0.5)
                if(Math.pow(i, 2) / Math.pow(a, 2) + Math.pow(j, 2) / Math.pow(b, 2) <= 1)
                    this.add(new Point2d(i, j));

    }

    /** TODO
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());

    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    public Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    /** TODO
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone() {
        return (Ellipse) super.clone();
    }
}
