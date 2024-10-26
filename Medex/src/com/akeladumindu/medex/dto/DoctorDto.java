package com.akeladumindu.medex.dto;

import com.akeladumindu.medex.enums.GenderType;

public class DoctorDto {
    String firstName;
    String lastName;
    String nic;
    String contact;
    String email;
    String specialization;
    String address;
    GenderType gender;

    public DoctorDto() {
    }

    public DoctorDto(String firstName, String lastName, String nic, String contact, String email, String address, String specialization, GenderType gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.specialization = specialization;
        this.gender = gender;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }
}
