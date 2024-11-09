package com.example.tp.JpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tp.model.Utilisateur;
import com.example.tp.model.UtilisateurImage;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurImageRepository extends JpaRepository<UtilisateurImage, Long> {
    UtilisateurImage findByUtilisateur(Utilisateur utilisateur);
}
