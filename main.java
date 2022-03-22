package com.yakushev.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class HomeApliances implements IHomeApliance {
    int weight;
    int power;
    int serialNumber;
    boolean isWorking = false;

    public HomeApliances(int power){
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    public void powerOn(){
        if (!isWorking){
            isWorking = true;
            System.out.println("Power On");
        }else{
            System.out.println("Already turned on");
        }
    }

    public void powerOff (){
        if (isWorking){
            isWorking = false;
            System.out.println("Power Off");
        }else{
            System.out.println("Already turned off");
        }
    }

    @Override
    public void print() {
        System.out.println("I'm HomeApliance");
    }
}

class TV extends HomeApliances{

    public TV(int power){
        super(power);
    }

    @Override
    public void print() {
        System.out.println("I'm TV");
    }
}

class VacuumCleaner extends HomeApliances{

    public VacuumCleaner(int power){
        super(power);
    }

    @Override
    public void print() {
        System.out.println("I'm VacuumCleaner");
    }

    public void suck(){
        System.out.println("I suck");
    }
}

public class main {
    static public void printListIHomeApliance(List<IHomeApliance> list) {
        System.out.print("{ ");
        for (IHomeApliance item : list) {
            System.out.print(item.getPower() + " ");
        }
        System.out.println("};");
    }

    public static void main(String[] args) {

        List<IHomeApliance> list = new ArrayList<>();

        list.add(new TV(228));
        list.add(new TV(500));
        list.add(new VacuumCleaner(1000));
        list.add(new VacuumCleaner(600));
        list.add(new VacuumCleaner(350));

        int powerSum = 0;
        for (var o : list){
            System.out.println(o.getPower());
            powerSum += o.getPower();
        }
        System.out.println("powerSum: " + powerSum);
        //--
        printListIHomeApliance(list);
        list.sort(Comparator.comparingInt(IHomeApliance::getPower));
        printListIHomeApliance(list);
        //--
        for (var o : list){
            if (o.getPower() < 1000 && o.getPower() > 300) {
                System.out.println(o.getClass().getName() + " : "+ o.getPower());
            }
        }

    }
}
