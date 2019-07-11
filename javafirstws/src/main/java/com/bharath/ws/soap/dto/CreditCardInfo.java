package com.bharath.ws.soap.dto;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(name = "CreditCardInfo")
public class CreditCardInfo {

    // @XmlElement is optional - only if we want to control the name of the elements etc.
    private String cardNumber;
    private Date expirtyDate;
    private String firstName;
    private String lastName;
    private String secCode;
    private String Address;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecCode() {
        return secCode;
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getExpirtyDate() {
        return expirtyDate;
    }

    public void setExpirtyDate(Date expirtyDate) {
        this.expirtyDate = expirtyDate;
    }

}
