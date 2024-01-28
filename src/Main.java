import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount(new Person("Максим ", "Соловьев ", "smithJack@gmail.com "), "DE45500105177725153978 ", 90));
        bankAccounts.add(new BankAccount(new Person("Софья ","Исаева ","isaevaSifia@mail.com "),"DE30500105176881543987 ",170));
        bankAccounts.add(new BankAccount(new Person("Владислав ","Львов ","vladislavL@hotmail.com "),"DE45500105172241537756 ",80));
        bankAccounts.add(new BankAccount(new Person("Семён ","Громов ","gromovS@mail.com "),"DE12500105177655759511 ",120000));
        bankAccounts.add(new BankAccount(new Person("Герман ","Горбунов ","germangrobunov@gmail.com "),"DE22500105175655372272 ",110000));

        System.out.println(bankAccounts);

        //1
        List<BankAccount> result1 = bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getBalance()<100)
                .collect(Collectors.toList());
        System.out.println(result1);
        //2
        Set<BankAccount> result2 = bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getBalance()>100000)
                .collect(Collectors.toSet());
        System.out.println(result2);
        //3

        for (BankAccount bankAccount : bankAccounts){
            bankAccount.setSecure(true);
        }
        List<BankAccount> result3 = bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getBalance()>100000)
                .sorted((p1,p2) -> p1.getOwner().getlName().compareTo(p2.getOwner().getlName())).toList();

        System.out.println(result3);

        //4
        Map<String, Double> result4 = bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getBalance() != 0)
                .collect(Collectors.groupingBy(bankAccount -> bankAccount.getOwner().getfName() + bankAccount.getOwner().getlName(),
                        Collectors.summingDouble(bankAccount -> bankAccount.getBalance())));
        System.out.println(result4);

    }
}