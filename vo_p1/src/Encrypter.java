import java.util.Scanner;
public class Encrypter {
    public static String encrypt(String n)
    {
        //  n = "1234"
        int number = Integer.parseInt(n);   // Converse string to integer

        int num1 = number%10;               //  num1 = 4
        number /= 10;

        int num2 = number%10;               //  num2 = 3
        number /= 10;

        int num3 = number%10;               //  num3 = 2
        number /= 10;

        int num4 = number%10;               //  num4 = 1

        //  n = 1234

        num1 = (num1 + 7) % 10;             //  1
        num2 = (num2 + 7) % 10;             //  0
        num3 = (num3 + 7) % 10;             //  9
        num4 = (num4 + 7) % 10;             //  8

        String num1_str = String.valueOf(num1);
        String num2_str = String.valueOf(num2);
        String num3_str = String.valueOf(num3);
        String num4_str = String.valueOf(num4);

        return num2_str + num1_str + num4_str + num3_str;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String number =  scanner.next();
        System.out.print(encrypt(number));
    }
}
