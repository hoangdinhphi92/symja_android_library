package org.matheclipse.core.builtin;

import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Factorial;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Times;

import java.util.function.DoubleUnaryOperator;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractTrigArg1;
import org.matheclipse.core.eval.interfaces.INumeric;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.ISignedNumber;
import org.matheclipse.core.interfaces.ISymbol;

public class HypergeometricFunctions {
	static {
		F.CosIntegral.setEvaluator(new CosIntegral());
		F.ExpIntegralEi.setEvaluator(new ExpIntegralEi());
		F.FresnelC.setEvaluator(new FresnelC());
		F.FresnelS.setEvaluator(new FresnelS());
		F.GegenbauerC.setEvaluator(new GegenbauerC());
		F.Hypergeometric1F1.setEvaluator(new Hypergeometric1F1());
		F.Hypergeometric2F1.setEvaluator(new Hypergeometric2F1());
		F.LogIntegral.setEvaluator(new LogIntegral());
		F.SinIntegral.setEvaluator(new SinIntegral());

	}

	private static class CosIntegral extends AbstractTrigArg1 implements INumeric, DoubleUnaryOperator {
		@Override
		public double applyAsDouble(double operand) {
			return de.lab4inf.math.functions.CosineIntegral.ci(operand);
		}

		@Override
		public IExpr e1DblArg(final double arg1) {
			return F.num(de.lab4inf.math.functions.CosineIntegral.ci(arg1));
		}

		@Override
		public double evalReal(final double[] stack, final int top, final int size) {
			if (size != 1) {
				throw new UnsupportedOperationException();
			}
			return de.lab4inf.math.functions.CosineIntegral.ci(stack[top]);
		}

		@Override
		public IExpr evaluateArg1(final IExpr arg1) {
			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
			super.setUp(newSymbol);
		}
	}

	private static class ExpIntegralEi extends AbstractTrigArg1 implements INumeric, DoubleUnaryOperator {

		@Override
		public double applyAsDouble(double operand) {
			if (F.isZero(operand)) {
				return Double.NEGATIVE_INFINITY;
			}
			return de.lab4inf.math.functions.ExponentialIntegalFunction.ei(operand);
		}

		@Override
		public IExpr e1DblArg(final double arg1) {
			if (F.isZero(arg1)) {
				return F.CNInfinity;
			}
			return F.num(de.lab4inf.math.functions.ExponentialIntegalFunction.ei(arg1));
		}

		@Override
		public double evalReal(final double[] stack, final int top, final int size) {
			if (size != 1) {
				throw new UnsupportedOperationException();
			}
			if (F.isZero(stack[top])) {
				return Double.NEGATIVE_INFINITY;
			}
			return de.lab4inf.math.functions.ExponentialIntegalFunction.ei(stack[top]);
		}

		@Override
		public IExpr evaluateArg1(final IExpr arg1) {
			if (arg1.isZero()) {
				return F.CNInfinity;
			}
			if (arg1.isInfinity()) {
				return F.CInfinity;
			}
			if (arg1.isNegativeInfinity()) {
				return F.C0;
			}
			if (arg1.isDirectedInfinity(F.CI)) {
				return F.Times(F.CI, F.Pi);
			}
			if (arg1.isDirectedInfinity(F.CNI)) {
				return F.Times(F.CNI, F.Pi);
			}
			if (arg1.isComplexInfinity()) {
				return F.Indeterminate;
			}
			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
			super.setUp(newSymbol);
		}
	}

	private static class FresnelC extends AbstractTrigArg1 implements INumeric, DoubleUnaryOperator {

		@Override
		public double applyAsDouble(double operand) {
			return de.lab4inf.math.functions.FresnelC.fresnelC(operand);
		}

		@Override
		public IExpr e1DblArg(final double arg1) {
			return F.num(de.lab4inf.math.functions.FresnelC.fresnelC(arg1));
		}

		@Override
		public double evalReal(final double[] stack, final int top, final int size) {
			if (size != 1) {
				throw new UnsupportedOperationException();
			}
			return de.lab4inf.math.functions.FresnelC.fresnelC(stack[top]);
		}

