package Point;

public final class PointOperator {

    /** TODO
     * Translates a vector of size N by another vector of size N
     * Similar to adding two vector of size N together
     * @param vector Vector to translate
     * @param translateVector Translation to apply
     */
    public static void translate(Double[] vector, Double[] translateVector) {
       if(vector.length != translateVector.length)
           throw new ArrayIndexOutOfBoundsException("Les vecteurs ne sont pas de meme dimension");
        for (int i = 0; i < vector.length; i++)
            vector[i] += translateVector[i];

    }

    /** TODO
     * Rotates a vector of size N by a matrix of size N x N
     * Similar to a matrix vector multiplication
     * @param vector Vector to rotate
     * @param rotationMatrix Matrix by which to rotate
     *
     */


    /** Note
     * Adding this function with
    @param vecteurACopier to @return a vector
    deepCopy way, I did not want to use Arrays.Copy to
     demonstrate my understanding of a deep copy.
     */

    public static Double[] dupliquer(Double[] vecteurACopier){
        Double[] nouveauVecteur = new Double[vecteurACopier.length];
        for(int i = 0; i < vecteurACopier.length; i++)
            nouveauVecteur[i] = vecteurACopier[i];
        return nouveauVecteur;
    }

    public static void rotate(Double[] vector, Double[][] rotationMatrix) {
        Double[] ancienVecteur = dupliquer(vector);
        for(int i = 0; i < vector.length; i++)
            for(int j = i + 1; j < vector.length; j++) {
                vector[i] = ancienVecteur[i] * rotationMatrix[i][i] + ancienVecteur[j] * rotationMatrix[i][j];
                vector[j] = ancienVecteur[i] * rotationMatrix[j][i] + ancienVecteur[j] * rotationMatrix[j][j];
            }
    }

    /** TODO
     * Divide a vector of size N by a scalar
     * @param vector Vector to divide
     * @param divider Scalar by which to divide
     */
    public static void divide(Double[] vector, Double divider) {
        if(divider.equals(0.0))
            throw new ArithmeticException("Division par 0");

        for (int i = 0; i < vector.length; i++)
            vector[i] /= divider;

    }

    /** TODO
     * Multiply a vector of size N by a scalar
     * @param vector Vector to multiply
     * @param multiplier Scalar by which to multiply
     */
    public static void multiply(Double[] vector, Double multiplier) {
        for(var i = 0; i < vector.length; i++)
            vector[i] *= multiplier;
    }

    /** TODO
     * Add a scalar to a vector of size N
     * @param vector Vector that we have to add to
     * @param adder Scalar to add to vector
     */
    public static void add(Double[] vector, Double adder) {
        for(var i = 0; i < vector.length; i++){
            vector[i] += adder;
        }
    }
}
