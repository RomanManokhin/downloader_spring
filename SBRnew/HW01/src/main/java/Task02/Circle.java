package Task02;

public class Circle implements Shape{

    final static float PI = (float) Math.PI;
    float r;

    public Circle(float r) {
        this.r = r;
    }

    @Override
    public float getPerimeter() {
        return 2 * PI * r;
    }

    @Override
    public float getArea() {
        return (float) (PI * Math.pow(r,2));
    }
}
