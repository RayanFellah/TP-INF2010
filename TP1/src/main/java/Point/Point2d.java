package Point;

import java.util.Arrays;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    /** TODO
     * 2D Point Constructor from coordinates
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point2d(Double x, Double y) {
        super(new double[] {x, y});
    } // ajout des params

    /** TODO
     * 2D Point Constructor from vector
     * @param vector Vector containing X and Y coordinates
     */

    public Point2d(Double[] vector) {
        super(Arrays.stream(vector).mapToDouble(Double::doubleValue).toArray());
    }

    /**
     * @return X coordinate
     */
    public double X() { return vector[X];}

    /**
     * @return Y coordinate
     */
    public double Y() { return vector[Y];}

    /** TODO
     * Translate the point by the given vector
     * @param translateVector The vector by which to translate
     * @return Translated point
     */
    @Override
    public Point2d translate(Double[] translateVector) {
        PointOperator.translate(this.vector, translateVector);
        return this;
    }

    /** TODO
     * Translate the point by the given 2D Point
     * @param translateVector The 2D Point by which to translate
     * @return Translated point
     */
    public Point2d translate(Point2d translateVector) {
        PointOperator.translate(this.vector, translateVector.vector);
        return this;
    }

    /** TODO
     * Rotate the point by the given rotation Matrix
     * @param rotationMatrix Matrix by which to rotate
     * @return Rotated point
     */
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        PointOperator.rotate(this.vector, rotationMatrix);
        return this;
    }

    /** TODO
     * Rotate the point by the given angle
     * @param angle Angle in radians
     * @return Rotated point
     */


    public Double cos(Double angle){
        return Math.cos(angle);
    } //  je ne veux pas ecrire Math..... :D
    public Double sin(Double angle){
        return Math.sin(angle);
    }

    public Point2d rotate(Double angle) {
        Double ancienX = this.vector[X];
        Double ancienY = this.vector[Y];
        this.vector[X] = ancienX * this.cos(angle) - ancienY * this.sin(angle);
        this.vector[Y] = ancienX * this.sin(angle) + ancienY * this.cos(angle);

        return this;
    }

    /** TODO
     * Divide the X and Y coordinates of a 2D point by a scalar
     * @param divider Scalar used to divide
     * @return Divided point
     */
    @Override
    public Point2d divide(Double divider) {
        PointOperator.divide(this.vector, divider);
        return this;
    }

    /** TODO
     * Multiply the X and Y coordinates of a 2D point by a scalar
     * @param multiplier Scalar used to multiply
     * @return Multiplied point
     */
    @Override
    public Point2d multiply(Double multiplier) {
        PointOperator.multiply(this.vector, multiplier);
        return this;
    }

    /** TODO
     * Add a scalar to the X and Y coordinates of a 2D point
     * @param adder Scalar to add
     * @return Added point
     */
    @Override
    public Point2d add(Double adder) {
        PointOperator.add(this.vector, adder);
        return this;
    }

    /** TODO
     * @return Deep copy of the 2D point
     */
    @Override
    public Point2d clone() {
        /**J'utilise ici la fonction que j'ai implemente (duplicate) dans PointOperator
         cuz c vrm plus net comme ça ;D*
         */
        return new Point2d(PointOperator.dupliquer(this.vector));
    }
}
