package it.unibas.aziende.modello;

import java.util.Calendar;

public class Dipendente {

    private String codiceFiscale;
    private String nome;
    private String cognome;
    private Calendar dataAssunzione;
    private String sesso;

    public Dipendente(String codiceFiscale, String nome, String cognome, Calendar dataAssunzione, String sesso) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
        this.sesso = sesso;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        if (codiceFiscale.length() != 6) {
            throw new IllegalArgumentException("il codice fiscale deve essere di 6 caratteri");
        }
        this.codiceFiscale = codiceFiscale;
    }

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

    public Calendar getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(Calendar dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    @Override
    public boolean equals(Object obj) {
        Dipendente altroDipendente = (Dipendente) obj;
        return this.hashString().equals(altroDipendente.hashString());

    }

    public int hashCode() {
        return this.hashString().hashCode();

    }

    public String hashString() {
        return this.getCodiceFiscale();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dipendente{codiceFiscale=").append(codiceFiscale);
        sb.append(", nome=").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", dataAssunzione=").append(dataAssunzione);
        sb.append(", sesso=").append(sesso);
        sb.append('}');
        return sb.toString();
    }

}
