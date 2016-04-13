import java.util.Random;
/**
 * @author Eli Brown
 *
 */
public class ReferenceString {
	/**
	 * @param nStringSize
	 * @return
	 */
	public static int[] generate(int nStringSize){
		int[] arrReferenceString = new int[nStringSize];
		int lastInt = -1;
		for(int i = 0; i < nStringSize; i++){
			int a = getUniqueInt(lastInt);
			arrReferenceString[i] = a;
			lastInt = a;     
		}
		
		return arrReferenceString;	
	}
	
	/**
	 * Returns an Integer between 0-9 that is different than the integer provided via input
	 * @param lastInt
	 * @return
	 */
	private static int getUniqueInt(int lastInt) {
		Random r = new Random();
		int a = r.nextInt(100);
		if(a != lastInt){
			return a;
		}
		else
			return getUniqueInt(lastInt);
	}

	public static void main(String[] args){
		
		int[] ref = generate(10000);
		for(int i = 0; i < 10000; i++){
			System.out.println(ref[i]);
		}
		
	}
}
