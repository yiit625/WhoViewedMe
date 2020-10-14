package com.example.Assignment.repository;

import com.example.Assignment.entity.ViewUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewUserRepository extends PagingAndSortingRepository<ViewUser, String>, JpaSpecificationExecutor<ViewUser>, CrudRepository<ViewUser, String> {

    @Query("select e from ViewUser e " +
            "inner join User as p on " +
            "e.viewedUser.id =p.id "+
            "where p.id = :viewedUser " +
            "order by e.viewedDate desc ")
    List<ViewUser> viewedUserList(@Param("viewedUser") String viewedUser);



}
