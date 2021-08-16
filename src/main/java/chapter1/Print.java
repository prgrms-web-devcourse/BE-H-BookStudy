package chapter1;

public class Print {
    Account account = Account.getInstance();

    void print(){
        System.out.println("===================================================");
        printInputOutputResult();
        printMonthlyCount();
        printPaymentTopTen();
        printMostExpendProduct();
    }

    void printInputOutputResult(){
        System.out.println("Answer1: 총수입과 총지출을 구하고 음수인지 양수인지 알려주세요");
        System.out.println("수입: " + account.getInput() +", 지출: " + account.getOutput());
        System.out.println("===================================================");
    }

    void printMonthlyCount(){
        System.out.println("Answer2: 특정달에는 몇건의 입출금 내역이 발생했나요? (숫자로 입력받았다면으로 가정하고 했어요)");
        System.out.println(account.monthlyCount(3));
        System.out.println("===================================================");
    }

    void printPaymentTopTen(){
        System.out.println("Answer3: 지출이 금액이 많은 상위 10개 항목을 구해주세요.");
        account.getTopTenOutput();
        System.out.println("===================================================");
    }

    void printMostExpendProduct(){
        System.out.println("Answer4: 돈을 가장 많이 소비하는 항목은?");
        System.out.println(account.mostOutput());
        System.out.println("===================================================");
    }
}
