public class Person {
    private String name;
    private int age;
    private int cashAmount; // 보유 현금
    private BankAccount account;

    public Person(String pName, int pAge) {
        name = pName;
        if (pAge < 0) {
            age = 12;
        } else {
            age = pAge;
        }
        cashAmount = 0;
    }

    public Person(String pName, int pAge, int pCashAmount) {
        name = pName;
        if (pAge < 0) {
            age = 12;
        } else {
            age = pAge;
        }

        if (pCashAmount < 0) {
            cashAmount = 0;
        } else {
            cashAmount = pCashAmount;
        }
    }

    public void setAge(int newAge) { // 새로운 값 받아오는 메소드
        if (newAge >= 0) {
            age = newAge;
        }
    }
    public void setName(String newName) { name = newName; }
    public String getName() { return name; }
    public void setCashAmount(int newCashAmount) {
        if (newCashAmount >= 0) {
            cashAmount = newCashAmount;
        }
    }
    public int getCashAmount() { return cashAmount; }
    public void setAccount(BankAccount newAccount){ account = newAccount; }
    public BankAccount getAccount() { return account; }

    // Person 인자로 transfer 메소드 처리
    public boolean transfer(Person to, int amount) {
        return account.transfer(to.getAccount(), amount);
    }

    // BankAccount 인자로 transfer 메소드 처리
    public boolean transfer(BankAccount to, int amount) {
        return account.transfer(to, amount);
    }
}
