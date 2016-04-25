
import java.util.ArrayList;
import java.util.stream.IntStream;
public class ArrayStats {
	public Double findMean(int[] arr){
		int temp = IntStream.of(arr).sum();
		Double mean = (double)(temp)/arr.length;
		return mean;
	}
	
	public Double findVar(int[] arr){
		Double mean = findMean(arr);
		Double var = 0.0;
		for (int i = 0; i < arr.length; i++){
			var += (arr[i]-mean)*(arr[i]-mean);
		}
		var = var/arr.length;
		return var;
	}
	
	public Double findVar(int[] arr, Double mean){
		Double var = 0.0;
		for (int i = 0; i < arr.length; i++){
			var += (arr[i]-mean)*(arr[i]-mean);
		}
		return 0.0;
	}
	
	public Double findStdDev(int[] arr){
		Double stddev = Math.sqrt(findVar(arr));
		return stddev;
	}
}
