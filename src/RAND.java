import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Random;
/**
 * 
 * @author Steven Robbins
 *
 */
public class RAND {
	public static void random(int [] ref, int framesize){
		int pagefaults = 0;
		Random ran = new Random();
		int[] mem = new int[framesize];
		boolean emptymem = true;
		Arrays.fill(mem, -1);
		Integer[] reference = IntStream.of(ref).boxed().toArray(Integer[]::new);
		int k = 0;
		for (int i = 0; i < ref.length; i++){
		//	System.out.println(Arrays.toString(mem) + "  " + i); //Debug
			int j = i;
			if (!IntStream.of(mem).anyMatch(x -> x == reference[j])){
				pagefaults++;
				if (emptymem) {
					if (mem[k] == -1){
//						/System.out.println("Setting frame: " + (k+1) + " to: " + reference[i]);
						mem[k]=reference[i];
						k++;
						if (k >= framesize) emptymem = false;
					}
				}
				else{
					int temp = ran.nextInt(framesize);
					//System.out.println("Setting frame: " + (temp+1) + " to: " + reference[i]);
					mem[temp]=reference[i];
				}
			}
			reference[i]=-1;
		}
		System.out.println("Pagefaults: " + pagefaults);
	}
		
	
	public static void main(String[] args){
		int[] refString = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
		random(refString,4);
	}
}
