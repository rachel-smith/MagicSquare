import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.text.*;
import java.io.*;
/*
 * Main class.
 * Will create Magic Square puzzles and check if puzzles are correct.
 *
 * @author Nerissa Lemon & Rachel Smith
 * @version 09/03/2016
 * References: http://www.guideforschool.com/1280095-java-program-to-print-magic-square-matrix/
 *              Used for easy to follow algorithm to create magic square
 *
 *              http://mathworld.wolfram.com/MagicSquare.html
 *              Used to understand the  math behind magic squares
 */

public class main {

    public static void main(String[] args) throws IOException {
      
        System.out.println("Enter the dimension of the matrix (Odd dimension only): ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        if(n%2!=0) {
        int box[][]=new int[n][n];
        int firstEle=(int)(Math.random()*100);
        System.out.println("Enter the difficulty of your game: 1 for easy, 2 for challenging, 3 for hard ");
        BufferedReader levelBuffer= new BufferedReader(new InputStreamReader(System.in));
        int level = Integer.parseInt(levelBuffer.readLine());
        int difficulty;
        if (level ==1) {difficulty = 5;}
        else if (level ==2) {difficulty = 7;}
        else {difficulty = 8;}
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                box[i][j]=0;
            }
        }
        int row=0;
        int col=n/2;
        for (int p = 0; p < n*n; p++) {
                box[row][col]=firstEle;
                firstEle++;
                row--;
                col++;
                if(row==-1)
                   row=n-1;
                if(col==n)
                   col=0;
                if(row==n-1 && col==0)
                {
                    row=1;
                    col=n-1;
                }
              if((box[row][col]!=0)) {
                   row+=2;
                   col--;
                 if(row==-1) row=0;
                if(col==-1) col=0;
            }
        }
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date myDate = new Date();
            String fileName = dateFormat.format(myDate)+".txt";
            try{
                PrintWriter out = new PrintWriter(fileName);
                int magicNum = 0;
                
                for (int i = 0; i < n; i++){
                    magicNum += box[i][i];
                }

                out.print("Magic Square. Magic Number = " + magicNum+"\n");
                double width = n * 7;
                String longBar = "";
                while(width != 0){
                    longBar = longBar + "-";
                    width--;
                }
                
                out.print(longBar+"\n");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int num = (int)(Math.random()*10);
                        if(num <= difficulty){
                            if(box[i][j]/10==0)
                                out.print( "|     |");
                            else
                                out.print( "|     |");
                        }
                        else {
                            if(box[i][j]/10==0)
                                out.print( "|  "+box[i][j]+"  |");
                            else
                                out.print( "| "+box[i][j]+"  |");
                        }
                        
                    }
                    out.print("");
                    out.print("\n"+longBar+"\n");
                }
                
                out.flush();
                out.close();
                
                System.out.println("File " + fileName + " was succesfully created. It contains the puzzle you created.");
                
                
            }catch (FileNotFoundException fnfe){
                System.out.println("Something went wrong. Please restart program and try again.");
            }
           
            
        
    }
}
}
