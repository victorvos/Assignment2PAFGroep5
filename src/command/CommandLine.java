package command;
import java.io.IOException;
import java.util.Scanner;

import domain.Trein;
import domain.Wagon;
import gui.Log;
import interfaces.Application;

/**
 * Created by Eigenaar on 14-12-2016.
 */
public class CommandLine extends Log implements Application {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.println("Welke DSL Command wil je gebruiken?");
        String dslLine = in.nextLine();
        System.out.println(dslLine);



        String eersteWoord = dslLine.split("\\s+")[0];
        String tweedeWoord = dslLine.split("\\s+")[1];
        String derdeWoord = dslLine.split("\\s+")[2];

        System.out.println(eersteWoord);

        if(eersteWoord == "new") {
            if(tweedeWoord == "train") {
                if(!(derdeWoord.isEmpty())) {
                    Trein trein = new Trein(derdeWoord);
                }
            } else if (tweedeWoord == "wagon") {
                String vierdeWoord = dslLine.split("\\s+")[3];
                if(vierdeWoord.isEmpty()) {
                    Wagon wagon = new Wagon(derdeWoord);
                } else if (vierdeWoord == "numseats") {
                    String vijfdeWoord = dslLine.split("\\s+")[4];
                    Wagon wagon = new Wagon(derdeWoord, Integer.parseInt(vijfdeWoord));
                }
            }
        }

        System.out.println(tweedeWoord);

        in.close();
    }

}
