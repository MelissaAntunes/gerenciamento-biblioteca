package org.teste.biblioteca;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Staff {
    private final IntegerProperty staffId;
    private final StringProperty name;
    private final StringProperty contact;


    public Staff(int staffId, String name, String contact) {
        this.staffId = new SimpleIntegerProperty(staffId);
        this.name = new SimpleStringProperty(name);
        this.contact = new SimpleStringProperty(contact);

    }

    public int getStaffId() {
        return staffId.get();
    }

    public void setStaffId(int staffId) {
        this.staffId.set(staffId);
    }
    public IntegerProperty staffIdProperty() {
        return staffId;
    }
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public StringProperty nameProperty() {
        return name;
    }
    public String getContact() {
        return contact.get();
    }
    public void setContact(String contact) {
        this.contact.set(contact);
    }
    public StringProperty contactProperty() {
        return contact;
    }


}
