import javax.swing.*;
import java.awt.*;

public class TestIfInPlane {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.add(new A());

        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
