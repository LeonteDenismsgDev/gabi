package de.msg.javatraining.donationmanager.entities;

import java.util.List;

public interface Role {

    public List<Permissions> getPermissions();
    public void addPermission(Permissions permission);
    public void setPermissions(List<Permissions> permissions);
    public boolean checkPermission(Permissions permission);
}
