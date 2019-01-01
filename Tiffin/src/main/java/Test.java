
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mrsagar
 */
public class Test {

    public static void main(String arStr[]) {
            SimpleDateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            Date unformateddate = originalFormat.parse("July 16, 2016 00:00:00");
            System.out.println(unformateddate);
        } catch (ParseException ex) {
            System.err.println("Error");
        }
        
    }
}
