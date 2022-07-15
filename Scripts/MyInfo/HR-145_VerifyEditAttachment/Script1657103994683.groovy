import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
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

// FAILED
//WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/')
//WebUI.openBrowser(GlobalVariable.URL)
//WebUI.maximizeWindow()
'Login with ESS user account'
CustomKeywords.'common.CommonKeywords.Login'(username, password)

//CustomKeywords.'common.CommonKeywords.Login'(GlobalVariable.USERNAME_ESS, GlobalVariable.PASSWORD_ESS)
WebUI.click(findTestObject('Dashboard/link_MyInfo'))

String file_name = 'Test596KB.png'

String file_name_edit = 'Test901KB.docx'

String xpath_file = ('//a[contains(text(),"' + file_name) + '")]'

CustomKeywords.'myinfo.MyInfoKeywords.AddAttachment'('Test596KB.png')

WebElement table = WebUI.findWebElement(findTestObject('MyInfo/table_Attachments'), 10)

List<WebElement> rows_table = table.findElements(By.tagName('tr'))

int rows_count = rows_table.size()

for (int row = rows_count - 1; row > 0; row--) {
    List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName('td'))

    if (columns_row.get(1).getText().equals(file_name)) {
        columns_row.get(7).findElement(By.tagName('a')).click()

        break
    }
}

WebUI.verifyElementVisible(findTestObject('MyInfo/section_AddAttachment'))

WebUI.verifyElementVisible(findTestObject('MyInfo/heading_EditAttachment'))

WebUI.verifyElementText(findTestObject('MyInfo/heading_EditAttachment'), 'Edit Attachment')

WebUI.verifyElementVisible(findTestObject('MyInfo/label_CurrentFile'))

WebUI.verifyElementText(findTestObject('MyInfo/label_CurrentFile'), 'Current File')

WebUI.verifyElementVisible(findTestObject('MyInfo/text_FileName'))

WebUI.verifyElementText(findTestObject('MyInfo/text_FileName'), file_name)

WebUI.verifyElementVisible(findTestObject('MyInfo/label_ReplaceWith'))

WebUI.verifyElementText(findTestObject('MyInfo/label_ReplaceWith'), 'Replace With')

WebUI.verifyElementVisible(findTestObject('MyInfo/input_SelectFile'))

WebUI.verifyElementVisible(findTestObject('MyInfo/label_MaxFileSize'))

WebUI.verifyElementVisible(findTestObject('MyInfo/label_Comment'))

WebUI.verifyElementText(findTestObject('MyInfo/label_Comment'), 'Comment')

WebUI.verifyElementVisible(findTestObject('MyInfo/textarea_Comment'))

WebUI.verifyElementVisible(findTestObject('MyInfo/label_RequiredNote_Attachment'))

WebUI.verifyElementText(findTestObject('MyInfo/label_RequiredNote_Attachment'), '* Required field')

WebUI.verifyElementVisible(findTestObject('MyInfo/button_Upload'))

WebUI.verifyElementAttributeValue(findTestObject('MyInfo/button_Upload'), 'value', 'Upload', 2)

WebUI.verifyElementVisible(findTestObject('MyInfo/button_SaveCommentOnly'))

WebUI.verifyElementAttributeValue(findTestObject('MyInfo/button_SaveCommentOnly'), 'value', 'Save Comment Only', 2)

WebUI.verifyElementVisible(findTestObject('MyInfo/button_Cancel'))

WebUI.verifyElementAttributeValue(findTestObject('MyInfo/button_Cancel'), 'value', 'Cancel', 2)

WebUI.verifyElementClickable(findTestObject('MyInfo/input_SelectFile'))

WebUI.verifyElementClickable(findTestObject('MyInfo/textarea_Comment'))

WebUI.click(findTestObject('MyInfo/button_Upload'))

WebUI.verifyElementVisible(findTestObject('MyInfo/label_ErrorMessageSelectFile'))

WebUI.verifyElementText(findTestObject('MyInfo/label_ErrorMessageSelectFile'), 'This field is required', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uploadFile(findTestObject('MyInfo/input_SelectFile'), 'D:\\Nam\\Test\\' + file_name)

String comment = 'This is the first comment'

WebUI.setText(findTestObject('MyInfo/textarea_Comment'), comment)

WebUI.verifyElementAttributeValue(findTestObject('MyInfo/textarea_Comment'), 'value', comment, 2)

WebUI.click(findTestObject('MyInfo/button_SaveCommentOnly'))

WebUI.verifyElementNotVisible(findTestObject('MyInfo/section_AddAttachment'))

WebUI.verifyTextPresent('Successfully Saved', false)

table = WebUI.findWebElement(findTestObject('MyInfo/table_Attachments'), 10)

rows_table = table.findElements(By.tagName('tr'))

rows_count = rows_table.size()

boolean find_file_edit = false

for (int row = rows_count - 1; row > 0; row--) {
    List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName('td'))

    if (columns_row.get(1).getText().equals(file_name) && columns_row.get(2).getText().equals(comment)) {
        find_file_edit = true

        columns_row.get(7).findElement(By.tagName('a')).click()

        break
    }
}

if (!(find_file_edit)) {
    KeywordUtil.markFailedAndStop('Edit attachment unsuccessfully!')
}

WebUI.verifyElementText(findTestObject('MyInfo/text_FileName'), file_name)

WebUI.verifyElementAttributeValue(findTestObject('MyInfo/textarea_Comment'), 'value', comment, 2)

WebUI.uploadFile(findTestObject('MyInfo/input_SelectFile'), 'D:\\Nam\\Test\\' + file_name_edit)

get_file_name = WebUI.getAttribute(findTestObject('MyInfo/input_SelectFile'), 'value')

WebUI.verifyMatch(get_file_name, '.*' + file_name_edit, true, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('MyInfo/button_Upload'))

WebUI.verifyElementNotVisible(findTestObject('MyInfo/section_AddAttachment'))

WebUI.verifyTextPresent('Successfully Saved', false)

table = WebUI.findWebElement(findTestObject('MyInfo/table_Attachments'), 10)

rows_table = table.findElements(By.tagName('tr'))

rows_count = rows_table.size()

find_file_edit = false

for (int row = rows_count - 1; row > 0; row--) {
    List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName('td'))

    if (columns_row.get(1).getText().equals(file_name_edit) && columns_row.get(2).getText().equals(comment)) {
        find_file_edit = true

        break
    }
}

if (find_file_edit) {
    KeywordUtil.markPassed('Edit attachment successfully!')
} else {
    KeywordUtil.markFailedAndStop('Edit attachment unsuccessfully!')
}

