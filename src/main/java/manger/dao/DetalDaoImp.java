package manger.dao;

import manger.model.Detal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DetalDaoImp implements DetalDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addDetal(Detal detal) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(detal);
    }

    @Override
    @Transactional
    public void updateDetal(Detal detal) {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println("DetalDaoImp "+detal.getId()+" "+detal.getName());
        session.update(detal);
    }

    @Override
    @Transactional
    public void removeDetal(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Detal detal = (Detal) session.load(Detal.class, new Integer(id));

        if (detal!=null){
            session.delete(detal);
        }
    }

    @Override
    @Transactional
    public Detal getDetalById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Detal detal = (Detal) session.load(Detal.class, new Integer(id));
        System.out.println("from getDetalById "+ detal.getName());

        return detal;
    }

    @Override
    @Transactional
    public List<Detal> listDetals() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Detal> detalList = session.createQuery("from Detal").list();

        return detalList;
    }

}
