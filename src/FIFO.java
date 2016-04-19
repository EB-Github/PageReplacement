
public class FIFO {
	public static void fifo(int[] ref){
		int pagefaults = 0;
		int[] presence = new int[100];
		int[] buf = new int[3]; //second dimension == age
		for(int i = 0; i < buf.length; i++){
			buf[i] = -1;
		}
		int j = 0;
		for(int i = 0; i < ref.length; i++){
			
			if(buf[j] == -1){
				pagefaults++;
				buf[j] = ref[i];
				presence[ref[i]] = 1;
			    j++;
			}
			
			if(buf[j] != ref[i] && presence[ref[i]] != 1){
				pagefaults++;
				presence[buf[j]] = 0;
				buf[j] = ref[i];
				presence[ref[i]] = 1;
			    j++;
			}
			if(j == 2) j = 0;
		}
		System.out.println(pagefaults);
	}
	
	public static void main(String[] args){
		int[] refString = {1,2,3,2,1,5,2,1,6,2,5,6,3,1,3,6,1,2,4,3};
		fifo(refString);
	}
}
