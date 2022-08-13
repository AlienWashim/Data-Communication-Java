
import java.util.Scanner;
//1 1 1 0 0 1 0 1 0

public class crc {

    void solve(int data[], int divider[], int in, int div, boolean reciever) {
        int track = 0, copy_round = 0,rec_round = 0;
        int copy[] = new int[div];
        int rec[] = new int[div];
        for (int n = 0; n < div; n++) {
            copy[n] = data[n];
            //System.out.println("copy == "+copy[n]);
        }
        int extra = div;
        for (int i = 0; i < in; i++) {
            if (copy[track] == 1) {
                if (reciever == true) {
                    for (int j = i ; j < i + div; j++) 
                    {
                        rec[rec_round] = copy[rec_round] ^ divider[rec_round];
                        rec_round++;
                    }
                    rec_round = 0;
                }
                for (int j = i + 1; j < i + div; j++) {
                    //System.out.print("Copy value = ");
                    //System.out.println("copy == "+copy[copy_round]);
                    copy[copy_round] = copy[copy_round + 1] ^ divider[copy_round + 1];
                    copy_round++;
                    //System.out.print(" "+copy[copy_round]);
                }
                //System.out.println("extra == "+extra); 
                if (extra < (in + div - 2)) {
                    copy[div - 1] = data[extra];
                }
                extra++;
                copy_round = 0;
            } else {
                if (reciever == true) {
                    for (int j = i ; j < i + div; j++) 
                    {
                        rec[rec_round] = copy[rec_round] ^ 0;
                        rec_round++;
                    }
                    rec_round = 0;
                }
                for (int j = i + 1; j < i + div; j++) {
                    //System.out.print("Copy value = ");
                    //System.out.println("copy == "+copy[copy_round]);
                    copy[copy_round] = copy[copy_round + 1] ^ 0;
                    copy_round++;
                    //System.out.print(" "+copy[copy_round]);
                }
                //System.out.println("helper == "+helper);
                //System.out.println("extra == "+extra); 
                if (extra < (in + div - 2)) {
                    copy[div - 1] = data[extra];
                }
                extra++;
                copy_round = 0;
            }
        }
        copy_round = 0;
        if (reciever == false) {
            for (int k = in; k < in + div - 1; k++) {
                data[k] = copy[copy_round];
                //System.out.println("copy=="+copy[copy_round]);
                copy_round++;
            }

            System.out.print("\nSender Data: ");
            for (int j = 0; j < data.length; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println("\n");
        }
        boolean result = true;
        if (reciever == true) {
            for (int i = 0; i < div; i++) {
                if (rec[i] == 1) {
                    result = false;
                    
                }
            }
            if (result == true) {
                System.out.print("\nRemainder : ");
                for (int n = 0; n < div; n++) {
                    System.out.print(" " + rec[n]);
                }
                System.out.println("\nSo, Real data found! \n\n");
            } else {
                System.out.print("\nRemainder : ");
                for (int n = 0; n < div; n++) {
                    System.out.print(" " + rec[n]);
                }
                System.out.println("\nSo, data is manipulated!!! \n\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data size: ");
        int in = sc.nextInt();
        System.out.print("Enter divider size: ");
        int div = sc.nextInt();
        int data[] = new int[div + in - 1];
        int divider[] = new int[div];
        System.out.println("\nEnter data : ");
        for (int i = 0; i < in + div - 1; i++) {
            if (i < in) {
                data[i] = sc.nextInt();
            } else {
                data[i] = 0;
            }
        }
        System.out.println("\nEnter Divider: ");
        for (int i = 0; i < div; i++) {
            divider[i] = sc.nextInt();
        }
        crc obj = new crc();
        boolean reciever = false;
        obj.solve(data, divider, in, div, reciever);
        reciever = true;
        obj.solve(data, divider, in, div, reciever);
    }

}
