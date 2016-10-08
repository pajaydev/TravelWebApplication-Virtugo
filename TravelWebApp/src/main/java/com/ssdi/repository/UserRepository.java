/**
 * 
 */
package com.ssdi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssdi.entity.UserDetails;

/**
 * @author ajaykumar
 *
 */
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
