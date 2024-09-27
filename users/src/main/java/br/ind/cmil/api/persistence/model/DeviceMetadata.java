
package br.ind.cmil.api.persistence.model;

import br.ind.cmil.api.base.EntityID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name="tbl_devices_metadatas")
public class DeviceMetadata extends EntityID{
   
    private String userId;
    private String deviceDetails;
    private String location;
    private LocalDate lastLoggedIn;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(String deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(LocalDate lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceMetadata{");
        sb.append("userId=").append(userId);
        sb.append(", deviceDetails=").append(deviceDetails);
        sb.append(", location=").append(location);
        sb.append(", lastLoggedIn=").append(lastLoggedIn);
        sb.append('}');
        return sb.toString();
    }
    
}
