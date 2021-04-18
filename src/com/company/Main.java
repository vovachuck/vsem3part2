package com.company;

import com.company.interfaces.IAccounting;
import com.company.model.BusinessSitting;
import com.company.model.Exemptions;
import com.company.model.SocialSitting;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<IAccounting> list = new ArrayList<>(
                Arrays.asList(
                        new SocialSitting(1, "Vova", Exemptions.STUDENT,40),
                        new SocialSitting(12, "Vasya", Exemptions.OTHER,20),
                        new SocialSitting(5, "Kolya", Exemptions.DEFAULT,10),
                        new SocialSitting(8, "Petro", Exemptions.DEFAULT,30),
                        new SocialSitting(20, "Alfred", Exemptions.PENSIONER,40),
                        new BusinessSitting(1, "Alyona",120),
                        new BusinessSitting(20, "Alex",80),
                        new BusinessSitting(12, "Vova",200),
                        new BusinessSitting(17, "Karl",180),
                        new BusinessSitting(6, "Mark",45)

                )
        );
        // Get total income of all seat
        double totalIncome = list.stream().mapToDouble(IAccounting::getPrice).sum();

        // Get number of cheapest seat
        int cheapestSeat = list.stream()
                .min(Comparator.comparingDouble(IAccounting::getPrice))
                .get()
                .seatNumber();

        // Get number of the most expensive seat
        int expensiveSeat = list.stream()
                .max(Comparator.comparingDouble(IAccounting::getPrice))
                .get()
                .seatNumber();

        // Get name most common passenger
        list.stream()
                .collect(Collectors.groupingBy(IAccounting::passengerName, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);

        // Get average price
        double averagePrice = list.stream()
                .mapToDouble(IAccounting::getPrice)
                .average()
                .orElse(0);

        System.out.println(totalIncome);
        System.out.println(cheapestSeat);
        System.out.println(expensiveSeat);
        System.out.println(averagePrice);
    }
    /*Output:
        Vova=2
        729.0
        5
        12
        72.9
    */
}
