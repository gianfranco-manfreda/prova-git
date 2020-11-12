package it.unibas.aziende.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private List<Azienda> listaAziende = new ArrayList<Azienda>();
    private Logger logger = LoggerFactory.getLogger(Archivio.class);

    public List<Azienda> getListaAziende() {
        return listaAziende;
    }

    public void setListaAziende(List<Azienda> listaAziende) {
        this.listaAziende = listaAziende;
    }

    public void addAzienda(Azienda azienda) {
        this.listaAziende.add(azienda);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Archivio{listaAziende=").append(listaAziende);
        sb.append('}');
        return sb.toString();
    }

    public List<Azienda> creaListaAziendePerCitta(String cittaSede) {
        List<Azienda> listaFiltrata = new ArrayList<Azienda>();
        for (Azienda azienda : this.listaAziende) {
            if (azienda.getCittaSede().equalsIgnoreCase(cittaSede)) {
                listaFiltrata.add(azienda);
            }
        }
        Collections.sort(listaFiltrata, new ComparatoreCittaCrescente());
        return listaFiltrata;
    }

    public boolean isDomandaIncompatibile(String codiceFiscale, Azienda azienda) {
        if (azienda.isDomandaGiaPresentata(codiceFiscale)) {
            return true;
        }
        return false;
    }

    public List<Dipendente> creaListaTuttiDipendenti() {
        List<Dipendente> listaTutti = new ArrayList<Dipendente>();
        for (Azienda azienda : this.listaAziende) {

            listaTutti.addAll(azienda.getListaDipendenti());
        }
        return listaTutti;
    }
    
    public boolean verificaDuplicati(List<Dipendente> listaTutti){
        logger.debug("lista dipendenti " + listaTutti.size());
        Set<Dipendente> insiemeDipendenti = new HashSet<Dipendente>(listaTutti);
        logger.debug("insieme dipendenti " + insiemeDipendenti.size());
        return listaTutti.size() != insiemeDipendenti.size();
    }

}
