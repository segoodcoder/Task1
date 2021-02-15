package main_task1;

import java.util.*;

public class AddressBook {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof AddressBook) {
            AddressBook testBook = (AddressBook) obj;
            return testBook.book.equals(this.book);
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        int result = 1;
        result = 31 * result + book.hashCode();
        return result;
    }

    private final Map<String, Address> book = new HashMap<>();

    public Map<String, Address> getBook() {
        return Collections.unmodifiableMap(book);
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
        if (!book.containsKey(surname)) book.put(surname, homeAddress);
    }

    public void deleteAddress(String surname) {
        book.remove(surname);
    }

    public void changeAddress(String surname, Address newHomeAddress) {
        if (book.containsKey(surname)) book.put(surname, newHomeAddress);
    }

    public Address getAddress(String surname) {
        return book.getOrDefault(surname, null);
    }

    public List<String> listByStreet(String street) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Address> entry : book.entrySet()) {
            if (entry.getValue().getStreet().equals(street)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public List<String> listByHouse(String street, int house) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Address> entry : book.entrySet()) {
            if (entry.getValue().getStreet().equals(street) && entry.getValue().getHouse() == house) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public List<String> listByFlat(String street, int house, int flat) {
        List<String> list = new ArrayList<>();
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
