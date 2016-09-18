package ball;

import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

import java.util.Arrays;
import java.util.List;

public class World {

    public final Player player = new Player();
    public final List<Rectangle2D> boxes = Arrays.asList(new Rectangle2D(-150, -300, 300, 50));
    public final Point2D gravity = new Point2D(0, -0.8);
    public Point2D ioTug = Point2D.ZERO;
    private final Point2D NORMAL_UP = new Point2D(0, 1);

    public void physics(ActionEvent event) {
        player.velocity = player.velocity.add(ioTug.multiply(0.1));
        player.velocity = player.velocity.add(gravity.multiply(0.1));
        for(Rectangle2D box: boxes) {
            if(box.intersects(player.position)) {
                if(player.velocity.getY() < 0) {
                    player.velocity = reflect(player.velocity, NORMAL_UP);
                }
                break;
            }
        }
        Point2D vel = player.velocity.multiply(0.1);
        player.position = new Rectangle2D(
            player.position.getMinX() + vel.getX(),
            player.position.getMinY() + vel.getY(),
            player.position.getWidth(),
            player.position.getHeight()
        );
    }

    private static Point2D reflect(Point2D vector, Point2D normal) {
        return vector.subtract(normal.multiply(2 * vector.dotProduct(normal)));
    }

}
