import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Prueba1 {
    WebDriver driver;

    @BeforeEach
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                .concat("\\src\\test\\resources\\drivers\\chromedriver.exe"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


    @Test
    void deberiaRegistrarseEnModuloDeRegistro() throws InterruptedException {
        //mapeo de elementos
        WebElement botonregistro = driver.findElement(By.xpath("//a[@class='login']"));
        botonregistro.click();

        WebElement cajacorreo = driver.findElement(By.id("email_create"));
        cajacorreo.sendKeys("ldsalazar@gmail.com");
        WebElement botoncrearcuenta = driver.findElement(By.xpath("//span[contains(.,'Create an account')]"));
        botoncrearcuenta.click();

        Thread.sleep(5000);

        WebElement checkbox1 = driver.findElement(By.id("id_gender1"));
        checkbox1.click();


        WebElement cajanombre = driver.findElement(By.id("customer_firstname"));
        cajanombre.sendKeys("manuel ");

        WebElement apellido = driver.findElement(By.id("customer_lastname"));
        apellido.sendKeys("leon");

        WebElement compania = driver.findElement(By.id("company"));
        compania.sendKeys("Indra");



        WebElement contrasena = driver.findElement(By.id("passwd"));
        contrasena.sendKeys("ballesta#251996");

        WebElement dia = driver.findElement(By.id("days"));
        dia.sendKeys("25");

        WebElement mes = driver.findElement(By.id("months"));
        mes.sendKeys("October");

        WebElement anio = driver.findElement(By.id("years"));
        anio.sendKeys("1996");

        WebElement direccion1 = driver.findElement(By.id("address1"));
        direccion1.sendKeys("calle 6b 13a 27");

        WebElement direccion2 = driver.findElement(By.id("address2"));
        direccion2.sendKeys("calle 6b 13a 27");

        WebElement ciudad = driver.findElement(By.id("city"));
        ciudad.sendKeys("Monteria");

        //WebElement estado = driver.findElement(By.id("id_state"));
        //ciudad.sendKeys("");

        Select estado = new Select(driver.findElement(By.id("id_state")));
        estado.selectByVisibleText("Florida");


        WebElement codigopostal = driver.findElement(By.id("postcode"));
        codigopostal.sendKeys("23001");

        Select usa = new Select(driver.findElement(By.id("id_country")));
        usa.selectByVisibleText("United States");

        WebElement informacion = driver.findElement(By.id("other"));
        informacion.sendKeys("sin informacion ");

        WebElement telefono1 = driver.findElement(By.id("phone"));
        telefono1.sendKeys("3104197185");

        WebElement telefono2 = driver.findElement(By.id("phone_mobile"));
        telefono2.sendKeys("3104197185");

        WebElement alias = driver.findElement(By.id("alias"));
        alias.sendKeys("alias manuel");

        WebElement botonregistro2 = driver.findElement(By.id("submitAccount"));
        botonregistro2.click();





    }


    @Test
    public void deberiaCoincidirElTitulo() throws InterruptedException  {

       Assertions.assertEquals("My account", driver.getTitle());


    }

    @Test
    public void  deberiaIniciarSesion(){
        WebElement botonregistro = driver.findElement(By.xpath("//a[@class='login']"));
        botonregistro.click();

        WebElement cajacorreo = driver.findElement(By.id("email"));
        cajacorreo.sendKeys("leonba01@gmail.com");
        WebElement cajacontrasena = driver.findElement(By.id("passwd"));
        cajacontrasena.sendKeys("ballesta#251996");

        WebElement botonINiciar = driver.findElement(By.id("SubmitLogin"));
        botonINiciar.click();

        //Assertions.assertEquals("My account - My Store", driver.getTitle());

        WebElement nombreusuario = driver.findElement(By.xpath("//span[contains(.,'manuel leon')]"));
        //Assertions.assertEquals("manuel leon", nombreusuario.getText());

        if (nombreusuario.getText().equals("manuel leon")){
            System.out.println("inicio de sesion exitoso");
        }else{
            try {
                System.out.println("inicio de sesion erroneo");
            }catch (NoSuchElementException e){
                e.printStackTrace();

            }
        }







    }
}
