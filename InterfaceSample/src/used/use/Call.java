package used.use;

import used.Calculater;
import used.SubCalc;

/**
 * インターフェース依存を確認するためのクラス
 */
public class Call {
	public static void main(String[] args) {
		// 加算クラスをインスタンス化
		Calculater calc = new SubCalc();
		// メソッドを実行
		Integer result = calc.calc(10, 5);
		// 結果を表示
		System.out.println("計算結果は「" + result + "」です。");
	}
}
