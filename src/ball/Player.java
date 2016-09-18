package ball;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class Player {
    public Rectangle2D position = new Rectangle2D(100, -100, 10, 10);
    public Point2D velocity = new Point2D(0, 0);

    public void move () {
        position = new Rectangle2D(
                position.getMinX() + velocity.getX(),
                position.getMinY() + velocity.getY(),
                position.getWidth(),
                position.getHeight()
        );
    }
}
