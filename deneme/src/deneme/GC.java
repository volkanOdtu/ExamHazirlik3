package deneme;

public class GC {
	//int[] val = new int[100];
	private static int finalizeCount = 0;
	
	public void finalize()
	{
		//super.finalize();
		finalizeCount++;
	}
	
	public static void main(String[] args)
	{
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println( "Total memory: " + runtime.totalMemory() + ", "
							+ "free memory: " + runtime.freeMemory());
		for (int i = 0; i < 1000; i++)
		{ new GC(); }
	
		System.out.println( "Number of times finalize executed: " + GC.finalizeCount);
		System.out.println( "Total memory: " + runtime.totalMemory() + ", " + "free memory: " + runtime.freeMemory());
	}

}

