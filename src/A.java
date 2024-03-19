import javax.swing.*;
import java.awt.*;

public class A extends JPanel {

    Coordinate3d c1 = new Coordinate3d(200, 0, 500);
    Coordinate3d c2 = new Coordinate3d(600, 0, 500);
    Coordinate3d c3 = new Coordinate3d(0, 0, 100);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    void generatePlane(Coordinate3d a, Coordinate3d b, Coordinate3d c){

    }
}
