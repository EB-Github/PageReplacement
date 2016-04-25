import java.util.stream.IntStream;
public class ArrayStats {
	public int findMean(int[] arr){
		int mean = IntStream.of(arr).sum();
		return mean;
	}
	
	public int findVar(int[] arr){
		int mean = findMean(arr);
		int var = 0;
		for (int i = 0; i < arr.length; i++){
			var += 
		}
		return 0;
	}
	
	public int findVar(int[] arr, int mean){
		return 0;
	}
}
