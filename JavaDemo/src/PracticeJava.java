public class PracticeJava {
    public static void main(String args[]) {
        int i=0;
        while(i<10){
            i++;
            System.out.println(i);
        }
        int j= 20;
        do{
            System.out.println(j);
        j++;
        }
        while(j<20);
        int x=1;
        for(int a=0;a<4;a++){

            for(int b=4;b>a;b--){
                System.out.print(x +" ");
                x++;
            }
            System.out.println();
        }
        int y=1;
        int temp=1;
        for(int a=1;a<=4;a++){
            for(int b=0;b<a;b++){
                System.out.print(y +" ");
                y++;
            }
            y=temp;
            System.out.println();
        }
        int z=1;
        for(int a=1;a<=4;a++){
            for(int b=0;b<a;b++){
                System.out.print(z +" ");
                z++;
            }
            System.out.println();
        }
        int g=3;
        int v=1;
        for(int a=1;a<=3;a++){
            for(int b=1;b<=a;b++){
                System.out.print(g +" ");
                g=3*v;
                v++;
            }
            System.out.println();
        }
    }

}
