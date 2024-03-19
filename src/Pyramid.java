import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pyramid extends JPanel implements ActionListener {

    private int x = 600;
    private int y = 600;

    private int angle = 0;

    double a = Math.toRadians(60);
    private double[] vertices = {
            -Math.cos(a), -Math.cos(a), -Math.sin(a), //Q3
            -Math.cos(a), -Math.cos(a), Math.sin(a), //Q2
            Math.cos(a), -Math.cos(a), Math.sin(a), //Q1
            Math.cos(a), -Math.cos(a), -Math.sin(a), //Q4
            0, Math.sin(a), 0
    };

    private int[] indices = {
            0, 1, 4,
            1, 2, 4,
            2, 3, 4,
            3, 0, 4,
            3, 2, 1,
            2, 1, 4
    };

    private Color [] colors = {
            Color.CYAN,
            Color.RED,
            Color.YELLOW,
            Color.BLUE,
            Color.decode("066055255"),
            Color.decode("066055255")
    };

    private int mul = 200;

    private int updateMS = 20;
    private int tick = 1;
    Timer timer = new Timer(updateMS, this);
    public Pyramid (){
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < indices.length; i+=3){
            int[] iIndices = {indices[i], indices[i+1], indices[i+2]};
            //System.out.println("Trying to draw triangle i: " + i + " indices: " + Arrays.toString(iIndices));
            drawTriangle(g, get3Point(iIndices), colors[i/3]);
            //System.out.println("Print next");
        }

        g.drawArc(300, 300, 10, 10, 0, 360);
        //System.out.println("Loop ended");
    }

    public Coordinate3d[] get3Point (int[] indices){
        Coordinate3d[] xyz = new Coordinate3d[3];
        for (int i = 0; i < 3; i++){
            xyz[i] = new Coordinate3d((int) (vertices[indices[i]*3]*mul), (int) (vertices[indices[i]*3+1]*mul), (int) (vertices[indices[i]*3+2]*mul)).rotate(Math.toRadians(angle/2), Math.toRadians(angle/3), Math.toRadians(angle));
        }
        return xyz;
    }
    public void drawTriangle(Graphics g, Coordinate3d[] vertices, Color color){

        int[] xC = new int[3];
        int[] yC = new int[3];

        for (int i = 0; i < 3; i++){
            int z = vertices[i].getZ();
            //double ooz = (double) 1/z;
            double ooz = (double) 1/40;
            xC[i] = (int) (vertices[i].convertTo2d().getX() * ooz * 40 ) + x/2;
            yC[i] = (int) (-vertices[i].convertTo2d().getY() * ooz * 40 ) + y/2;
        }
        //System.out.println("Printing: " + Arrays.toString(xC) + Arrays.toString(yC));
        //g.setColor(color);
        //g.fillPolygon(xC, yC, xC.length);
        g.drawPolygon(xC, yC, xC.length);
    }

    public double getMul() {
        return mul;
    }

    public void setMul(int mul) {
        this.mul = mul;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        angle += tick;
    }
}
