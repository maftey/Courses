package edu.diary.Service;

import java.util.Set;

import edu.diary.domain.IModule;

public interface ModuleService {
  

  // CREATE if Module.module = null, if id!=null -> UPDATE
  IModule save(IModule module);

  //    false if not found
  boolean delete(int id);

  IModule get(int id);

  // null if not found
  Set<IModule> getAll();

  void deleteAll();
}
