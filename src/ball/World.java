package ball;

import javafx.event.ActionEvent;
import javafx.geometry.Point2D;

public class World {

    public Point2D position = new Point2D(100, -100);

    public Point2D velocity = new Point2D(0, 0);

    public Point2D gravity = new Point2D(0, -0.8);
    public Point2D ioTug = Point2D.ZERO;

    public void physics(ActionEvent event) {
        velocity = velocity.add(ioTug.multiply(0.1));
        velocity = velocity.add(gravity.multiply(0.1));
        if (position.getY() < -250) {
            Point2D normal = new Point2D(0, 1);
            position = new Point2D(position.getX(), -250);
            velocity = velocity.subtract(normal.multiply(2 * velocity.dotProduct(normal)));
        }

        position = position.add(velocity.multiply(0.1));
    }

}
