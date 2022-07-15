import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// PASSED
//WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/')
//WebUI.openBrowser(GlobalVariable.URL)
//WebUI.maximizeWindow()
'Login with ESS user account'
CustomKeywords.'common.CommonKeywords.Login'(username, password)

//CustomKeywords.'common.CommonKeywords.Login'(GlobalVariable.USERNAME_ESS, GlobalVariable.PASSWORD_ESS)
WebUI.click(findTestObject('Dashboard/link_MyInfo'))

String file_name = 'Test596KB.png'

String xpath_file = ('//a[contains(text(),"' + file_name) + '")]'

CustomKeywords.'myinfo.MyInfoKeywords.AddAttachment'(file_name)

WebUI.verifyElementNotClickable(findTestObject('MyInfo/button_Delete'))

WebElement table = WebUI.findWebElement(findTestObject('MyInfo/table_Attachments'), 10)

List<WebElement> rows_file = table.findElements(By.xpath(xpath_file))

int count_file_before_delete = rows_file.size()

List<WebElement> rows_table = table.findElements(By.tagName('tr'))

int rows_count = rows_table.size()

for (int row = rows_count - 1; row >= 0; row--) {
    List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName('td'))

    if (columns_row.get(1).getText().equals(file_name)) {
        columns_row.get(0).findElement(By.tagName('input')).click()

        break
    }
}

WebUI.click(findTestObject('MyInfo/button_Delete'))

WebUI.verifyTextPresent('Successfully Deleted', false)

int count_file_after_delete = 0

TestObject object = new TestObject()

object.addProperty('xpath', ConditionType.EQUALS, xpath_file)

if (WebUI.verifyElementVisible(object, FailureHandling.OPTIONAL) == true) {
    rows_file = WebUI.findWebElements(object, 5)

    count_file_after_delete = rows_file.size()
}

if (count_file_after_delete == (count_file_before_delete - 1)) {
    KeywordUtil.markPassed('Deleted file successfully!')
} else {
    KeywordUtil.markFailed('Deleted file unsuccessfully!')
}

