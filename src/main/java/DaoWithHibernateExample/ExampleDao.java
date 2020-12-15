package DaoWithHibernateExample;

import DaoWithHibernateExample.JPA.ExampleEntity;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ExampleDao extends AbstractHibernateDao<ExampleEntity> implements Dao<ExampleEntity>
{
    public ExampleDao() {
        setClazz(ExampleEntity.class);
    }

    public List<ExampleEntity> getResultListByCategory(String category) {
        Session session = Hibernate.getSession();

        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ExampleEntity> query = builder.createQuery(ExampleEntity.class);
        Root<ExampleEntity> root = query.from(ExampleEntity.class);

        query.select(root).where(builder.equal(root.get("category"), category));
        List<ExampleEntity> resultList = session.createQuery(query).getResultList();

        session.getTransaction().commit();
        return resultList;
    }

    public void deleteAll() {
        List<ExampleEntity> all = getAll();

        for(int i = 0; i < all.size(); i++) {
            delete(all.get(i));
        }
    }

    public void resetCategory(String category) {
        ExampleDao dao = new ExampleDao();
        dao.getResultListByCategory(category).forEach(el -> {
            el.setIknowit(false);
            dao.update(el);
        });
    }

    public void resetAllCategory() {
        ExampleDao dao = new ExampleDao();
        List<ExampleEntity> list = dao.getAll();
        list.forEach(el -> {
            el.setIknowit(false);
            dao.update(el);
        });
    }

    public void setIknowIt(ExampleEntity entity) {
        ExampleDao dao = new ExampleDao();
        entity.setIknowit(true);
        dao.update(entity);
    }

    public ExampleEntity getRandomExampleWithCategory(String category) {

        try (Session session = Hibernate.getSession()) {
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ExampleEntity> query = builder.createQuery(ExampleEntity.class);
            Root<ExampleEntity> root = query.from(ExampleEntity.class);

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("category"), category));
            predicates.add(builder.equal(root.get("iknowit"), false));

            query.where(predicates.toArray(new Predicate[0]));
            List<ExampleEntity> resultList = session.createQuery(query).getResultList();
            if (resultList.size() < 1) {
//            ExampleEntity empty = new ExampleEntity();
//            empty.setExample("Вопросы кончились - на выход");
//            return empty;
                return null;
            }
            int randomNumber = (int) (Math.random() * resultList.size());
            return resultList.get(randomNumber);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
