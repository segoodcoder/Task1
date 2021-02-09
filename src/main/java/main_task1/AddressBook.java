package main_task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class AddressBook {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !obj.getClass().getName().equals(this.getClass().getName())) return false;
        AddressBook testBook = (AddressBook) obj;
        if (testBook.book.equals(this.book)) {
            return true;
        }
        return false;
    }

    public Map<String, Address> book = new HashMap<>();

    public static class Address {
        private final String street;
        private final int house;
        private final int flat;

        public Address(String street, int house, int flat) {
            this.street = street;
            this.house = house;
            this.flat = flat;
        }

        public String getStreet() {
            return street;
        }

        public int getHouse() {
            return house;
        }

        public int getFlat() {
            return flat;
        }
    }

    public void addAddress(String surname, Address homeAddress) {
        book.put(surname, homeAddress);
    }

    public void deleteAddress(String surname) {
        book.remove(surname);
    }

    public void changeAddress(String surname, Address newHomeAddress) {
        book.put(surname, newHomeAddress);
    }

    public Object getAddress(String surname) {
        return book.getOrDefault(surname, null);
    }


}
