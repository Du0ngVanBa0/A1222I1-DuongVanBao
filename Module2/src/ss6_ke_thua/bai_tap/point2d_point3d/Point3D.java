package ss6_ke_thua.bai_tap.point2d_point3d;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{getX(), getY(), z};
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }

    public static void main(String[] args) {
        Point3D p3 = new Point3D(3, 4, 5);
        System.out.println(p3);
        float[] f = p3.getXYZ();
        for (float i : f) {
            System.out.print(i + "  ");
        }
    }
}
