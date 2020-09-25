package Task02;

public class Triangle implements Shape {

    private int a;
    private int b;
    private int c;
    private int height;
    private int width;

    public Triangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float getPerimeter() {
        return a + b + c;
    }

    @Override
    public float getArea() {
        return (float) (width * height / 2);
    }


}
