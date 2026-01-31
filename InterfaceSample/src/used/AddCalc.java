package used;

/**
 * Calucater実装クラス<br>
 * 加算を行う
 */
public class AddCalc implements Calculater {
	@Override
	public Integer calc(Integer x, Integer y) {
		return x + y;
	}
}
