package src;

import java.util.Random;

public class Enemy {
	String name;
	final int MAXHP;
	int hp;
	int spd;
	int pow;

	public Enemy(String name, final int MAXHP, int hp, int spd, int pow) {
		this.name = name;
		this.MAXHP = MAXHP;
		this.hp = hp;
		this.spd = spd;
		this.pow = pow;
	}

	public static int attack(String name,final int MAXHP,int hp,int pow,int enemyNum) {
		int tempDamage;
		int crtJudge;
		int again;
		int crtDmg = 1;

		Random ran = new Random();

		System.out.println(Main.REDBACK + "「" + name + "」" + "の攻撃！" + Main.COLOREND);

		/* 1/5の確率でクリティカル発生 */
		crtJudge = ran.nextInt(5);

		if (crtJudge == 4) {
			crtDmg = 2;
			System.out.println(Main.CYAN + "クリティカルヒット！" + Main.COLOREND);
		}
		
		tempDamage = pow * crtDmg;

		System.out.println(Main.RED + tempDamage + "ダメージ！" + Main.COLOREND);

		again = ran.nextInt(2);

		switch (enemyNum) {
		case 2, 3:
			if (again == 1) {
				System.out.println(Main.RED + "「" + name + "」" + "の2回攻撃！" + Main.COLOREND);
				
				crtJudge = ran.nextInt(5);

				if (crtJudge == 4) {
					crtDmg = 2;
					System.out.println(Main.CYAN + "クリティカルヒット！" + Main.COLOREND);
				}
				
				tempDamage = pow * crtDmg;

				System.out.println(Main.RED + tempDamage + "ダメージ！" + Main.COLOREND);
			}
			break;
		default:
			break;
		}
		
		return tempDamage;
	}

}