package com.mycompany.p4poo2.view;

import com.mycompany.p4poo2.model.House;
import com.mycompany.p4poo2.persistence.FileHouse;
import java.io.IOException;
import java.util.ArrayList;
import com.mycompany.p4poo2.view.AskData;

/**
 *
 * @author arnau
 */
public class Main {

    private static final String menu = "1. Afegir casa.\n2. Afegir placa.\n3. Afegir aparell.\n4. Encendre interruptor general de la casa.\n5. Encentre un aparell.\n6. Apagar un aparell.\n7. Veure les cases.\n8. Veure informació d’una casa.\n9. Sortir.";
    private static ArrayList<House> listHouses;
    private static FileHouse file;
    private static AskData ask;
    private static House house;

    public static void main(String[] args) {
        try {
            file = new FileHouse();
            listHouses = new ArrayList<>();
            ask = new AskData();
            house = new House();
            int opc = -1;
            boolean notExit = true;

            do {
//                llegeix els fichers abans de res
                listHouses = file.readHouses();
                System.out.println(menu);
                opc = ask.askInt("Escull una opció: ", "L'opció no es valida", 1, 9);
                switch (opc) {
//                Afegir casa
                    case 1 -> {
                        house.addHouse(listHouses);
                        file.writeHousesOverWrite(listHouses);
                    }
                    case 2 -> {
                        house.addPlate(listHouses);
                        
                    }
                    case 3 -> {
                        
                    }
                    case 4 -> {

                    }
                    case 5 -> {

                    }
                    case 6 -> {

                    }
                    case 7 -> {

                    }
                    case 8 -> {

                    }
                    case 9 -> {
                        notExit = false;
                    }
                }
            } while (notExit);
        } catch (IOException ex) {
            System.out.println("-1");
        }

    }
}
