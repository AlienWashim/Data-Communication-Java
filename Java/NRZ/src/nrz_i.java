import java.util.Scanner;
public class nrz_i {
    nrz_i(){
        System.out.println("NRZ-I program executing...");
        System.out.print("Please, Enter input size: ");
        Scanner sc = new Scanner(System.in);
        int bit_len = sc.nextInt();
        int arr[] = new int[bit_len];
        char enc[] = new char[bit_len];
        int dec[] = new int[bit_len];
        System.out.print("Enter input data: ");
        //Input 1 0 0 1 1 0 1
        for (int i = 0; i < bit_len; i++) {
            arr[i] = sc.nextInt();
            if(i == 0){
                System.out.print("\nEnput data: ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("\n\nIntial state is H");
        int state = 1; //Starting from high
        for (int i = 0; i < bit_len; i++){
            if(arr[i] == 1 && state == 1){
                state = 0;
                enc[i] = 'L';
            }
            else if(arr[i] == 1 && state == 0){
                state = 1;
                enc[i] = 'H';
            }
            else{
                if(state == 0){
                    enc[i] = 'L';
                }
                else{
                    enc[i] = 'H';
                }
            }
        }
        
        System.out.print("Encode Data: ");
        for (int i = 0; i < bit_len; i++) {
            System.out.print(enc[i]);
        }
        state = 1;
        int cycle = 0;
        for (int i = 0; i < bit_len; i++){
            if(enc[i] == 'L' && cycle == 0){
                dec[i] = 1;
                cycle++;
                state = 1;
            }
            else if(enc[i] == 'L' && cycle > 0){
                dec[i] = 0;
                cycle++;
                state = 1;
            }
            else if(enc[i] == 'H' && cycle == 0){
                dec[i] = state;
                cycle = 0;
            }
            else if(enc[i] == 'H' && cycle > 0){
                dec[i] = state;
                state = 0;
                cycle = 0;
            }
        }
        System.out.print("\nDecode Data: ");
        for (int i = 0; i < bit_len; i++) {
            System.out.print(dec[i] + "");
        }
        System.out.println("");
        nrz_i2 obj = new nrz_i2(arr,bit_len);
    }
}
