/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package controller;

import Library.Check_Valid;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Collections;
import model.Country;
import view.Menu;

/**
 *
 * @author DAO
 */
public class Manage_East_Asia_Countries extends Menu<String> {
    private ArrayList<Country> lc;
    private Check_Valid ck;
    static String[] mc = {"Input the information of 11 countries in East Asia", "Display the information of country you've just input", "Search the information of country by user-entered name", "Display the information of countries sorted name in ascending", "Exit"};
    public Manage_East_Asia_Countries(){
        super("Manage East Asia Countries",mc);
        lc = new ArrayList<>();
        ck = new Check_Valid();
    }
    
    @Override
    public void execute(int n) {
                    switch (n) {
                case 1 -> inputCountry(lc);
                case 2 -> printCountry(lc);
                case 3 -> searchByName(lc);
                case 4 -> printCountrySorted(lc);
                case 5 -> exit(0);
                default ->
                System.out.println("Try again"); 
           } 
    }

            //allow user input infomation of contries
    public void inputCountry(ArrayList<Country> lc) {
        System.out.print("Enter code of contry: ");
        String countryCode = ck.checkInputString();
        //check code contry exist or not
        if (!ck.checkCountryExist(lc, countryCode)) {
            System.err.println("Country exist.");
            return;
        }
        System.out.print("Enter name of contry: ");
        String countryName = ck.checkInputString();
        System.out.print("Enter total area: ");
        double countryArea = ck.checkInputDouble();
        System.out.print("Enter terrain of country: ");
        String countryTerrain = ck.checkInputString();
        lc.add(new Country(countryTerrain, countryCode, countryName, countryArea));
        System.err.println("Add successful.");
    }
    
    
            //display infomation of country
    public void printCountry(ArrayList<Country> lc) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            country.display();
        }
    }

    //display infomation sort name in ascending
    public void printCountrySorted(ArrayList<Country> lc) {
        Collections.sort(lc);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            country.display();
        }
    }
    
        //allow user search infomation contry by name
    public void searchByName(ArrayList<Country> lc) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = ck.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }
    
}
