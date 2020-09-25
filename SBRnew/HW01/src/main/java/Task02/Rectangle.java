package Task02;

public class Rectangle implements Shape {

    private int height;
    private int width;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(){

    }


    @Override
    public float getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public float getArea() {
        return width * height;
    }



}
