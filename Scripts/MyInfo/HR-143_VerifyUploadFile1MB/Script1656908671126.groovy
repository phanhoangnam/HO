import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// FAILED
//WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/')
//WebUI.openBrowser(GlobalVariable.URL)
//WebUI.maximizeWindow()
'Login with ESS user account'
CustomKeywords.'common.CommonKeywords.Login'(username, password)

//CustomKeywords.'common.CommonKeywords.Login'(GlobalVariable.USERNAME_ESS, GlobalVariable.PASSWORD_ESS)
WebUI.click(findTestObject('Dashboard/link_MyInfo'))

String file_name = 'Test1MB.png'

CustomKeywords.'myinfo.MyInfoKeywords.AddAttachment'(file_name)

