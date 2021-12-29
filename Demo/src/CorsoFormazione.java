import java.util.*;

public class CorsoFormazione {
	private String nome,descrizione;
	private int presenzeMin,maxPartecipanti,idCorso;
	private Operatore op = new Operatore();
	private ArrayList <Iscritto> iscrizioni = new ArrayList<Iscritto>();
	private ArrayList <Lezione> lezioni = new ArrayList<Lezione>();
	private ArrayList <AreeTematiche> aree = new ArrayList<AreeTematiche>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getPresenzeMin() {
		return presenzeMin;
	}
	public void setPresenzeMin(int presenzeMin) {
		this.presenzeMin = presenzeMin;
	}
	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}
	public void setMaxPartecipanti(int maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}
	public Operatore getOp() {
		return op;
	}
	public void setOp(Operatore op) {
		this.op = op;
	}
	public ArrayList<Iscritto> getIscrizioni() {
		return iscrizioni;
	}
	public void setIscrizioni(ArrayList<Iscritto> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	public ArrayList<Lezione> getLezioni() {
		return lezioni;
	}
	public void setLezioni(ArrayList<Lezione> lezioni) {
		this.lezioni = lezioni;
	}
	public ArrayList<AreeTematiche> getAree() {
		return aree;
	}
	public void setAree(ArrayList<AreeTematiche> aree) {
		this.aree = aree;
	}
}
