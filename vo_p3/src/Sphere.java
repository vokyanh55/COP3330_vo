import java.text.DecimalFormat;

public class Sphere implements Shape, Shape3D {
    private double radius;
    private String nameOfShape;

    public Sphere(double radius){
        super();
        this.radius = radius;
        this.nameOfShape = "sphere";
    }

    public String getName(){
        return nameOfShape;
    }

    public double getArea(){
        DecimalFormat number1 = new DecimalFormat("####0.00");
        return Double.parseDouble(number1.format(4*Math.PI * radius * radius));
    }

    public double getVolume(){
        DecimalFormat number2 = new DecimalFormat("####0.00");
        return Double.parseDouble(number2.format((1.333333333333)*(Math.PI)*(radius*radius*radius)));
    }
}

