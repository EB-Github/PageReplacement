
public class FIFO {
	public static void fifo(int[] ref, int framesize){
		int pagefaults = 0;
		boolean[] available = new boolean[100];
		int[] buf = new int[framesize]; //second dimension == age
		for(int i = 0; i < buf.length; i++){
			buf[i] = -1;
		}
		int j = 0;
		for(int i = 0; i < ref.length; i++){
			
			if(buf[j] == -1){
				pagefaults++;
				System.out.println("Setting frame: " + (j+1) + " to: " + ref[i]);
				buf[j] = ref[i];
				available[ref[i]] = true;
			    j++;
			    if(j > framesize-1) j = 0;
			}
			
			else if(buf[j] != ref[i] && available[ref[i]] != true){
				pagefaults++;
				available[buf[j]] = false;
				System.out.println("Setting frame: " + (j+1) + " to: " + ref[i]);
				buf[j] = ref[i];
				available[ref[i]] = true;
			    j++;
			    if(j > framesize-1) j = 0;
			}
			
			else{
				System.out.println("Nothing change");
			}
			
		}
		System.out.println("Page Faults: " + pagefaults);
	}
	
	public static void main(String[] args){
		int[] refString = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
		fifo(refString,4);
	}
}
