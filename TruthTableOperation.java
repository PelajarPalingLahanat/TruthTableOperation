/*

 byte  : [-128  _  127]
 short : [-32,768  _  32,767]
 int   : [-2,147,483,648  _  2,147,483,647]
 long  : [-9,223,372,036,854,775,808  _  9,223,372,036,854,775,807]

 */

 /*
    COVERS :

    1. AND
    2. NOT
    3. OR
    4. XOR

 */
 import java.util.*;
 import java.lang.*;
 public class TruthTableOperation {
     // + //
     static char orGate(char a,char b){
         if(a == '1' || b == '1') return '1';
         else return '0';
     }

     // x //
     static char andGate(char a,char b){
         if(a == '0' || b == '0') return '0';
         else return '1';
     }

     // ~ //
     static char notGate(char a){
         if(a == '1')return '0';
         else return '1';
     }

     // (+) //
     static char xorGate(char a,char b){
         if(a == b) return '0';
         else return '1';
     }
     static void exitThisShit(){
         System.out.println("\n\n\t\tInvalid Operation");
         System.out.println("\t\tProgram will now exit");
         System.out.println("\t\tThank you!\n\n\n\n");
         System.out.println("\t\t/$$$$$$$$ /$$   /$$ /$$$$$$ /$$$$$$$$");
         System.out.println("\t\t| $$_____/| $$  / $$|_  $$_/|__  $$__/");
         System.out.println("\t\t| $$      |  $$/ $$/  | $$     | $$   ");
         System.out.println("\t\t| $$$$$    \\  $$$$/   | $$     | $$   ");
         System.out.println("\t\t| $$__/     >$$  $$   | $$     | $$   ");
         System.out.println("\t\t| $$       /$$/\\  $$  | $$     | $$   ");
         System.out.println("\t\t| $$$$$$$$| $$  \\ $$ /$$$$$$   | $$   ");
         System.out.println("\t\t|________/|__/  |__/|______/   |__/   ");
         System.out.println("\n\n\t<< PROGRAM BY ARIF RAIHAN BIN AHMAD RIDZUAN @ ANAS  >>");

     }




     public static void main(String[] args){
         Scanner input = new Scanner(System.in);


         //VARIABLES DECLARATION

         int masuk,i,number,j;
         char operation ;
         String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

         System.out.print("Enter the amount of inputs : ");
         masuk = input.nextInt();

         //ARRAY DECLARATION
         int maxRow = (int)Math.pow(2,masuk);
         char[][] inputsArray = new char[maxRow][masuk];
         char[] result = new char[maxRow];
         for(i = 0; i < masuk;i++){
             System.out.print("_____");
         }
         System.out.println();
         for(i = 0; i < masuk; i++){
             System.out.print(alphabet.charAt(i) + "   |");
         }
         System.out.println();
         for(i = 0; i < masuk; i++){
             System.out.print("=====");
         }
         System.out.println();
         //FILLING THE ARRAY WITH CORRECT VALUE
         for(i = 0; i < maxRow;i++){
             number = i;
             for(j = 0; j < masuk;j++){
                 int currBaseValue = (int)Math.pow(2,masuk - 1 - j);
                 if(number >= currBaseValue){
                     inputsArray[i][j] = '1';
                     number = number - currBaseValue;
                 }
                 else inputsArray[i][j] = '0';

                 System.out.print(inputsArray[i][j] + "   |");
             }
             System.out.println();
         }

         for(i = 0; i < masuk;i++)System.out.print("=====");
         System.out.println();
         System.out.println("\n\n\nOperation available : ");
         System.out.println("1. AND <<2 GATE>>");
         System.out.println("2. OR  <<2 GATE>>");
         System.out.println("3. XOR <<2 GATE>>");
         System.out.println("4. NOT <<1 GATE>>\n\n");
         System.out.print("Enter the number ex. '1' for AND : ");
         operation = input.next().charAt(0);
         System.out.println("\n\n");
         if(operation < 49 || operation > 52){
             exitThisShit();
             System.exit(0);
         }
         //VARIABLES DECLARATION

         char arr1,arr2;
         int arrChoose,arrChoose1;
         char operateSymbol = 'n';
         if(operation == '1')operateSymbol = 'x';
         if(operation == '2')operateSymbol = '+';
         if(operation == '3')operateSymbol = '^';
         if(operation == '4')operateSymbol = '~';


         if(operation != '4'){
             System.out.print("Enter column 1 :");
             arr1 = input.next().toUpperCase().charAt(0);
             if(arr1 < 65 || arr1 > 65 - 1 + masuk){
                 exitThisShit();
                 System.exit(0);
             }
             System.out.print("Enter column 2 :");
             arr2 = input.next().toUpperCase().charAt(0);
             if(arr2 < 65 || arr2 > 65 - 1 + masuk){
                 exitThisShit();
                 System.exit(0);
             }
             System.out.println("\n\n");
             arrChoose = arr1 - 65;
             arrChoose1 = arr2 - 65;
            System.out.println("________________");
             System.out.printf("%c  |%c  |(%c%c%c)  |\n",arr1,arr2,arr1,operateSymbol,arr2);
            System.out.println("================");
             for(i = 0;i < maxRow;i++){
                 System.out.print(inputsArray[i][arrChoose] + "  |" + inputsArray[i][arrChoose1] + "  |  ");
                 if     (operation == '1'){result[i] = andGate(inputsArray[i][arrChoose],inputsArray[i][arrChoose1]);}
                 else if(operation == '2'){result[i] = orGate(inputsArray[i][arrChoose],inputsArray[i][arrChoose1]);}
                 else  {result[i] = xorGate(inputsArray[i][arrChoose],inputsArray[i][arrChoose1]);}
                 System.out.print(result[i]+"    |");
                 System.out.println();
             }
         }

        else {
             System.out.print("Enter a column : ");
             arr1 = input.next().toUpperCase().charAt(0);
             if(arr1 < 65 || arr1 > 65 - 1 + masuk){
                 exitThisShit();
                 System.exit(0);
             }
             arrChoose = arr1 - 65;
             System.out.println("_________");
             System.out.printf("%c  |(%c%c)|\n",arr1,operateSymbol,arr1);
             System.out.println("=========");
             for(i = 0; i < maxRow;i++){
             System.out.print(inputsArray[i][arrChoose] + "  |");
             result[i] = notGate(inputsArray[i][arrChoose]);
             System.out.println(result[i]+"   |");
            }
         }














     }
 }
