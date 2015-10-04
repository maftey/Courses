package edu.diary.repository;

import java.util.Set;

import edu.diary.domain.IModule;

public interface ModuleRepository {
  

  // CREATE if Module.module = null, if id!=null -> UPDATE
  IModule save(IModule module);

  //    false if not found
  boolean delete(int id);

  IModule get(int id);

  // null if not found
  Set<IModule> getAll();

  void deleteAll();
}
