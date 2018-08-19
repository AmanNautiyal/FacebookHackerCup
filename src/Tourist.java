/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman Nautiyal
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Tourist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        BufferedWriter prt=null;
        try {
            File infile=new File("tourist.txt");
            File outfile=new File("tourist_output.txt");
            prt = new BufferedWriter(new FileWriter(outfile));
            Scanner In=new Scanner(infile);
            int t=In.nextInt();
            int n,k;
            long v;
            String str,attractions[];
            for(int i=0;i<t;i++)
            {
                n=In.nextInt();
                k=In.nextInt();
                v=In.nextLong();
                In.nextLine();
                attractions=new String[n];
                for(int j=0;j<n;j++)
                    attractions[j]=In.nextLine();
                int no=(int)(((v-1)*k)%n);
                prt.write("Case #"+(i+1)+":");
                for(int j=0;j<=((no+k)-n-1);j++)
                    prt.write(" "+attractions[j]);
                int l;
                if((no+k)>(n-1))
                    l=n;
                else
                    l=no+k;
                for(int j=no;j<l;j++)
                    prt.write(" "+attractions[j]);
                prt.write("\n");
            } } catch (IOException ex) {
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
