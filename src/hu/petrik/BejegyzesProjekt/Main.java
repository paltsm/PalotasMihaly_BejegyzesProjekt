package hu.petrik.BejegyzesProjekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Bejegyzes> bejegyzesek = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		bejegyzesekHozzaadasa();
		try {
			konzolosBejegyzes();
		} catch (NumberFormatException e) {
			System.out.println("nem pozitív egész számot adott meg");
		}
	}

	public static void konzolosBejegyzes() {

		System.out.print("kérem adja meg, hány darab bejegyzést akar még: ");
		int dbszam = -1;
		while (dbszam < 0) {
			dbszam = Integer.parseInt(sc.nextLine());
			if (dbszam < 0) {
				throw new NumberFormatException();
			}
			for (int i = 0; i < dbszam; i++) {
				System.out.print("szerző: ");
				String szerzo = sc.nextLine();
				System.out.print("tartalom: ");
				String tartalom = sc.nextLine();
				if (szerzo.isEmpty()) {
					bejegyzesek.add(new Bejegyzes());
				} else {
					bejegyzesek.add(new Bejegyzes(szerzo, tartalom));
				}
			}
			for (Bejegyzes bejegyzes : bejegyzesek) {
				System.out.println(bejegyzes);
			}

		}
//		c.) A bejegyzesek.csv további bejegyzéseket tartalmaz az alábbi formában:
//			szerzo;tartalom
//		Olvasd be a fájlt és a tartalmát add hozzá a listához.
//		d.) Ossz ki véletlenszerűen hússzor annyi likeot mint ahány bejegyzés található a listában. (pl.
//			10 bejegyzés esetén 200 like kerüljön kiosztásra)
//		e.) Kérj be a felhasználótól egy szöveget. A második bejegyzés tartalmát módosítsd a
//			felhasználó által megadott szövegre.
//		f.) Írd ki a bejegyzéseket a konzolra.
	}

	public static void bejegyzesekHozzaadasa() {
		Bejegyzes b1 = new Bejegyzes("Teszt Elek", "tesztelek");
		Bejegyzes b2 = new Bejegyzes("Gipsz Jakab", "bejegyzés2 ------");
		bejegyzesek.add(b1);
		bejegyzesek.add(b2);
	}
}
