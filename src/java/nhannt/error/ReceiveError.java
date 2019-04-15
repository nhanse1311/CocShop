/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.error;

import java.io.Serializable;

/**
 *
 * @author Nhan
 */
public class ReceiveError implements Serializable {

    private String productIDErr;
    private String productNameErr;
    private String brandErr;
    private String descriptionErr;
    private String priceErr;
    private String quantityErr;
    private String categoryIDErr;

    private String usernameErr;
    private String passwordErr;
    private String confirmErr;
    private String firstNameErr;
    private String lastNameErr;
    private String emailErr;
    private String phoneErr;
    private String addressErr;

    public String getProductIDErr() {
        return productIDErr;
    }

    public void setProductIDErr(String productIDErr) {
        this.productIDErr = productIDErr;
    }

    public String getProductNameErr() {
        return productNameErr;
    }

    public void setProductNameErr(String productNameErr) {
        this.productNameErr = productNameErr;
    }

    public String getBrandErr() {
        return brandErr;
    }

    public void setBrandErr(String brandErr) {
        this.brandErr = brandErr;
    }

    public String getDescriptionErr() {
        return descriptionErr;
    }

    public void setDescriptionErr(String descriptionErr) {
        this.descriptionErr = descriptionErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getQuantityErr() {
        return quantityErr;
    }

    public void setQuantityErr(String quantityErr) {
        this.quantityErr = quantityErr;
    }

    public String getCategoryIDErr() {
        return categoryIDErr;
    }

    public void setCategoryIDErr(String categoryIDErr) {
        this.categoryIDErr = categoryIDErr;
    }

    public String getUsernameErr() {
        return usernameErr;
    }

    public void setUsernameErr(String usernameErr) {
        this.usernameErr = usernameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getConfirmErr() {
        return confirmErr;
    }

    public void setConfirmErr(String confirmErr) {
        this.confirmErr = confirmErr;
    }

    public String getFirstNameErr() {
        return firstNameErr;
    }

    public void setFirstNameErr(String firstNameErr) {
        this.firstNameErr = firstNameErr;
    }

    public String getLastNameErr() {
        return lastNameErr;
    }

    public void setLastNameErr(String lastNameErr) {
        this.lastNameErr = lastNameErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    public String getPhoneErr() {
        return phoneErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }

    public String getAddressErr() {
        return addressErr;
    }

    public void setAddressErr(String addressErr) {
        this.addressErr = addressErr;
    }

    

}
