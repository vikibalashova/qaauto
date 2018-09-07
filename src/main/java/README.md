1. On the Internet, find the extension Selenium for Java (Maven)
   (Or you can use this link "https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java").   
   1.1 Click on the latest version - copy the code - paste into intellij idea.  
   1.2 At the beginning and at the end of this code, add the word <dependencies> and </ dependencies> respectively.     
   1.3 Run the program. 
2. Install the program geckodriver for Win/OS/Linux.
(you can use this link "https://github.com/mozilla/geckodriver/releases").

COMMENT: If you have an error, you can write the way to the program.
For example:(System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");)      

# Usage
-------

## Conflict
### Resolve

## Cherrypick
## Cherrypick #2
Home Task #7:
1. Update page.LinkedinHomePage and LinkedinLoginSubmit page classes using PageFactory pattern (as it's done for page.LinkedinLoginPage class)
2. Using PageObject and PageFactory patterns implement new Test scenario in a separate test class:
- Open login page
- Verify login page is loaded
- Login with valid credentials
- Verify home page is loaded
- Search for 'hr' Searchterm
- Verify Search page is loaded
- Verify 10 results displayed on search page
- Verify each result item contains searchterm

Главная задача № 7:
1. Обновите ссылки page.LinkedinHomePage и LinkedinLoginSubmit, используя шаблон PageFactory (как это делается для класса page.LinkedinLoginPage)
2. Использование шаблонов PageObject и PageFactory реализует новый тестовый сценарий в отдельном тестовом классе:
- Открытая страница входа
- Подтвердить загрузку страницы входа в систему
- Вход с действительными учетными данными
- Подтверждена загрузка домашней страницы
- Поиск «hr» Searchterm
- загружена страница подтверждения поиска
- Проверить 10 результатов, отображаемых на странице поиска.
- Проверить, что каждый элемент результата содержит searchterm
