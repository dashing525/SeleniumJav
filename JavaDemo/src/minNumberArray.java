public class minNumberArray {
    public static void main(String[] args) {

        int arr[][] = new int[3][3];
        arr[0][0] =5;
        arr[0][1] =15;
        arr[0][2] =25;
        arr[1][0] =2;
        arr[1][1] =12;
        arr[1][2] =22;
        arr[2][0] =3;
        arr[2][1] =4;
        arr[2][2] =8;
         int min= arr[0][0];
         int col =0;
        for(int i=0;i<arr.length;i++){

            for(int j=0;j<arr[i].length;j++){
            if(arr[i][j]<min){
                min=arr[i][j];
                col=j;
            }
            }
        }
     int max=arr[0][col];
        int k=0;
        while(k<3){
            if(arr[k][col]>max){
                max=arr[k][col];
            }
            k++;
        }
        System.out.println(max);
    }
}
