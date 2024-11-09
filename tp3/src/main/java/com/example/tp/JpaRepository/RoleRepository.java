package com.example.tp.JpaRepository;




import org.springframework.data.jpa.repository.JpaRepository;


import com.example.tp.model.Role;


import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNom(String nom);
}