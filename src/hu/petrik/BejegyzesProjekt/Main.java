package hu.petrik.BejegyzesProjekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		String fajlNev = "bejegyzesek.csv";
		try {
			beolvasasosBejegyzes(fajlNev);
		} catch (FileNotFoundException e) {
			System.out.println("hiba! nem található az alábbi fájl: " + fajlNev);
		} catch (IOException e) {
			System.out.println("ismeretlen hiba történt a forrásfájl olvasása során");
			System.out.println(e.getMessage());
		}
		randomLike();
		for (Bejegyzes bejegyzes : bejegyzesek) {
			System.out.println(bejegyzes);
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

		}

	}

	public static void beolvasasosBejegyzes(String fajlNev) throws IOException {
		FileReader fr = new FileReader(fajlNev);
		BufferedReader br = new BufferedReader(fr);
		String sor = br.readLine();
		while (sor != null && !sor.isEmpty()) {
			String[] adatok = sor.split(";");
			Bejegyzes bejegyzes = new Bejegyzes(adatok[0], adatok[1]);
			bejegyzesek.add(bejegyzes);
			sor = br.readLine();
		}
		br.close();
		fr.close();
//		e.) Kérj be a felhasználótól egy szöveget. A második bejegyzés tartalmát módosítsd a
//			felhasználó által megadott szövegre.
//		f.) Írd ki a bejegyzéseket a konzolra.
	}

	public static void randomLike() {
		for (int i = 0; i < 20 * bejegyzesek.size(); i++) {
			int index = (int) (Math.random() * bejegyzesek.size());
			bejegyzesek.get(index).like();
		}
	}
	

	public static void bejegyzesekHozzaadasa() {
		Bejegyzes b1 = new Bejegyzes("Teszt Elek", "tesztelek");
		Bejegyzes b2 = new Bejegyzes("Gipsz Jakab", "bejegyzés2 ------");
		bejegyzesek.add(b1);
		bejegyzesek.add(b2);
	}
}
