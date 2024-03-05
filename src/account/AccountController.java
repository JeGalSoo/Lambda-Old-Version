package account;

import common.UtilService;
import common.UtilServiceImpl;
import enums.Messenger;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AccountController {
    AccountServiceImpl accountService;
    UtilService us;
    Date transactionDate;
    public AccountController(){
        this.accountService=AccountServiceImpl.getInstance();
        this.us= UtilServiceImpl.getInstance();
        transactionDate = new Date();
    }
    public Messenger createAccount(Scanner sc) {
        System.out.println("이름을 입력해 주세요");
        return accountService.save(Account.builder()
                .accountNumber(String.valueOf(us.createRandomInteger(1,3)))
                .accountHolder(sc.next())
                .balance(0.0)
                .transactionDate(transactionDate)
                .build());
    }

    public String deposit(Scanner sc) {
        System.out.println("계좌번호를 입력하세요");
        return accountService.deposit(Account.builder()
                .accountNumber(sc.next())
                .transactionDate(transactionDate)
                .build(),sc);
    }

    public String withdraw(Scanner sc) {
        System.out.println("계좌번호를 입력하세요.");
        return accountService.withdraw(Account.builder()
                .accountNumber(sc.next())
                .transactionDate(transactionDate)
                .build(),sc);
    }

    public List<?> getBalance(Scanner sc) {
        return accountService.getBalance(Account.builder()
                .accountNumber(sc.next())
                .build());
    }

    public String cancelAccount(Scanner sc) {
        System.out.println("계좌번호와 예금주명을 입력하세요.");
        return accountService.delete(Account.builder()
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .transactionDate(transactionDate)
                .build());
    }
    public List<?> getAccounts(Scanner sc) {
        return accountService.findAll();
    }
}
