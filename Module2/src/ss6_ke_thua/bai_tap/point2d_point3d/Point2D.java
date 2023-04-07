package ss6_ke_thua.bai_tap.point2d_point3d;

public class Point2D {
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{x, y};
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    public static void main(String[] args) {
        Point2D p2 = new Point2D(3,4);
        System.out.println(p2);
    }
}
