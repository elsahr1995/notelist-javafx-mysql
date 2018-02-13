package dao;

import models.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateNoteDaoImpl implements NoteDao {

    private final SessionFactory factory;

    public HibernateNoteDaoImpl() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public List<Note> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Note").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Note find(Long id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Note) session.get(Note.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Long add (Note note) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(note);
            return note.getId();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void update(Note note) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(note);
        } finally {
            tx.commit();
            session.close();
        }

    }

    @Override
    public Integer delete(Long id) {

        Integer count = 0;

        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(find(id));
            count++;
        } finally {
            tx.commit();
            session.close();
        }

        return count;
    }
}
