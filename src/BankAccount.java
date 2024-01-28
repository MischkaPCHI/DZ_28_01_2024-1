public class BankAccount {
    private Person owner;
    private String IBAN;
    private double balance;
    private boolean isSecure = false;

    public BankAccount(Person owner, String IBAN, double balance) {
        this.owner = owner;
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public void setSecure(boolean secure) {
        isSecure = secure;
    }

    public String secureIban() {
        return IBAN.substring(0, 4)
                + "*".repeat(IBAN.length() - 6)
                + IBAN.substring(IBAN.length() - 3);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner = " + owner +
                ", IBAN =' " + (isSecure == true ? secureIban() : IBAN) + '\'' +
                ", balance = " + balance +
                "}\n";
    }
}
