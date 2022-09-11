
import java.util.*;

public class Manchester {
    int size; //gloabal varibale that will store size of input
    String encode_data[] = new String[size]; //global variable that will store encoding data
    int decode_data[] = new int[size]; //global variable that will store decoding data
    
    Manchester(){};
    Manchester(int in_size){
        this.size = in_size; //storing input size into global variable by this constructor
        this.encode_data = new String[in_size];
        this.decode_data = new int[in_size];
    }
    //this encode method will encode the input
    //encoding start
    void encode(int inputs[]) {
        String state = ""; //this will keep track of present state
        if (inputs[0] == 1) {
            encode_data[0] = "HL"; //If first bit is 1 its mean HL
            state = "HL";
        } else {
            encode_data[0] = "LH"; //if first bit is '0' then LH
            state = "LH";
        }

        for (int i = 1; i < size; i++) { //loop start from 1 because position '0' is alrady encoded
            if (inputs[i] == 1) {  //if 1 found it will check the previous state and it will toggle
                if (state == "HL") {
                    encode_data[i] = "LH";
                    state = "LH";
                } else {
                    encode_data[i] = "HL";
                    state = "HL";
                }
            } else {
                encode_data[i] = state; //if zero found previous state will be copied
            }
        }
        print_encode_data(); //calling encode data printing method
    }
    //encoding end
    //decoding start
   void decode(){ //using encode data as its input
        int state; //it will keep track of present state
        if (encode_data[0] == "HL") { //if the first encode data is HL it will copy 1 otherwise '0'
            decode_data[0] = 1;
            state = 1; //HL = 1
        } else {
            decode_data[0] = 0;
            state = 0; //LH = 0
        }
        for (int i = 1; i < size; i++){
            if(encode_data[i] == "HL"){ //if the present state is HL
                if(state == 1){ //and the previous state is also HL
                    decode_data[i] = 0; //thats mean previous state was copied, so it will be '0'
                    state = 1; //present state is HL = 1
                }else{
                    decode_data[i] = 1; //if the previous state was '0' and as the present state is HL = 1, it will be 1
                    state = 1;
                }
            }else{ // when the present state is LH = 0
                if(state == 0){ //and the previous state 0
                    decode_data[i] = 0; //state copied, so it wlll be 0
                    state = 0; //as present state is LH = 0
                }else{ //and the previous state 1
                    decode_data[i] = 1; // it toggled, so it will be 1
                    state = 0; //as present state is LH = 0
                }
            }
        }
        print_decode_data();//calling decode data printing method
    }
    
    //encode data printing method start
    void print_encode_data(){
        System.out.print("\n Encode data: ");
        for(int i = 0; i < size; i++){
            System.out.print(encode_data[i]);
        }
        System.out.println("\n");
    }
    //print end
    
    //decode data printing method start
    void print_decode_data(){
        System.out.print("\n Decode data: ");
        for(int i = 0; i < size; i++){
            System.out.print(decode_data[i]);
        }
        System.out.println("\n\n");
    }
    //print end

    public static void main(String[] args) {
        System.out.print(" Enter input size: ");
        Scanner sc = new Scanner(System.in);
        int input_size = sc.nextInt();
        Manchester obj = new Manchester(input_size); //Calling constructor to store input size into global varibale named size
        //and also creating object of Menchester class to call other method from main function
        while (input_size <= 0) {
            System.out.print(" Input must be greater than '0'\n Please Enter input size again: ");
            input_size = sc.nextInt();
        }
        int inputs[] = new int[input_size];
        System.out.print("\n Enter your input: ");
        //taking user input
        for (int i = 0; i < input_size; i++) {
            inputs[i] = sc.nextInt();
        }
        obj.encode(inputs); //calling encode method
        obj.decode(); //calling encode method
    }

}
