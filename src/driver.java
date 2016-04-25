import java.io.FileWriter;
import java.io.IOException;

public class driver {
	public static void main(String[] args) throws IOException{
		int[] a = ReferenceString.generate(10000);
		int[] b = ReferenceString.generate(10000);
		int[] c = ReferenceString.generate(10000);
		
		FIFO.fifo(a, 3);
		OPT.optimal(a, 3);
		RAND.random(a, 3);
		
		System.out.println();

		FIFO.fifo(b, 3);
		OPT.optimal(b, 3);
		RAND.random(b, 3);
		
		System.out.println();

		FIFO.fifo(c, 3);
		OPT.optimal(c, 3);
		RAND.random(c, 3);
		
		
		FileWriter fw = new FileWriter("a.txt");

	    for (int i = 0; i < a.length; i++) {
	      fw.write(a[i] + ", ");
	    }
	    fw.close();
	    
	    fw = new FileWriter("b.txt");

	    for (int i = 0; i < b.length; i++) {
	      fw.write(b[i] + ", ");
	    }
	    fw.close();
	    
	    fw = new FileWriter("c.txt");

	    for (int i = 0; i < c.length; i++) {
	      fw.write(c[i] + ", ");
	    }
	    fw.close();
	  
		
		
	}
}
