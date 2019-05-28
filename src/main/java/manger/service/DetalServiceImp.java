package manger.service;

import manger.dao.DetalDao;
import manger.model.Detal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DetalServiceImp implements DetalService {

    private DetalDao detalDao;
    private List<Detal> listNow = new ArrayList();
    private List<Detal> listTemp = new ArrayList();
    private int paging = 10;
    private int position = 0;

    public void setDetalDao(DetalDao detalDao) {
        this.detalDao = detalDao;
    }

    @Override
    @Transactional
    public void addDetal(Detal detal) {
        this.detalDao.addDetal(detal);
        position = 0;
    }

    @Override
    @Transactional
    public void updateDetal(Detal detal) {
        System.out.println("DetalServiceImp "+detal.getId()+" "+detal.getName()+"***");
        this.detalDao.updateDetal(detal);
        position = 0;
    }

    @Override
    @Transactional
    public void removeDetal(int id) {
        this.detalDao.removeDetal(id);
        this.listNow = this.detalDao.listDetals();
        position = 0;
    }

    @Override
    @Transactional
    public List<Detal> getDetalByName(String str) {
        List<Detal> detals = this.detalDao.listDetals();
        listNow.clear();
        for (Detal detal: detals
             ) {
            if(detal.getName().toLowerCase().contains(str.toLowerCase())){
                listNow.add(detal);
            }
        }
        position = 0;
        return listNow;
    }

    @Override
    @Transactional
    public List<Detal> listNeed() {
        listNow.clear();
        List<Detal> detals = this.detalDao.listDetals();
        for (Detal detal: detals
        ) {
            if(detal.isNeed()){
                listNow.add(detal);
            }
        }
        position = 0;
        return listNow;
    }

    @Override
    @Transactional
    public List<Detal> listNoNeed() {
        listNow.clear();
        List<Detal> detals = this.detalDao.listDetals();
        for (Detal detal: detals
        ) {
            if(!detal.isNeed()){
                listNow.add(detal);
            }
        }
        position = 0;
        return listNow;
    }

    @Override
    @Transactional
    public List<Detal> listNext() {
        if(position+paging<listNow.size())
            position+=paging;
        return null;
    }

    @Override
    @Transactional
    public List<Detal> listPrev() {
        if(position<paging)
            position = 0;
        else
            position-=paging;
        return null;
    }

    @Override
    @Transactional
    public Detal getDetalById(int id) {
        return this.detalDao.getDetalById(id);
    }

    @Override
    @Transactional
    public List<Detal> listDetals() {

        listTemp.clear();
        for(int i = position; i < position + paging; i++){
            if(i < listNow.size())
                listTemp.add(listNow.get(i));
            else
                return listTemp;
        }
        return listTemp;
    }

    @Override
    @Transactional
    public int compAmount() {
        List<String> typeList = new ArrayList();
        List<Integer> typeAmnt = new ArrayList();
        List<Detal> detals = this.detalDao.listDetals();

        for (Detal detal: detals
        ) {
            if(detal.isNeed() && !typeList.contains(detal.getType())){
                typeList.add(detal.getType());
            }
        }

        for (String type: typeList
        ) {
            int count = 0;
            for (Detal detal: detals){
                if(detal.getType().equals(type)){
                    count+=detal.getAmount();
                }
            }
            if(count==0) return 0;
            typeAmnt.add(count);
        }

        return Collections.min(typeAmnt);
    }

    @Override
    @Transactional
    public List<Detal> listAll() {
        listNow = this.detalDao.listDetals();
        return listNow;
    }

    @Override
    @Transactional
    public List<Detal> listNow() {
        listTemp.clear();
        List<Detal> listAll = listAll();
        for(int i = position; i < position + paging; i++){
            if(i < listAll.size())
                listTemp.add(listAll.get(i));
            else
                return listTemp;
        }
        return listTemp;
    }

}
