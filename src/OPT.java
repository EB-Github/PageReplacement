import java.util.Arrays;
import java.util.stream.IntStream;
/**
 * 
 * @author Steven Robbins
 *
 */
public class OPT {
	public static void optimal(int [] ref, int framesize){
		int pagefaults = 0;
		int[] mem = new int[framesize];
		boolean emptymem = true;
		Arrays.fill(mem, -1);
		Integer[] reference = IntStream.of(ref).boxed().toArray(Integer[]::new);
		int k = 0;
		for (int i = 0; i < ref.length; i++){
			//System.out.println(Arrays.toString(mem) + "  " + i); //Debug
			int j = i;
			if (!IntStream.of(mem).anyMatch(x -> x == reference[j])){
				pagefaults++;
				if (emptymem) {
					if (mem[k] == -1){
						System.out.println("Setting frame: " + (k+1) + " to: " + reference[i]);
						mem[k]=reference[i];
						k++;
						if (k >= framesize) emptymem = false;
					}
				}
				else{
					int furthest = 0;
					int distance = 0;
					for(int pntr = 0; pntr < framesize; pntr++){
						int temp = Arrays.asList(reference).indexOf(mem[pntr]);
						if (temp == -1) {
							furthest = pntr;
							break;
						}
						else if (distance < temp) {
							furthest = pntr;
							distance = temp;
						}
					}
					System.out.println("Setting frame: " + (furthest+1) + " to: " + reference[i]);
					mem[furthest]=reference[i];
				}
			}
			reference[i]=-1;
		}
		System.out.println("Pagefaults: " + pagefaults);
	}
		
	
	public static void main(String[] args){
		int[] refString = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
		optimal(refString,4);
	}
}
