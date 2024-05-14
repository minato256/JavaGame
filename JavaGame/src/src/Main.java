package src;

import java.util.Scanner;

/*牧場大乱闘
 * 
 * 動物（敵）が襲ってくるので、殺します。
 * 敵とあなたが交互に攻撃を行い、どちらかのHPが0になるまで続けます。
 * 
 * あなたの連勝記録によって出現する敵の種類も変わっていき、
 * 勝ちを重ねるごとに敵は強くなっていきます。
 * 
 * 殺されないよう、頑張ってください。
 * 
 * 
 * 
 * 
 */

public class Main {
	public static final String RED = "\u001b[00;31m";
	public static final String GREEN = "\u001b[00;32m";
	public static final String YELLOW = "\u001b[00;33m";
	public static final String PURPLE = "\u001b[00;34m";
	public static final String PINK = "\u001b[00;35m";
	public static final String CYAN = "\u001b[00;36m";
	public static final String COLOREND = "\u001b[00m";

	public static final String REDBACK = "\u001b[00;41m";
	public static final String GREENBACK = "\u001b[00;42m";
	public static final String YELLOWBACK = "\u001b[00;44m";
	public static final String PURPLEBACK = "\u001b[00;43m";
	public static final String PINKBACK = "\u001b[00;45m";
	public static final String CYANBACK = "\u001b[00;46m";

	public static int selectTec() {
		Scanner sc = new java.util.Scanner(System.in);
		int tecKind;

		System.out.println("どのわざを使う？");
		System.out.println("1 : 殴る	2 : 踏みつぶす");
		tecKind = sc.nextInt();

		return tecKind;
	}

	public static char win(Player p, int winCount) {
		Scanner sc = new java.util.Scanner(System.in);
		char cont = 'y';

		System.out.println("\u001b[00;42m 勝利！ (勝利数：" + winCount + ")\u001b[00m");
		System.out.print("    ▽\n");
		skip();

		if (winCount % 3 != 0) {
			System.out.println("\u001b[00;42m ・HPの全回復まであと" + (3 - (winCount % 3)) + "勝\u001b[00m");
			System.out.print("    ▽\n");
			skip();
		} else {
			System.out.println("\u001b[00;42m" + winCount + "勝達成！ HPを全回復しました！\u001b[00m");
			System.out.print(p.hp + " → ");
			System.out.println(p.MAXHP);
			System.out.print("    ▽\n");
			skip();
		}
		if (winCount % 5 == 0) {
			System.out.println("\u001b[00;41m ！！出現モンスターが切り替わりました！！\u001b[00m");
			System.out.print("    ▽\n");
			skip();
		} else if (winCount == 9) {
			System.out.println("\u001b[00;41m ！！出現`Xスターが切@?:%替わりまし*/??\u001b[00m");
			System.out.print("    ▽\n");
			skip();
		} else {
			System.out.println("\u001b[00;42m ・出現モンスター変更まで残り :" + (5 - (winCount % 5)) + "勝\u001b[00m");
			System.out.print("    ▽\n");
			skip();
		}
		System.out.println("次へすすむ → press〈y〉");
		System.out.println("ゲームを終了する → press〈n〉");
		cont = sc.next().charAt(0);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		return cont;

	}

	public static void lose() {
		System.out.println("敗北...あなたは死にました。");

	}

	public static void showHp(Player p) {
		int i;
		double tempPlayerHp;
		double tempMaxHp = p.hp;
		tempPlayerHp = tempMaxHp / p.MAXHP;
		tempPlayerHp = tempPlayerHp * 33;

		System.out.println(p.name + "\n" + p.hp + " / " + p.MAXHP);

		/* 想定出力
		 * 
		 * "プレイヤー名"
		 * ≪最大体力≫ / ≪現在体力≫
		 * -----------------------------------
		 * |▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮|
		 * -----------------------------------
		 * 
		 */
		for (i = 0; i < 35; i++) {
			System.out.print("-");
			if (i == 34) {
				System.out.println("");
			}
		}
		for (i = 0; i < 33; i++) {
			if (i == 0) {
				System.out.print("|");
			}
			if (i < tempPlayerHp) {
				System.out.print("\u001b[00;44m▮\u001b[00m");
			} else {
				System.out.print("\u001b[00;44m \u001b[00m");
			}
			if (i == 32) {
				System.out.println("|");
			}
		}
		for (i = 0; i < 35; i++) {
			System.out.print("-");
			if (i == 34) {
				System.out.println("\n");
			}
		}
	}

