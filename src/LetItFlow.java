
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aman Nautiyal
 */
public class LetItFlow {

    /**
     * @param args the command line arguments
     */
    static int ways, n;
    static char house[][];
    static void compute(int i, int j, char or) {
        
        switch (house[i][j]) {
            
            case '#':
                ;//do nothing
                break;
            case '$':
                ways++;
                if (ways == 1000000007) {
                    ways = 0;
                }
                break;
            default:
                house[i][j] = '#';
                go_left:
                switch (or) {
                    case 'N':
                        compute( i, j - 1, 'W');
                        break;
                    case 'S':
                        compute( i, j + 1, 'E');
                        break;
                    case 'E':
                        compute( i - 1, j, 'N');
                        break;
                    case 'W':
                        compute( i + 1, j, 'S');
                        break;
                }
                go_right:
                switch (or) {
                    case 'N':
                        compute( i, j + 1, 'E');
                        break;
                    case 'S':
                        compute( i, j - 1, 'W');
                        break;
                    case 'E':
                        compute( i + 1, j, 'S');
                        break;
                    case 'W':
                        compute( i - 1, j, 'N');
                        break;
                }
                house[i][j] = '.';
                break;
        }
    }
    static void compute2()
    {
        for(int i=)
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(Br.readLine());
        String str;
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(Br.readLine());
            house = new char[5][n + 2];
            Arrays.fill(house[0], '#');
            Arrays.fill(house[4], '#');
            for (int j = 1; j <= 3; j++) {
                house[j][0] = '#';
                house[j][n + 1] = '#';
            }
            house[3][n + 1] = '$';
            ways = 0;
            for (int j = 1; j <= 3; j++) {
                str = Br.readLine();
                for (int k = 1; k <= n; k++) {
                    house[j][k] = str.charAt(k - 1);
                }
            }
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < n + 2; y++) {
                    System.out.print(house[x][y]);
                }
                System.out.println();
            }
            compute(1, 1, 'E');
            System.out.println("Case #" + (i + 1) + ": " + ways);
        }
    }
    //1,0,2,0,4,0,8,0,16,0,
}
