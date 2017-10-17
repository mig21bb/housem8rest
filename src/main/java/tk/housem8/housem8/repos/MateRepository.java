/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.repos;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.housem8.housem8.entities.Mate;

/**
 *
 * @author Administrador
 */
@CrossOrigin
public interface MateRepository extends CrudRepository<Mate, Integer> {

    @Query("select m from Mate m where m.user = :user")
    public Mate findByUser(@Param("user") String user);
    
    @Query("select m from Mate m where m.email = :email")
    public Mate findByEmail(@Param("email") String email);
        
    @Query("SELECT m FROM Mate m"
             + " left JOIN m.ocupationList o JOIN o.room r JOIN r.houseId h"
             + " WHERE o.startDate < CURRENT_DATE and (o.endDate > CURRENT_DATE or o.endDate is null) and  h.id=:houseId"
            )
    public List<Mate> findByHouse(@Param("houseId") Integer houseId);
    
    
    
}
