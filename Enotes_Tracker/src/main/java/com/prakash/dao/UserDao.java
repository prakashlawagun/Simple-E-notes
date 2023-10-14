package com.prakash.dao;

import java.util.List;

import com.prakash.entity.Notes;
import com.prakash.entity.User;

public interface UserDao {
	public int saveUser(User user);
	
	public User login(String email,String password);
	
	public int saveNotes(Notes note);
	
	public List<Notes> getNotesByUser(User user);
	
	public Notes getNotesById(int id);
	
	public void updateNotes(Notes note);
	
	public void deleteNotes(int id);
}
