package manger.dao;

import manger.model.Detal;

import java.util.List;

public interface DetalDao {
    public void addDetal(Detal detal);
    public void updateDetal(Detal detal);
    public void removeDetal(int id);
    public Detal getDetalById(int id);
    public List<Detal> listDetals();

}
