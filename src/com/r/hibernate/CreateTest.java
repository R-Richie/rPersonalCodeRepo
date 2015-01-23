package com.r.hibernate;

import java.sql.Time;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Track track = new Track("Russia Trance",
					"vol2/album610/track02.mp3", Time.valueOf("00:03:30"),
					new Date(), (short) 0);
			session.save(track);
			track = new Track("Video Killed the Radio Star",
					"vol2/album611/track12.mp3", Time.valueOf("00:03:49"),
					new Date(), (short) 0);
			session.save(track);
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (tx != null) {
				tx.rollback();
			}
			throw new Exception("Transaction failed", e);
		} finally {
			session.close();
		}
		sessionFactory.close();
	}
}
