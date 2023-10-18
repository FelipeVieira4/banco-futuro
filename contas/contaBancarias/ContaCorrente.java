package contas.contaBancarias;

import java.util.ArrayList;
import java.util.Calendar;

import tipos.Transacao;

public class ContaCorrente extends ContaBancaria{
  private ArrayList<Transacao> listaTransacoes = new ArrayList<Transacao>();

  public void depositar(double valor) {
    this.saldo += valor;


    Calendar data = Calendar.getInstance();  

    Transacao transacao = new Transacao("Depósito",(float)valor, data);
    listaTransacoes.add(transacao);
  }

  public Boolean sacar(double valor) {

      if (valor <= saldo) {
          this.saldo -= valor;

          Calendar data = Calendar.getInstance();
          Transacao transacao = new Transacao("Saque", (float)-valor,data);
          listaTransacoes.add(transacao);
          return true;
      } else {
          System.out.println("Saldo insuficiente");
      }
      return false;
  }

  public ArrayList<Transacao> getlistaTransacoes(){
    return this.listaTransacoes;
  }
}