package hu.petrik.BejegyzesProjekt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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

	public void setTartalom(String tartalom) {
		this.tartalom = tartalom;
		this.szerkesztve = LocalDateTime.now();
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
		this.likeok = 0;
		this.letrejott = LocalDateTime.now();
		this.szerkesztve =  this.letrejott;
	}
	public Bejegyzes(){
		this.szerzo="Teszt Elek";
		this.tartalom="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, nostrum.";
		this.likeok = 0;
		this.letrejott = LocalDateTime.now();
		this.szerkesztve =  this.letrejott;
	}

	public void like() {
		this.likeok++;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return String.format("%s - %d - %s" +
						"%s" +
						"\n%s\n",
				this.szerzo, this.likeok, this.letrejott.format(formatter),
				(!Objects.equals(this.szerkesztve, this.letrejott)) ? "\nSzerkesztve: "+this.szerkesztve.format(formatter) : "",
				this.tartalom);
	}
}
