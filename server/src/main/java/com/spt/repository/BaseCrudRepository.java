package com.spt.repository;

import com.spt.entity.User;
import org.springframework.data.repository.CrudRepository;

public class BaseCrudRepository<T, ID> extends CrudRepository<T, ID> {
}
