/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Maria Claudia
 */
public class ErrorviewModel {
    private String errorMessage;
private String nomControleur;
private String nomMethode;

    public ErrorviewModel() {
    }

    public ErrorviewModel(String errorMessage, String nomControleur, String nomMethode) {
        this.errorMessage = errorMessage;
        this.nomControleur = nomControleur;
        this.nomMethode = nomMethode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getNomControleur() {
        return nomControleur;
    }

    public void setNomControleur(String nomControleur) {
        this.nomControleur = nomControleur;
    }

    public String getNomMethode() {
        return nomMethode;
    }

    public void setNomMethode(String nomMethode) {
        this.nomMethode = nomMethode;
    }

}
