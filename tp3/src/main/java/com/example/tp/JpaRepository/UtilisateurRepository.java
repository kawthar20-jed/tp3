package com.example.tp.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tp.model.Utilisateur;

import java.util.Optional;




import com.example.tp.model.Role;




import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
    List<Utilisateur> findByRole(Role role);
}

