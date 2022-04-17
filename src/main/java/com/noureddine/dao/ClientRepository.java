/**
 * 
 */
package com.noureddine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noureddine.entities.Client;

/**
 * @author Aboubakar
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
