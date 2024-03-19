import java.lang.Math.*;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Coordinate3d extends Coordinate2d{

    private int z;

    public Coordinate3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Coordinate2d convertTo2d(){
        return new Coordinate2d(this.getX(), this.getY());
    }

    public int getZ() {
        return z;
    }

    public Coordinate3d rotate(double A, double B, double C){
        int i = getX();
        int j = getY();
        int k = getZ();

        int newX = (int) (j * sin(A) * sin(B) * cos(C) - k * cos(A) * sin(B) * cos(C) +
                    j * cos(A) * sin(C) + k * sin(A) * sin(C) + i * cos(B) * cos(C));

        int newY = (int) (j * cos(A) * cos(C) + k * sin(A) * cos(C) -
                    j * sin(A) * sin(B) * sin(C) + k * cos(A) * sin(B) * sin(C) -
                    i * cos(B) * sin(C));

        int newZ = (int) (k * cos(A) * cos(B) - j * sin(A) * cos(B) + i * sin(B)) ;

        return new Coordinate3d(newX, newY, newZ+100);
    }


    public void setZ(int z) {
        this.z = z;
    }
}
