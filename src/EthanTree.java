
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aman Nautiyal
 */
public class EthanTree {

    /**
     * @param args the command line arguments
     */
    static int arr[][];
    static int n,k,pre,post;
    static int preorder[],postorder[],groups[];
    static void preorder_traverse(int i)
    {
       preorder[pre++]=i;
       if(arr[0][i]!=0)
           preorder_traverse(arr[0][i]);
       if(arr[1][i]!=0)
           preorder_traverse(arr[1][i]);
    }
    static void postorder_traverse(int i)
    {
       if(arr[0][i]!=0)
           postorder_traverse(arr[0][i]);
       if(arr[1][i]!=0)
           postorder_traverse(arr[1][i]);
       postorder[post++]=i;
    }
    static int nosets()
    {
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        HashSet<Integer> a,b;
        int x,y;
        for(int i=0;i<n;i++)
        {
            x=preorder[i];
            y=postorder[i];
          if(!list.isEmpty())
          {
              a=null;
              for(HashSet mem:list)
                  if(mem.contains(x))
                  {
                      a=mem;break;
                  }
              b=null;
              for(HashSet mem:list)
                  if(mem.contains(y))
                  {
                      b=mem;break;
                  }
              if(a==null && b==null)
              {
                  HashSet<Integer> temp=new HashSet<>();
                  temp.add(x);
                  temp.add(y);
                  list.add(temp);
              }
              else if(a==null)
              {
                 b.add(x);
              }
              else if(b==null)
              {
                  a.add(y);
              }
              else if(!(a.equals(b)))
              {
                  a.addAll(b);
                  list.remove(b);
              }
          }
        }
        return list.size();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner Sc = new Scanner(System.in);
        int t = Sc.nextInt();
        Sc.nextLine();
        for (int i = 0; i < t; i++) {
            n = Sc.nextInt();
            k = Sc.nextInt();
             preorder=new int[n];
            postorder=new int[n];
            groups=new int[n];
            pre=0;
            post=0;
            arr=new int[2][n+1];
            for(int j=1;j<=n;j++)
            {
                arr[0][j]=Sc.nextInt();
                arr[1][j]=Sc.nextInt();
            } 
            preorder_traverse(1);
            postorder_traverse(1);
            for(int j:preorder)
                System.out.print(j+" ");
            System.out.println();
            for(int j:postorder)
                System.out.print(j+" ");
            int x=nosets();
            System.out.println(x);
       }
    }
}
