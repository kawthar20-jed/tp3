package com.example.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tp.JpaRepository.RoleRepository;
import com.example.tp.JpaRepository.UtilisateurImageRepository;
import com.example.tp.JpaRepository.UtilisateurRepository;
import com.example.tp.model.Role;
import com.example.tp.model.Utilisateur;
import com.example.tp.model.UtilisateurImage;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UtilisateurImageRepository utilisateurImageRepository;

    @Transactional
    public Utilisateur createUtilisateur(Utilisateur utilisateur, Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Rôle non trouvé"));
        utilisateur.setRole(role);
        return utilisateurRepository.save(utilisateur);
    }

    @Transactional
    public void addImageToUtilisateur(Long utilisateurId, UtilisateurImage image) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        image.setUtilisateur(utilisateur);
        utilisateurImageRepository.save(image);
    }

    public List<Utilisateur> getUtilisateursByRole(Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Rôle non trouvé"));
        return utilisateurRepository.findByRole(role);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    @Transactional
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Transactional
    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }

    @Transactional
    public void deleteImageFromUtilisateur(Long utilisateurId, Long imageId) {
        UtilisateurImage image = utilisateurImageRepository.findById(imageId).orElseThrow(() -> new RuntimeException("Image non trouvée"));
        if (!image.getUtilisateur().getId().equals(utilisateurId)) {
            throw new RuntimeException("Cette image n'appartient pas à l'utilisateur spécifié");
        }
        utilisateurImageRepository.delete(image);
    }
}