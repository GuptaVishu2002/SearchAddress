import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

class MyAddress {
    String address;
    String yomi;
}

class PostalCode {
    String code;
    MyAddress pref;
    MyAddress city;
    MyAddress town;
}

class rp6 {
    static PostalCode[] codeData = new PostalCode[3000];
    static int codeDataLength;
    
    public static void main(String[] args){
        int index = 0;
        try {
            File file  = new File("shizuokaPostalCode.csv"); 
            Scanner sc = new Scanner(file);
            
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                String[] re = str.split(",", 7);
                if (re.length == 7){
                    PostalCode cur = new PostalCode();
                    
                    MyAddress p= new MyAddress();
                    MyAddress c= new MyAddress();
                    MyAddress t= new MyAddress();
                    
                    cur.code  = re[0];
                    p.yomi    = re[1];
                    p.address = re[4];
                    c.yomi    = re[2];
                    c.address = re[5];
                    t.yomi    = re[3];
                    t.address = re[6];

                    cur.pref = p;
                    cur.city = c;
                    cur.town = t;
                    
                    codeData[index] = cur;

                    index++;
                }
            }
            codeDataLength = index;
        } catch (FileNotFoundException e){
            System.err.print(e);
        }

        printAddress();
    }

    static void printAddress(){
        int i;
        PostalCode tmp;
        for(i=0;i<codeDataLength;i++){
            tmp = codeData[i];
            System.out.println("" + tmp.code + ": "
                               + tmp.pref.address + "(" + tmp.pref.yomi + ")"
                               + tmp.city.address + "(" + tmp.city.yomi + ")"
                               + tmp.town.address + "(" + tmp.town.yomi + ")");
        }
    }
}

