
import java.util.Scanner;

public class nrz_home {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Choose option: \n1. NRZ\n2. NRZ-I\n3. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    {
                        nrz obj = new nrz();
                        break;
                    }
                case 2:
                    {
                        nrz_i obj = new nrz_i();
                        break;
                    }
                case 3:
                    {
                        System.out.println("Program terminated...");
                        break;
                    }
                default:
                    System.out.println("Wrong choice! please try again...");
                    break;
            }
            if(option == 3){
                break;
            }
        }
    }
}
