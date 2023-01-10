package Letter;

import Interface.Transform;
import Point.Point2d;
import Shape.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public final class LetterFactory {
    final static Double maxHeight = 150.0; //hauteur max
    final static Double maxWidth = maxHeight / 2.5; // largeur max
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8; // la largeur dune bande de la lettre
    final static Double halfStripeThickness = stripeThickness / 2;

    final static Double zero = 0.0; // nous utilisons cette constante lors des translations pour fixer Y ou X a 0

    /** ATTENTION!!!!!!!!
     * I am creating this function to find the intersection
     * of two collections of base shapes return it,
     * it takes
     * @param first first BaseShape
     * @param second second BaseShape
     * @return collection representing the intersection of the two forms
     */
    public static Collection<Point2d> findInter(BaseShape first, BaseShape second){
        return first.getCoords().stream().distinct().filter(second.getCoords()::contains).collect(Collectors.toList());
    }

    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        // composants
        Transform tr = new Transform();

        double angle = 10; // cet angle vient d'un calcul trigonometrique
        double facteur = 1.5; // ce facteur vient ajouter de l'esthetique, obtenu par essai-erreur

        Rectangle brancheGauche = new Rectangle(halfStripeThickness, maxHeight);
        brancheGauche.rotate(brancheGauche.getCoords(),Math.toRadians(-angle));
        brancheGauche.translate(brancheGauche.getCoords(),new Point2d(stripeThickness * facteur, 0.0));

        Rectangle milieu = new Rectangle(halfMaxWidth - halfStripeThickness , halfStripeThickness  );
        milieu.translate(milieu.getCoords(),new Point2d(stripeThickness / 2, zero));

        Rectangle brancheDroite = new Rectangle(halfStripeThickness, maxHeight);
        brancheDroite.rotate(brancheDroite.getCoords(),Math.toRadians(angle));

        BaseShape monA = brancheDroite.add(brancheGauche).add(milieu);
        return monA;




    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {

        Transform tr = new Transform();
        Rectangle brGauche = new Rectangle(stripeThickness, maxHeight);
        Circle haut = new Circle(halfMaxHeight / 2);
        Circle bas = new Circle(halfMaxHeight / 2);
        Circle trou = new Circle((halfMaxWidth - halfStripeThickness / 2));

        //transformations
        haut.removeAll(trou.getCoords());
        bas.removeAll(trou.getCoords());
        brGauche.replaceAll(tr.translate(brGauche.cloneCoords(), new Point2d(-halfMaxWidth, zero)));
        haut.replaceAll(tr.translate(haut.cloneCoords(), new Point2d(zero, -halfMaxHeight/ 2)));
        bas.replaceAll(tr.translate(bas.cloneCoords(), new Point2d(zero, halfMaxHeight / 2)));

        BaseShape monB = new BaseShape();
        monB.addAll(brGauche.cloneCoords());
        monB.addAll(haut.cloneCoords());
        monB.addAll(bas.cloneCoords());

        return monB;
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {

        BaseShape monC = create_O();

        for(Point2d el: monC.getCoords())
            if((el.X() <= maxWidth && el.X() >= halfStripeThickness) && (el.Y() <= 2 * stripeThickness && el.Y() >= - 2 * stripeThickness ))
                monC.remove(el);

        return monC;

    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        Transform tr = new Transform();

        double facteur = 4.50; // ce facteur vient ajouter de l'esthetique, obtenu par essai-erreur

        Rectangle haut = new Rectangle(maxWidth, halfStripeThickness);
        Rectangle milieu = haut.clone();
        Rectangle bas = haut.clone();
        Rectangle brGauche = new Rectangle(halfStripeThickness, maxHeight);

        haut.replaceAll(tr.translate(haut.getCoords(), new Point2d(zero, halfMaxHeight )));
        bas.replaceAll(tr.translate(bas.getCoords(), new Point2d(zero, -halfMaxHeight )));
        brGauche.replaceAll(tr.translate(brGauche.getCoords(), new Point2d(-halfMaxWidth + facteur, zero)));

        BaseShape monE = new BaseShape();
        monE.add(brGauche);
        monE.add(haut);
        monE.add(bas);
        monE.add(milieu);

        return monE;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {

        Transform tr = new Transform();

        Rectangle brGauche = new Rectangle(stripeThickness, maxHeight);
        brGauche.replaceAll(tr.translate(brGauche.cloneCoords(), new Point2d(- halfMaxWidth, zero)));
        Rectangle brDroite = new Rectangle(stripeThickness, maxHeight);
        brDroite.replaceAll(tr.translate(brDroite.cloneCoords(), new Point2d( halfMaxWidth, zero)));
        Rectangle millieu = new Rectangle(maxWidth, stripeThickness );

        BaseShape monH = new BaseShape();
        monH.add(brDroite);
        monH.add(brGauche);
        monH.add(millieu);
        return monH;
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {

        Transform tr = new Transform();

        Rectangle brGauche = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle brDroite = brGauche.clone();
        Rectangle diagonale = new Rectangle(halfStripeThickness, maxHeight);
        double angle = Math.atan(maxWidth/ maxHeight);

        brGauche.replaceAll(tr.translate(brGauche.getCoords(), new Point2d(-halfMaxWidth, zero)));
        brDroite.replaceAll(tr.translate(brDroite.getCoords(), new Point2d(halfMaxWidth, zero)));
        diagonale.replaceAll(tr.rotate(diagonale.getCoords(), -angle));


        BaseShape monN = new BaseShape();
        monN.add(brGauche);
        monN.add(brDroite);
        monN.add(diagonale);

        return monN;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {

        Transform tr = new Transform();
        Ellipse right = new Ellipse(maxWidth, maxHeight);
        right.replaceAll(tr.translate(right.cloneCoords(), new Point2d(halfStripeThickness, zero)));
        Ellipse left = new Ellipse(maxWidth, maxHeight);
        left.replaceAll(tr.translate(left.cloneCoords(), new Point2d(-halfStripeThickness, zero)));


        // Maintenant je forme le 0 en enlevant le trou
        Ellipse mon0 = new Ellipse(maxWidth, maxHeight);
        mon0.removeAll(findInter(left, right));
        // jai utilise ma fonction findInter pour trouver lintersection des points entre les deux ellipse
        return (BaseShape) mon0;
    }
}
