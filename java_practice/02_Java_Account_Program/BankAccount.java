package Java_Account_Program;

public class BankAccount {
    int balance;
    Person owner;

    // 파라미터 : 입금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean deposit(int amount) {
        // 1. write code here
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

    // 파라미터 : 출금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean withdraw(int amount) {
        // 2. write code here
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

    // 첫 번째 파라미터 : 받는 사람(Person)
    // 두 번째 파라미터 : 이체할 금액(정수)
    // 리턴 : 성공여부(불린)
}