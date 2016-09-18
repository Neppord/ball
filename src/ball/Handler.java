package ball;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;

public class Handler {


    private final World world;

    private final Point2D upTug = new Point2D(0, 0.1);
    private final Point2D downTug = new Point2D(0, -0.1);
    private final Point2D leftTug = new Point2D(-0.1, 0);
    private final Point2D rightTug = new Point2D(0.1, 0);

    public Handler(World world) {
        this.world = world;
    }

    public void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case D:
            case RIGHT: world.ioTug = rightTug; break;
            case A:
            case LEFT: world.ioTug = leftTug; break;
        }
    }

    public void handleKeyReleased(KeyEvent keyEvent) {
        world.ioTug = Point2D.ZERO;
    }
}
