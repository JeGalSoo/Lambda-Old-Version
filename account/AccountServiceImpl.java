package account;

import common.AbstractService;
import enums.Messenger;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AccountServiceImpl extends AbstractService<Account> implements AccountService {
    @Getter
    private static AccountServiceImpl instance = new AccountServiceImpl();
    List<Account> list;

    private AccountServiceImpl(){
        this.list = new ArrayList<>();
    } //디폴트 생성자를 막음 / 단 앞에 맵 선언 필요


    @Override
    public String deposit(Account ad, Scanner sc) {
        for(Account acd : list){
            if(acd.getAccountNumber().equals(ad.getAccountNumber())){
                System.out.println("입금 금액을 입력하세요");
                double a=sc.nextDouble();
                acd.setBalance(acd.getBalance()+a);
                System.out.println(a + "원 입금이 완료 되었습니다.\n 잔액은 " + acd.getBalance()+ "입니다.");
            }else{
                System.out.println("계좌번호가 다릅니다.");
            }
        }
        return null;
    }

    @Override
    public String withdraw(Account ad, Scanner sc) {
        for(Account acd:list) {
            if (acd.getAccountNumber().equals(ad.getAccountNumber())) {
                System.out.println("출금 금액을 입력하세요");
                int a = sc.nextInt();
                if (acd.getBalance() < a) {
                    System.out.println("잔액이 부족합니다.");
                } else {
                    acd.setBalance(acd.getBalance() - a);
                    System.out.println(a + "원 출금이 완료 되었습니다.\n 잔액은 " + acd.getBalance() + "입니다.");
                }
            }
        }
        return "";
    }

    @Override
    public List<Account> getBalance(Account ad) {
        for(Account acd:list){
            if(acd.getAccountNumber().equals(ad.getAccountNumber())){
                System.out.printf(acd.getAccountNumber()+"의 잔액은 : "+acd.getBalance()+ "원 입니다.");
            }else{
                System.out.println("계좌번호를 틀렸습니다.");
            }
        }
        return null;
    }

    @Override
    public Messenger save(Account account) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Account> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Account account) {
        return null;
    }


    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}

