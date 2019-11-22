import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] results = new int[0][3];
        switch(args.length) {
            case 0:
                results = pushToArray( results, rectangle(20,30));
                results = pushToArray( results, rectangle(40,50));
                results = pushToArray( results, rectangle(100,150));
                results = pushToArray( results, rectangle(30,64));

                results = pushToArray( results, square(60));
                results = pushToArray( results, square(50));
                results = pushToArray( results, square(20));
                results = pushToArray( results, square(645));

                break;
            case 1:
                results = pushToArray( results, square(Integer.parseInt(args[0])));
                break;
            case 2:
                results = pushToArray( results,rectangle(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
                break;

        }

        System.out.println("Type 'square' or 'rectangle' for new objects 'exit' to exit or 'print' to print all previous");

        do {
            String action = sc.nextLine();
            switch (action){
                case "rectangle": results = pushToArray( results, rectangle()); break;
                case "square": results = pushToArray( results, square());; break;
                case "print": print(results); break;
                case "help": System.out.println("Type 'square' or 'rectangle' for new objects 'exit' to exit or 'print' to print all previous"); break;
                case "exit": return;
                default: System.out.println("Type 'help' to see all commands again");
            }
        }while (true);

    }

    private static int calcRectangleArea(int width, int height){
        return width*height;
    }

    private static int calcRectanglePerimeter(int a, int b){
        return 2*a+2*b;
    }

    private static int squareArea( int width){
        return calcRectangleArea(width,width);
    }

    private static int squarePerimeter( int width ){
        return calcRectanglePerimeter(width,width);
    }

    private static int[] square(int width){
        int area = squareArea(width);
        int perimeter = squarePerimeter(width);
        int[] value = {1, area, perimeter};

        System.out.println("Area is " + area + "cm²");
        System.out.println("Perimeter is " + perimeter + "cm");

        return value;
    }

    private static int[] rectangle(int width, int height){
        int area = calcRectangleArea(width,height);
        int perimeter = calcRectanglePerimeter(width, height);
        int[] value = {0, area, perimeter};

        System.out.println("Area is " + area + "cm²");
        System.out.println("Area is " + perimeter + "cm");

        return value;
    }

    private static int[] square(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give width");
        int width = sc.nextInt();

        int area = squareArea(width);
        int perimeter = squarePerimeter(width);
        int[] value = {1, area, perimeter};

        System.out.println("Area is " + area + "cm²");
        System.out.println("Perimeter is " + perimeter + "cm");

        return value;
    }
    private static int[] rectangle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give width");
        int width = sc.nextInt();
        System.out.println("Give height");
        int height = sc.nextInt();

        int area = calcRectangleArea(width,height);
        int perimeter = calcRectanglePerimeter(width, height);
        int[] value = {0, area, perimeter};

        System.out.println("Area is " + area + "cm²");
        System.out.println("Perimeter is " + perimeter + "cm");

        return value;
    }

    private static int[][] pushToArray(int[][] old, int[] newEntry){
        int[][] newArray = new int[ old.length + 1 ][3];
        for(int i=0; i<old.length; i++){
            newArray[i] = old[i];
        }
        newArray[old.length] = newEntry;

        return newArray;
    }

    private static void print(int[][] array){
        for(int i=0; i < array.length; i++){
            switch (array[ i ][ 0 ]){
                case 0: System.out.println("Rectangle:"); break;
                case 1: System.out.println("Square:"); break;
            }
            System.out.println("\tArea: " + array[ i ][ 1 ]);
            System.out.println("\tPerimeter: " + array[ i ][ 2 ] +"\n");
        }
    }

}
