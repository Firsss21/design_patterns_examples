package structuralPatterns.compositeExample;

import structuralPatterns.compositeExample.plainModel.Baggage;
import structuralPatterns.compositeExample.plainModel.Passenger;
import structuralPatterns.compositeExample.plainModel.PlainBody;
import structuralPatterns.compositeExample.plainModel.PlainClass;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Композитор.
        Проблема, которую решает: единый доступ к элементам древовидной структуры.
        Пример: есть коробки, в ней еще коробки и в ней еще коробки, в ней какие-то элементы.
         */
        // мейн - строитель самолета.
        // корпус
        PlainBody plain = new PlainBody("Boeing 777", 3);
        // класс обслуживания (первый, бизнес, эконом) - максимальное кол-во мест и ограничение на вес багажа для пассажиров.
        PlainClass firstClass = new PlainClass("First class",5, 100);
        PlainClass businessClass = new PlainClass("Business class",5, 40);
        PlainClass economyClass = new PlainClass("Economy class",10, 20);
        // пассажир
        Passenger thief = new Passenger("Thief");

        List<Passenger> firstClassPassengers =
                Arrays.asList(
                        new Passenger("Vladimir"),
                        new Passenger("John"),
                        new Passenger("Gudawa"));
        firstClass.appendChild(thief);
        firstClassPassengers.stream().forEach(
                passenger ->
                {
                    passenger.appendChild(new Baggage(passenger, 50));
                    firstClass.appendChild(passenger);
                }
        );

        List<Passenger> businessClassPassengers =
                Arrays.asList(
                        new Passenger("Aleksandr"),
                        new Passenger("Boris"),
                        new Passenger("Clay"),
                        new Passenger("Don"),
                        new Passenger("Egor"));
        businessClassPassengers.stream().forEach(
                passenger ->
                {
                    passenger.appendChild(new Baggage(passenger, 30));
                    businessClass.appendChild(passenger);
                }
        );

        List<Passenger> economyClassPassengers =
                Arrays.asList(
                        new Passenger("Fanya"),
                        new Passenger("Grisha"),
                        new Passenger("Hector"),
                        new Passenger("Igor"),
                        new Passenger("Jora"),
                        new Passenger("Kostya"),
                        new Passenger("Leonid"),
                        new Passenger("Mark"));
        economyClassPassengers.stream().forEach(
                passenger ->
                {
                    passenger.appendChild(new Baggage(passenger, 10));
                    economyClass.appendChild(passenger);
                }
        );

        plain.appendChild(firstClass);
        plain.appendChild(businessClass);
        plain.appendChild(economyClass);

                    // багаж
        // Клиент - терминал аэропорта, показ структуры и чек на перевес
        PlainTerminal plainTerminal = new PlainTerminal(plain);
        plainTerminal.showPlainStructure();
        plainTerminal.checkOverweight();
        // Клиент - фбр, умеет искать пассажиров внутри самолета и снимать их с рейса.
        AdministrationClient administrationClient = new AdministrationClient(plain);
//        administrationClient.findAndShowResult("Thief");
        administrationClient.removeComponent("Thief");

        /*
        Хорошо сочетается с билдером или цепочкой обязанностей
         */
    }
}
