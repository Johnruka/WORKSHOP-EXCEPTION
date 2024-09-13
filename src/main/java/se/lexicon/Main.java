package se.lexicon;


import se.lexicon.data_access.NameService;
import se.lexicon.domain.Person;
import se.lexicon.exception.MyExceptionHandler;
import se.lexicon.fileIO.CSVReader_Writer;

import java.io.IOException;
import java.util.List;

public class Main
{
    public static void main( String[] args ) {

        try {
            List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
            System.out.println("Male names: " + maleFirstNames);
            System.out.println();

            List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
            System.out.println("Female names: " + femaleFirstNames);
            System.out.println();

            List <String> lastNames;
            NameService nameService;
            Person test;

            lastNames = CSVReader_Writer.getLastNames();
            System.out.println("Last names: " + lastNames);
            System.out.println();

            if(maleFirstNames != null && femaleFirstNames != null && lastNames != null)
                nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);
            else
                throw new NullPointerException("Any of the names list is empty...");

            nameService.addFemaleFirstName("Emily");
//            nameService.addFemaleFirstName("Emily");
//            nameService.addFemaleFirstName("Lilly");
            System.out.println();

            nameService.addMaleFirstName("Cris");
//            nameService.addMaleFirstName("Gustav");
            System.out.println();

            nameService.addLastName("Jackson");
//            nameService.addLastName("Hansson");
            System.out.println();

            if(nameService != null) {
                test = nameService.getNewRandomPerson();
                System.out.println(test);
            }
        } catch (IOException e) {
            System.out.println("I/O EXCEPTION: " + e.getMessage());
        } catch (Exception e){
            System.out.println("============================================================");
            MyExceptionHandler.handleExceptionsInMain(e);
            System.out.println("============================================================");
        }
    }
}
