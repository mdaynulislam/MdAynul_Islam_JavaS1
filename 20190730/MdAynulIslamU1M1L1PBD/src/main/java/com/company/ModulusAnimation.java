package com.company;

public class ModulusAnimation {

    public static void main( String[] args ) throws Exception
    {
        for ( int i=0; i<80; i++ )
        {
            if ( i%5 == 0 )
                System.out.print("           ~-~-~-~-       \n");
            else if ( i%5 == 1 )
                System.out.print("         ~-~-~-~-         \n");
            else if ( i%5 == 2 )
                System.out.print("     ~-~-~-~-             \n");
            else if ( i%5 == 3 )
                System.out.print(" ~-~-~-~-                 \n");
            else if ( i%5 == 4 )
                System.out.print("   ~-~-~-~-               \n");
            else if ( i%5 == 5 )
                System.out.print("       ~-~-~-~-           \n");
            else if ( i%5 == 6 )
                System.out.print("    ~-~-~-~-              \n");
            else if ( i%5 == 7 )
                System.out.print("  ~-~-~-~-                \n");
            else if ( i%5 == 8 )
                System.out.print(" ~-~-~-~-                 \n");
            else if ( i%5 == 9 )
                System.out.print("       ~-~-~-~-           \n");
            else if ( i%5 == 10 )
                System.out.print("           ~-~-~-~-       \n");
            else if ( i%5 == 11 )
                System.out.print("        ~-~-~-~-          \n");
            else if ( i%5 == 12 )
                System.out.print("     ~-~-~-~-             \n");
            else if ( i%5 == 13 )
                System.out.print("  ~-~-~-~-                \n");
            else if ( i%5 == 14 )
                System.out.print("     ~-~-~-~-             \n");
            else if ( i%5 == 15 )
                System.out.print("          ~-~-~-~-         \n");

            Thread.sleep(200);
        }
    }
}
