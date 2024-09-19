package br.ind.cmil.gestao.domain.user;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Administrativo
 */
public enum TypeProfile {
    ROLE_ADMIN("admin"),
    ROLE_ADMINISTRATIVE("administrative"),
    ROLE_ASSISTANT("assistant"),
    ROLE_BUYER("buyer"),
    ROLE_DIRECTOR("director"),
    ROLE_ENGINEER("engineer"),
    ROLE_MANAGER("maneger"),
    ROLE_HR("hr"),
    ROLE_TECHNICAL("technique"),
    ROLE_USER("user");
    private final String value;

    private TypeProfile(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
     public static TypeProfile convertPerfilValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "admin" ->
                TypeProfile.ROLE_ADMIN;
            case "administrative" ->
                TypeProfile.ROLE_ADMINISTRATIVE;
            case "assistant" ->
                TypeProfile.ROLE_ASSISTANT;
           
            case "buyer" ->
                TypeProfile.ROLE_BUYER;
            case "director" ->
                TypeProfile.ROLE_DIRECTOR;
            case "engineer" ->
                TypeProfile.ROLE_ENGINEER;
            case "manager" ->
                TypeProfile.ROLE_MANAGER;
            case "hr" ->
                TypeProfile.ROLE_HR;
            case "technical" ->
                TypeProfile.ROLE_TECHNICAL;
            case "user" ->
                TypeProfile.ROLE_USER;
            default ->
                throw new IllegalArgumentException(" Profile invalido " + value);
        };
    }

    public static Set<String> profiles() {
        Set<String> profiles = new HashSet<>();
        for (TypeProfile profile : TypeProfile.values()) {
            profiles.add(profile.getValue());
        }
        return profiles;
    }


}
