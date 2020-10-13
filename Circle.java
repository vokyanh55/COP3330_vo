public class Circle implements Shape, Shape2D{
    private double side;
    private String nameOfShape;

    public Circle (double side){
        super();
        this.side = side;
        this.nameOfShape = "circle";
    }

    public double getArea(){
        return Math.PI*side*side;
    }

    public String getName(){
        return nameOfShape;
    }
}
