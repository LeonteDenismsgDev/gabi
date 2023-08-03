package de.msg.javatraining.donationmanager.entities;

import java.util.ArrayList;
import java.util.List;

public class RoleImpl implements Role{
    List<Permissions> permissionsList = new ArrayList<>();

    @Override
    public List<Permissions> getPermissions() {
        return permissionsList;
    }

    @Override
    public void addPermission(Permissions permission) {
        permissionsList.add(permission);
    }

    @Override
    public void setPermissions(List<Permissions> permissions) {
        this.permissionsList = permissions;
    }

    @Override
    public boolean checkPermission(Permissions permission) {
        return this.permissionsList.contains(permission);
    }
}
