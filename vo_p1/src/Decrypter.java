import java.util.Scanner;

public class Decrypter {
    public static int calculation ( int n )
    {
        if (n >= 7)
            return n-7;
        else
            return n+10-7;
    }

    public static String decrypt (String n)
    {
        int number = Integer.parseInt(n);

        int num1 = number % 10;
        number /= 10;
        num1 = calculation(num1);

        int num2 = number % 10;
        number /= 10;
        num2 = calculation(num2);

        int num3 = number % 10;
        number /= 10;
        num3 = calculation(num3);

        int num4 = number % 10;

        num4 = calculation(num4);

        String num1_str = String.valueOf(num1);
        String num2_str = String.valueOf(num2);
        String num3_str = String.valueOf(num3);
        String num4_str = String.valueOf(num4);

        return num2_str + num1_str + num4_str + num3_str;
    }

    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        String number = scanner.next();
        System.out.print(decrypt(number));
    }
}
