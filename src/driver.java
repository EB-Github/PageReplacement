
public class driver {
	public static void main(String[] args){
		int[] a = ReferenceString.generate(10000);
		ReferenceString.analyzeString(a, 100);
		FIFO.fifo(a, 3);
		
	}
}
