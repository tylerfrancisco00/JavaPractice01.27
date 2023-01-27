package src;

import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class Demo 
{
    abstract void driving();
    abstract void riding();

    public static void main(String args[])
    {
        Demo thingWithWheels;
        Scanner keyboard = new Scanner(System.in);
        int wheels = 0;
        do
        {
            try
            {
            System.out.println("please enter a number of wheels");
            wheels = keyboard.nextInt();
            if (wheels <= 0)
            {
                throw new IllegalArgumentException();
            }


            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter a valid number and try again.");
                keyboard.nextLine();
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Please enter a number greater than zero.");
                keyboard.nextLine();
            }
        }       
        while (wheels == 0);  

        if (wheels < 4)
        {
            thingWithWheels = new Bike();
            thingWithWheels.riding();

        }
        else
        {
            thingWithWheels = new Car();
            thingWithWheels.driving();
        }

        keyboard.close();
    }
}