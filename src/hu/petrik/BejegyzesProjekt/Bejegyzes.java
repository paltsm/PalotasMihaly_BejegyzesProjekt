package hu.petrik.BejegyzesProjekt;

import java.time.LocalDateTime;

public class Bejegyzes {
	private String szerzo;
	private String tartalom;
	private int likeok;
	private LocalDateTime letrejott;
	private LocalDateTime szerkesztve;

	public String getSzerzo() {
		return szerzo;
	}

	public String getTartalom() {
		return tartalom;
	}

	public int getLikeok() {
		return likeok;
	}

	public LocalDateTime getLetrejott() {
		return letrejott;
	}

	public LocalDateTime getSzerkesztve() {
		return szerkesztve;
	}

	public Bejegyzes(String szerzo, String tartalom) {
		this.szerzo = szerzo;
		this.tartalom = tartalom;
	}

	public void setTartalom(String tartalom) {
		this.tartalom = tartalom;
	}
	public void like(){

	}
//	Az osztály példányosításakor állítsa be a likeok számát 0-ra, a létrehozás és a
//	szerkesztés idejét pedig az aktuális időpontra (konstruktorban készítsd el).
//	• A tartalom módosításakor változzon a szerkesztés ideje is az aktuális időpontra
//	(tartalom setterjében készítsd el).
//	• A like() eljárás növelje a likeok számát 1-el.
//	c.) Írd felül a beépített toString() függvényt, hogy visszaadja az adatokat az alábbi formában:
//	szerzo – likeok – letrejott
//	Szerkeszve: szerkesztes
//			tartalom
//+.) Csak akkor írja ki a szerkesztés dátumát, ha a bejegyzés módosítva lett.
}
