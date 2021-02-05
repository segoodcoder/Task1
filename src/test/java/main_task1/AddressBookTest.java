package main_task1;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest extends TestCase {


    @Test
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddAddress() {
        AddressBook expected = new AddressBook();
        AddressBook actual = new AddressBook();
        AddressBook.Address testAddress = new AddressBook.Address("via Sempione Nord", 91, 1);
        AddressBook.Address testAddress_2 = new AddressBook.Address("via Leopardi", 12, 4);
        expected.book.put("Kiselev", testAddress);
        expected.book.put("Kiseleva", testAddress_2);
        actual.addAddress("Kiselev", testAddress);
        actual.addAddress("Kiseleva", testAddress_2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteAddress() {
        AddressBook expected = new AddressBook();
        AddressBook actual = new AddressBook();
        AddressBook.Address addressForDelete = new AddressBook.Address("via Fratelli Omarini", 14, 76);
        AddressBook.Address addressNotForDelete = new AddressBook.Address("via Principe de Piemonte", 3, 4);
        expected.book.put("Kiselev", addressForDelete);
        expected.book.put("Kiseleva", addressForDelete);
        expected.book.put("Gladenko", addressNotForDelete);
        actual.book.put("Kiselev", addressForDelete);
        actual.book.put("Kiseleva", addressForDelete);
        actual.book.put("Gladenko", addressNotForDelete);
        expected.book.remove("Kiselev");
        actual.deleteAddress("Kiselev");
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testChangeAddress() {
        AddressBook expected = new AddressBook();
        AddressBook actual = new AddressBook();
        AddressBook.Address addressForDelete = new AddressBook.Address("via Fratelli Omarini", 14, 76);
        AddressBook.Address addressNew = new AddressBook.Address("via Principe de Piemonte", 3, 4);
        expected.book.put("Kiselev", addressForDelete);
        expected.book.put("Kiseleva", addressForDelete);
        expected.book.put("Gladenko", addressNew);
        actual.book.put("Kiselev", addressForDelete);
        actual.book.put("Kiseleva", addressForDelete);
        actual.book.put("Gladenko", addressNew);
        expected.book.remove("Kiselev");
        expected.book.put("Kiselev",addressNew);
        actual.changeAddress("Kiselev", addressNew);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAddress() {
        AddressBook toGet = new AddressBook();
        AddressBook.Address toGetAd = new AddressBook.Address("via Gilberto Borromeo", 8, 1);
        AddressBook.Address toGetAd2 = new AddressBook.Address("Dvorets", 1, 1);
        toGet.book.put("Kiselev", toGetAd);
        toGet.book.put("Putin", toGetAd2);
    }

    @Test
    public void testListOfPeople() {

    }
}