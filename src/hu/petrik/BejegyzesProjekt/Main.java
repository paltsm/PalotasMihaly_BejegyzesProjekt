package hu.petrik.BejegyzesProjekt;

import java.io.*;
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
		bejegyzesEdit();
		System.out.println();
		System.out.println("----------------------");
		for (Bejegyzes bejegyzes : bejegyzesek) {
			System.out.println(bejegyzes);
		}
		likeDolgok();
		System.out.println();
		System.out.println("----------------------");
		Rendezes();
		for (Bejegyzes bejegyzes : bejegyzesek) {
			System.out.println(bejegyzes);
		}
		try {
			TextIratas();
		} catch (IOException e) {
			throw new RuntimeException(e);
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
	}

	public static void randomLike() {
		for (int i = 0; i < 20 * bejegyzesek.size(); i++) {
			int index = (int) (Math.random() * bejegyzesek.size());
			bejegyzesek.get(index).like();
		}
	}

	public static void bejegyzesEdit() {
		System.out.print("adjon meg egy szöveget: ");
		String tartalom=sc.nextLine();
		bejegyzesek.get(1).setTartalom(tartalom);
	}

	public static void likeDolgok(){
		int maxLike=0;
		for (int i = 1; i < bejegyzesek.size(); i++) {
			if (bejegyzesek.get(maxLike).getLikeok()<bejegyzesek.get(i).getLikeok()){
				maxLike=i;
			}
		}
		System.out.printf("legnépszerűbb poszt likeok: %d",bejegyzesek.get(maxLike).getLikeok());
		int harmicot=0;
		int tizenot=0;
		for (Bejegyzes bejegyzes:bejegyzesek) {

			if (bejegyzes.getLikeok()>35){
				harmicot++;
			}
			if (bejegyzes.getLikeok()<15){
				tizenot++;
			}
		}
		System.out.printf("%d db posztnak van 35-nél több like",harmicot);
		System.out.printf("%d db posztnak van 15-nél kevesebb like",tizenot);
	}
	public static void Rendezes(){

		for (int i = bejegyzesek.size()-1; i > 0; i--) {
			for (int j = 0; j <= i-1; j++) {
				if (bejegyzesek.get(j).getLikeok()<bejegyzesek.get(j+1).getLikeok()){
					Bejegyzes b1=bejegyzesek.get(j+1);
					bejegyzesek.set(j+1,bejegyzesek.get(j));
					bejegyzesek.set(j,b1);
				}
			}
		}
	}
	public  static void TextIratas() throws IOException {
//		+.) A rendezett lista tartalmát írd ki egy bejegyzesek_rendezett.txt fájlba.
		FileWriter writer=new FileWriter("test.txt");
		PrintWriter pw=new PrintWriter(writer);
		for (Bejegyzes bejegyzes:bejegyzesek) {
			pw.println(bejegyzes);
		}

		pw.close();
		writer.close();
		System.out.println("okos");
	}
	public static void bejegyzesekHozzaadasa() {
		Bejegyzes b1 = new Bejegyzes("Teszt Elek", "tesztelek");
		Bejegyzes b2 = new Bejegyzes("Gipsz Jakab", "bejegyzés2 ------");
		bejegyzesek.add(b1);
		bejegyzesek.add(b2);
	}
}
