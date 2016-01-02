import java.util.*;
public class HasUnique{

     public static void main(String []args){
        System.out.println(has_unique("fabcdef"));
     }
     public static boolean has_unique(String s) {
         char[] str = s.toCharArray();
         Arrays.sort(str);
         for(int i=1;i<str.length;i++) {
             if(str[i] == str[i-1])
                return false;
         }
         return true;
     }
}
