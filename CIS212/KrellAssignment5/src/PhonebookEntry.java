public class PhonebookEntry {

    private int _phoneNumber;
    private String _lastName;
    private String _firstName;
    private String _fullName;

    public PhonebookEntry(int phoneNumber, String lastName, String firstName, String fullName) {
        setPhoneNumber(phoneNumber);
        setLastName(lastName);
        setFirstName(firstName);
        setFullName(fullName);
    }

    public PhonebookEntry(PhonebookEntry phonebookEntry) {
        setPhoneNumber(phonebookEntry.getPhoneNumber());
        setLastName(phonebookEntry.getLastName());
        setFirstName(phonebookEntry.getFirstName());
        setFullName(phonebookEntry.getFullName());
    }

    public int getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        _phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getFullName() {
        return _fullName;
    }

    public void setFullName(String fullName) {
        _fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhonebookEntry that = (PhonebookEntry) o;

        if (getPhoneNumber() != that.getPhoneNumber()) return false;
        if (!getLastName().equals(that.getLastName())) return false;
        return getFirstName().equals(that.getFirstName());
    }

    @Override
    public String toString() {
        return _phoneNumber + " " + _lastName + ", " + _firstName;
    }
}
