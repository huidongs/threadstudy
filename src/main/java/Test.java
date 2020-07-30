import java.util.Scanner;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/30 14:38
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Data:");
        double l = sc.nextDouble();
        double w = sc.nextDouble();
        double r= sc.nextDouble();
        double side_len=sc.nextDouble();
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();
        Square square = new Square();
        rectangle.setRectangle(l,w);
        circle.setCircle(r);
        square.setSquare(side_len);
        System.out.println(rectangle.getArea());
        System.out.println(circle.getArea());
        System.out.println(square.getArea());
    }
}
class Shape{
    private double x,y;
    public double getArea(){
        return 0.00;
    }
}
class Rectangle extends Shape{
    private double x,y;
    public Rectangle(){
        super();
    }
    public void setRectangle(double x,double y){
        this.x=x;
        this.y=y;
    }
    public double getArea(){
        return x*y;
    }
}
class Square extends Rectangle{
    private double side_len;
    public Square(){
        super();
    }
    public void setSquare(double side_len){
        this.side_len=side_len;
    }
    public double getArea(){
        return side_len*side_len;
    }
}
class Circle extends Shape{
    private double radius;
    public Circle(){
        super();
    }
    public void setCircle(double r){
        radius = r;
    }
    public double getArea(){
        return 3.14*radius*radius;
    }
}
