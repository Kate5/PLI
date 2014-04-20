package ua.alf.repository;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.alf.model.Language;
import ua.alf.model.Statistic;
import ua.alf.util.HibernateUtil;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene Chipachenko
 * Date: 20.04.2014
 * Time: 13:40
 */
public class StatisticRepository {
    private static StatisticRepository instance = new StatisticRepository();

    public static StatisticRepository getInstance() {
        return instance;
    }

    private StatisticRepository() {
    }

    public void save(Statistic statistic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(statistic);
        session.getTransaction().commit();
        session.close();
    }

    public void remove(Statistic statistic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(session);
        session.getTransaction().commit();
        session.close();
    }

    public List<Statistic> findByLanguage(Language language) {
        List result;

        Session session = HibernateUtil.getSessionFactory().openSession();
        result = session.createCriteria(Statistic.class)
                .add(Restrictions.eq("language", language))
                .list();
        session.close();

        return result;
    }

    public Statistic findByLangAndDate(Language language, Date date) {
        Statistic result;
        Session session = HibernateUtil.getSessionFactory().openSession();
        result = (Statistic) session.createCriteria(Statistic.class)
                .add(Restrictions.eq("language", language))
                .add(Restrictions.eq("date", date))
                .uniqueResult();
        session.close();
        return result;
    }
}
