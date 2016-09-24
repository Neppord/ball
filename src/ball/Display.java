package ball;

import javafx.geometry.Point3D;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;

public class Display {

    public Camera camera = new PerspectiveCamera();
    private Sphere ball = new Sphere(10);
    private PointLight light = new PointLight(Color.WHITE);
    private AmbientLight ambientLight = new AmbientLight(Color.WHITE);
    private final Group player = new Group(ball, camera, light, ambientLight);
    private final Group ground = new Group();
    private final Group level = new Group(player, ground);
    public Scene levelScene = new Scene(level, 1280, 720, true, SceneAntialiasing.BALANCED);

    private final World world;

    public Display(final World world) {
        this.world = world;
        camera.setRotationAxis(new Point3D(1, 0, 0));
        camera.setRotate(-22.5);
        levelScene.setCamera(camera);
        ball.setMaterial(new PhongMaterial(Color.RED));
        ball.setTranslateX(-5);
        ball.setTranslateY(-5);
        for(Rectangle2D box: world.boxes) {
            Box floor = new Box(
                    box.getWidth(),
                    box.getHeight(),
                    40
            );
            floor.setMaterial(new PhongMaterial(Color.GREEN));
            floor.setTranslateX(box.getMinX() + (box.getWidth() / 2));
            floor.setTranslateY(-box.getMinY() - (box.getHeight() / 2));
            ground.getChildren().add(floor);
        }
    }

    public void animate(long now) {
        if (world.ioTug.getY() < 0) {
            ball.setMaterial(new PhongMaterial(Color.ORANGE));
        } else {
            ball.setMaterial(new PhongMaterial(Color.RED));
        }
        camera.setTranslateX(-levelScene.getWidth()/2);
        camera.setTranslateY(-levelScene.getHeight()/2);
        player.setTranslateX(world.player.position.getMinX());
        player.setTranslateY(-world.player.position.getMinY());
    }
}
