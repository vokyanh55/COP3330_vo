import java.util.Scanner;
import java.util.ArrayList;


public class App
{
    //  NO MODIFICATION

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    //
    public static boolean moreInput ()
    {
        Scanner scanner = new Scanner (System.in);
        String str = scanner.next();
        char key = str.charAt(0);

        if (key == 'Y')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static double getUserHeight()
    {
        Scanner scanner = new Scanner (System.in);
        double height = scanner.nextDouble();
        if (height<0)
        {
            height = Math.abs(height);
        }
        return height;
    }

    public static double getUserWeight()
    {
        Scanner scanner = new Scanner (System.in);
        double weight = scanner.nextDouble();
        if (weight<0)
        {
            weight = Math.abs(weight);
        }
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex input)
    {
        System.out.println(input.getScore());
        System.out.println(input.getCategories());
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> input)
    {
        int length = input.size();


        double total=0;
        double average;

        for ( int i = 0; i < length; i++)
        {
            total = total + input.get(i).getScore();
        }

        average = total / length;
        System.out.print(average);
    }
}

