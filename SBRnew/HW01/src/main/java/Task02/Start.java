package Task02;

public class Start {
    public static void main(String[] args) {

        Shape square = new Square(4);
        System.out.println(square.getArea());
        System.out.println(square.getPerimeter());

        Shape rectangle = new Rectangle(3,2);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        Shape triangle = new Triangle(4,2);
        Shape triangle1 = new Triangle(4,2,3);
        System.out.println(triangle.getArea());
        System.out.println(triangle1.getPerimeter());

        Shape circle = new Circle(5);
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());

    }
}
