package scratch;
import java.util.ArrayList;
public class Scratch {


public static void main (String[] args){
int simple_array[]=new int[5];/*or {1,2,3,4,5}*/

ArrayList<Integer> mylist =new ArrayList<Integer>(5);
mylist.add(5);
mylist.add(2);
mylist.add(4);
mylist.add(1);
mylist.add(3);

for(Integer x : mylist)
{
    System.out.println(x);
}

    System.out.prin tln(mylist.size());

}

}