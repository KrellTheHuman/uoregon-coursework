public class PhonebookEntry {

    private int _phoneNumber;
    private String _fullName;

    public PhonebookEntry(int phoneNumber, String fullName) {
        setPhoneNumber(phoneNumber);
        setFullName(fullName);
    }

    public PhonebookEntry(PhonebookEntry phonebookEntry) {
        setPhoneNumber(phonebookEntry.getPhoneNumber());
        setFullName(phonebookEntry.getFullName());
    }

    public int getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        _phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return _fullName;
    }

    public void setFullName(String fullName) {
        _fullName = fullName;
    }
}
