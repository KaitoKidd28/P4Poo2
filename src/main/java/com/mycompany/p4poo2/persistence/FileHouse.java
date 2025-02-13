package com.mycompany.p4poo2.persistence;

import com.mycompany.p4poo2.model.House;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author arnau
 */
public class FileHouse {

    private String nameFileHouse = "cases.txt";
    private String nameFilePlate = "plaques.txt";
    private String nameFileDevice = "aparells.txt";
    private String nameFolder = "dades";
    private String pathFolder;
    private String pathFileHouse;
    private String pathFilePlate;
    private String pathFileDevice;

    public FileHouse() throws IOException {
        pathFolder = "." + File.separator + nameFolder;
        pathFileHouse = pathFolder + File.separator + nameFileHouse;
        pathFilePlate = pathFolder + File.separator + nameFilePlate;
        pathFileDevice = pathFolder + File.separator + nameFileDevice;
        File folder = new File(pathFolder);
        File fileHouse = new File(pathFileHouse);
        File filePlate = new File(pathFilePlate);
        File fileDevice = new File(pathFileDevice);

        if (!folder.exists()) {
            folder.mkdir();
        }

        if (!fileHouse.exists()) {
            fileHouse.createNewFile();
        }

        if (!filePlate.exists()) {
            filePlate.createNewFile();
        }

        if (!fileDevice.exists()) {
            fileDevice.createNewFile();
        }
    }

    public void writeHousesInFile(House house) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileHouse, true));
        writer.write(house.getNif() + "-" + house.getName() + "-" + house.getSurface() + "-" + house.isSwitchh());
        writer.newLine();
        writer.close();
    }

    public void writeHousesOverWrite(ArrayList<House> houses) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileHouse, false));
        for (House x : houses) {
            writer.write(x.getNif() + "-" + x.getName() + "-" + x.getSurface() + "-" + x.isSwitchh());
            writer.newLine();
        }
        writer.close();
    }

    public ArrayList<House> readHouses() throws IOException {
        ArrayList<House> houses = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(pathFileHouse));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("-");
            String nif = data[0];
            String name = data[1];
            int surface = Integer.parseInt(data[2]);
            houses.add(new House(nif, name, surface));
        }

        return houses;
    }

    public void writePlatesOverWrite(ArrayList<House> houses) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathFilePlate, false));
        for (House x : houses) {
            writer.write(x.getNif() + "-" + x.getName() + "-" + x.getSurface() + "-" + x.isSwitchh());
            writer.newLine();
        }
        writer.close();
    }
}
