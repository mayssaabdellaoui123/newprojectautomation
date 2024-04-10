package testdata;

import io.qameta.allure.Step;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class DataFromGoogleSheet {


    public String Loginrange = "login Scenarios!B3:C9";


    @Step("Get Data sets From Google Sheet")
    public List<List<Object>> DataFromGoogleSheet(String range) throws GeneralSecurityException, IOException {
        GoogleSheetAPI sheetAPI = new GoogleSheetAPI();
        List<List<Object>> values = sheetAPI.getData(range);
        return  values;
    }


}
