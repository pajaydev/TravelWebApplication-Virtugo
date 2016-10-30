/**
 * 
 */
package com.ssdi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ssdi.entity.User;


/**
 * @author adithya956
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	User findByEmailAndPassword(String email, String password);
}