	public static void showHp(String name, final int MAXHP, int hp) {
		int i;
		double tempEnemyHp;
		double tempMaxHp = MAXHP;
		tempEnemyHp = hp / tempMaxHp;
		tempEnemyHp = tempEnemyHp * 33;

		System.out.println(name + "\n" + hp + " / " + MAXHP);

		/* 想定出力
		 * 
		 * "モンスター名"
		 * ≪最大体力≫ / ≪現在体力≫
		 * -----------------------------------
		 * |▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮▮|
		 * -----------------------------------
		 * 
		 */
		for (i = 0; i < 35; i++) {
			System.out.print("-");
			if (i == 34) {
				System.out.println("");
			}
		}
		for (i = 0; i < 33; i++) {
			if (i == 0) {
				System.out.print("|");
			}
			if (i < tempEnemyHp) {
				System.out.print("\u001b[00;41m▮\u001b[00m");
			} else {
				System.out.print("\u001b[00;41m \u001b[00m");
			}
			if (i == 32) {
				System.out.println("|");
			}
		}
		for (i = 0; i < 35; i++) {
			System.out.print("-");
			if (i == 34) {
				System.out.println("\n");
			}
		}
	}

	//ページ送りをするためのメソッド
	public static void skip() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
	}

	public static void main(String[] args) {
		//宣言ゲーム共通情報
		int enemyNumber, spdJudge, i;
		char next = 'y';
		int winCount = 0;
		int turnCount = 0;
		int enemyEncount;
		int damage = 0;
		int tempDamage;
		int tempTecKind;
		spdJudge = -1;
		enemyNumber = 0;
		int res = 'y';
		Scanner sc = new Scanner(System.in);

		String[] text = { "20xx年、アメリカテキサス州",
				"平穏なはずの牧場に、悲劇が降りかかる...",
				".........",

				/* length=2 */
				/* ↓ここからチュートリアル用メッセージ */
				"ヤギが現れました",
				"敵はそれぞれHPをもち、あなたも同じくHPをもちます。",
				"どちらかのHPが0になるまで戦闘は続きます。",
				"では、攻撃してみましょう。",
				"繰り出す技を選びましょう。",
				/* ↑ここまでチュートリアル用 */

				/* length=7 */
				/* ↓ここから隠しボス用メッセージ */
				"素晴らしいです。。",
				"おかげで牧場を守れそうですね。",
				"さて...",
				"頃合いでしょう。",
				"不思議に思いませんでしたか？",
				"私が何者か、",
				"ただのガイドと思っていませんか？",
				"さあ、、始めましょうか。",
				/* length=16 */
				"なんと、、",
				"ただの酪農家になぜこんな力が...？",
				"どうやら今の私ではあなたには勝てないようですね。",
				"体制を立て直すとします。",
				"またどこかで会いましょう。。。"
		};

		String[] you = { "羊は、、よし。",
				"今日も牧場は問題なし！",
				"そろそろ出荷の時期になってきたし、",
				"質のいい牛を選ばないとな。",
				"、、おや？",
				"あれUFOやん",
				"オーマイガー！！！動物が空からァァァァ！！！！！",
				"こ、このままでは私の牧場が狩りつくされる～～～～！！！！",
		};

		//Enemyクラスを配列でインスタンス化
		Enemy[] ene = new Enemy[10];

		ene[0] = new Enemy("温厚なヤギ", 15, 15, 10, 3);
		ene[1] = new Enemy("やましいサル", 17, 17, 7, 4);
		ene[2] = new Enemy("喧嘩好きのオカピ", 24, 24, 13, 6);
		ene[3] = new Enemy("？？？", 35, 35, 20, 9);

		System.out.println("✟牧場ウォーズ✟");
		System.out.print("\n\nEnterを押してはじめる ↓\n\n");
		skip();

		System.out.println("プレイヤーネームを決めましょう。");
		System.out.println("あなたの名前は？");
		String name = sc.nextLine();

		//Playerインスタンスを生成
		//コンストラクタで初期化
		Player p = new Player(name, 50, 50, 13, 6);

		System.out.println("では、始めましょう。。。\n\n");
		System.out.print("\n\nEnterを押してはじめる ↓\n\n");
		skip();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		/**/

		for (i = 0; i < 3; i++) {
			System.out.println(text[i]);
			for (int j = 0; j < 4; j++) {
				System.out.print(" ");
			}
			System.out.print("▽\n");
			skip();
		}

		for (i = 0; i < you.length; i++) {
			if (i == 6) {
				System.out.println("ドドドドドドドドドド！！！！！！！\n");
			}
			System.out.println("「" + name + "」：" + you[i]);
			for (int j = 0; j < 4; j++) {
				System.out.print(" ");
			}
			System.out.print("▽\n");
			skip();
		}

		System.out.println("ここからは戦闘が始まります。");
		System.out.print("    ▽\n");
		skip();
		System.out.println("あなたは牧場を守るため、凶暴な動物を倒さなければなりません。");
		System.out.print("    ▽\n");
		skip();
		System.out.println("戦闘のチュートリアルを聞きますか？");
		skip();
		System.out.println("はい → y	いいえ → n\n");
		char yORn = sc.next().charAt(0);

		//チュートリアルを行う場合
		if (yORn == 'y') {
			System.out.println("\nでは、チュートリアルを開始します。");
			skip();

			//敵情報を温厚なヤギで固定
			enemyNumber = 0;

			System.out.println("\n「" + ene[enemyNumber].name + "」" + "が飛び出してきた！\n");
			System.out.print("    ▽\n");
			skip();
			showHp(ene[enemyNumber].name, ene[enemyNumber].MAXHP, ene[enemyNumber].hp);

			for (i = 3; i < 7; i++) {
				System.out.println(text[i]);
				for (int j = 0; j < 4; j++) {
					System.out.print(" ");
				}
				System.out.print("▽\n");
				skip();
			}

			//チュートリアル用
			do {
				//技選択
				tempTecKind = selectTec();

				//選択された技を発動
				switch (tempTecKind) {
				case 1:
					tempDamage = Player.naguru(p);
					ene[enemyNumber].hp -= tempDamage;
					break;
				case 2:
					tempDamage = Player.fumu(p);
					ene[enemyNumber].hp -= tempDamage;
					break;
				}

				if (ene[enemyNumber].hp <= 0) {
					ene[enemyNumber].hp = 0;
				}
				turnCount++;
				showHp(ene[enemyNumber].name, ene[enemyNumber].MAXHP, ene[enemyNumber].hp);
				System.out.print("    ▽\n");
				skip();

				//敵のHPが0の場合
				if (ene[enemyNumber].hp <= 0)
					break;

				//敵の攻撃をtempDamageに一時保存
				tempDamage = Enemy.attack(ene[enemyNumber].name, ene[enemyNumber].MAXHP, ene[enemyNumber].hp,
						ene[enemyNumber].pow, enemyNumber);
				p.hp -= tempDamage;

				showHp(p);
				turnCount++;
				System.out.print("    ▽\n");
				skip();

				if (turnCount == 2) {
					System.out.println("敵からの攻撃を受けました。");
					System.out.print("    ▽\n");
					skip();
					System.out.println("敵にもそれぞれ、HPや素早さなどのステータスを持っています。");
					System.out.print("    ▽\n");
					skip();
					System.out.println("連勝が重なると、強敵にも遭遇するかもしれません。");
					System.out.print("    ▽\n");
					skip();
					System.out.println("では、敵を倒してみましょう。");
					System.out.print("    ▽\n");
					skip();
				}

			} while (next == 'y');

			System.out.println("お見事です。");
			System.out.print("    ▽\n");
			skip();
			System.out.println("敵を倒しましたね。");
			System.out.print("    ▽\n");
			skip();
			System.out.println("これで戦闘に関することは問題ないでしょう。");
			System.out.print("    ▽\n");
			skip();
			System.out.println("では、健闘を祈ります。。。");
			System.out.print("    ▽\n\n\n\n\n\n\n");
			skip();
		} else {
			System.out.println("チュートリアルをスキップしました。");
			System.out.print("    ▽\n");
			skip();
			System.out.println("では、健闘を祈ります。");
			System.out.print("    ▽\n\n\n\n\n\n\n");
			skip();
		}
		//*/

		//戦闘開始
		if (next != 'n') {
			
			

			//勝利数を0で初期化
			winCount = 0;

			//エンカウントするモンスターを2種類で初期化
			enemyEncount = 2;

			//ターンカウントを0で初期化
			turnCount = 0;

			//勝利数が５を超えた場合３種類に変更
			if (winCount >= 5) {
				enemyEncount = 3;
			}

			do {

				//ターン数が０であればエンカウントモンスターを抽選
				if (turnCount == 0) {
					
					//プレイヤーの体力を初期化
					p.hp = p.MAXHP;

					/*--------------エンカウントモンスター決定-----------------*/
					if (winCount < 5) {
						enemyNumber = new java.util.Random().nextInt(enemyEncount);
					} else if (winCount >= 5) {
						enemyNumber = new java.util.Random().nextInt(enemyEncount);
					}

					//エンカウントモンスターのHPを初期化
					ene[enemyNumber].hp = ene[enemyNumber].MAXHP;

					//素早さが同値だった場合、ランダムで先後を決める
					if (ene[enemyNumber].spd == p.spd) {
						spdJudge = new java.util.Random().nextInt(2);
					}

					System.out.println("\n「" + ene[enemyNumber].name + "」" + "が飛び出してきた！\n");
					showHp(ene[enemyNumber].name, ene[enemyNumber].MAXHP, ene[enemyNumber].hp);
				}

				/*----------------------*--------------プレイヤー側が先行-------------------------------------------*/
				if (ene[enemyNumber].spd < p.spd || spdJudge == 0) {

					/* ------------プレイヤー行動---------------------*/

					//技を選択
					res = selectTec();
					switch (res) {
					case 1:
						damage = Player.naguru(p);
						//ダメージを計算
						ene[enemyNumber].hp -= damage;
						break;
					case 2:
						damage = Player.fumu(p);
						//ダメージを計算
						ene[enemyNumber].hp -= damage;
						break;
					}
					
					if (ene[enemyNumber].hp <= 0) {
						ene[enemyNumber].hp = 0;
					}

					turnCount++;
					showHp(ene[enemyNumber].name, ene[enemyNumber].MAXHP, ene[enemyNumber].hp);
					System.out.print("    ▽\n");
					skip();

					//勝敗判定
					if (ene[enemyNumber].hp == 0) {
						winCount++;
						turnCount = 0;

						if (enemyNumber != 3) {
							next = win(p, winCount);
						}

						if (winCount == 9 || next == 'n') {
							break;
						}
					}
					/*------------------------------------------------*/

					/* ------------モンスター行動---------------------*/
					if (ene[enemyNumber].hp > 0) {
						
						/*テスト用
						ene[enemyNumber].pow = 999;
						//*/
						  
						//敵の攻撃をtempDamageに一時保存
						tempDamage = Enemy.attack(ene[enemyNumber].name, ene[enemyNumber].MAXHP,
								ene[enemyNumber].hp, ene[enemyNumber].pow, enemyNumber);
						p.hp -= tempDamage;
						if (p.hp <= 0) {
							p.hp = 0;
						}

						showHp(p);
						turnCount++;
						System.out.print("    ▽\n");
						skip();
						
						if(p.hp == 0) {
							next = 'n';
							lose();
							break;
						}
					}
					/*------------------------------------------------*/
					/*-----------------------------------モンスター側が先行---------------------------------------------*/
				} else if (ene[enemyNumber].spd > p.spd || spdJudge == 1) {

					/* ------------モンスター行動---------------------*/

					//敵の攻撃をtempDamageに一時保存
					tempDamage = Enemy.attack(ene[enemyNumber].name, ene[enemyNumber].MAXHP,
							ene[enemyNumber].hp,
							ene[enemyNumber].pow, enemyNumber);
					p.hp -= tempDamage;
					if (p.hp <= 0) {
						p.hp = 0;
					}

					showHp(p);
					turnCount++;
					System.out.print("    ▽\n");
					skip();

					if(p.hp == 0) {
						next = 'n';
						lose();
						break;
					}
					/*------------------------------------------------*/

					if (p.hp > 0) {
						/* ------------プレイヤー行動---------------------*/
						//技を選択
						res = selectTec();
						switch (res) {
						case 1:
							damage = Player.naguru(p);
							//ダメージを計算
							ene[enemyNumber].hp -= damage;
							break;
						case 2:
							damage = Player.fumu(p);
							//ダメージを計算
							ene[enemyNumber].hp -= damage;
							break;
						}
						
						if (ene[enemyNumber].hp <= 0) {
							ene[enemyNumber].hp = 0;
						}

						turnCount++;
						showHp(ene[enemyNumber].name, ene[enemyNumber].MAXHP, ene[enemyNumber].hp);
						System.out.print("    ▽\n");
						skip();

						//勝敗判定
						if (ene[enemyNumber].hp == 0) {
							winCount++;
							turnCount = 0;

							if (enemyNumber != 3) {
								next = win(p, winCount);
							}

							if (winCount == 9 || next == 'n') {
								break;
							}
						}
						/*------------------------------------------------*/
					}
				}

			} while (next != 'n' || winCount <= 9 || p.hp > 0);
		}

		/*-----------------------------------------xtraBOSS-------------------------------------------------*/
		if (next != 'n') {
			//隠しボスのメッセージ
			for (i = 8; i < 16; i++) {
				if (i > 13) {
					System.out.print("『？？？』：");
				}
				System.out.println(text[i]);
				skip();
			}

			enemyNumber = 3;

			System.out.println("\n「" + ene[enemyNumber].name + "」" + "があらわれた！\n");
			showHp(ene[enemyNumber].name, ene[enemyNumber].MAXHP, ene[enemyNumber].hp);

			do {

				/* ------------モンスター行動---------------------*/
				//敵の攻撃をtempDamageに一時保存
				tempDamage = Enemy.attack(ene[enemyNumber].name, ene[enemyNumber].MAXHP, ene[enemyNumber].hp,
						ene[enemyNumber].pow, enemyNumber);
				p.hp -= tempDamage;
				if (p.hp <= 0) {
					p.hp = 0;
					lose();
				}

				showHp(p);
				turnCount++;
				System.out.print("    ▽\n");
				skip();
				if (p.hp == 0) {
					System.out.println("『？？？』：こんなものですか。");
					System.out.print("    ▽\n");
					skip();
					System.out.println("敗北...");
					System.out.print("    ▽\n");
					skip();
					System.out.println("もう一度挑戦しますか？");
					System.out.println("はい → y	いいえ → n");
					next = sc.next().charAt(0);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					if (next == 'n') {
						break;
					} else {
						p.hp = p.MAXHP;
						ene[enemyNumber].hp = ene[enemyNumber].MAXHP;
						continue;
					}
				}
				/*------------------------------------------------*/

				if (p.hp > 0) {
					/* ------------プレイヤー行動---------------------*/
					//技を選択
					res = selectTec();
					switch (res) {
					case 1:
						damage = Player.naguru(p);
						//ダメージを計算
						ene[enemyNumber].hp -= damage;
						break;
					case 2:
						damage = Player.fumu(p);
						//ダメージを計算
						ene[enemyNumber].hp -= damage;
						break;
					}
					
					if (ene[enemyNumber].hp <= 0) {
						ene[enemyNumber].hp = 0;
					}

					turnCount++;
					showHp(ene[enemyNumber].name, ene[enemyNumber].MAXHP, ene[enemyNumber].hp);
					System.out.print("    ▽\n");
					skip();

					//勝敗判定
					if (ene[enemyNumber].hp == 0) {
						winCount++;
						turnCount = 0;

						if (enemyNumber != 3) {
							res = win(p, winCount);
						}

						if (winCount == 9 || res == 'n') {
							break;
						}
					}
					/*------------------------------------------------*/
				}
			} while (ene[enemyNumber].hp > 0 || p.hp > 0 || next != 'n');

			if (ene[enemyNumber].hp <= 0) {
				System.out.print("   ▽\n");
				skip();
				System.out.print("\n\n\n\n\n\n\n\n\n\n");
				for (i = 17; i < text.length; i++) {
					System.out.print("『？？？』：");
					System.out.println(text[i]);
					skip();
				}
			}

			if (ene[enemyNumber].hp <= 0)
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
						+ "    ■■■■     ■    ■■    ■■  ■■■■■      ■■■■   ■     ■■■■■    ■    ■■■■  \n"
						+ " ■■   ■    ■    ■■    ■■  ■         ■■   ■  ■     ■        ■    ■   ■ \n"
						+ " ■        ■ ■   ■■■  ■ ■  ■         ■       ■     ■       ■ ■   ■   ■ \n"
						+ " ■        ■ ■   ■ ■  ■ ■  ■■■■■     ■       ■     ■■■■■   ■ ■   ■   ■ \n"
						+ " ■   ■■■ ■   ■  ■ ■  ■ ■  ■         ■       ■     ■      ■   ■  ■■■■  \n"
						+ " ■     ■ ■■■■■  ■  ■■  ■  ■         ■       ■     ■      ■■■■■  ■  ■■ \n"
						+ " ■■   ■■ ■   ■  ■  ■■  ■  ■         ■■   ■  ■     ■      ■   ■  ■   ■ \n"
						+ "  ■■■■■ ■     ■ ■      ■  ■■■■■      ■■■■   ■■■■■ ■■■■■ ■     ■ ■    ■"
						+ "\n\n\n\n\n\n\n\n\n\n\n");
		}
		if (winCount <= 9) {
			System.out.println("\n\n\nゲーム終了！");
			System.out.println("最高戦績：" + winCount + "勝");
		}
	}

}
