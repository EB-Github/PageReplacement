
public class driver {
	public static void main(String[] args){
		int[] a = ReferenceString.generate(100);
		for(int i = 0; i < a.length; i++){
			if(i%10 == 0){System.out.println();}
			System.out.print(a[i]+" ");
		}
	}
}
