package deneme;

public class CountCurrrency {

	public static void countNotes(int amount) {
		int[] amounts = { 2000 ,500 ,200 ,100 ,50 ,20 ,10 ,5 ,1};
		int[] banknotesCount = new int[9];
		
		//bolerek en yuksek ten kac adet olabilecegini bulup amount dan cikairyoruz
		for(int i=0 ; i< amounts.length ; i++ ) {
			if(amount > amounts[i]) {
				banknotesCount[i] = amount /amounts[i];
				amount = amount - amounts[i] * banknotesCount[i] ; 
			}
		}
		for(int i= 0; i< banknotesCount.length ;i++) {
			System.out.println(amounts[i] + " " + banknotesCount[i] + " adet " );
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		countNotes(868);
	}

}
