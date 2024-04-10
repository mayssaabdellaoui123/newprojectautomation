package utilities;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testdata.DataFromGoogleSheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Utility {
    DataFromGoogleSheet dataFromgoogle = new DataFromGoogleSheet();

    public static List<String> ValuesFromChart;


    public List<String> SortDataComesFromGoogleSheet( String range ) throws GeneralSecurityException, IOException {
        List<List<Object>> data = dataFromgoogle.DataFromGoogleSheet(range);
        if (data == null)  {
            List<String> vide = new ArrayList<>();
            return vide;
        }
        List<String> newdata = data.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
        System.out.println(newdata);
        Collections.sort(newdata);
        System.out.println(newdata);
        return newdata ;
    }

    public List<String> sortData(List<String> unsortedData){
        Collections.sort(unsortedData);
        return unsortedData;
    }



    public List<String> ModifyDataComingFromChart (List<String> DataFromChart) {
        List<String > newChartLabel = new ArrayList<>();

        for (String text : DataFromChart){
            if (text == null){
                continue;
            }
            if ((text.contains(", z")) == false) {
                continue;
            }

            int j =  text.indexOf(", z");
            int k = text.indexOf(". ");
            String newtext = text.substring(k+2,j);
            String newtext1 = newtext.replace(", y: "," : ").concat("%");
            newChartLabel.add(newtext1);

        }
        Collections.sort(newChartLabel);
        ValuesFromChart = newChartLabel;

        return  newChartLabel;

    }

    public List<String> ModifyDataComingFromChartForFilterComparison () {
        List<String > newChartLabel = new ArrayList<>();
        for (String text : ValuesFromChart){
            if (text.equals("null")){
                continue;
            }
            int i =  text.indexOf(" : ");
            String newtext = text.substring(0,i);
            System.out.println(newtext);
            newChartLabel.add(newtext);
        }
        Collections.sort(newChartLabel);
        ValuesFromChart = newChartLabel;


        return  newChartLabel;

    }




}
