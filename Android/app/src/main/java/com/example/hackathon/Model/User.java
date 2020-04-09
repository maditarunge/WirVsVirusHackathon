package com.example.hackathon.Model;

import java.time.LocalDateTime;

public class User {

    private int id;
    private String nickname;
    private String firstName;
    private String surName;
    private String password;
    private Type type;
    private String mail;
    private String mobile;
    private String phone;
    private boolean active;
    private LocalDateTime creatingDate;
    private int resetPassword;
    private String resetToken;
    private LocalDateTime resetDate;
    private String apikey;

    public User(int id, String nickname, String firstName, String surName, String password, Type type, String mail, String mobile, String phone, boolean active, LocalDateTime creatingDate, int resetPassword, String resetToken, LocalDateTime resetDate, String apikey) {
        setId(id);
        setNickname(nickname);
        setFirstName(firstName);
        setSurName(surName);
        setPassword(password);
        setType(type);
        setMail(mail);
        setMobile(mobile);
        setPhone(phone);
        setActive(active);
        setCreatingDate(creatingDate);
        setResetPassword(resetPassword);
        setResetToken(resetToken);
        setResetDate(resetDate);
        setApikey(apikey);
    }

    public User(String nickname, String firstName, String surName, String password, Type type, String mail, String mobile, String phone, boolean active, LocalDateTime creatingDate, int resetPassword, String resetToken, LocalDateTime resetDate, String apikey) {
        setNickname(nickname);
        setFirstName(firstName);
        setSurName(surName);
        setPassword(password);
        setType(type);
        setMail(mail);
        setMobile(mobile);
        setPhone(phone);
        setActive(active);
        setCreatingDate(creatingDate);
        setResetPassword(resetPassword);
        setResetToken(resetToken);
        setResetDate(resetDate);
        setApikey(apikey);
    }

    public User(String nickname, String firstName, String surName, String password) {
        setNickname(nickname);
        setFirstName(firstName);
        setSurName(surName);
        setPassword(password);
    }

    public User(int id, String nickname, String firstName, String surName, String password, Type type, String mail, String mobile, String phone, boolean active, LocalDateTime creatingDate) {
        setId(id);
        setNickname(nickname);
        setFirstName(firstName);
        setSurName(surName);
        setPassword(password);
        setType(type);
        setMail(mail);
        setMobile(mobile);
        setPhone(phone);
        setActive(active);
        setCreatingDate(creatingDate);
    }

    public User(String nickname, String firstName, String surName, String password, Type type, String mail, String phone, boolean active) {
        setNickname(nickname);
        setFirstName(firstName);
        setSurName(surName);
        setPassword(password);
        setType(type);
        setMail(mail);
        setPhone(phone);
        setActive(active);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    private void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    private void setType(Type type) {
        this.type = type;
    }

    public String getMail() {
        return mail;
    }

    private void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    private void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    private void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatingDate() {
        return creatingDate;
    }

    private void setCreatingDate(LocalDateTime creatingDate) {
        this.creatingDate = creatingDate;
    }

    public int getResetPassword() {
        return resetPassword;
    }

    private void setResetPassword(int resetPassword) {
        this.resetPassword = resetPassword;
    }

    public String getResetToken() {
        return resetToken;
    }

    private void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public LocalDateTime getResetDate() {
        return resetDate;
    }

    private void setResetDate(LocalDateTime resetDate) {
        this.resetDate = resetDate;
    }

    public String getApikey() {
        return apikey;
    }

    private void setApikey(String apikey) {
        this.apikey = apikey;
    }

    //TODO MR 2020-04-09 1718: implement correct encrypting
    public static String encryptPass(String password)
    {
        return password;
    }
}
