package deneme;

import java.util.ArrayList;
import java.util.List;

public class Servers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> liste = new ArrayList<Integer>();
		liste.add(0);
		liste.add(0);
		liste.add(1);
		liste.add(0);
		//a.findContigousArea(liste); 
		
		List<Integer> liste2 = new ArrayList<Integer>();
		liste2.add(1);
		liste2.add(0);
		liste2.add(0);
		liste2.add(0);
		
		List<List<Integer> > grid = new ArrayList<List<Integer>>();
		
		grid.add(liste);
		grid.add(liste2);
		
		
		List<Integer> rowPoints;
		for(int  y= 0; y< grid.size() ; y++)
		{
			 rowPoints= grid.get(y);
			 for(int x=0 ;x < rowPoints.size(); x++ ) {
				 rowPoints.get(x);
				 System.out.print( rowPoints.get(x)  );
			 }
			 System.out.println();
			 //rowOnes=  findContigousArea(rowPoints);
			 //sum = sum + rowOnes;
		}

		//Burda ilk paremetre y ,ikinci x
		int[][] allServers = new int [2][4];

		allServers[0][0] = 0;
		allServers[0][1] = 0;
		allServers[0][2] = 1;
		allServers[0][3] = 0;
		
		allServers[1][0] = 1;
		allServers[1][1] = 0;
		allServers[1][2] = 0;
		allServers[1][3] = 0;
		
		for(int y=0; y <allServers.length ;y++) {
			for(int x= 0 ; x <allServers[y].length ; x++) {
				System.out.print(allServers[y][x]);
			}
			System.out.println();
		}
		
	}

}
