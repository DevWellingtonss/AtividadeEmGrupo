package service;

import model.Carro;

public class CarroServiceImpl implements CarroService {

    @Override
    public void acelerar(Carro carro) {
        if(carro.isLigado()) {
            carro.setVelocidadeAtual((int) (carro.getVelocidadeAtual() + (carro.getCavalos() * 0.1)));
        }
    }

    @Override
    public void frear(Carro carro) {
        carro.setVelocidadeAtual((int) (carro.getVelocidadeAtual() - (carro.getCavalos()*0.15)));
        if(carro.getVelocidadeAtual() <= 0) {
            carro.setVelocidadeAtual(0);
        }
    }

    @Override
    public void ligar(Carro carro) {
        carro.setLigado(true);
    }

    @Override
    public void desligar(Carro carro) {
        carro.setLigado(false);
    }

    @Override
    public String estadoAtual(Carro carro) {
        return "O carro está ligado: " +
                carro.isLigado() +
                " e a velocidade atual é: " +
                carro.getVelocidadeAtual();
    }
}
