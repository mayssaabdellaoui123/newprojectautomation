package testcases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import utilities.BaseFile;

@Listeners({ TestListener.class })
@Epic("Functional tests")
@Feature("Interest Rate Risk Tests")
public class InterestRateRiskTestCases extends BaseFile {
}
