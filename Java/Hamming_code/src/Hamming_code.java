
import java.util.*;


public class Hamming_code {
public static int x; //size of modified array
boolean check( int parity[],int checker)
{
    boolean res = false;
    for(int i = 1; i < parity.length; i++)
    {
        if(parity[i] == checker)
        {
            return false;
        }
        else
        {
            res = true;
        }
    }
    return res;
}
    int size(int i) {
        int res = 1;
        if (i == 0) {
            return 1;
        } else {
            for (int k = 1; k <= i; k++) {
                res = res * 2;
            }
            return res;
        }
        
    }
    int option()
    {
        int ret = 0;
        System.out.println("\n\n***   Select a Option   ***\n1. Even parity\n2. Odd parity\n");
        Scanner c = new Scanner(System.in);
        int choice = c.nextInt();
        System.out.println(" ");
        if(choice == 1)
        {
            ret = 1;
        }
        else if(choice == 2){
            ret = 2;
        }
        return ret;
    }
    void solve_it(int mod_size, int ques_size, int mod[],int parity[])
    {
        int count = 0;
        Hamming_code ob = new Hamming_code();
        int selector = ob.option(); //calling option method to choose option from user
        for(int i = 1; parity[i] < mod_size; i++) //parity position selection
        {
            //System.out.println("main loop");
                for(int k = parity[i]; k <= mod_size; k = k + (parity[i]*2)) //segment selection
                {
                    for(int t = 0; t < parity[i]; t++) //count 1 of every selected segment
                    {
                        if(mod[k+t] == 1)
                        {
                            count++;
                        }
                    }
                }
            //System.out.println("count = "+count);
           if(selector == 1) // if selector is 1 then even parity will be selected
           {
               //System.out.println("count = "+count);
               if(count%2 == 0)
               {
                   mod[parity[i]] = 0;
               }
               else
               {
                   mod[parity[i]] = 1;
               }
               
               //System.out.println("mod value = "+mod[parity[i]]);
           }
           else if(selector == 2) // if selector is 2 then odd parity will be selected
           {
               //System.out.println("count = "+count);
               if(count%2 == 0)
               {
                   mod[parity[i]] = 1;
               }
               else
               {
                   mod[parity[i]] = 0;
               }
               //System.out.println("mod value = "+mod[parity[i]]);
           }
           count = 0;
        }
    }
    void print(int mod[],int end,int in,int ques[])
    {
        System.out.print("Question: ");
        for(int i = 0; i < in; i++)
        {
            System.out.print(ques[i]+" ");
        }
        
        System.out.print("\nAnswer: ");
        for(int i = 1; i <= end; i++)
        {
            System.out.print(mod[i]+" ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int mod[] = new int[100];
        int parity[] = new int[100];
        Hamming_code obj = new Hamming_code();
        
        //input start
        System.out.println("Enter Array Size: ");
        Scanner sc =  new Scanner(System.in);
        int in = sc.nextInt();
        int ques[] =  new int[in];
        System.out.println("Now enter "+in+" array element: ");
        for(int i = 0; i < in; i++)
        {
            int store = sc.nextInt();
            ques[i] = store;
        } //input end

        for (int i = 0; i < 15; i++) {
            parity[i + 1] = obj.size(i); //storing parity value manually
            //System.out.println(parity[i + 1]);
        }
        //System.out.println(parity[1]);

        //modified array input start
        int n = 0;
        for (int s = 1; s <= mod.length; s++) {
            //System.out.println("check res = "+obj.check(parity,s));
            if(obj.check(parity,s) && n<in) //check method return true if it is not a parity position
            {
                mod[s] = ques[n];
                n++;
                x = s;
                //System.out.println("mod "+s+"="+mod[s]);
            } 
        }
        //System.out.println("modified array size= "+x);
        //modified array input done
        
        obj.solve_it(x,in,mod,parity); //calling solve method to do all operation
        obj.print(mod,x,in,ques); //calling print method to print question and answer
    }
}
