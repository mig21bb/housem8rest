/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.housem8.housem8.entities.Ocupation;

/**
 *
 * @author Administrador
 */
@CrossOrigin
public interface OcupationRepository extends CrudRepository<Ocupation, Integer> {
    
}
