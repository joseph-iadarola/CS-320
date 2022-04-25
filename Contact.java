/**
 * Joseph Iadarola
 */
public class Contact {
	private static final int PHONENUM_LENGTH = 10;
	private static final int MAX_ID_LENGTH = 10;
	private static final int MAX_FIRSTNAME_LENGTH = 10;
	private static final int MAX_LASTNAME_LENGTH = 10;
	private static final int MAX_ADDRESS_LENGTH = 30;
	private static final String INITIAL = "START";
	private static final String INITIAL_NUM = "1234567890";
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	Contact() {
		this.contactId = INITIAL;
		this.firstName = INITIAL;
		this.lastName = INITIAL;
		this.phoneNumber = INITIAL_NUM;
		this.address = INITIAL;
	}

	Contact(String contactId) {
		updateContactId(contactId);
		this.firstName = INITIAL;
		this.lastName = INITIAL;
		this.phoneNumber = INITIAL_NUM;
		this.address = INITIAL;
	}

	Contact(String contactId, String firstName) {
		updateContactId(contactId);
		updateFirstName(firstName);
		this.lastName = INITIAL;
		this.phoneNumber = INITIAL_NUM;
		this.address = INITIAL;
	}

	Contact(String contactId, String firstName, String lastName) {
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		this.phoneNumber = INITIAL_NUM;
		this.address = INITIAL;
	}

	Contact(String contactId, String firstName, String lastName, String phoneNumber) {
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		this.address = INITIAL;
	}

	Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		updateAddress(address);
	}

	protected final String getContactId() {
		return contactId;
	}

	protected final String getFirstName() {
		return firstName;
	}

	protected final String getLastName() {
		return lastName;
	}

	protected final String getPhoneNumber() {
		return phoneNumber;
	}

	protected final String getAddress() {
		return address;
	}

	protected void updateFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name can't be empty");
		} else if (firstName.length() > MAX_FIRSTNAME_LENGTH) {
			throw new IllegalArgumentException("First name can't be longer than " + MAX_FIRSTNAME_LENGTH + " characters");
		} else {
			this.firstName = firstName;
		}
	}

	protected void updateLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name can't be empty");
		} else if (lastName.length() > MAX_LASTNAME_LENGTH) {
			throw new IllegalArgumentException("Last name can't be longer than " + MAX_LASTNAME_LENGTH + " characters");
		} else {
			this.lastName = lastName;
		}
	}

	protected void updatePhoneNumber(String phoneNumber) {
		String reg = "[0-9]+";
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Phone number can't be empty.");
		} else if (phoneNumber.length() != PHONENUM_LENGTH) {
			throw new IllegalArgumentException("Phone number length invalid. Ensure it is " + PHONENUM_LENGTH + " digits.");
		} else if (!phoneNumber.matches(reg)) {
			throw new IllegalArgumentException("Phone number cannot have anything but numbers");
		} else {
			this.phoneNumber = phoneNumber;
		}
	}

	protected void updateAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address can not be empty");
		} else if (address.length() > MAX_ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address can not be longer than " + MAX_ADDRESS_LENGTH + " characters");
		} else {
			this.address = address;
		}
	}

	protected void updateContactId(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("Contact ID can not be empty");
		} else if (contactId.length() > MAX_ID_LENGTH) {
			throw new IllegalArgumentException("Contact ID can not be longer than " + MAX_ID_LENGTH + " characters");
		} else {
			this.contactId = contactId;
		}
	}
}
