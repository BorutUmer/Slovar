public class Slovar {

	public static void main(String[] args) {
		BralecPodatkov br = new BralecPodatkov();
		String niz;
		System.out.print("Vpiši želeno besedilo: ");
		niz = br.beriNiz();
		String[] seznamBesed = niz.split(" ");
		for (int i = 0; i < seznamBesed.length; i++) {
			System.out.println(seznamBesed[i]);
		}
		System.out.println("V besedilu je " + seznamBesed.length + " besed");
		int stevec = 0;
		for (int j = 0; j < seznamBesed.length; j++) {
			for (int k = 0; k < seznamBesed.length; k++) {
				if ((seznamBesed[j].equals(seznamBesed[k])) && (k != j)) {

					break;
				} else if ((k == seznamBesed.length - 1) || (k == j)) {
					stevec++;

				}
			}
		}
		System.out.println("V besedilu je " + stevec + "enoliènih pojavitev besed");

		System.out.println("V besedilu je " + niz.length() + " znakov");
		for (int k = seznamBesed.length - 1; k >= 0; k--) {
			System.out.print(seznamBesed[k] + " ");
		}

	}

}
