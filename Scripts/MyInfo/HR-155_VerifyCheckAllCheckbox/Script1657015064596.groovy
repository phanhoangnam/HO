import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

// Uncheck any record in the table
List<WebElement> columns_row = rows_table.get(1).findElements(By.tagName('td'))

columns_row.get(0).findElement(By.tagName('input')).click()

// Check CheckAll checkbox should be unchecked
if (columns_row_header.get(0).findElement(By.tagName('input')).isSelected() == true) {
    KeywordUtil.markFailed('CheckAll checkbox works incorrectly!')
}

// Click the checkbox of the record that is unchecked
columns_row.get(0).findElement(By.tagName('input')).click()

// Check CheckAll checkbox should be checked
if (columns_row_header.get(0).findElement(By.tagName('input')).isSelected() == false) {
    KeywordUtil.markFailed('CheckAll checkbox works incorrectly!')
}

