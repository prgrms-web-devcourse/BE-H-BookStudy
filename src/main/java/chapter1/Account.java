package chapter1;


import chapter1.vo.Input;
import chapter1.vo.Output;
import chapter1.vo.Transaction;

import java.time.LocalDate;
import java.util.*;

public class Account {
    private static Account account = null;
    private final List<Output> outputList;
    private final List<Input> inputList;
    private final List<Transaction> list;
    private final int[] monthlyCount = new int[13];

    private int total;
    private int input;
    private int output;

    private Account() {
        list = new ArrayList<>();
        outputList = new ArrayList<>();
        inputList = new ArrayList<>();

    }

    // 게좌는 한사람당 하나만 가진다는 전제(?)로 싱글턴 패턴을 써보았습니다.
    public static Account getInstance() {
        if (account == null) {
            account = new Account();
        }
        return account;
    }

    public int getTotal() {
        return total;
    }

    public int getInput() {
        return input;
    }

    public int getOutput() {
        return output;
    }

    public void addAccountList(LocalDate date, int money, String product) {
        if (money < 0) {
            list.add(new Output(date, money, product));
            outputList.add(new Output(date, money, product));
            output+= money;
        }else if(money>0){
            list.add(new Input(date, money, product));
            inputList.add(new Input(date, money, product));
            input+= money;
        }
        total += money;

        monthlyCount[date.getMonthValue()]++;
    }

    public int monthlyCount(int month) {
        return monthlyCount[month];
    }

    public void getTopTenOutput(){
        Collections.sort(outputList);
        if(outputList.size()< 10){
            printOutputList(outputList, outputList.size());
        }else{
            printOutputList(outputList,10);
        }
    }
    void printOutputList(List<Output> list, int size) {
        for(int i = 0; i < size; i++){
            System.out.println(list.get(i).getProduct());
        }
    }
    public String getMostOutput(){
        int curTotalConsumption = 0;
        int maxValue = 0;
        String ret = null;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < outputList.size(); i++){
            Output out = outputList.get(i);
            curTotalConsumption = map.getOrDefault(out.getProduct(), 0) + out.getMoney();
            if(maxValue > curTotalConsumption){
                maxValue = curTotalConsumption;
                ret = out.getProduct();
            }
        }
        return ret;
    }

}
