package src;

import java.util.Random;

/*技について
 *「殴る」は基礎攻撃力が高いが急所率は低い
 *「踏みつぶす」は基礎攻撃力が低いが急所率は高い
 * 
 */

public class Player {
	String name;
	final int MAXHP;
	int hp;
	int spd;
	int pow;
	
	public Player(String name,final int MAXHP,int hp,int spd,int pow) {
		this.name = name;
		this.MAXHP = MAXHP;
		this.hp = hp;
		this.spd = spd;
		this.pow = pow;
	}
	
	public static int naguru(Player p) {
		String[] mess = {"ゴッ！","ドゴッ！","ボキッ！"};
		int RandomMessage;
		int tecDamage = 1;
		int criticalJudge;
		int criticalDamage = 1;
		
		Random ran = new Random();
		
		System.out.println("\n\n\n\n「" + p.name + "」の「殴る」！");
		
		/*  1/5の確率でクリティカル  */
		criticalJudge = ran.nextInt(4);
		if(criticalJudge == 4) {
			criticalDamage = 2;
			System.out.println("クリティカル！！");
		}
		
		/*  乱数によって表示するメッセージを変える  */
		RandomMessage = ran.nextInt(3);
		System.out.println(mess[RandomMessage]);
		
		System.out.println(Main.CYAN + (tecDamage + p.pow) * criticalDamage + "ダメージ！" + Main.COLOREND);
		
		return (tecDamage + p.pow) * criticalDamage;
	}
	
	public static int fumu(Player p) {
		String[] mess = {"ドスッ！","ドゴンッ！","グシャッ！"};
		int RandomMessage;
		int tecDamage = 2;
		int criticalJudge;
		int criticalDamage = 1;
		
		Random ran = new Random();
		
		System.out.println("\n\n\n\n「" + p.name + "」の「殴る」！");
		
		/*  1/5の確率でクリティカル  */
		criticalJudge = ran.nextInt(5);
		if(criticalJudge == 4) {
			criticalDamage = 2;
			System.out.println(Main.CYAN + "クリティカルヒット！" + Main.COLOREND);
		}
		
		/*  乱数によって表示するメッセージを変える  */
		RandomMessage = ran.nextInt(3);
		System.out.println(mess[RandomMessage]);
		
		return (tecDamage + p.pow) * criticalDamage;
	}
}
