package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class CarroServiceTest {
    @Test
    public void testeVelocidadeNaoPodeSerNegativa() {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta",100);

        // When
        carroService.acelerar(carro1);
        carroService.frear(carro1);
        carroService.frear(carro1);

        // Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 0);
    }

    @Test
    public void testeDeveAcelerarCorretamente() {
        CarroService carroService = new CarroServiceImpl();

        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta",100);
        Carro carro2 =
                new Carro("prata", "GM", "2012", "Celta",100);
        Carro carro3 =
                 null;
        
        carroService.ligar(carro1);
        carroService.acelerar(carro1);

        carroService.ligar(carro2);
        carroService.acelerar(carro2);

        Assert.assertTrue(carro1.isLigado());

        Assert.assertFalse(carro1.getVelocidadeAtual()==15);

        Assert.assertEquals(10,carro1.getVelocidadeAtual());

        Assert.assertEquals(carro1,carro2);

        Assert.assertNotEquals(30,carro1.getVelocidadeAtual());

        Assert.assertSame(carro1.getVelocidadeAtual(),carro2.getVelocidadeAtual());

        Assert.assertSame(carro1,carro1);

        Assert.assertNull(carro3);

        Assert.assertThat(carro1.getVelocidadeAtual(), is(equalTo(10)));

        Assert.assertThat(carro1.getVelocidadeAtual(), is(not(20)));

    }

    @Test
    public void testeNaoDeveAcelerarDesligado() {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta",100);

        // When
        carroService.acelerar(carro1);

        // Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 0);
    }
}
