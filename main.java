import java.util.*;
import java.text.*;
import java.io.*;
/**
 * Main class.
 * Will create Magic Square puzzles and check if puzzles are correct.
 * 
 * @author Nerissa Lemon & Rachel Smith 
 * @version 09/03/2016
 */


public class main
{
    // instance variables 
    private int x;
    
    /**
     * Main method. Will run the Magic Square program.
     */
    public static void main(String[] args){
        //test puzzles
        //3x3
        //4x4
        int[] puzz1 = {0,0,10,32,0,12,20,0,28,0,0,0,2,24,0,26};
        int magicNum1 = 68;
        int[] ansPuzz1 = {8,18,10,32,30,12,20,6,28,14,22,4,2,24,16,26};
        int[] puzz2 = {0,12,8,52,0,0,0,0,0,24,28,48,0,0,56,4};
        int magicNum2 = 136;
        int[] ansPuzz2 = {64,12,8,52,20,40,44,32,36,24,28,48,16,60,56,4};
        
        //Print puzzles 
        //4x4
        System.out.println("Puzzle 1 (4x4)");
        print4by4(puzz1);
        System.out.println("Puzzle 2 (4x4)");
        print4by4(puzz2);
        System.out.println("Answers: \n Puzzle 1 (4x4): \n");
        print4by4(ansPuzz1);
        System.out.println("Puzzle 2 (4x4)\n");
        print4by4(ansPuzz2);
        
        System.out.println("Puzzle Checker");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter 4 for 4x4 puzzle or 3 for 3x3 puzzle and press enter. ");
        String userChoice = keyboard.nextLine();
        System.out.println("Please enter the magic number for the puzzle.");
        String userMagicNumber = keyboard.nextLine();
        System.out.println("Please enter the path for your file containing your solution. ");
        String answerFile = keyboard.nextLine();
        
        //Get user file, read and store.
        File userFile = new File(answerFile);
        try{
            Scanner fileScanner = new Scanner (userFile);
            int[] userAnswer = new int [16];
            int j = 0;
            while (fileScanner.hasNextInt()){
                userAnswer[j] = fileScanner.nextInt();
                j++;
            }
            System.out.println("File input complete!");
        }
        catch(FileNotFoundException fe){
            System.out.println("File not found :(");
        }
        //Check if solution was correct and alert user. 
        
        
       
        
    }
    
    public static void print4by4(int[] arrToPrint){
        for(int i = 0; i < arrToPrint.length; i++){
                if(arrToPrint[i] == 0)
                    System.out.print(" _ ");
                else
                    System.out.print(" "+arrToPrint[i]+" ");
                
                if( i==3 || i == 7 || i == 11 || i == 15)
                   System.out.print("\n");
            }
    
    }

    /**
     * Constructor for objects of class main
     */
    public main()
    {
        // initialise instance variables
        x = 1;
        int y=1;
        if (!(x==0) && !(y==1)){
            System.out.println("&& logic worked");
            System.out.println("DIE HERE");
        }
        //else 
        if(!(x==0) || !(y==1)){
            System.out.println("|| logic worked");
            System.out.println("DIE HERE");
        }
        else{
            System.out.println("both params didn't pass");
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
