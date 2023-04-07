package ss6_ke_thua.bai_tap.point_and_movable_point;

public class Point {
    private float x;
    private float y;

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{x, y};
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

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

    public static void main(String[] args) {
        Point p = new Point(10,20);
        System.out.println(p);
        for(float x:p.getXY()){
            System.out.println(x);
        }
    }
}
