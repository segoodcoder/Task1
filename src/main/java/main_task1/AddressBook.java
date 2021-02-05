package main_task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class AddressBook {

    @Override
    public boolean equals (Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        return this.equals(obj);
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
        book.remove(surname);
        book.put(surname, newHomeAddress);
    }

    public Object getAddress(String surname) {
        if (book.containsKey(surname)) return book.get(surname);
        else return null;
    }

    public List<String> listOfPeople(Address address) {
        ArrayList<String> peopleList = new ArrayList<>();
        for (Map.Entry<String, Address> entry : book.entrySet()) {
            if (entry.getValue().equals(address)) peopleList.add(entry.getKey());
        }
        return peopleList;
    }

}
