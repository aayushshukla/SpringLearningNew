package com.example.JPADemo2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.JPADemo2.Entities.Trainer;

// CURDRepository : save() ,saveAll, findById , findAll , deleteById , deleteAll
// JPARepository <TypeObject,primarykeydatatyp>
// jparepository inherites property from curdrepository
// adds two additional function : sorting and pagination

@Repository
public interface TrainerRepo extends JpaRepository<Trainer,Integer> {
	
	// ?1 indicates a positional parameter .It is for define query parameter to 
	//avoid issues like sql injection/
	@Query("Select t from Trainer t where t.email =?1")
    List<Trainer>	findByEmail(String semail);
	
	@Query("Select t1 from Trainer t1 where t1.trainerName Like %?1%")
	List<Trainer> findByNamePattern(String pattern);
	 
	@Query ("Select t1 from Trainer t1 where t1.trainerId =?1 and t1.trainerName = ?2")
    Trainer	findTrainerDetails(int id , String name);
	@Query(value="Select * from trainer_table",nativeQuery = true)
   List<Trainer>	findAllTrainerInfo();
}
