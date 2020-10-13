public class Square implements Shape, Shape2D {
    private double side;
    private String nameOfShape;

    public Square(double side){
        super();
        this.side = side;
        this.nameOfShape = "square";
    }

    public double getArea(){
        return side*side;
    }

    public String getName(){
        return nameOfShape;
    }
}
