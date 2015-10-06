package edu.diary.repository;

import java.util.Set;

import edu.diary.domain.Module;

public interface ModuleRepository {

	// CREATE if Module.module = null, if id!=null -> UPDATE
	Module save(Module module);

	// false if not found
	boolean delete(String name);

	Module get(String name);

	// null if not found
	Set<Module> getAll();

	boolean deleteAll();

	Module update(Module module);
}
