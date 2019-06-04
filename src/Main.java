import javafx.util.converter.LongStringConverter;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = null;

        ArrayList<Connection> connections = new ArrayList<>();



        String path = "D:\\Documents\\GDrive\\ISEL\\AED_\\Serie3P2\\file\\small.csv";

        int counter = 0;
        Scanner sc = null;

        DisjointSet djs = new DisjointSet();

        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");


            while (sc.hasNextLine()) {

                String tmp[] = new String[7];
                String line = sc.nextLine();

                tmp = line.split("\\t");

                if(tmp[1].equals("True")){
                    counter++;
                    Connection con = new Connection();
                    con.tUser = tmp[3];

                    con.rUser = tmp[4];
                    djs.addNewDisjointSet(con.tUser);
                    connections.add(con);

                }


            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }

        for (Connection con: connections) {
            djs.union(con.tUser, con.rUser);
        }


        System.out.println(djs.printALl());

    }

//    private static boolean notIn(String s,  int counter) {
//
//        if(counter == 0) return true;
//
//        for(int i = 0; i<counter; i++){
//            if(s.equals(uniqueIds[i])) return false;
//        }
//
//        return true;
//    }
}
