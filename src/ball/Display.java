package ball;

import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;

public class Display {

    public Camera camera = new PerspectiveCamera();
    private Sphere ball = new Sphere(10);
    private Box floor = new Box(300, 50, 40);
    private PointLight light = new PointLight(Color.WHITE);
    private AmbientLight ambientLight = new AmbientLight(Color.RED);
    private final Group player = new Group(ball, camera, light, ambientLight);
    private final Group level = new Group(player, floor);
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
        floor.setMaterial(new PhongMaterial(Color.GREEN));
        floor.setTranslateX(0);
        floor.setTranslateY(300 - 25);
    }

    public void animate(long now) {

        camera.setTranslateX(-levelScene.getWidth()/2);
        camera.setTranslateY(-levelScene.getHeight()/2);
        player.setTranslateX(world.position.getX());
        player.setTranslateY(-world.position.getY());
    }
}
