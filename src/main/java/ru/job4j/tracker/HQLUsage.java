package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import java.util.List;

public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            List<Item> list = findAll(session);
            for (Item it : list) {
                System.out.println(it);
            }
            Item rsl = unique(session);
            System.out.println(rsl);
            Item rsl1 = findById(session, 1);
            System.out.println(rsl1);
            var item = new Item();
            item.setName("Item 4");
            Item rsl2 = insert(session, item);
            System.out.println(rsl2);
            System.out.println(update(session, 4));
            System.out.println(delete(session, item.getId()));
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static List<Item> findAll(Session session) {
        Query query = session.createQuery("from Item");
        return query.list();
    }

    public static Item unique(Session session) {
        Query<Item> query = session.createQuery(
                "from Item as i where i.id = 3", Item.class);
        return query.uniqueResult();
    }

    public static Item findById(Session session, int id) {
        Query<Item> query = session.createQuery(
                "from Item as i where i.id = :fId", Item.class);
        query.setParameter("fId", id);
        return query.uniqueResult();
    }

    public static Item insert(Session session, Item item) {
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return item;
    }

    public static boolean update(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                            "UPDATE Item SET name = :fName WHERE id = :fId")
                    .setParameter("fName", "new name")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return false;
    }

    public static boolean delete(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return false;
    }
}
