public class Cube implements Shape, Shape3D {
    private double side;
    private String nameOfShape;

    public  Cube(double side) {
        super();
        this.side = side;
        this.nameOfShape = "cube";
    }
    public double getArea(){
        return 6*side*side;
    }

    public String getName(){
        return nameOfShape;
    }

    public double getVolume(){
        return side*side*side;
    }
}