		@Override
		public IExpr evaluateArg1(final IExpr arg1) {
			if (arg1.isNumber()) {
				if (arg1.isZero()) {
					return F.C0;
				}
			}
			if (arg1.isInfinity()) {
				return F.C1D2;
			}
			if (arg1.isNegativeInfinity()) {
				return F.CN1D2;
			}
			if (arg1.equals(F.CIInfinity)) {
				return F.Divide(F.CI, F.C2);
			}
			if (arg1.equals(F.CNIInfinity)) {
				return F.Divide(F.CNI, F.C2);
			}
			if (arg1.equals(F.CComplexInfinity)) {
				return F.Indeterminate;
			}
			IExpr negExpr = AbstractFunctionEvaluator.getNormalizedNegativeExpression(arg1);
			if (negExpr.isPresent()) {
				return F.Negate(F.FresnelC(negExpr));
			}
			IExpr restExpr = AbstractFunctionEvaluator.extractFactorFromExpression(arg1, F.CI);
			if (restExpr.isPresent()) {
				return F.Times(F.CI, F.FresnelC(restExpr));
			}

			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
			super.setUp(newSymbol);
		}
	}

	private static class FresnelS extends AbstractTrigArg1 implements INumeric, DoubleUnaryOperator {

		@Override
		public double applyAsDouble(double operand) {
			return de.lab4inf.math.functions.FresnelS.fresnelS(operand);
		}

		@Override
		public IExpr e1DblArg(final double arg1) {
			return F.num(de.lab4inf.math.functions.FresnelS.fresnelS(arg1));
		}

		@Override
		public double evalReal(final double[] stack, final int top, final int size) {
			if (size != 1) {
				throw new UnsupportedOperationException();
			}
			return de.lab4inf.math.functions.FresnelS.fresnelS(stack[top]);
		}

		@Override
		public IExpr evaluateArg1(final IExpr arg1) {
			if (arg1.isNumber()) {
				if (arg1.isZero()) {
					return F.C0;
				}
			}
			if (arg1.isInfinity()) {
				return F.C1D2;
			}
			if (arg1.isNegativeInfinity()) {
				return F.CN1D2;
			}
			if (arg1.equals(F.CIInfinity)) {
				return F.Divide(F.CNI, F.C2);
			}
			if (arg1.equals(F.CNIInfinity)) {
				return F.Divide(F.CI, F.C2);
			}
			if (arg1.equals(F.CComplexInfinity)) {
				return F.Indeterminate;
			}
			IExpr negExpr = AbstractFunctionEvaluator.getNormalizedNegativeExpression(arg1);
			if (negExpr.isPresent()) {
				return F.Negate(F.FresnelS(negExpr));
			}
			IExpr restExpr = AbstractFunctionEvaluator.extractFactorFromExpression(arg1, F.CI);
			if (restExpr.isPresent()) {
				return F.Times(F.CNI, F.FresnelS(restExpr));
			}

			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
			super.setUp(newSymbol);
		}
	}

	private final static class GegenbauerC extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			Validate.checkSize(ast, 3);
			IExpr n = ast.arg1();
			IExpr z = ast.arg2();

			int nInt = n.toIntDefault(Integer.MIN_VALUE);
			if (nInt > Integer.MIN_VALUE) {
				if (nInt == 0) {
					return F.CComplexInfinity;
				}
				if (nInt == 1) {
					// 2*z
					return F.Times(F.C2, z);
				}
				if (nInt == 2) {
					// 2*z^2 - 1
					return F.Plus(F.CN1, F.Times(F.C2, F.Sqr(z)));
				}
				if (nInt > 2) {
					// (2^n/n)*z^n + Sum(((-1)^k*(n - k - 1)!*(2*z)^(n - 2*k))/(k! * (n -
					// 2*k)!), {k, 1, Floor(n/2)})
					int floorND2 = nInt / 2;
					return Plus(Times(Power(C2, n), Power(n, -1), Power(z, n)),
							F.sum(k -> Times(Power(CN1, k), Power(Times(C2, z), Plus(Times(F.CN2, k), n)),
									Power(Times(Factorial(k), Factorial(Plus(Times(F.CN2, k), n))), -1),
									Factorial(Plus(CN1, Negate(k), n))), 1, floorND2));
				}
			}

