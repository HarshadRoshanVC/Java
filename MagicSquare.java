import java.util.Scanner;
public class MagicSquare {
 
    public static void main(String[] args) {
        int n = 3;
        Scanner sc=new  Scanner(System.in);
        char choice='n';
        do{
            System.out.print("Enter the size of magic sqaure (positive & odd):");
            n=sc.nextInt();
            if(n%2==0 || n<0){
                System.out.println("INPUT ERROR!!! Invalid size");
                continue;
            } 
            System.out.println("The magic sqaure with size = "+n+" is:");
            for (int[] row : magicSquareOdd(n)) {
                for (int x : row)
                    System.out.format("%2s ", x);
                System.out.println();
            }
            System.out.printf("The "+n+"x"+n+" magic square adds up to %d \n", (n * n + 1) * n / 2);
            System.out.print("Do you want to continue (Y/N):");
            choice=sc.next().charAt(0);
        }while(choice=='y' || choice=='Y');
        
    }
 
    public static int[][] magicSquareOdd(final int base) {
 
        int[][] grid = new int[base][base];
        int r = 0, number = 0;
        int size = base * base;
 
        int c = base / 2;
        while (number++ < size) {
            grid[r][c] = number;
            if (r == 0) {
                if (c == base - 1) {
                    r++;
                } else {
                    r = base - 1;
                    c++;
                }
            } else {
                if (c == base - 1) {
                    r--;
                    c = 0;
                } else {
                    if (grid[r - 1][c + 1] == 0) {
                        r--;
                        c++;
                    } else {
                        r++;
                    }
                }
            }
        }
        return grid;
    }
}
