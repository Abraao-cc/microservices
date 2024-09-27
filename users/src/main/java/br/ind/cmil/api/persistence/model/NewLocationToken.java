package br.ind.cmil.api.persistence.model;

import br.ind.cmil.api.base.EntityID;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name = "tbl_news_locations_tokens")
public class NewLocationToken extends EntityID {

    private String token;

    @OneToOne(targetEntity = UserLocation.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_location_id")
    private UserLocation userLocation;

    //
    public NewLocationToken() {
        super();
    }

    public NewLocationToken(final String token) {
        super();
        this.token = token;
    }

    public NewLocationToken(final String token, final UserLocation userLocation) {
        super();
        this.token = token;
        this.userLocation = userLocation;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserLocation getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(UserLocation userLocation) {
        this.userLocation = userLocation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NewLocationToken{");
        sb.append("token=").append(token);
        sb.append(", userLocation=").append(userLocation);
        sb.append('}');
        return sb.toString();
    }

}
