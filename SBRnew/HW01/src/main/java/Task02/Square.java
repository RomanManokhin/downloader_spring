package Task02;

public class Square implements Shape{

    private int width;

    public Square(int width) {
        this.width = width;
    }


    @Override
    public float getPerimeter() {
        return width * 4;
    }

    @Override
    public float getArea() {
        return (float)(Math.pow(width,2));
    }


}
