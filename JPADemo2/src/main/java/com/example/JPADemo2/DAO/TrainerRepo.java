package com.example.JPADemo2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JPADemo2.Entities.Trainer;

// CURDRepository : save() ,saveAll, findById , findAll , deleteById , deleteAll
// JPARepository <TypeObject,primarykeydatatyp>
// jparepository inherites property from curdrepository
// adds two additional function : sorting and pagination

@Repository
public interface TrainerRepo extends JpaRepository<Trainer,Integer> {

}
