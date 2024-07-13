package com.infosys.admin.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.admin.Model.Admin;

@Repository
public interface AdminRepo  extends JpaRepository<Admin, Integer>{

}
