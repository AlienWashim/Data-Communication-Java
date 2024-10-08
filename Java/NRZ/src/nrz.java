
import java.util.Scanner;


public class nrz {
    nrz(){
        System.out.println("NRZ program executing...");
        System.out.print("Please, Enter input size: ");
        Scanner sc = new Scanner(System.in);
        int bit_len = sc.nextInt(); //input size
        int arr[] = new int[bit_len]; //declaring array for input
        char enc[] = new char[bit_len]; // array for encoded result
        int dec[] = new int[bit_len]; // array for decoded result
        System.out.print("Enter input: ");
        for (int i = 0; i < bit_len; i++) { // array input
            arr[i] = sc.nextInt();
            if(i == 0){
                System.out.print("\nEnput data: ");
            }
            System.out.print(arr[i]);
        }
        //Encode
        for (int i = 0; i < bit_len; i++) {
            if (arr[i] == 1) {
                enc[i] = 'H';
            }else{
                enc[i] = 'L';
            }
        }
        //Decode
        for (int i = 0; i < bit_len; i++) {
            if (enc[i] == 'H') {
                dec[i] = 1;
            } else {
                dec[i] = 0;
            }
        }
        System.out.print("\n\nEncode Data: ");
        for (int i = 0; i < bit_len; i++) {
            System.out.print(enc[i]);
        }
        System.out.print("\nDecode Data: ");
        for (int i = 0; i < bit_len; i++) {
            System.out.print(dec[i] + "");
        }
        System.out.println("\n");
    }
}

