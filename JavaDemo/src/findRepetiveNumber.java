import java.util.ArrayList;

class findrepeativenumber {

     public static void main(String[] args) {
         int arr[] ={2,5,6,2,3,4,6};

         ArrayList<Integer> array = new ArrayList<>();

         for (int i=0;i<arr.length;i++){
             int count =0;
             if(!array.contains(arr[i])){
                 array.add(arr[i]);
             for ( int j=i+1;j<arr.length;j++) {
                 if (arr[i] == arr[j]) {
                     count++;
                 }
             }
                 System.out.println(arr[i] +" Repeated in " +count +" Times");
             }

         }
     }
}
