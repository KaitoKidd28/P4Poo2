package com.mycompany.p4poo2.model;

import com.mycompany.p4poo2.view.AskData;
import java.util.ArrayList;

/**
 *
 * @author arnau
 */
public class House {

    private String nif;
    private String name;
    private int surface;
    private boolean switchh;
    private ArrayList<Plate> listPlates;
    private ArrayList<Device> listDevices;
    private AskData ask = new AskData();

    public House(String nif, String name, int surface) {
        this.nif = nif;
        this.name = name;
        this.surface = surface;
        this.switchh = true;
        this.listPlates = new ArrayList<>();
        this.listDevices = new ArrayList<>();
    }

    public House() {
    }

    public void addHouse(ArrayList<House> houses) {
        String nif;
        String name;
        int surface;

        nif = ask.askNif("Introduiex el Nif: ");

        if (nif.equals("-1")) {
            System.out.println("S'ha introduir el Nif erroni repetides vegades, sortint al menu...");
        } else {
            name = ask.askString("Introduiex el nom de la casa: ");
            surface = ask.askInt("Introdueix la superficie de la casa: ", "La superficie no es correcta", 11);
            houses.add(new House(nif, name, surface));

        }

    }

    public void addPlate(ArrayList<House> houses) {
        String nif = ask.askNif("Nif del propietari de la casa: ");
        int surface;
        double price;
        int power;
        for (House house : houses) {
            if (house.getNif().equals(nif)) {
                surface = ask.askInt("Superficie de la placa:", "La superficie no es correcte", 1);
                if (surface >= house.surface) {
                    power = ask.askInt("Potència: ", "La potència no es correcte", 1);
                    price = ask.askDouble("Preu de la placa: ", "El preu no es correcte", 1);
                    house.getListPlates().add(new Plate(surface, price, power));
                    System.out.println("OK: Placa afegida a la casa.");
                }
                else {
                    System.out.println("La placa no cap a la casa");
                }

            }
        }

        System.out.println("No existeix cap casa amb el nif indicat.");
    }

    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public int getSurface() {
        return surface;
    }

    public boolean isSwitchh() {
        return switchh;
    }

    public ArrayList<Plate> getListPlates() {
        return listPlates;
    }

    public void setListPlates(ArrayList<Plate> listPlates) {
        this.listPlates = listPlates;
    }
    
    
}
