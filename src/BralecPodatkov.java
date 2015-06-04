import java.util.StringTokenizer;
import java.io.*;

public class BralecPodatkov{
/**
Desc: shrani niz v spremenljivko, prebere ga iz STDIN
Params: -
Pre: -
Post: -
Result: spremenljivka s shranjenim nizom
Env: -
*/
	public String beriNiz(){
		char ch =' ';
		int tmp;
		String strTmp = "";
		try{
			while(ch != '\n'){
				//ch = (char)
				tmp = System.in.read();
				//if(ch != '\n')
				ch = (char)tmp;
				if(!Character.isISOControl(tmp))
					strTmp += ch;
			}
		}
		catch(Exception e){}
		return(strTmp);
	}
/**
Desc: Pretvori niz, ki ga prebere iz STDIN v vektor celih stevil
Params: -
Pre: -
Post: -
Result: Vektor celih stevil
Env: -
*/
	public int[] beriStevila(){
		String niz = beriNiz();
		int intTmp[] = pretvoriVStevila(niz);;
		return (intTmp);
	}
/**
Desc: Pretvori niz v vektor stevil.
Params: - vhodni niz String
Pre: -
Post: -
Result: Vektor celih stevil
Env: -
*/
	private int[] pretvoriVStevila(String niz){
		String strTmp;
                StringTokenizer strTok = new StringTokenizer(niz);
                int intTmp[], i = 0;
                intTmp = new int[strTok.countTokens()];
                while(strTok.hasMoreTokens()){
                        strTmp = strTok.nextToken();
                        intTmp[i++] = Integer.valueOf(strTmp).intValue();
                }
		return(intTmp);
	}
/*
Desc: Prebere matriko iz datoteke
Params: - Ime datoteke, String
Pre: -
Post: -
Result: Polje nizov, ki predstavljajo znakovni zapis matrike
Env: -
*/
	private String[] beriIzDatoteke(String imeDatoteke){
		FileInputStream fin;
		int c, i = 0;
		String strTmp[] = new String[30];
		strTmp[0] = "";
		try {
			fin = new FileInputStream(imeDatoteke);
			while ((c = fin.read())!=-1) { // beremo prvi znak
			if((char)c != '\n')
				strTmp[i] += (char)c;
			else{
				i++;
				strTmp[i] = "";
			}
			}
		}catch (Exception e) {
			System.out.println("Ne morem odpreti "+ e.getMessage());
		}
		String sss[] = new String[i];
		for(int j = 0; j < i; j++)
			sss[j] = strTmp[j];
		return(sss);
	}
/*
Desc: Prebere matriko iz datoteke in jo zapi¹e v matriko celih stevil
Params: - Ime datoteke, String
Pre: -
Post: -
Result: Matrika celih stevil
Env: -
*/
	public int[][] beriMatrikoIzDatoteke(String imeDatoteke){
		String strTmp[] = beriIzDatoteke(imeDatoteke);
		int intTmp[][] = new int[30][30], j;
		for(j= 0; j < strTmp.length; j++){
			intTmp[j] = pretvoriVStevila(strTmp[j]);
		}
		int iii[][] = new int[strTmp.length][intTmp[0].length];
		for(j = 0; j < strTmp.length; j++)
			iii[j] = intTmp[j];
		return(iii);
	}

}
