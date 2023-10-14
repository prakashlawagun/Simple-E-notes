package com.prakash.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prakash.entity.Notes;
import com.prakash.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		int i =(Integer)hibernateTemplate.save(user);
		return i;
	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		String sql = "from User where email=:em and password=:pwd";
		
		User user = (User) hibernateTemplate.execute(s->{
			Query q = s.createQuery(sql);
			q.setParameter("em", email);
			q.setParameter("pwd", password);
			
			return q.uniqueResult();
		});
		
		return user;
	}

	@Override
	public int saveNotes(Notes note) {
		// TODO Auto-generated method stub
		int i = (Integer)hibernateTemplate.save(note);
		return i;
	}

	@Override
	public List<Notes> getNotesByUser(User user) {
		// TODO Auto-generated method stub
		String sql = "from Notes where  user=: us";
		
		List<Notes> list = hibernateTemplate.execute(s->{
		Query<Notes> q = s.createQuery(sql);
		q.setParameter("us", user);
		return q.getResultList();
		
	});
		return list;
	}

	@Override
	public Notes getNotesById(int id) {
		// TODO Auto-generated method stub
		Notes n = hibernateTemplate.get(Notes.class,id);
		return n;
	}

	@Override
	public void updateNotes(Notes note) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(note);
	}

	@Override
	public void deleteNotes(int id) {
		// TODO Auto-generated method stub
		Notes n = hibernateTemplate.get(Notes.class,id);
		hibernateTemplate.delete(n);
		
	}

}
