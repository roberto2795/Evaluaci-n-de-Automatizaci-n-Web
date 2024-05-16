import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaDeRegresionCarritoCompras {

    public static void main(String[] args) {
        // Configurar el sistema para usar el controlador de Chrome (descarga el controlador de Selenium WebDriver para Chrome)
        System.setProperty("webdriver.chrome.driver", "ruta_al_controlador/chromedriver");

        // Inicializar el navegador Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar la ventana del navegador
        driver.manage().window().maximize();

        // Ingresar a la página de Juntoz
        driver.get("https://juntoz.com/");

        // Iniciar sesión
        iniciarSesion(driver);

        // Validar la autenticación
        validarAutenticacion(driver);

        // Ingresar a la categoría "Envio Gratis" y seleccionar el primer producto
        ingresarCategoriaYSeleccionarProducto(driver);

        // Agregar al carrito
        agregarAlCarrito(driver);

        // Validar que se haya agregado exitosamente al carrito
        validarAgregadoAlCarrito(driver);

        // Cerrar el navegador
        driver.quit();
    }

    public static void iniciarSesion(WebDriver driver) {
        // Lógica para iniciar sesión
        WebElement cuentaButton = driver.findElement(By.className("cuenta"));
        cuentaButton.click();

        WebElement emailInput = driver.findElement(By.id("inputEmail"));
        emailInput.sendKeys("279540acosta@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys("G@toazul");

        WebElement iniciarSesionButton = driver.findElement(By.id("signIn"));
        iniciarSesionButton.click();
    }

    public static void validarAutenticacion(WebDriver driver) {
        // Lógica para validar la autenticación
        WebElement menuPrincipal = driver.findElement(By.className("menu-principal"));
        if (menuPrincipal.isDisplayed()) {
            System.out.println("Autenticación exitosa.");
        } else {
            System.out.println("Fallo en la autenticación.");
        }
    }

    public static void ingresarCategoriaYSeleccionarProducto(WebDriver driver) {
        // Lógica para navegar a la categoría "Envio Gratis" y seleccionar el primer producto
        WebElement envioGratisLink = driver.findElement(By.linkText("Envío Gratis"));
        envioGratisLink.click();

        // Suponiendo que hay una lista de productos y se selecciona el primero
        WebElement primerProducto = driver.findElement(By.xpath("//div[@class='producto'][1]"));
        primerProducto.click();
    }

    public static void agregarAlCarrito(WebDriver driver) {
        // Lógica para agregar el producto al carrito
        WebElement agregarAlCarritoButton = driver.findElement(By.id("agregar-carrito"));
        agregarAlCarritoButton.click();
    }

    public static void validarAgregadoAlCarrito(WebDriver driver) {
        // Lógica para validar que el producto se haya agregado exitosamente al carrito
        WebElement carritoButton = driver.findElement(By.className("carrito"));
        carritoButton.click();

        WebElement productosEnCarrito = driver.findElement(By.className("productos-carrito"));
        if (productosEnCarrito.isDisplayed()) {
            System.out.println("Producto agregado al carrito exitosamente.");
        } else {
            System.out.println("Fallo al agregar producto al carrito.");
        }
    }
}