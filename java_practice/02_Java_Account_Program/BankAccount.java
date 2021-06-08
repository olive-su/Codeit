public class BankAccount {
    private int balance; // 계좌 잔고
    private Person owner; // 계좌 소유주

    public BankAccount(int pBalance) {
        if (pBalance < 0){
            balance = 0;
        } else {
            balance = pBalance;
        }
    }

    public BankAccount(Person pOwner) {
        owner = pOwner;
        balance = 0;
    }

    public BankAccount(int pBalance, Person pOwner) {
        if (pBalance < 0){
            balance = 0;
        } else {
            balance = pBalance;
        }
        owner = pOwner;
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }
    public int getBalance() {
        return balance;
    }
    public void setOwner(Person newOwner) {
        owner = newOwner;
    }
    public Person getOwner() {
        return owner;
    }

    // 파라미터 : 입금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean deposit(int amount) {
        if ((amount >= 0) && (owner.getCashAmount() >= amount)){
            balance += amount;
            owner.setCashAmount(owner.getCashAmount() - amount);
            System.out.println(amount + "원 입금하였습니다. "+"잔고: "+balance+"원, 현금: "+owner.getCashAmount()+"원");
            return true;
        }
        else {
            System.out.println("입금 실패입니다. 잔고: "+balance+"원, 현금: "+owner.getCashAmount()+"원");
            return false;
        }
    }

    public boolean deposit(double amount, double exchangeRate) {
        return deposit((int) (amount * exchangeRate));
    }


    // 파라미터 : 출금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean withdraw(int amount) {
        if (amount >= 0 && balance >= amount){
            balance -= amount;
            owner.setCashAmount(owner.getCashAmount() + amount);
            System.out.println(amount + "원 출금하였습니다. "+"잔고: "+balance+"원, 현금: "+owner.getCashAmount()+"원");
            return true;
        }
        else {
            System.out.println("출금 실패입니다. 잔고: "+balance+"원, 현금: "+owner.getCashAmount()+"원");
            return false;
        }
    }
    // 첫 번째 파라미터: 받는 사람의 계좌 (BankAccount)
    // 두 번째 파라미터: 이체할 금액 (정수)
    // 리턴 : 성공여부 (불린)
    public boolean transfer(BankAccount to, int amount) {
        boolean success;

        if (amount >= 0 && balance >= amount){
            success = true;
            balance -= amount; // 보낸 사람 (-)
            to.balance += amount; // 받는 사람 (+)
        }
        else {
            success = false;
        }

        System.out.println(success + " - from: "
                + owner.getName() + ", to: "
                + to.owner.getName() + ", amount: "
                + amount + ", balance: " + balance);

        return success;
    }

    // 첫 번째 파라미터: 받는 사람 (Person)
    // 두 번째 파라미터: 이체할 금액 (정수)
    // 리턴 : 성공여부 (불린)
    public boolean transfer(Person to, int amount) {
        return transfer(to.getAccount(), amount);
    }
}
