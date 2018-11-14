import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

class MyAddress {
    private String address;
    private String yomi;
    
    MyAddress(){
    }
    
    MyAddress(String address, String yomi){
    	this.address = address;
    	this.yomi = yomi;
    }
    
    String getAddress(){
    	return address;
    }
    
    String getYomi(){
    	return yomi;
    }
    
    void setAddress(String address){
    	this.address = address;
    }
    
    void setYomi(String yomi){
    	this.yomi = yomi;
    }
    
    public String toString(){
    	return address + "(" + yomi + ")" ;
    }
}

class PostalCode {
    private String code;
    private MyAddress pref;
    private MyAddress city;
    private MyAddress town;
    
    PostalCode(){
    }
    
    PostalCode(String Code, MyAddress Pref, MyAddress City, MyAddress Town){
    	this.code = Code;
    	this.pref = Pref;
    	this.city = City;
    	this.town = Town;
    }

    String getCode(){
    	return code;
    }
    
    MyAddress getPref(){
    	return this.pref;
    }
    
    MyAddress getCity(){
    	return this.city;
    }
    
    MyAddress getTown(){
    	return this.town;
    }
    
    void setCode(String code){
    	this.code = code;
    }
    
    void setPref(MyAddress pref){
    	this.pref = pref ;
    }
    
    void setCity(MyAddress city){
    	this.city = city ;
    }
    
    void setTown(MyAddress town){
    	this.town = town ;
    }
    
    public String toString(){
    	return code + ": " + pref + " " + city + " " + town ;
    }
}

class rp65 {
    static PostalCode[] codeData = new PostalCode[3000];
    static int codeDataLength;
    
    public static void main(String[] args){
        int index = 0;
        String pCode;
        try {
            File file  = new File("shizuokaPostalCode.csv"); 
            Scanner sc = new Scanner(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            HashMap<String,PostalCode> map = new HashMap<String,PostalCode>();
            
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                String[] re = str.split(",", 7);
                if (re.length == 7){
                	map.put(re[0],new PostalCode(re[0],new MyAddress(re[4],re[1]),new MyAddress(re[5],re[2]),new MyAddress(re[6],re[3])));
                    PostalCode cur = new PostalCode();
                    
                    MyAddress p= new MyAddress();
                    MyAddress c= new MyAddress();
                    MyAddress t= new MyAddress();
                    
                    cur.setCode(re[0]);
                    p.setYomi(re[1]);   
                    p.setAddress(re[4]);
                    c.setYomi(re[2]);    
                    c.setAddress(re[5]); 
                    t.setYomi(re[3]);    
                    t.setAddress(re[6]); 

                    cur.setPref(p); 
                    cur.setCity(c);
                    cur.setTown(t); 
                    
                    codeData[index] = cur;

                    index++;
                    
                }
            }
            codeDataLength = index;
            
             while(true){
				System.out.print("address:");
				pCode = br.readLine();
				if(pCode.compareTo("exit") == 0){
					System.out.println("exit!");
					System.exit(0);
				}
				for(int i=0; i<codeDataLength;++i){
					String addr = codeData[i].toString();
					if(addr.indexOf(pCode) != -1)
						System.out.println(addr + "\n");
				}
            }
		
        } catch (FileNotFoundException e){
            System.err.print(e);
        }
        catch(Exception e){

            System.err.print(e);
        }

        /* printAddress(); */
        
    }

    static void printAddress(){
        int i;
        PostalCode tmp;
        for(i=0;i<codeDataLength;i++){
            tmp = codeData[i];
            System.out.println("" + tmp.getCode() + ": "
                               + tmp.getPref().getAddress() + "(" + tmp.getPref().getYomi() + ")"
                               + tmp.getCity().getAddress() + "(" + tmp.getCity().getYomi() + ")"
                               + tmp.getTown().getAddress() + "(" + tmp.getTown().getYomi() + ")");
        }
    }
    
    static void checkPlace(Boolean x){
    
    }
}

