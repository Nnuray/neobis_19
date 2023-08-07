import java.util.Scanner;

public class banknotes2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        System.out.println(inp);
        int hun = inp/100;
        System.out.println(hun+" nota(s) de R$ 100,00");
        int fif = (inp-hun*100)/50;
        System.out.println(fif+" nota(s) de R$ 50,00");
        int twe = (inp-hun*100-fif*50)/20;
        System.out.println(twe+" nota(s) de R$ 20,00");
        int ten = (inp-hun*100-fif*50-twe*20)/10;
        System.out.println(ten+" nota(s) de R$ 10,00");
        int five = (inp-hun*100-fif*50-twe*20-ten*10)/5;
        System.out.println(five+" nota(s) de R$ 5,00");
        int two = (inp-hun*100-fif*50-twe*20-ten*10-five*5)/2;
        System.out.println(two+" nota(s) de R$ 2,00");
        int one=(inp-hun*100-fif*50-twe*20-ten*10-five*5-two*2);
        System.out.println(one+" nota(s) de R$ 1,00");
    }
}
