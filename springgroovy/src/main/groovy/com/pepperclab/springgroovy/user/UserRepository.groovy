package com.pepperclab.springgroovy.user

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Created by johney on 15. 6. 10..
 */
@Repository
@Qualifier(value = "userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}