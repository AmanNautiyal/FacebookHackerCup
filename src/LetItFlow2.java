
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aman Nautiyal
 */
public class LetItFlow2 {

    /**
     * @param args the command line arguments
     */
    static int n;
    static long ways;
    static char house[][];

    static void compute() {
       boolean top,bottom;
       int count=0;
      for(int x=1;x<n-2;x+=2)
      {
        top=true;
        bottom=true;
        if(house[0][x]=='#' || house[0][x+1]=='#')
            top=false;
         if(house[2][x]=='#' || house[2][x+1]=='#')
            bottom=false; 
         if(!top && !bottom)
         {
             ways=0;
             return;
         }
         if(!top || !bottom)
            count++;
      } 
      //System.out.println(count);
      ways=(long)Math.pow(2,(n/2)-1-count);
      ways=ways%1000000007;
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedWriter prt=null;
        try{
        File infile=new File("let_it_flow.txt");
            File outfile=new File("let_it_flow_output.txt");
            prt = new BufferedWriter(new FileWriter(outfile));
            Scanner In=new Scanner(infile);
        int t = In.nextInt();
        String str;
        for (int i = 1; i <= t; i++) {
            n = In.nextInt();
            In.nextLine();
            house = new char[3][n];
            ways = 0;
            for (int j = 0; j < 3; j++) {
                str = In.nextLine();
                for (int k = 0; k < n; k++) {
                    house[j][k] = str.charAt(k);
                }
            }
            boolean p = true;
            if(n%2!=0)
                p=false;
            if(house[0][0]=='#' ||house[2][n-1]=='#')
                p=false;
            for (int x = 1; x < n - 1 && p; x++) 
                if (house[1][x] == '#') 
                    p = false;
           
            if (p) 
                compute();
            prt.write("Case #" + i + ": " + ways+"\n");
        }
    }
        catch (IOException ex) {
            Logger.getLogger(Tourist.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                prt.close();
            } catch (IOException ex) {
                Logger.getLogger(Tourist.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
