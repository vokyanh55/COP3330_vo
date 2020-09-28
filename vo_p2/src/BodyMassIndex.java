public class BodyMassIndex{
    public double score;
    public double x,y;
    public BodyMassIndex(double height, double weight)
    {
        x = weight;
        y = height;
        calculateBMI();
    }

    public double calculateBMI ()
    {
        double inches = Math.pow(y,2);
        double result = 703 * x / inches;
        score = result;
        return result;
    }

    public String getCategories ()
    {

        if (score < 18.5)
        {
            return ("Underweight < 18.5");
        }
        else if (score >= 18.5 && score <= 24.9)
        {
            return("Normal weight = 18.5–24.9");
        }
        else if (score >= 25 && score <= 29.9)
        {
            return("Overweight = 25–29.9");
        }

        return("Obesity >= 30");
    }

    public double getScore()
    {
        return score;
    }
}