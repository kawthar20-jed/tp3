package com.example.tp.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tp.model.Utilisateur;
import com.example.tp.model.UtilisateurImage;
import com.example.tp.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur, @RequestParam Long roleId) {
        return utilisateurService.createUtilisateur(utilisateur, roleId);
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @PutMapping("/{utilisateurId}/role/{roleId}")
    public ResponseEntity<Void> assignRoleToUtilisateur(@PathVariable Long utilisateurId, @PathVariable Long roleId) {
      
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{utilisateurId}/image")
    public ResponseEntity<Void> addImageToUtilisateur(@PathVariable Long utilisateurId, @RequestBody UtilisateurImage image) {
        utilisateurService.addImageToUtilisateur(utilisateurId, image);
        return ResponseEntity.ok().build();
    }

  
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/role/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long roleId) {
        utilisateurService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{utilisateurId}/image/{imageId}")
    public ResponseEntity<Void> deleteImageFromUtilisateur(@PathVariable Long utilisateurId, @PathVariable Long imageId) {
        utilisateurService.deleteImageFromUtilisateur(utilisateurId, imageId);
        return ResponseEntity.noContent().build();
    }
}