package manger.service;

import manger.model.Detal;

import java.util.List;

public interface DetalService {
    public void addDetal(Detal detal);
    public void updateDetal(Detal detal);
    public void removeDetal(int id);
    public Detal getDetalById(int id);
    public List<Detal> listDetals();
    public int compAmount();

    public List<Detal> getDetalByName(String str);
    public List<Detal> listNeed();
    public List<Detal> listNoNeed();
    public List<Detal> listAll();
    public List<Detal> listNext();
    public List<Detal> listPrev();
    public List<Detal> listNow();


}
