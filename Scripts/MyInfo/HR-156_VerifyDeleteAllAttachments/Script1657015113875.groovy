import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

// PASSED
//WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/')
//WebUI.openBrowser(GlobalVariable.URL)
//WebUI.maximizeWindow()
'Login with ESS user account'
CustomKeywords.'common.CommonKeywords.Login'(username, password)

//CustomKeywords.'common.CommonKeywords.Login'(GlobalVariable.USERNAME_ESS, GlobalVariable.PASSWORD_ESS)
WebUI.click(findTestObject('Dashboard/link_MyInfo'))

CustomKeywords.'myinfo.MyInfoKeywords.AddAttachment'('Test596KB.png')

CustomKeywords.'myinfo.MyInfoKeywords.AddAttachment'('Test901KB.docx')

WebElement table = WebUI.findWebElement(findTestObject('MyInfo/table_Attachments'), 10)

List<WebElement> rows_table = table.findElements(By.tagName('tr'))

int rows_count = rows_table.size()

List<WebElement> columns_row_header = rows_table.get(0).findElements(By.tagName('th'))

// Click CheckAll checkbox
columns_row_header.get(0).findElement(By.tagName('input')).click()

// Check all checkboxes of records in the table should be checked
for (int row = 1; row < rows_count; row++) {
    List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName('td'))

    if (columns_row.get(0).findElement(By.tagName('input')).isSelected() == false) {
        KeywordUtil.markFailed('CheckAll checkbox works incorrectly!')
    }
}

// Click Delete button
WebUI.click(findTestObject('MyInfo/button_Delete'))

WebUI.verifyTextPresent('Successfully Deleted', false)

WebUI.verifyElementNotVisible(findTestObject('MyInfo/table_Attachments'), FailureHandling.OPTIONAL)

WebUI.verifyElementVisible(findTestObject('MyInfo/button_AddAttachment'))

WebUI.verifyElementAttributeValue(findTestObject('MyInfo/button_AddAttachment'), 'value', 'Add', 2)

