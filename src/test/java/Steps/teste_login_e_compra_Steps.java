package Steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class teste_login_e_compra_Steps {

    WebDriver driver = new ChromeDriver();
    String url = "https://www.saucedemo.com/";
    String login = "standard_user";
    String senha  = "secret_sauce";
    String produtos;
    String expected = "https://www.saucedemo.com/inventory.html";
    String checkout;
    String expectedOut = "https://www.saucedemo.com/checkout-step-one.html";
    String firstName = "Maria";
    String lastName = "Santos";
    String zipCode = "60000";
    String urlFinish = "https://www.saucedemo.com/checkout-step-two.html";
    String finish;
    String end;
    String urlEnd = "https://www.saucedemo.com/checkout-complete.html";



    @Before
        public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }
    @Dado("que o usuario esta na pagina de login")
    public void que_o_usuario_esta_na_pagina_de_login() {
        driver.get(url);
    }

    @Quando("insere os dados validos para login")
    public void insere_os_dados_validos_para_login() {
        driver.findElement(By.id("user-name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
    }

    @Entao("deve acessar a plataforma")
    public void deve_acessar_a_plataforma() {
       produtos = driver.getCurrentUrl();
       Assert.assertEquals(expected, produtos);
        driver.quit();
    }

   @Dado("que o usuario esta na pagina de produtos")
    public void que_o_usuario_esta_na_pagina_de_produtos() {
       driver.get(url);
       driver.findElement(By.id("user-name")).sendKeys(login);
       driver.findElement(By.id("password")).sendKeys(senha);
       driver.findElement(By.id("login-button")).click();
       produtos = driver.getCurrentUrl();
       Assert.assertEquals(expected, produtos);
    }

    @Quando("seleciona o produto desejado")
    public void seleciona_o_produto_desejado() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Entao("os produtos devem ser adicionados ao carrinho")
    public void os_produtos_devem_ser_adicionados_ao_carrinho() {
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("item_4_title_link"));
        driver.quit();
    }

    @Dado("que usuário adicionou  o produto desejado ao carrinho")
    public void que_usuário_adicionou_o_produto_desejado_ao_carrinho() {
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

    }

    @Quando("clica no botao Checkout")
    public void clica_no_botao_checkout() {
      driver.findElement(By.id("checkout")).click();
    }

    @Entao("deve ser direcionado para a pagina Checkout Your Information")
    public void deve_ser_direcionado_para_a_pagina_checkout_your_information() {
        checkout = driver.getCurrentUrl();
        Assert.assertEquals(expectedOut, checkout);
        driver.quit();
    }

    @Dado("que o usuario esta na pagina de checkout")
    public void que_o_usuario_esta_na_pagina_de_checkout() {
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

    }

    @Quando("insere suas informações pessoais")
    public void insere_suas_informações_pessoais() {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
    }

    @Quando("clica no botao Continue")
    public void clica_no_botao_continue() {
        driver.findElement(By.id("continue")).click();
    }

    @Então("deve ser direcionado para a pagina Overview")
    public void deve_ser_direcionado_para_a_pagina_overview() {
        finish = driver.getCurrentUrl();
        Assert.assertEquals(urlFinish, finish);
        driver.quit();
    }

    @Dado("que o usuario selecionou o produto")
    public void que_o_usuario_selecionou_o_produto() {
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
    }

    @Dado("inseriu suas informaçoes na pagina de checkut")
    public void inseriu_suas_informaçoes_na_pagina_de_checkut() {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
        driver.findElement(By.id("continue")).click();
    }

    @Quando("clica no botao Finish na pagina Checkout Step Two")
    public void clica_no_botao_finish_na_pagina_checkout_step_two() {
        driver.findElement(By.id("finish")).click();
    }

    @Então("deve ser direcionada para a pagina Complete")
    public void deve_ser_direcionada_para_a_pagina_complete() {
        end = driver.getCurrentUrl();
        Assert.assertEquals(urlEnd, end);
        driver.quit();
    }

    @After
    public void encerra(){
        driver.close();
    }
}

