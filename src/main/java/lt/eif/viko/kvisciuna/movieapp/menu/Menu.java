package lt.eif.viko.kvisciuna.movieapp.menu;


import lt.eif.viko.kvisciuna.movieapp.db.MovieLoader;
import lt.eif.viko.kvisciuna.movieapp.db.ObjectLoader;
import lt.eif.viko.kvisciuna.movieapp.model.Movie;
import lt.eif.viko.kvisciuna.movieapp.server.JavaServer;
import lt.eif.viko.kvisciuna.movieapp.util.JaxbiUtil;

import javax.xml.bind.JAXBException;
import java.util.Scanner;
/**
 * Represents a console menu for managing movies, including operations like loading movies,
 * transforming movies to XML or Pojo, and sending files over a network.
 */
public class Menu {
    /**
     * Displays the main menu to the user.
     *
     * @param input A Scanner object for reading user input.
     * @return The integer choice of the user.
     */
        public static int displayMenu(Scanner input){
            System.out.println("Make a selection");
            System.out.println("------------------");
            System.out.printf("| 1) %20s \n", "Load movies");
            System.out.printf("| 2) %20s \n", "Transform to XML");
            System.out.printf("| 3) %20s \n", "Transform to Pojo");
            System.out.printf("| 4) %20s \n", "Sent xml file over network");
            System.out.printf("| 5) %20s \n", "Sent xsd file over network");
            System.out.printf("| 6) %20s \n", "Quit");
            return input.nextInt();
        }
    /**
     * Continuously shows the menu to the user and processes the user's choices
     * to perform various actions: loading movies, converting movies to XML or Pojo,
     * and sending files over a network.
     */
        public static void showMenu(){
            Scanner input = new Scanner(System.in);
            int userChoice;
            do{
                userChoice = displayMenu(input);
                switch(userChoice){
                    case 1:
                        // Load movies from the database and display them
                        MovieLoader.loadMovies();
                        break;
                    case 2:
                        // Transform a single movie to XML format and print it
                        try {
                            JaxbiUtil.transformToXml(ObjectLoader.loadObject(Movie.class, 1));
                        } catch (JAXBException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        // Transform a single movie from XML back to a POJO and print it
                        try {
                            JaxbiUtil.transformToPojo(ObjectLoader.loadObject(Movie.class, 1));
                        } catch (JAXBException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 4:
                        // Start a server and send an XML file over the network
                        JavaServer javaServer = new JavaServer();
                        javaServer.start(7777, "Movie.xml");
                        break;
                    case 5:
                        // Start a server and send an XSD file over the network
                        JavaServer javaServer1 = new JavaServer();
                        javaServer1.start(7777, "Movie.xsd");
                    case 6:
                        // Exit the program
                        System.out.println("Quitting");
                        System.exit(0);
                        break;
                    default:
                        // Optional: Handle invalid selections, if necessary

                        break;

                }
            }while(userChoice!=6);
        }
    }



