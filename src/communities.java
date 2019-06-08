import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class communities {



    public static void main(String[] args) throws IOException {

        String file = "D:\\Documents\\GDrive\\ISEL\\AED_\\Serie3P2\\Comunities\\out\\production\\Comunities\\" + args[0];
        FileInputStream inputStream = null;
        inputStream = new FileInputStream(file);
        Scanner sc = new Scanner(inputStream, "UTF-8");//new Scanner(System.in);

        MyDisJointSet djs = new MyDisJointSet();

        try {

            //sc = new Scanner(inputStream, "UTF-8");

           // String command = sc.next();

            while (sc.hasNextLine()) {

                String tmp[] = new String[7];
                String line = sc.nextLine();

                tmp = line.split("\\t");

                if(tmp[1].equals("TRUE") || tmp[1].equals("True")){

                    djs.addConnection(tmp[3], tmp[4]);

                }
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
//            if (inputStream != null) {
//                inputStream.close();
//            }
            if (sc != null) {
                sc.close();
            }
        }


        Scanner sc2 = new Scanner(System.in);

        long startTime = System.currentTimeMillis();

        while(sc2.hasNext()) {

            String command = sc2.next();

            if(command.equals("e")){
                System.out.println("\nExiting... See ya!!\n");
                break;
            }
            else if(command.startsWith("sameCommunity")){

                String user1 = sc2.next();
                String user2 = sc2.next();

                System.out.format("User1: %s\n", user1);
                System.out.format("User2: %s\n", user2);

                int communityNumber = djs.inSameCommunity(user1, user2);

                if(communityNumber >-1)
                    System.out.format("The users belong to the Same community (Community number %d) !\n", communityNumber);
                else
                    System.out.println("The users do not belong to the Same community!\n");

            }
            else if(command.startsWith("getCommunityAvgConnections")){
                //djs.getConnectionAvg();
            }
            else if(command.equals("getCommunitiesCount")){

                System.out.format("There are %d communities in the provided file.\n", djs.getCommunities());
            }
            else{
                System.out.println("Unrecognized command!");
            }


        }

        long elapsedTime = System.currentTimeMillis()-startTime;

        System.out.println("time to Process: "+  elapsedTime);
        sc2.close();


    }


}
