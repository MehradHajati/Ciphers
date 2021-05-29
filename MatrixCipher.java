// Matrix Cipher
// Mehrad Hajati
// 2021/05/29
// This program encrypts a message using the MATRIX and LETTERS constants.
// Encryption Part: this part of the program find the row and column of each letter of the message on the MATRIX. 
// Aftter finding the row and column it turns those two number from 1-6 into one of the LETTERS and it ouputs the message in code.
// Decryption Part: This part uses the LETTERS to find the row and column number for each charracter then uses the MATRIX to find the original message.


import java.util.*;

public class MatrixCipher{

    public static final char[][] MATRIX = {{'0', '1', '2', '3', '4', '5'}, 
                                            {'6', '7', '8', '9', 'a', 'b'},
                                            {'c', 'd', 'e', 'f', 'g', 'h'},
                                            {'i', 'j', 'k', 'l', 'm', 'n'},
                                            {'o', 'p', 'q', 'r', 's', 't'},
                                            {'u', 'v', 'w', 'x', 'y', 'z'}};
    public static final String LETTERS = "abcdef";

    public static void main(String[] args){

        // Introduction
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to encrypt or decrypt?");
        String answer = sc.next();
        while (!(answer.equals("encrypt") || (answer.equals("decrypt")))){
            System.out.println("Please try again!");
            System.out.println("Would you like to encrypt or decrypt?");
            answer = sc.next();
        }

        // Encrypting Part
        if (answer.equals("encrypt")){
            System.out.println("Please type the message you would like to encrypt:");
            sc.nextLine();
            String[] message = (sc.nextLine().toLowerCase()).split(" ");
            int numwords = message.length;
            String code = "";
            for (int i = 0; i < numwords; i++){
                int numletters = message[i].length();
                for (int j = 0; j < numletters; j++){
                    char letter = message[i].charAt(j);
                    for (int x = 0; x < 6; x++){
                        for (int y = 0; y < 6; y++){
                            if (letter == MATRIX[x][y]){
                                code += LETTERS.charAt(x);
                                code += LETTERS.charAt(y);
                            }
                        }
                    }
                }
                code += " ";
            }
            System.out.println(code);
        }

        // Decoding Part
        else if(answer.equals("decrypt")){
            System.out.println("Please type the sequence of letters you would like to decrypt:");
            sc.nextLine();
            String[] code = (sc.nextLine().toLowerCase()).split(" ");
            String message = "";
            int numwords = code.length;
            for (int i = 0; i < numwords; i++){
                int numletters = code[i].length();
                for (int j = 0; j < numletters; j = j+2){
                    char letter = code[i].charAt(j);
                    char nextletter = code[i].charAt(j+1);
                    int row = LETTERS.indexOf(letter);
                    int column = LETTERS.indexOf(nextletter);
                    message += MATRIX[row][column];
                }
                message += " ";
            }
            System.out.println(message);
        }
    }
}