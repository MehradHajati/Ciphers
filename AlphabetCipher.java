// Alphabet Cipher
// Mehrad Hajati
// 2021/05/18 
// This program turns letters of the alphabet into their correposing position in the alphabet and space is in position zero. 
// At the end of the encryption a "-1" is added to the end to show the end of the message. 

import java.util.*;

public class AlphabetCipher {

    // Constants 
    public static final char[] alphabet = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    // the string and integer beneath can be any negative number or any number larger than 27 but they must match each other for the program to work
    public static final String endofEncryption = "-1";
    public static final int endofDecoding = -1;


    public static void main(String[] args){

        // Introduction
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to encrypt or decode?");
        String answer = sc.next();
        while (!(answer.equals("encrypt") || (answer.equals("decode")))){
            System.out.println("Please try again!");
            System.out.println("Would you like to encrypt or decode?");
            answer = sc.next();
        }
        
        // Encrypting Part
        if (answer.equals("encrypt")){
            System.out.println("Please type the message you would like to encrypt:");
            String message = sc.next();
            message += sc.nextLine();
            message.toLowerCase();
            int length = message.length();
            String encryptedMessage = "";
            for (int i = 0; i < length; i++){
                char letter = message.charAt(i);
                for (int j = 0; j < 27; j++){
                    if (letter == alphabet[j]){
                        encryptedMessage = encryptedMessage + j + " ";
                    }
                }

            } 
            encryptedMessage += endofEncryption;
            System.out.println(encryptedMessage);

        }

        // Decoding Part
        else if(answer.equals("decode")){
            System.out.println("Please type the sequence of numbers you would like to decode");
            int number = sc.nextInt();
            ArrayList<Integer> encryptedMessage = new ArrayList<Integer>(); 
            while (number != endofDecoding){
                encryptedMessage.add(number);
                number = sc.nextInt();
            }
            String message = "";
            int size = encryptedMessage.size();
            for (int i = 0; i < size; i++){
                char letter = alphabet[encryptedMessage.get(i)];
                message += letter;
            }
            System.out.println(message);
        }
    }
}
