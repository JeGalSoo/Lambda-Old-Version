package account;


import java.util.List;
import java.util.Scanner;

public interface AccountService {
        String deposit(Account ad, Scanner sc);

        String withdraw(Account ad, Scanner sc);

        List<?> getBalance(Account ad);
}