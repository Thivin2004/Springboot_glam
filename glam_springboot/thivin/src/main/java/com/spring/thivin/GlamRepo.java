package com.spring.thivin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GlamRepo extends JpaRepository<Glam,Integer>
{
   
}