package main_task1;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookTest {

    @Test
    public void testAddAddress() {
        Map<String, AddressBook.Address> expected = new HashMap<>();
        AddressBook actual = new AddressBook();
        AddressBook.Address testAddress = new AddressBook.Address("via Sempione Nord", 91, 1);
        AddressBook.Address testAddress_2 = new AddressBook.Address("via Leopardi", 12, 4);
        expected.put("Kiselev", testAddress);
        expected.put("Kiseleva", testAddress_2);
        actual.addAddress("Kiselev", testAddress);
        actual.addAddress("Kiseleva", testAddress_2);
        Assert.assertEquals(expected, actual.getBook());
    }


    @Test
    public void testDeleteAddress() {
        Map<String, AddressBook.Address> expected = new HashMap<>();
        AddressBook actual = new AddressBook();
        AddressBook.Address addressForDelete = new AddressBook.Address("via Fratelli Omarini", 14, 76);
        AddressBook.Address addressNotForDelete = new AddressBook.Address("via Principe de Piemonte", 3, 4);
        expected.put("Kiselev", addressForDelete);
        expected.put("Kiseleva", addressForDelete);
        expected.put("Gladenko", addressNotForDelete);
        actual.addAddress("Kiselev", addressForDelete);
        actual.addAddress("Kiseleva", addressForDelete);
        actual.addAddress("Gladenko", addressNotForDelete);
        expected.remove("Kiselev");
        actual.deleteAddress("Kiselev");
        Assert.assertEquals(expected, actual.getBook());

    }

    @Test
    public void testChangeAddress() {
        Map<String, AddressBook.Address> expected = new HashMap<>();
        AddressBook actual = new AddressBook();
        AddressBook.Address addressForDelete = new AddressBook.Address("via Fratelli Omarini", 14, 76);
        AddressBook.Address addressNew = new AddressBook.Address("via Principe de Piemonte", 3, 4);
        expected.put("Kiselev", addressForDelete);
        expected.put("Kiseleva", addressForDelete);
        expected.put("Gladenko", addressNew);
        actual.addAddress("Kiselev", addressForDelete);
        actual.addAddress("Kiseleva", addressForDelete);
        actual.addAddress("Gladenko", addressNew);
        expected.put("Kiselev", addressNew);
        actual.changeAddress("Kiselev", addressNew);
        Assert.assertEquals(expected, actual.getBook());
    }

    @Test
    public void testGetAddress() {
        AddressBook toGet = new AddressBook();
        AddressBook.Address toGetAd = new AddressBook.Address("via Gilberto Borromeo", 8, 1);
        AddressBook.Address toGetAd2 = new AddressBook.Address("Dvorets", 1, 1);
        toGet.addAddress("Kiselev", toGetAd);
        toGet.addAddress("Putin", toGetAd2);
        Assert.assertEquals(toGet.getAddress("Putin"), toGetAd2);
        Assert.assertEquals(toGet.getAddress("Kiselev"), toGetAd);
    }

    @Test
    public void testListByStreet() {
        AddressBook toTest = new AddressBook();
        List<String> testList = new ArrayList<>();
        List<String> testList1;
        toTest.addAddress("Kiselev", new AddressBook.Address("Kostromskoy ave", 44, 53));
        toTest.addAddress("Ivanov", new AddressBook.Address("Kostromskoy ave", 38, 11));
        toTest.addAddress("Sergeev", new AddressBook.Address("Yaroslavsky ave", 76, 21));
        testList.add("Kiselev");
        testList.add("Ivanov");
        testList1 = toTest.listByStreet("Kostromskoy ave");
        Assert.assertEquals(testList, testList1);
    }

    @Test
    public void testListByHouse() {
        AddressBook toTest = new AddressBook();
        List<String> testList = new ArrayList<>();
        List<String> testList1;
        toTest.addAddress("Kiselev", new AddressBook.Address("Kostromskoy ave", 44, 53));
        toTest.addAddress("Ivanov", new AddressBook.Address("Kostromskoy ave", 44, 11));
        toTest.addAddress("Sergeev", new AddressBook.Address("Yaroslavsky ave", 76, 21));
        testList.add("Kiselev");
        testList.add("Ivanov");
        testList1 = toTest.listByHouse("Kostromskoy ave", 44);
        Assert.assertEquals(testList, testList1);
    }

    @Test
    public void testListByFlat() {
        AddressBook toTest = new AddressBook();
        List<String> testList = new ArrayList<>();
        List<String> testList1;
        toTest.addAddress("Kiselev", new AddressBook.Address("Kostromskoy ave", 44, 53));
        toTest.addAddress("Kiseleva", new AddressBook.Address("Kostromskoy ave", 44, 53));
        toTest.addAddress("Sergeev", new AddressBook.Address("Yaroslavsky ave", 76, 21));
        testList.add("Kiseleva");
        testList.add("Kiselev");
        testList1 = toTest.listByFlat("Kostromskoy ave", 44, 53);
        Assert.assertEquals(testList, testList1);
    }
}