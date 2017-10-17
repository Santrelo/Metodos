import java.io.*;
import java.text.Collator;


public class OrdenTabla {
	
	private String [][]a;
	private int conta,tama;
	public OrdenTabla(String [][] a,int conta,int tama) {
		this.a = a;
		this.conta=conta;
		this.tama = tama;
	}
	public static OrdenTabla LoadData() throws IOException{
		FileReader fr = new FileReader("C:\\Users\\Santiago Restrepo\\eclipse-workspace\\java desde cero\\src\\fichero.txt");
		BufferedReader bf = new BufferedReader(fr);
		String r; 
		int tama=0;
		int conta=0;
	
			while((r = bf.readLine())!=null) {
			
			
			String a[]= r.split(",");
			tama=a.length;
			
				conta ++;
		
			
			}
			
		
		String b[][]= new String[conta][tama]; 

		FileReader gr = new FileReader("C:\\Users\\Santiago Restrepo\\eclipse-workspace\\java desde cero\\src\\fichero.txt");
		BufferedReader gf = new BufferedReader(gr);
		String d;
		int linea = 0;
		while((d = gf.readLine())!=null) {
			String z[]= d.split(" , ");
			b[linea] = z;
			linea++;
			
			
		}
		
		for(int i = 0 ; i<conta;i++) {
			System.out.println("");
			for(int k= 0 ;k <tama;k++) {
				System.out.print(b[i][k]+" ");
			}
		}
		System.out.println();
		return new OrdenTabla(b,conta,tama);
	}
		
	
		
		
		
	
	
	public OrdenTabla sortMulti(OrdenTabla a){
	
		
		
		int s = a.a[0][0].indexOf(".");
		
		
		String aux[] =new String[a.tama];
		if(s>=0) {
		
			
			
			
		
			int linea = 0;
			for(int i = 0 ; i<a.a.length;i++) {
				for(int k = i+1;k<a.a.length;k++) {
					double l1 = Double.parseDouble(a.a[i][linea]);
					double l2 = Double.parseDouble(a.a[k][linea]);
					if(l1>l2) {
					aux=a.a[i];
					a.a[i]=a.a[k];
					a.a[k]=aux;
					linea=0;
					
					}
					if(l1==l2) {
						if(linea <a.tama-1) {
						k--;
						linea++;
						}
						else {
						
						linea = 0;
						}
					}
					
				}
			}
			for(int i = 0 ; i<a.conta;i++) {
				System.out.println("");
				for(int k= 0 ;k <a.tama;k++) {
					System.out.print(a.a[i][k]+" ");
				}
			}
			
		}
		else {
		try {
			
			
			
		
			int linea = 0;
			for(int i = 0 ; i<a.a.length;i++) {
				for(int k = i+1;k<a.a.length;k++) {
					int l1 = Integer.parseInt(a.a[i][linea]);
					int l2 = Integer.parseInt(a.a[k][linea]);
					if(l1>l2) {
					aux=a.a[i];
					a.a[i]=a.a[k];
					a.a[k]=aux;
					linea =0;
					}
					if(l1==l2) {
						if(linea <a.tama-1) {
							k--;
							linea++;
							}
							else {
							
							linea = 0;
							}
					}
					
				}
			}
			for(int i = 0 ; i<a.conta;i++) {
				System.out.println("");
				for(int k= 0 ;k <a.tama;k++) {
					System.out.print(a.a[i][k]+" ");
				}
			}
		
		}
		catch(Exception E){
			Collator comparador = Collator.getInstance();
			comparador.setStrength(Collator.SECONDARY);
			
			int linea = 0;
			for(int i = 0 ; i<a.a.length;i++) {
				for(int k = i+1;k<a.a.length;k++) {
					int l1 = comparador.compare(a.a[i][linea], a.a[k][linea]);
					if(l1==1) {
					aux=a.a[i];
					a.a[i]=a.a[k];
					a.a[k]=aux;
					linea =0;
					}
					if(l1==0) {
						if(linea <a.tama-1) {
							k--;
							linea++;
							}
							else {
							
							linea = 0;
							}
					}
					
				}
			}
			for(int i = 0 ; i<a.conta;i++) {
				System.out.println("");
				for(int k= 0 ;k <a.tama;k++) {
					System.out.print(a.a[i][k]+" ");
				}
			}
			
			}
		
		
		
		}
		
		return new OrdenTabla(a.a,a.conta,a.tama);
		}
		
	
	
	public void UniTest(String [][] a) {
		String [] b = a[0];
		
		int r =a.length;
		int s= b.length;
		for(int i = 0 ; i<r;i++) {
			System.out.println("");
			for(int k= 0 ;k <s;k++) {
				System.out.print(a[i][k]+" ");
			}
		}
		System.out.println();
		
		OrdenTabla p = new OrdenTabla(a,r,s);
		p.sortMulti(p);
	}
	
	public static void main(String []args) throws IOException {
		String a[][]=new String[4][4]; 
		a[0][0]= "a";
		a[0][1]= "b";
		a[0][2]= "c";
		a[0][3]= "g";
		
		a[1][0]= "a";
		a[1][1]= "b";
		a[1][2]= "c";
		a[1][3]= "f";
		
		a[2][0]= "a";
		a[2][1]= "b";
		a[2][2]= "c";
		a[2][3]= "e";
		
		a[3][0]= "a";
		a[3][1]= "b";
		a[3][2]= "c";
		a[3][3]= "d";
	
		//OrdenTabla g = LoadData(); 
		//g.sortMulti(g);
		
		OrdenTabla p = new OrdenTabla(a,4,4);
		p.UniTest(a);
		
	}
	
	
}
