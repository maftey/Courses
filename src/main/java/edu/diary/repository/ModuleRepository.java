package edu.diary.repository;

import java.util.Set;

import edu.diary.domain.Course;
import edu.diary.domain.Module;

public interface ModuleRepository {

	// CREATE if Module.module = null, if id!=null -> UPDATE
	Module save(Module module);
	
	Module update(Module module, int id);

	Module get(String name);
	
	// false if not found
	boolean delete(String name);

	// null if not found
	Set<Module> getAll();

	boolean deleteAll();

	Set<Module> getAllForCourse(Course course);

	
}
