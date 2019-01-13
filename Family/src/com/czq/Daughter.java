package com.czq;

import java.util.Random;

public class Daughter extends Thread {
	@Override
	public void run() {
		try {
			while (true) {
				Fruit.DauChangenum++;
				Fruit.DauChangenum = Fruit.DauChangenum % 8;
				if (Fruit.DauChangenum < 4) {
					Fruit.Dauflag = 1;
					Fruit.haveAppleSemaphore.acquire();
					Fruit.GetputmutexSemaphore.acquire();
					Fruit.apple--;
					if (Fruit.flag[0] == 1) {
						Fruit.label[0].setBounds(100, 550, 50, 50);
						Fruit.container.add(Fruit.label[0]);

					} else if (Fruit.flag[1] == 1) {
						Fruit.label[1].setBounds(100, 550, 50, 50);
						Fruit.container.add(Fruit.label[1]);

					}

					Fruit.jTextArea.append("女儿吃了一个苹果.\t" + "盘子中有苹果" + Fruit.apple + "盘子中有橘子" + Fruit.orange + "\n");
					Fruit.container.add(Fruit.jScrollPane);
					Fruit.container.setVisible(false);
					Fruit.container.setVisible(true);

					System.out.println("女儿吃了一个苹果.\t\t" + "盘子中有苹果" + Fruit.apple + "盘子中有橘子" + Fruit.orange);
					sleep(new Random().nextInt(1000) % 201 + 800);
					// sleep(500);
					if (Fruit.flag[0] == 1) {
						Fruit.flag[0] = 0;
						Fruit.container.remove(Fruit.label[0]);
					} else if (Fruit.flag[1] == 1) {
						Fruit.flag[1] = 0;
						Fruit.container.remove(Fruit.label[1]);
					}
					Fruit.container.setVisible(false);
					Fruit.container.setVisible(true);
					// sleep(new Random().nextInt(1000));


					Fruit.FruitNumSemapore.release();
					Fruit.GetputmutexSemaphore.release();
					
					if (Fruit.DauChangenum == 3) {
						Fruit.jTextArea.append("女儿吃了四个 苹果啦!她想吃橘子.\n");
						Fruit.container.add(Fruit.jScrollPane);
						Fruit.container.setVisible(false);
						Fruit.container.setVisible(true);
						System.out.println("女儿吃了四个 苹果啦!她想吃橘子.");
						Fruit.Dauflag = 0;
					}

				} else {
					Fruit.Dauflag = 0;
					Fruit.haveOrangeSemaphore.acquire();
					Fruit.GetputmutexSemaphore.acquire();
					Fruit.orange--;
					if (Fruit.flag[2] == 1) {
						Fruit.label[2].setBounds(100, 550, 50, 50);
						Fruit.container.add(Fruit.label[2]);

					} else if (Fruit.flag[3] == 1) {
						Fruit.label[3].setBounds(100, 550, 50, 50);
						Fruit.container.add(Fruit.label[3]);

					}
					Fruit.jTextArea.append("女儿吃了一个橘子.\t" + "盘子中有苹果" + Fruit.apple + "盘子中有橘子" + Fruit.orange + "\n");
					Fruit.container.add(Fruit.jScrollPane);
					Fruit.container.setVisible(false);
					Fruit.container.setVisible(true);

					System.out.println("女儿吃了一个橘子.\t\t" + "盘子中有苹果" + Fruit.apple + "盘子中有橘子" + Fruit.orange);
					sleep(new Random().nextInt(1000) % 201 + 800);
					// sleep(500);
					if (Fruit.flag[2] == 1) {
						Fruit.flag[2] = 0;
						Fruit.container.remove(Fruit.label[2]);
					} else if (Fruit.flag[3] == 1) {
						Fruit.flag[3] = 0;
						Fruit.container.remove(Fruit.label[3]);
					}
					Fruit.container.setVisible(false);
					Fruit.container.setVisible(true);
					
					
					Fruit.FruitNumSemapore.release();
					Fruit.GetputmutexSemaphore.release();
					
					if (Fruit.DauChangenum == 7) {
						Fruit.jTextArea.append("女儿吃了四个橘子啦!她想吃苹果.\n");
						Fruit.container.add(Fruit.jScrollPane);
						Fruit.container.setVisible(false);
						Fruit.container.setVisible(true);
						System.out.println("女儿吃了四个橘子啦!她想吃苹果.");
						Fruit.Dauflag=1;
					}

				}

			}
		} catch (InterruptedException e) {

		}
	}

}
