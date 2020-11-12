package it.unibas.aziende.modello;

import java.util.ArrayList;
import java.util.List;

public class Azienda {

    private String partitaIva;
    private String denominazione;
    private String cittaSede;
    private List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();

    public Azienda(String partitaIva, String denominazione, String cittaSede) {
        this.partitaIva = partitaIva;
        this.denominazione = denominazione;
        this.cittaSede = cittaSede;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public String prova(){
    	return "prova con git";
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getCittaSede() {
        return cittaSede;
    }

    public void setCittaSede(String cittaSede) {
        this.cittaSede = cittaSede;
    }

    public List<Dipendente> getListaDipendenti() {
        return listaDipendenti;
    }

    public void setListaDipendenti(List<Dipendente> listaDipendenti) {
        this.listaDipendenti = listaDipendenti;
    }

    public void addDipendente(Dipendente dipendente) {
        this.listaDipendenti.add(dipendente);
    }

    public boolean isDomandaGiaPresentata(String codiceFiscale) {
        for (Dipendente dipendente : listaDipendenti) {
            if (dipendente.getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Azienda{partitaIva=").append(partitaIva);
        sb.append(", denominazione=").append(denominazione);
        sb.append(", cittaSede=").append(cittaSede);
        sb.append(", listaDipendenti=").append(listaDipendenti);
        sb.append('}');
        return sb.toString();
    }

}
