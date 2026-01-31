package used;

/**
 * Calucater実装クラス<br>
 * 減算を行う
 */
public class SubCalc implements Calculater {
	@Override
	public Integer calc(Integer x, Integer y) {
		return x - y;
	}
}
