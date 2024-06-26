import java.sql.Date;
import java.util.*;

public class Studente {
	private String nome,cognome,cf,matricola,password;
	private Date data;
	private ArrayList <Iscritto> iscrizioni = new ArrayList<Iscritto>();
	private ArrayList <Partecipa> presenze = new ArrayList<Partecipa>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Iscritto> getIscrizioni() {
		return iscrizioni;
	}
	public void setIscrizioni(ArrayList<Iscritto> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}
	public ArrayList<Partecipa> getPresenze() {
		return presenze;
	}
	public void setPresenze(ArrayList<Partecipa> presenze) {
		this.presenze = presenze;
	}
}
