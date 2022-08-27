import java.util.Scanner;

public class IP_Chacker {  
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any IP address: ");
        input = sc.nextLine();
        System.out.print("Sample Input: "+input+"\n");
        
        String[] array = input.split("[.]", 0);
        System.out.print("Smaple Output: ");
        int temp,check = 0;
        for(int i = 0; i<4; i++){
            temp = Integer.parseInt(array[i]);
            if(i<3){
                System.out.print(Integer.toBinaryString(temp)+".");
            }else{
                System.out.print(Integer.toBinaryString(temp)+" ");
            }
            if(temp > 255){
                check = 1;
            }
        }
        System.out.println("");
        System.out.println("");
        if(check == 1){
            System.out.println("\nInvalid IP Address!\n");
        } 
    }
}
