package com.example.bizzylink.model.dto;

import org.jetbrains.annotations.NotNull;

public class EditPasswordDto {
    @NotNull
    private String currentPassword;

    @NotNull
    private String newPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
