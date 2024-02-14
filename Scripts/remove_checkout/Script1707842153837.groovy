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

WebUI.click(findTestObject('Object Repository/remove_item/Page_Advantage Shopping/a_My account My orde_124641'))

WebUI.setText(findTestObject('Object Repository/remove_item/Page_Advantage Shopping/input_OR_username'), GlobalVariable.username)

WebUI.setText(findTestObject('Object Repository/remove_item/Page_Advantage Shopping/input_Username_password'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/remove_item/Page_Advantage Shopping/button_SIGN IN'))

WebUI.click(findTestObject('Object Repository/remove_item/Page_Advantage Shopping/span_TABLETS'))

WebUI.click(findTestObject('Object Repository/remove_item/Page_Advantage Shopping/img_SHOP NOW_16'))

WebUI.click(findTestObject('Object Repository/remove_item/Page_Advantage Shopping/button_ADD TO CART'))

WebUI.click(findTestObject('Object Repository/remove_item/Page_Advantage Shopping/a_1'))

WebUI.click(findTestObject('Object Repository/remove_item/Page_Advantage Shopping/a_REMOVE'))

String pathObjekHapusItem = 'Object Repository/remove_item/Page_Advantage Shopping/a_REMOVE'

String pathObjekKeranjangKosong = 'Object Repository/remove_item/Page_Advantage Shopping/label_Your shopping cart is empty' // Mencoba mengklik elemen hapus item
// Menunggu sebentar untuk memungkinkan perubahan UI terlihat
// Memverifikasi keberadaan label "Keranjang belanja Anda kosong"

def verifikasiKeranjangKosongSetelahPenghapusan(String pathObjekHapusItem, String pathObjekKeranjangKosong) {
    boolean klikBerhasil = WebUI.click(findTestObject(pathObjekHapusItem))

    if (klikBerhasil) {
        WebUI.delay(1)

        def labelKeranjangKosongTerlihat = WebUI.verifyElementPresent(findTestObject(pathObjekKeranjangKosong), 5)

        if (labelKeranjangKosongTerlihat) {
            print('Item berhasil dihapus! Keranjang belanja sekarang kosong.')

            return true
        } else {
            print('Gagal memverifikasi label keranjang kosong setelah penghapusan item.')

            return false
        }
    } else {
        print('Gagal mengklik elemen hapus item.')

        return false
    }
}

