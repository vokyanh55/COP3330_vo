public class Triangle implements Shape, Shape2D{
    private double base;
    private double height;
    private String nameOfShape;

    public Triangle (double base, double height){
        super();
        this.base = base;
        this.height = height;
        this.nameOfShape = "triangle";
    }

    public double getArea(){
        return (base * height) / 2;
    }

    public String getName(){
        return nameOfShape;
    }
}
