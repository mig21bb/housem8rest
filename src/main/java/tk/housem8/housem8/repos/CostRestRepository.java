/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.repos;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.housem8.housem8.entities.CostRest;

/**
 *
 * @author Administrador
 */
@CrossOrigin
public interface CostRestRepository extends CrudRepository<CostRest, Integer> {

    @Query("select c from CostRest c where c.mateId=:mateId and c.houseId=:houseId and c.datetime BETWEEN :startDate AND :endDate order by c.datetime"
            )
    public List<CostRest> findByMateAndHouse(@Param("mateId") Integer mateId,
                                         @Param("houseId") Integer houseId,
                                         @Param("startDate") Date startDate,
                                         @Param("endDate") Date endDate);
    
    @Query("select c from CostRest c where c.houseId=:houseId and c.datetime BETWEEN :startDate AND :endDate order by c.datetime"
            )
    public List<CostRest> findByHouse(   @Param("houseId") Integer houseId,
                                         @Param("startDate") Date startDate,
                                         @Param("endDate") Date endDate);
    /*
    @Query("select c from CostRest c where c.costFamily.id=:costFamilyId and c.houseId.id=:houseId and c.datetime BETWEEN :startDate AND :endDate order by c.datetime"
            )
    public List<Cost> findByHouseAndCostFamily(@Param("costFamilyId") Integer costFamilyId,
                                         @Param("houseId") Integer houseId,
                                         @Param("startDate") Date startDate,
                                         @Param("endDate") Date endDate);
    */
    /* @Query("select c from CostRest c where c.mateId.id=:mateId and c.costFamily.id=:costFamilyId and c.houseId.id=:houseId and c.datetime BETWEEN :startDate AND :endDate order by c.datetime"
            )
    public List<Cost> findByHouseAndMateAndCostFamily(@Param("mateId") Integer mateId,
                                         @Param("costFamilyId") Integer costFamilyId,
                                         @Param("houseId") Integer houseId,
                                         @Param("startDate") Date startDate,
                                         @Param("endDate") Date endDate);
    
    */
    
}
