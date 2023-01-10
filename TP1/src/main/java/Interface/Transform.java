package Interface;

import Point.Point2d;

import java.util.Collection;
import java.util.stream.Collectors;

public class Transform implements Rotate, Translate{
    /** TODO
     * Rotate all points of collections given in parameters
     * with the angle given
     * @param coords collections of Point2d
     * @param angle angle of rotation
     * @return rotated collection
     * */
    public Collection<Point2d> rotate(Collection<Point2d> coords, Double angle) {

        return coords.stream().map(point -> point.rotate(angle)).collect(Collectors.toList());
    }

    /** TODO
     * Translate all points of a collection by a given vector
     * @param coords Collection of Point2d
     * @param translateVector Vector of translation
     * @return translated coords
     * */
    public Collection<Point2d> translate(Collection<Point2d> coords, Point2d translateVector) {

        coords.stream().forEach(el -> el.translate(translateVector));
        return coords;
    }
}
