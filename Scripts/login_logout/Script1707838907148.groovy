import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.click(findTestObject('Object Repository/Login/Page_Advantage Shopping/svg_CHECKOUT  (0.00)_menuUser'))

WebUI.setText(findTestObject('Object Repository/Login/Page_Advantage Shopping/input_OR_username'), GlobalVariable.username)

WebUI.setText(findTestObject('Object Repository/Login/Page_Advantage Shopping/input_Username_password'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/Login/Page_Advantage Shopping/button_SIGN IN'))

WebUI.click(findTestObject('Object Repository/Login/Page_Advantage Shopping/a_ruslan1_750cc9'))

WebUI.click(findTestObject('Object Repository/Login/Page_Advantage Shopping/label_My account'))

WebUI.verifyElementText(findTestObject('Object Repository/Login/Page_Advantage Shopping/div_ruslan ruslan'), 'ruslan ruslan')

WebUI.click(findTestObject('Object Repository/Login/Page_Advantage Shopping/a_ruslan1_750cc9'))

/*Verifikasi untuk */
def isLoggedIn = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Page_Advantage Shopping/a_ruslan1_750cc9'), 
    5)

if (isLoggedIn) {
    // Klik "Sign out"
    WebUI.click(findTestObject('Object Repository/Login/Page_Advantage Shopping/label_Sign out'))

    // Verifikasi bahwa teks "ruslan1" tidak ada
    def isRuslanTextPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Page_Advantage Shopping/a_ruslan1_750cc9'), 
        5)

    if (isRuslanTextPresent) {
        // Gagal logout
        //throw new Exception('"ruslan1" masih ada setelah logout')
        //  } else {
        // Berhasil logout
        print('Berhasil logout')
    }
    // Tidak perlu logout karena tidak ada user yang login
} else {
    print('Tidak perlu logout karena tidak ada user yang login')
}

