import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
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

WebUI.openBrowser('https://schroleeduspatest.azurewebsites.net/#/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Test/input_Email'), 'testqa33@gmail.com')

WebUI.setText(findTestObject('Test/input_Password'), 'Quality33')

WebUI.click(findTestObject('Test/button_Login'))

WebUI.click(findTestObject('Test/tab_Engage'))

WebUI.click(findTestObject('Test/div_SendContract'))

WebUI.setText(findTestObject('Test/input_ApplicantEmail'), 'x@gmail.com')

WebUI.sendKeys(findTestObject('Test/input_ApplicantEmail'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('Test/input_FirstName'), 5)

WebUI.sendKeys(findTestObject('Test/input_FirstName'), Keys.chord(Keys.CONTROL, 'A'))

WebUI.sendKeys(findTestObject('Test/input_FirstName'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Test/input_FirstName'), 'a')

WebUI.sendKeys(findTestObject('Test/input_LastName'), Keys.chord(Keys.CONTROL, 'A'))

WebUI.sendKeys(findTestObject('Test/input_LastName'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Test/input_LastName'), 'b')

WebUI.setText(findTestObject('Test/input_Position'), 'c')

WebUI.click(findTestObject('Test/button_NextStep'))

//WebUI.click(findTestObject('Test/input_UploadContract'))
CustomKeywords.'common.CommonKeywords.uploadFile'(findTestObject('Test/input_UploadContract'), 'D:\\Nam\\Katalon\\Automation Assignment.pdf')

WebUI.delay(3)

text = WebUI.getText(findTestObject('Test/input_UploadContract'))

value = WebUI.getAttribute(findTestObject('Test/input_UploadContract'), 'value')

WebUI.delay(10)

WebUI.closeBrowser()

