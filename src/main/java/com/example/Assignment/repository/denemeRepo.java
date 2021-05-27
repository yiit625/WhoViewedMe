package com.example.Assignment.repository;

import com.example.Assignment.entity.User;
import com.example.Assignment.entity.ViewUser;
import com.example.Assignment.enums.EnumStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

@Repository
public interface denemeRepo extends JpaRepository<ViewUser,String> {


}
