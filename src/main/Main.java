package main;

import java.io.IOException;
import java.util.Scanner;

import model.Billboard;
import model.BillboardData;

public class Main {
	
	static Scanner  sc = new Scanner (System.in);
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		BillboardData data = new BillboardData();
		data.addBillboard(new Billboard(955, 300, true, "Auctor Quis Tristique Corp."));
		data.addBillboard(new Billboard(937, 234, true, "Hendrerit Institute\n"));
		menu();
		//data.LoadData();
		//BillboardData.billboards.LoadData();*/
	}
	
	
	public static void menu() throws IOException, ClassNotFoundException {
		BillboardData data = new BillboardData();
		
		boolean exit = false;
		int opcion = 0;
		
		while(exit != true) {
			System.out.println("---Billboard----\n"+
					"1. Importar\n"+
					"2. add Billboard\n"+
					"3. display billboards\n"+
					"4. Export hazard report\n"+
					"5.Exit\n"+
					"\nEnter an option\n");
			opcion = sc.nextInt ();
		switch (opcion) {
				
			case 1:
				data.ImportarCSV();
				data.ImportarCSV2();
				
				
				break;
			case 2:
				data.add();
				
				break;
			case 3:
				data.DisplayBillboards();
				break;
			case 4:
			
				data.print();
				data.report();
				break;
			}
		}		
	}


	
	
	
}
