import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
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

CustomKeywords.'myinfo.MyInfoKeywords.AddAttachment'(file_name)

WebElement table = WebUI.findWebElement(findTestObject('MyInfo/table_Attachments'), 10)

List<WebElement> rows_table = table.findElements(By.tagName('tr'))

int rows_count = rows_table.size()

for (int row = rows_count - 1; row > 0; row--) {
    List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName('td'))

    if (columns_row.get(1).getText().equals(file_name)) {
        columns_row.get(1).findElement(By.tagName('a')).click()

        break
    }
}

CustomKeywords.'common.CommonKeywords.isFileDownloaded'('C:\\Users\\phoangnam\\Downloads', file_name)

