package com.czq;

import java.util.Random;

public class Mother extends Thread {

	@Override
	public void run() {
		try {
			while (true) {
				if (Fruit.orange == 1 && Fruit.Sonflag == 1 && Fruit.Dauflag == 1) {
					try {
						wait();
					} catch (Exception e) {
					}
				} else {
					Fruit.FruitNumSemapore.acquire();
					Fruit.GetputmutexSemaphore.acquire();

					if (Fruit.flag[2] == 1) {
						Fruit.label[3].setBounds(800, 100, 50, 50);
						Fruit.container.add(Fruit.label[3]);
						Fruit.container.setVisible(false);
						Fruit.container.setVisible(true);
					} else if (Fruit.flag[3] == 1 || Fruit.orange == 0) {
						Fruit.label[2].setBounds(800, 100, 50, 50);
						Fruit.container.add(Fruit.label[2]);
						Fruit.container.setVisible(false);
						Fruit.container.setVisible(true);
					}

					// sleep(500);
					Fruit.orange++;
					sleep(new Random().nextInt(1000) % 201 + 800);
					Fruit.label[2].setBounds(500, 250, 50, 50);
					Fruit.container.add(Fruit.label[2]);
					Fruit.flag[2] = 1;
					if (Fruit.orange == 2) {
						Fruit.label[3].setBounds(550, 250, 50, 50);
						Fruit.container.add(Fruit.label[3]);
						Fruit.flag[3] = 1;
					}
					Fruit.jTextArea
							.append("母亲往盘子里放入了一个橘子.\t" + "盘子中有苹果" + Fruit.apple + "盘子中有橘子" + Fruit.orange + "\n");
					Fruit.container.add(Fruit.jScrollPane);
					Fruit.container.setVisible(false);
					Fruit.container.setVisible(true);

					System.out.println("母亲往盘子里放入了一个橘子.\t" + "盘子中有苹果" + Fruit.apple + "盘子中有橘子" + Fruit.orange);

					// sleep(500);
					sleep(new Random().nextInt(1000) % 201 + 800);

					Fruit.GetputmutexSemaphore.release();
					Fruit.haveOrangeSemaphore.release();
				}

			}
		} catch (InterruptedException e) {

		}
	}

}
