package com.mzr.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mzr.domain.PhoneNumber;
import com.mzr.domain.User;
import com.mzr.utility.HibernateUtil;

public class OToMDAOImpl implements OToMDAO {

	@Override
	public void saveData() {
		Session ses = HibernateUtil.getSession();
		
		User user = new User();
		user.setUserId(1);
		user.setFirstName("Raja");
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setPhone(620000);
		ph1.setNumberType("Home");
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setPhone(954850);
		ph2.setNumberType("Office");
		
		Set<PhoneNumber>childs = new HashSet<PhoneNumber>();
		childs.add(ph1);
		childs.add(ph2);
		
		user.setPhones(childs);
		
		User user1 = new User();
		user1.setUserId(1005);
		user1.setFirstName("Mazhar");
		
		PhoneNumber ph3 = new PhoneNumber();
		ph3.setPhone(0002111);
		ph3.setNumberType("Home");
		
		PhoneNumber ph4 = new PhoneNumber();
		ph4.setPhone(7777754);
		ph4.setNumberType("Office");
		
		Set<PhoneNumber>childs1 = new HashSet<PhoneNumber>();
		childs1.add(ph3);
		childs1.add(ph4);
		
		user1.setPhones(childs1);
		Transaction tx = null;
		
			tx = ses.beginTransaction();
			ses.save(user);
			ses.save(user1);
			tx.commit();
			System.out.println("Objects are saved");
		
	}

	@Override
	public void loadData() {
		Session ses = HibernateUtil.getSession();
		Query query = null;
		List<User> list = null;
		Set<PhoneNumber> childs = null;
		query = ses.createQuery("from User");
		list = query.list();
		for(User user:list) {
			System.out.println("Parent---->"+user);
			childs=user.getPhones();
			for(PhoneNumber ph:childs) {
				System.out.println("childs---->"+ph);
			}
		}
		User user = (User)ses.get(User.class, 1);
		Set<PhoneNumber> childs1 = user.getPhones();
		childs1.size();
		/*for(PhoneNumber ph:childs1) {
			System.out.println(ph);
		}*/
	}

	@Override
	public void addNewPhoneNumberToExistingUser() {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, 1002);
		Set<PhoneNumber> childs = user.getPhones();
		PhoneNumber ph = new PhoneNumber();
		ph.setPhone(555555555);
		ph.setNumberType("Personal");
		Transaction tx = ses.beginTransaction();
		try {
			childs.add(ph);
			tx.commit();
			System.out.println("New Child is added");
		}
		catch (Exception e) {
			tx.rollback();
		}
		

	}

	@Override
	public void deleteUserWithPhoneNumber() {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, 1001);
		Transaction tx = ses.beginTransaction();
		try {
			ses.delete(user);
			tx.commit();
			System.out.println("Object is deleted");
		}
		catch (Exception e) {
			tx.rollback();
		}

	}

	@Override
	public void deleteOnePhoneNumberOfAUser() {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, 1004);
		Set<PhoneNumber> childs =user.getPhones();
		PhoneNumber ph = ses.get(PhoneNumber.class,(long)555555555);
		Transaction tx = ses.beginTransaction();
		try {
			childs.remove(ph);
			tx.commit();
			System.out.println("PhoneNumber is deleted");
		} catch (Exception e) {
			tx.rollback();
		}

	}

	@Override
	public void deleteAllPhoneNumberOfAUser() {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, 1005);
		Set<PhoneNumber> childs = user.getPhones();
		Transaction tx = ses.beginTransaction();
		try {
			childs.clear();
			tx.commit();
			System.out.println("Phone Numbers are cleared");
		} catch (Exception e) {
			tx.rollback();
		}

	}

	@Override
	public void transferPhoneNumberFromOneUserToAnotherUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePhoneNumberProviderForExistingUser() {
		// TODO Auto-generated method stub

	}

}
