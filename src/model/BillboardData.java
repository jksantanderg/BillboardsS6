package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class BillboardData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String SEPARATOR="\\|";
	public static final String SEP="++";
	public static final String QUOTE="\"";
	
	static Scanner  sc = new Scanner (System.in);
	public static ArrayList<Billboard> billboards;
	public static ArrayList <String> bill;
	
	public BillboardData() {
		billboards = new ArrayList<>();
	}
	
	public void addBillboard(Billboard billboard) {
		billboards.add(billboard);
	}
	
	
	void saveData() {
		try {
			File file = new File("data/Billboarddata.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void LoadData() {
		try {
			File file = new File("data/Datos1.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object object = ois.readObject();
			
			//ArrayList<Billboard> billboards = (ArrayList<Billboard>) ois.readObject();
			//BillboardData.billboards = billboards;
			BillboardData data = (BillboardData) object;
			this.billboards = data.billboards;
			
				
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	public void ImportarCSV() throws IOException {
		BufferedReader br = null;
	      
	      try {
	         
	         br = new BufferedReader(new FileReader("data/Datos1.csv"));
	         String line = br.readLine();
	         while (null!=line) {
	            String [] parts = line.split(SEPARATOR);
	            for(String p : parts) {
					System.out.println(p);
				}
	            int w =Integer.parseInt(parts[0]);
				int h =Integer.parseInt(parts[1]);
				boolean iu =Boolean.parseBoolean(parts[2]);
				String b = (parts[3]);
				
				Billboard bb = new Billboard(w,h,iu,b);
				billboards.add(bb);	
	            
	         }
	         
	        
	         
	      } catch (Exception e) {
	        
	      } finally {
	         if (null!=br) {
	            br.close();
	         }
	      }
	}
	public void ImportarCSV2() throws IOException {
		BufferedReader br = null;
	      
	      try {
	         
	         br = new BufferedReader(new FileReader("data/Datos2.csv"));
	         String line = br.readLine();
	         while (null!=line) {
	            String [] fields = line.split(SEPARATOR);
	            for(String p : fields) {
					System.out.println(p);
				}
	            
	            fields = removeTrailingQuotes(fields);
	            //System.out.println(Arrays.toString(fields));
	            
	            
	            
	            line = br.readLine();
	            
	            
				Billboard billboard = new Billboard();
				
	            billboard.setWidth(Integer.parseInt(fields[0]));
				billboard.setHigh(Integer.parseInt(fields[1]));
				billboard.setInUse(Boolean.parseBoolean(fields[2]));
				billboard.setBrand(fields[3]);
				
					billboards.add(billboard);
					
	         }
	         
	      } catch (Exception e) {
	        
	      } finally {
	         if (null!=br) {
	            br.close();
	         }
	      }
	}
	
	private static String[] removeTrailingQuotes(String[] fields) {

	      String result[] = new String[fields.length];

	      for (int i=0;i<result.length;i++){
	         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
	      }
	      return result;
	   }
	//DEserializacion
	
	public void Deserializacion(){
		
		
	}
	
	public void add() throws IOException {
		System.out.println("puede agregar una valla a los datos del programa.\n "
				+ "Los parámetros de la valla deben estar separados por (++). Por ejemplo:\n"
				+ "200++300++true++Mister Wings\n "
				+ "\nIngrese los datos \n");
				//String in = sc.nextLine ();
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					String linea = reader.readLine();
					
					String path = "data/Billboarddata.txt";
					
					File file = new File(path);
					FileInputStream fis = new FileInputStream(file);
					//Edición del archillo
					String data = "";
					data +=linea;
				
					FileOutputStream fos= new FileOutputStream(file);
					fos.write(data.getBytes());
					fos.close();
					
					String vallas = linea;
					String[] parts = linea.split("\\++");
					for(String p : parts) {
						System.out.println(p);
					}
					int w =Integer.parseInt(parts[0]);
					int h =Integer.parseInt(parts[1]);
					boolean iu =Boolean.parseBoolean(parts[2]);
					String b = (parts[3]);
					
					Billboard bb = new Billboard(w,h,iu,b);
					billboards.add(bb);	
					for(Billboard p: billboards) {
					System.out.println(bb);}
					
					//save();
					//saveData();
					
					
					fis.close();		
	}
	


	
	public void DisplayBillboards() {
		System.out.println("W    H	  inUse	 Brand\n");
		for(Billboard b : billboards) {
			System.out.println(b.getWidth()+"  "+b.getHigh()+"  "+b.inUse+"  "+b.getBrand());
		}
		System.out.println("TOTAL: "+(billboards.size())+" vallas\n");	
	}
	
	
	public void print() {
		
		for(Billboard b : billboards) {
		System.out.println(b.getBrand());
		System.out.println("===========================\n"+
							"DANGEROUS BILLBOARD REPORT\n"+
							"===========================\n"+
							"The dangerous billboard are:\n");
		
			int area = b.getHigh()*b.getWidth();
			System.out.println(" Billboard "+b.getBrand()+" with area "+area+" \n");	
			
		}
	}
	public void report() throws IOException {
		
		String path = "data/report.txt";
		
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		
		//BufferedReader
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(isr);
		
		String data = "";
		String line = "";
				
		line = ("===========================\n"+
				"DANGEROUS BILLBOARD REPORT\n"+
				"===========================\n"+
				"The dangerous billboard are:\n");
				data += line+"\n";
		fis.close();
		
		//Edición del archillo
		for(Billboard b : billboards) {
			
		//for(int i =0;i<billboards.size(); i++) {
			int area = b.getHigh()*b.getWidth();
			
			data +=(". Billboard "+b.getBrand()+" with area "+area+" \n");
		}
		

		FileOutputStream fos= new FileOutputStream(file);
		fos.write(data.getBytes());
		fos.close();
		
		}
}