			int zInt = z.toIntDefault(Integer.MIN_VALUE);
			if (zInt > Integer.MIN_VALUE) {
				if (zInt == 0) {
					// 2 * (1/v) * Cos(1/2*Pi*v)
					return F.Times(F.C2, F.pow(n, F.CN1), F.Cos(F.Times(C1D2, F.Pi, n)));
				}
				if (zInt == 1) {
					// 2 / v
					return F.Divide(F.C2, n);
				}
				if (zInt == -1) {
					// (2/v)*Cos(Pi*v)
					return F.Times(F.C2, F.pow(n, F.CN1), F.Cos(F.Times(F.Pi, n)));
				}
			}

			if (n.equals(F.C1D2)) {
				// 4*Sqrt((1+z)/2)
				return F.Times(F.C4, F.Sqrt(F.Times(F.C1D2, F.Plus(F.C1, z))));
			}
			IExpr negExpr = AbstractFunctionEvaluator.getNormalizedNegativeExpression(n);
			if (negExpr.isPresent()) {
				return F.GegenbauerC(negExpr, z).negate();
			}
			if (n.isInteger() && n.isPositive()) {
				negExpr = AbstractFunctionEvaluator.getNormalizedNegativeExpression(z);
				if (negExpr.isPresent()) {
					return F.Times(F.Power(F.CN1, n), F.GegenbauerC(n, negExpr));
				}
			}
			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
			super.setUp(newSymbol);
		}
	}

	private static class Hypergeometric1F1 extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) {
			Validate.checkSize(ast, 4);

			IExpr a = ast.arg1();
			if (a.isZero()) {
				return F.C1;
			}
			IExpr b = ast.arg2();
			if (b.isZero()) {
				return F.CComplexInfinity;
			}
			IExpr z = ast.arg3();
			if (z.isZero()) {
				return F.C1;
			}

			if (b.isOne()) {
				// LaguerreL(-a, z)
				return F.LaguerreL(a.negate(), z);
			}

			if (a.isSignedNumber() && b.isSignedNumber()) {
				ISignedNumber n = (ISignedNumber) a;
				ISignedNumber m = (ISignedNumber) b;
				if (n.isInteger() && m.isInteger() && n.isNegative() && m.isNegative() && m.isGreaterThan(n)) {
					return F.CComplexInfinity;
				}
				if (z.isSignedNumber()) {
					double aDouble = n.doubleValue();
					double bDoube = m.doubleValue();
					double zDouble = ((ISignedNumber) z).doubleValue();
					try {
						return F.num(de.lab4inf.math.functions.KummerFunction.kummer(aDouble, bDoube, zDouble));
					} catch (RuntimeException rex) {
						engine.printMessage("Hypergeometric1F1: " + rex.getMessage());
					}
				}
			}
			if (a.equals(b)) {
				// E^z
				return F.Power(F.E, z);
			}
			if (a.isOne()) {
				// (-1 + b)*E^z*z^(1 - b)*(Gamma(-1 + b) - Gamma(-1 + b, z))
				return F.Times(F.Plus(F.CN1, b), F.Power(F.E, z), F.Power(z, F.Plus(F.C1, F.Negate(b))),
						F.Plus(F.Gamma(F.Plus(F.CN1, b)), F.Negate(F.Gamma(F.Plus(F.CN1, b), z))));
			}
			if (a.isMinusOne()) {
				// 1 - z/b
				return F.Subtract(F.C1, F.Divide(z, b));
			}
			if (a.isNumEqualInteger(F.C2)) {
				// (-1 + b)*(1 + (2 - b)*E^z*z^(1 - b)* (Gamma(-1 + b) - Gamma(-1 + b, z)) + E^z*z^(2 - b)*(Gamma(-1 +
				// b] - Gamma(-1 + b, z)))
				return F.Times(F.Plus(F.CN1, b), F.Plus(F.C1,
						F.Times(F.Plus(F.C2, F.Negate(b)), F.Power(F.E, z), F.Power(z, F.Plus(F.C1, F.Negate(b))),
								F.Plus(F.Gamma(F.Plus(F.CN1, b)), F.Negate(F.Gamma(F.Plus(F.CN1, b), z)))),
						F.Times(F.Power(F.E, z), F.Power(z, F.Plus(F.C2, F.Negate(b))),
								F.Plus(F.Gamma(F.Plus(F.CN1, b)), F.Negate(F.Gamma(F.Plus(F.CN1, b), z))))));
			}
			if (a.isNumEqualInteger(F.CN2)) {
				// 1 - (2*z)/b + z^2/(b*(1 + b))
				return F.Plus(F.C1, F.Times(F.CN2, F.Power(b, -1), z),
						F.Times(F.Power(b, -1), F.Power(F.Plus(F.C1, b), -1), F.Sqr(z)));
			}
			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
		}
	}

	private static class Hypergeometric2F1 extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) {
			Validate.checkSize(ast, 5);

			IExpr a = ast.arg1();
			IExpr b = ast.arg2();
			IExpr c = ast.arg3();
			IExpr z = ast.arg4();
			if (z.isZero()) {
				return F.C1;
			}
			if (a.isInteger() && a.isNegative() && z.isOne()) {
				IInteger n = (IInteger) a.negate();
				// Pochhammer(c-b, n) / Pochhammer(c, n)
				return F.Divide(F.Expand(F.Pochhammer(F.Subtract(c, b), n)), F.Pochhammer(c, n));
			}
			if (a.isSignedNumber() && b.isSignedNumber() && c.isSignedNumber() && z.isSignedNumber()) {
				double aDouble = ((ISignedNumber) a).doubleValue();
				double bDouble = ((ISignedNumber) b).doubleValue();
				double cDouble = ((ISignedNumber) c).doubleValue();
				double zDouble = ((ISignedNumber) z).doubleValue();
				try {
					return F.num(de.lab4inf.math.functions.HypergeometricGaussSeries.gaussSeries(aDouble, bDouble,
							cDouble, zDouble));
				} catch (RuntimeException rex) {
					engine.printMessage("Hypergeometric2F1: " + rex.getMessage());
				}
			}
			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
			super.setUp(newSymbol);
		}
	}

	private static class LogIntegral extends AbstractTrigArg1 implements INumeric, DoubleUnaryOperator {

		@Override
		public double applyAsDouble(double operand) {
			if (F.isZero(operand)) {
				return 0.0;
			}
			if (F.isEqual(operand, 1.0)) {
				return Double.NEGATIVE_INFINITY;
			}
			return de.lab4inf.math.functions.LogarithmicIntegalFunction.li(operand);
		}

		@Override
		public IExpr e1DblArg(final double arg1) {
			if (F.isZero(arg1)) {
				return F.C0;
			}
			if (F.isEqual(arg1, 1.0)) {
				return F.CNInfinity;
			}
			return F.num(de.lab4inf.math.functions.LogarithmicIntegalFunction.li(arg1));
		}

		@Override
		public double evalReal(final double[] stack, final int top, final int size) {
			if (size != 1) {
				throw new UnsupportedOperationException();
			}
			return applyAsDouble(stack[top]);
		}

		@Override
		public IExpr evaluateArg1(final IExpr arg1) {
			if (arg1.isZero()) {
				return F.C0;
			}
			if (arg1.isOne()) {
				return F.CNInfinity;
			}
			if (arg1.isInfinity()) {
				return F.CInfinity;
			}
			if (arg1.isComplexInfinity()) {
				return F.CComplexInfinity;
			}
			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
			super.setUp(newSymbol);
		}
	}

	private static class SinIntegral extends AbstractTrigArg1 implements INumeric, DoubleUnaryOperator {

		@Override
		public double applyAsDouble(double operand) {
			return de.lab4inf.math.functions.SineIntegral.si(operand);
		}

		@Override
		public IExpr e1DblArg(final double arg1) {
			return F.num(de.lab4inf.math.functions.SineIntegral.si(arg1));
		}

		@Override
		public double evalReal(final double[] stack, final int top, final int size) {
			if (size != 1) {
				throw new UnsupportedOperationException();
			}
			return de.lab4inf.math.functions.SineIntegral.si(stack[top]);
		}

		@Override
		public IExpr evaluateArg1(final IExpr arg1) {
			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
			super.setUp(newSymbol);
		}
	}

	private final static HypergeometricFunctions CONST = new HypergeometricFunctions();

	public static HypergeometricFunctions initialize() {
		return CONST;
	}

	private HypergeometricFunctions() {

	}

}
