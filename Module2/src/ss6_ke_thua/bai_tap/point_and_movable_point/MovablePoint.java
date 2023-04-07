package ss6_ke_thua.bai_tap.point_and_movable_point;

public class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MovablePoint move() {
        setX(getX()+xSpeed);
        setY(getY()+ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY()
                + "), speed=(" + xSpeed + "," + ySpeed + ")";
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{xSpeed, ySpeed};
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint(10,10,1,1);
        System.out.println(mp);
        System.out.println(mp.move());
        System.out.println(mp.move());
        System.out.println(mp.move());
    }
}
