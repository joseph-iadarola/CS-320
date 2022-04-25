/**
 * Joseph Iadarola
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
	protected String longContactId, longFirstName, longLastName, longPhoneNumber, shortPhoneNumber,
			longAddress;

	@BeforeEach
	void setUp() {
		contactId = "5029K877A3";
		firstNameTest = "John";
		lastNameTest = "Doe";
		phoneNumberTest = "5853931234";
		addressTest = "1 Main East Rochester NY 14445";
		longContactId = "112233445566778899";
		longFirstName = "Billy Bambi Blingling";
		longLastName = "-banzi Smelly";
		longPhoneNumber = "58512345678";
		shortPhoneNumber = "1234567";
		longAddress = "1 Main St Zipper Drive, East Rochester, NY 14445";
	}


	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertThrows(Exception.class, () -> service.deleteContact(contactId));
		assertAll(() -> service.deleteContact(service.getContactList().get(0).getContactId()));
	}

	@Test
	void updateFirstNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
		assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class,
				() -> service.updateFirstName(service.getContactList().get(0).getContactId(), longFirstName));
		assertThrows(IllegalArgumentException.class,
				() -> service.updateFirstName(service.getContactList().get(0).getContactId(), null));
		assertThrows(Exception.class, () -> service.updateFirstName(contactId, firstNameTest));
	}

	@Test
	void updateLastNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);
		assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
		assertThrows(IllegalArgumentException.class,
				() -> service.updateLastName(service.getContactList().get(0).getContactId(), longLastName));
		assertThrows(IllegalArgumentException.class,
				() -> service.updateLastName(service.getContactList().get(0).getContactId(), null));
		assertThrows(Exception.class, () -> service.updateLastName(contactId, lastNameTest));
	}

	@Test
	void updatePhoneNumberTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneNumberTest);
		assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
		assertThrows(IllegalArgumentException.class,
				() -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), longPhoneNumber));
		assertThrows(IllegalArgumentException.class,
				() -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), shortPhoneNumber));
		assertThrows(IllegalArgumentException.class,
				() -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), contactId));
		assertThrows(IllegalArgumentException.class, ()

		-> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), null));
		assertThrows(Exception.class, () -> service.updatePhoneNumber(contactId, lastNameTest));
	}

	@Test
	void updateAddressTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateAddress(service.getContactList().get(0).getContactId(), addressTest);
		assertEquals(addressTest, service.getContactList().get(0).getAddress());
		assertThrows(IllegalArgumentException.class,
				() -> service.updateAddress(service.getContactList().get(0).getContactId(), longAddress));
		assertThrows(IllegalArgumentException.class,
				() -> service.updateAddress(service.getContactList().get(0).getContactId(), null));
		assertThrows(Exception.class, () -> service.updateAddress(contactId, addressTest));
	}
}
