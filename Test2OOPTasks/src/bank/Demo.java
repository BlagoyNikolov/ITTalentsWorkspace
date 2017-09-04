package bank;

import java.util.ArrayList;
import java.util.Random;

public class Demo {
	public static void main(String[] args) {
		Bank bank = new Bank("Talents", "Infinity Tower");

		Deposit shortDeposit = new Deposit("Short Deposit", 0.03, 3);
		Deposit longDeposit = new Deposit("Long Deposit", 0.05, 12);
		Credit homeCredit = new Credit("Home Credit", 0.06);
		Credit consumerCredit = new Credit("Consumer Credit", 1.0);

		bank.addDepositToProducts(shortDeposit);
		bank.addDepositToProducts(longDeposit);
		bank.addCreditToProducts(homeCredit);
		bank.addCreditToProducts(consumerCredit);

		ArrayList<Client> clients = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			clients.add(new Client("Client" + i, 1000 * new Random().nextDouble() + 1000, 1000 * new Random().nextDouble() + 700, bank));
		}

		for (Client client : clients) {
			Deposit d = bank.getRandomDeposit().clone();
			double value = ((new Random().nextInt(20) + 80) / (double) 100) * client.getSalary();
			d.setValue(value);
			d.setMonthlyFee(value / d.getPeriod());
			if (client.openDeposit(d)) {
				bank.addToReserve(d.getValue());
				bank.addToRegister(client, d);
			}
		}

		bank.addInterestToDeposits();
		bank.printBalanceAndReserve();
		bank.printRegister();
	}
}
