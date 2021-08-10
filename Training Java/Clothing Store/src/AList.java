import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class TestMain{
	public static void main(){
		checkTest();
			
	}
	public static void checkTest(){
		Set set =new TreeSet();
		set.add("A");
		set.add(3);
		set.add("B");
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next()+"");
		}
		
	}
	
}
	
