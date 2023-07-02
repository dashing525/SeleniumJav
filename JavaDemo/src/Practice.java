import java.util.*;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] word = s.split(" ");
        MapValueRetrieve();
        CommonElement();
        ReverseString("My name is Sonu");
        PalindromeString();
        PalindromeNumber();
        RemoveDuplicateNumber();
        DuplicateString();
        DuplicateChar();
        DuplicateNumber();
        switchSize();
        String rev=" ";
        for (String str : word) {
            StringBuffer sb = new StringBuffer(str);
            rev = rev+sb.reverse().toString()+" ";
        }
        System.out.println(rev.trim());
    }
    public static void DuplicateString(){
        /*String [] spl = string.split(" ");
        String rev =" ";
        for (String word :spl){
            String reverseWord = " ";
            for (int i=word.length()-1;i>=0;i--){
                reverseWord = reverseWord + word.charAt(i);
            }
            rev = rev +reverseWord +" ";
        }
        System.out.println(rev.trim());
*/
  List <String> ar = new ArrayList<String>();
  ar.add("Sonu");
        ar.add("Kumar");
        ar.add("Sonu");
        ar.add("Ruchi");

        Set <String> s = new HashSet<String>();
        for(String word : ar){
            if(s.add(word)==false){
                System.out.println(word);
            }
        }
    }
    public  static void DuplicateChar(){
        String str = "Ruchi Devi Sonu";
        char [] c= str.toCharArray();

        for(int i=0;i< str.length();i++){
            for(int j=i+1;j<str.length();j++){
                if(c[i]==c[j]){
                    System.out.println(c[i]);
                }
            }
        }
    }
        public static void switchSize(){
        int value =42;
        String size;
        switch (value){
            case 38:
                size = "Small";
           break;
            case 40:
                size = "Medium";
                break;
            case 42:
                size = "Large";
                break;
            case 44:
                size = "Extra Large";
                break;
            case 46:
                size = "Double Extra Large";
                break;
            default:
             size=  "invalid size" ;
        }
            System.out.println(size);
        }

    public  static void DuplicateNumber(){
        int [] num  = {1,5,3,2,6,8,4,2,5};

        for(int i=0;i< num.length;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i]==num[j]){
                    System.out.println(num[i]);
                }
            }
        }
    }
    public  static void RemoveDuplicateNumber(){
        int [] num  = {1,5,3,2,6,8,4,2,5};
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0;i<num.length;i++){
            set.add(num[i]);
        }
        System.out.println(set);
    }
    public  static void PalindromeString(){
        String str= "sonuunos";
        StringBuffer sb = new StringBuffer(str);

        if(str.equalsIgnoreCase(sb.toString())){
            System.out.println("Palindrome");
        }
        else
            System.out.println("Not Palindrome");
    }
    public  static void PalindromeNumber(){
        int num= 1234321;
        int rim=0;
        int rev=0;
        int copy =num;
        while(num>0){
            rim = num%10;
            rev= rev*10+rim;
            num= num/10;
        }
        if(rev==copy){
            System.out.println("Palindrome");
        }
        else
            System.out.println("Not Palindrome");
        }
    public  static void ReverseString(String str) {
        String [] word= str.split(" ");
        String rev =" ";
        for (int i = word.length- 1; i >= 0; i--) {
            if (i==0) {
                rev = rev+ word[i];
            } else {
                rev = rev + word[i] + " ";
            }
        }
        System.out.println(rev.trim());
    }
    public static void CommonElement(){

        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(12);
        arr1.add(32);
        arr1.add(52);
        arr1.add(42);

        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(12);
        arr2.add(25);
        arr2.add(10);
        arr2.add(42);
       arr1.retainAll(arr2);
        System.out.println(arr1);
    }
    public static void MapValueRetrieve(){

        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"Rohit");
        map.put(2,"Rock");
        map.put(3,"Rahul");
        for (Map.Entry<Integer,String> entry : map.entrySet())
        System.out.println(entry.getKey() +"  " + entry.getValue());

    }
    public static void TestDemo(){
        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        String intro ="My name is sonu kumar";

        int x=0;
        int y=0;
        char [] c =name.toCharArray();
        for(int i=0; i<c.length ; i++ ){
            if(c[i]=='z'){
                x=x+1;
            }
            else if(c[i]=='o'){
                y=y+1;
            }
        }
        if(y==2*x){
            System.out.println("Yes");    // Writing output to STDOUT
        }
        else
            System.out.println("No");

    }
    }



