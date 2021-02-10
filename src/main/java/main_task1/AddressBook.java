package main_task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !obj.getClass().getName().equals(this.getClass().getName())) return false;
        AddressBook testBook = (AddressBook) obj;
        return testBook.book.equals(this.book);
    }

    private final Map<String, Address> book = new HashMap<>();
    private final List<String> list = new ArrayList<>();

    public Map<String, Address> getBook() {
        return book;
    }

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

    public List<String> listByStreet(String street) {
        for (Map.Entry<String, Address> entry : book.entrySet()) {
            if (entry.getValue().getStreet().equals(street)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public List<String> listByHouse(String street, int house) {
        for (Map.Entry<String, Address> entry : book.entrySet()) {
            if (entry.getValue().getStreet().equals(street) && entry.getValue().getHouse() == house) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public List<String> listByFlat(String street, int house, int flat) {
        for (Map.Entry<String, Address> entry: book.entrySet()) {
            if (entry.getValue().getStreet().equals(street)) {
                if (entry.getValue().getHouse() == house) {
                    if (entry.getValue().getFlat() == flat) {
                        list.add(entry.getKey());
                    }
                }
            }
        }
        return list;
    }
}
