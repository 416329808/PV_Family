package com.czq;

import java.util.Random;

public class Farther extends Thread {
	@Override
	public void run() {
		try {
			while (true) {

				if (Fruit.apple == 1 && Fruit.Sonflag == 0 && Fruit.Dauflag == 0) {
					try {
						wait();
					} catch (Exception e) {
					} 

				} else {
					Fruit.FruitNumSemapore.acquire();
					Fruit.GetputmutexSemaphore.acquire();
					if (Fruit.flag[0] == 1) {
						Fruit.label[1].setBounds(750, 600, 50, 50);
						Fruit.container.add(Fruit.label[1]);
						Fruit.container.setVisible(false);
						Fruit.container.setVisible(true);

					} else if (Fruit.flag[1] == 1 || Fruit.apple == 0) {
						Fruit.label[0].setBounds(750, 600, 50, 50);
						Fruit.container.add(Fruit.label[0]);
						Fruit.container.setVisible(false);
						Fruit.container.setVisible(true);
					}


					// sleep(500);
					Fruit.apple++;
					sleep(new Random().nextInt(1000) % 201 + 800);
					
					Fruit.label[0].setBounds(400, 250, 50, 50);
					Fruit.container.add(Fruit.label[0]);
					Fruit.flag[0] = 1;
					if (Fruit.apple == 2) {
						Fruit.label[1].setBounds(450, 250, 50, 50);
						Fruit.container.add(Fruit.label[1]);
						Fruit.flag[1] = 1;
					}
					Fruit.jTextArea
							.append("父亲往盘子里放入了一个苹果.\t" + "盘子中有苹果" + Fruit.apple + "盘子中有橘子" + Fruit.orange + "\n");
					Fruit.container.add(Fruit.jScrollPane);
					Fruit.container.setVisible(false);
					Fruit.container.setVisible(true);
					System.out.println("父亲往盘子里放入了一个苹果.\t" + "盘子中有苹果" + Fruit.apple + "盘子中有橘子" + Fruit.orange);
					// sleep(500);
					sleep(new Random().nextInt(1000) % 201 + 800);

					Fruit.GetputmutexSemaphore.release();
					Fruit.haveAppleSemaphore.release();
				}

			}
		} catch (InterruptedException e) {

		} 
	}

}
