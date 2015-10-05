package edu.diary.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

import edu.diary.domain.IModule;
import edu.diary.repository.ModuleRepository;

public class JdbcModuleRepositoryImpl implements ModuleRepository{
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	@Override
	public IModule save(IModule module) {
		String inserUser = "INSERT INTO modules ";
//		PreparedStatement ps = conn.prepareStatement();
		
		
		
		
		
		
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IModule get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<IModule> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	

}
