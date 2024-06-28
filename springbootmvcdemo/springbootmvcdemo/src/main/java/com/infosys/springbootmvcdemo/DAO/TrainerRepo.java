package com.infosys.springbootmvcdemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.springbootmvcdemo.Model.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Integer> {

}
