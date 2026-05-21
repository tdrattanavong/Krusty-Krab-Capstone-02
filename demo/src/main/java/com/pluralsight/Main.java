package com.pluralsight;

import com.pluralsight.loops.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        // Step 1: Create list of people
        List<Person> people = new ArrayList<>();

        people.add(new Person("Imanuel", "Dartey", 21));
        people.add(new Person("Yoel", "Weldeselassie", 29));
        people.add(new Person("Oscar", "Kayaya", 25));
        people.add(new Person("Jeremy", "Baez", 22));
        people.add(new Person("Aiden", "Vongkhamchan", 17));
        people.add(new Person("Caiden", "Seng", 19));
        people.add(new Person("Taihvonne", "Rattanavong", 21));
        people.add(new Person("Omar", "Miranda", 24));
        people.add(new Person("Ariel", "Raymundo", 27));
        people.add(new Person("Damarrius", "Thompson", 26));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type the first or last name you are searching for: ");
        String name = scanner.nextLine().trim().toLowerCase();

        double age = 0;
        int count = 0;

        for(Person person : Person){
            age += person.getAge();
            count++;
        }

