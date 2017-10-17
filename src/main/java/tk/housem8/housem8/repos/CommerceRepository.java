/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.repos;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.housem8.housem8.entities.Commerce;
import tk.housem8.housem8.entities.Cost;
import tk.housem8.housem8.entities.CostFamily;

/**
 *
 * @author Administrador
 */

@CrossOrigin
public interface CommerceRepository extends CrudRepository<Commerce, Integer> {

    @Query("select cm from Commerce cm where cm.activo=1 and cm.fechaBorrado is null")
    public List<Commerce> findAllActive();
    
}
