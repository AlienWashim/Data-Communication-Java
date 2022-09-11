public class nrz_i2 {
    nrz_i2(int arr[],int bit_len){
        System.out.println("\nInitial State is L");
        char enc[] = new char[bit_len];
        int dec[] = new int[bit_len];
        
        int state = 0; //Starting from low
        for (int i = 0; i < bit_len; i++){
            if(arr[i] == 1 && state == 0){
                state = 1;
                enc[i] = 'H';
            }
            else if(arr[i] == 1 && state == 1){
                state = 0;
                enc[i] = 'L';
            }
            else{
                if(state == 1){
                    enc[i] = 'H';
                }
                else{
                    enc[i] = 'L';
                }
            }
        }
        
        System.out.print("Encode Data: ");
        for (int i = 0; i < bit_len; i++) {
            System.out.print(enc[i]);
        }
        state = 0;
        int cycle = 0;
        for (int i = 0; i < bit_len; i++){
            if(enc[i] == 'H' && cycle == 0){
                dec[i] = 1;
                cycle++;
                state = 1;
            }
            else if(enc[i] == 'H' && cycle > 0){
                dec[i] = 0;
                cycle++;
                state = 1;
            }
            else if(enc[i] == 'L' && cycle == 0){
                dec[i] = state;
                cycle = 0;
            }
            else if(enc[i] == 'L' && cycle > 0){
                dec[i] = state;
                state = 0;
                cycle = 0;
            }
        }
        System.out.print("\nDecode Data: ");
        for (int i = 0; i < bit_len; i++) {
            System.out.print(dec[i] + "");
        }
        System.out.println("\n");
    }
}
