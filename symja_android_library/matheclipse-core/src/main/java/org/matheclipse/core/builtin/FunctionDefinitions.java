package org.matheclipse.core.builtin;

import static org.matheclipse.core.expression.F.*;

public final class FunctionDefinitions {
	static {
		Abs.setEvaluator(new org.matheclipse.core.reflection.system.Abs());
		AbsArg.setEvaluator(new org.matheclipse.core.reflection.system.AbsArg());
		ArcCos.setEvaluator(new org.matheclipse.core.reflection.system.ArcCos());
		ArcCosh.setEvaluator(new org.matheclipse.core.reflection.system.ArcCosh());
		ArcCot.setEvaluator(new org.matheclipse.core.reflection.system.ArcCot());
		ArcCoth.setEvaluator(new org.matheclipse.core.reflection.system.ArcCoth());
		ArcCsc.setEvaluator(new org.matheclipse.core.reflection.system.ArcCsc());
		ArcCsch.setEvaluator(new org.matheclipse.core.reflection.system.ArcCsch());
		ArcSec.setEvaluator(new org.matheclipse.core.reflection.system.ArcSec());
		ArcSech.setEvaluator(new org.matheclipse.core.reflection.system.ArcSech());
		ArcSin.setEvaluator(new org.matheclipse.core.reflection.system.ArcSin());
		ArcSinh.setEvaluator(new org.matheclipse.core.reflection.system.ArcSinh());
		ArcTan.setEvaluator(new org.matheclipse.core.reflection.system.ArcTan());
		ArcTanh.setEvaluator(new org.matheclipse.core.reflection.system.ArcTanh());
		Arg.setEvaluator(new org.matheclipse.core.reflection.system.Arg());
		BesselJ.setEvaluator(new org.matheclipse.core.reflection.system.BesselJ());
		CDF.setEvaluator(new org.matheclipse.core.reflection.system.CDF());
		Ceiling.setEvaluator(new org.matheclipse.core.reflection.system.Ceiling());
		CentralMoment.setEvaluator(new org.matheclipse.core.reflection.system.CentralMoment());
		ChebyshevT.setEvaluator(new org.matheclipse.core.reflection.system.ChebyshevT());
		ChebyshevU.setEvaluator(new org.matheclipse.core.reflection.system.ChebyshevU());
		Coefficient.setEvaluator(new org.matheclipse.core.reflection.system.Coefficient());
		CoefficientList.setEvaluator(new org.matheclipse.core.reflection.system.CoefficientList());
		CoefficientRules.setEvaluator(new org.matheclipse.core.reflection.system.CoefficientRules());
		ComplexExpand.setEvaluator(new org.matheclipse.core.reflection.system.ComplexExpand());
		ComposeList.setEvaluator(new org.matheclipse.core.reflection.system.ComposeList());
		Conjugate.setEvaluator(new org.matheclipse.core.reflection.system.Conjugate());
		ContinuedFraction.setEvaluator(new org.matheclipse.core.reflection.system.ContinuedFraction());
		Cos.setEvaluator(new org.matheclipse.core.reflection.system.Cos());
		Cosh.setEvaluator(new org.matheclipse.core.reflection.system.Cosh());
		CosIntegral.setEvaluator(new org.matheclipse.core.reflection.system.CosIntegral());
		Cot.setEvaluator(new org.matheclipse.core.reflection.system.Cot());
		Coth.setEvaluator(new org.matheclipse.core.reflection.system.Coth());
		Csc.setEvaluator(new org.matheclipse.core.reflection.system.Csc());
		Csch.setEvaluator(new org.matheclipse.core.reflection.system.Csch());
		Curl.setEvaluator(new org.matheclipse.core.reflection.system.Curl());
		D.setEvaluator(new org.matheclipse.core.reflection.system.D());
		Default.setEvaluator(new org.matheclipse.core.reflection.system.Default());
		Derivative.setEvaluator(new org.matheclipse.core.reflection.system.Derivative());
		Discriminant.setEvaluator(new org.matheclipse.core.reflection.system.Discriminant());
		Distribute.setEvaluator(new org.matheclipse.core.reflection.system.Distribute());
		Divergence.setEvaluator(new org.matheclipse.core.reflection.system.Divergence());
		Dot.setEvaluator(new org.matheclipse.core.reflection.system.Dot());
		DSolve.setEvaluator(new org.matheclipse.core.reflection.system.DSolve());
		EasterSunday.setEvaluator(new org.matheclipse.core.reflection.system.EasterSunday());
		ElementData.setEvaluator(new org.matheclipse.core.reflection.system.ElementData());
		Eliminate.setEvaluator(new org.matheclipse.core.reflection.system.Eliminate());
		EllipticE.setEvaluator(new org.matheclipse.core.reflection.system.EllipticE());
		EllipticPi.setEvaluator(new org.matheclipse.core.reflection.system.EllipticPi());
		Erf.setEvaluator(new org.matheclipse.core.reflection.system.Erf());
		Exp.setEvaluator(new org.matheclipse.core.reflection.system.Exp());
		Export.setEvaluator(new org.matheclipse.core.reflection.system.Export());
		ExtendedGCD.setEvaluator(new org.matheclipse.core.reflection.system.ExtendedGCD());
		FindInstance.setEvaluator(new org.matheclipse.core.reflection.system.FindInstance());
		FindRoot.setEvaluator(new org.matheclipse.core.reflection.system.FindRoot());
		Fit.setEvaluator(new org.matheclipse.core.reflection.system.Fit());
		Floor.setEvaluator(new org.matheclipse.core.reflection.system.Floor());
		FractionalPart.setEvaluator(new org.matheclipse.core.reflection.system.FractionalPart());
		FresnelC.setEvaluator(new org.matheclipse.core.reflection.system.FresnelC());
		FresnelS.setEvaluator(new org.matheclipse.core.reflection.system.FresnelS());
		FrobeniusSolve.setEvaluator(new org.matheclipse.core.reflection.system.FrobeniusSolve());
		FromCharacterCode.setEvaluator(new org.matheclipse.core.reflection.system.FromCharacterCode());
		FromContinuedFraction.setEvaluator(new org.matheclipse.core.reflection.system.FromContinuedFraction());
		FromPolarCoordinates.setEvaluator(new org.matheclipse.core.reflection.system.FromPolarCoordinates());
		Gamma.setEvaluator(new org.matheclipse.core.reflection.system.Gamma());
		GCD.setEvaluator(new org.matheclipse.core.reflection.system.GCD());
		GeometricMean.setEvaluator(new org.matheclipse.core.reflection.system.GeometricMean());
		GroebnerBasis.setEvaluator(new org.matheclipse.core.reflection.system.GroebnerBasis());
		HarmonicNumber.setEvaluator(new org.matheclipse.core.reflection.system.HarmonicNumber());
		Haversine.setEvaluator(new org.matheclipse.core.reflection.system.Haversine());
		HeavisideTheta.setEvaluator(new org.matheclipse.core.reflection.system.HeavisideTheta());
		HermiteH.setEvaluator(new org.matheclipse.core.reflection.system.HermiteH());
		Horner.setEvaluator(new org.matheclipse.core.reflection.system.Horner());
		HornerForm.setEvaluator(new org.matheclipse.core.reflection.system.HornerForm());
		Hypergeometric1F1.setEvaluator(new org.matheclipse.core.reflection.system.Hypergeometric1F1());
		Hypergeometric2F1.setEvaluator(new org.matheclipse.core.reflection.system.Hypergeometric2F1());
		Im.setEvaluator(new org.matheclipse.core.reflection.system.Im());
		Import.setEvaluator(new org.matheclipse.core.reflection.system.Import());
		IntegerExponent.setEvaluator(new org.matheclipse.core.reflection.system.IntegerExponent());
		IntegerPart.setEvaluator(new org.matheclipse.core.reflection.system.IntegerPart());
		InterpolatingFunction.setEvaluator(new org.matheclipse.core.reflection.system.InterpolatingFunction());
		InterpolatingPolynomial.setEvaluator(new org.matheclipse.core.reflection.system.InterpolatingPolynomial());
		Interpolation.setEvaluator(new org.matheclipse.core.reflection.system.Interpolation());
		Interval.setEvaluator(new org.matheclipse.core.reflection.system.Interval()); 
		InverseErf.setEvaluator(new org.matheclipse.core.reflection.system.InverseErf());
		InverseErfc.setEvaluator(new org.matheclipse.core.reflection.system.InverseErfc());
		InverseFunction.setEvaluator(new org.matheclipse.core.reflection.system.InverseFunction());
		InverseHaversine.setEvaluator(new org.matheclipse.core.reflection.system.InverseHaversine());
		JaccardDissimilarity.setEvaluator(new org.matheclipse.core.reflection.system.JaccardDissimilarity());
		LaguerreL.setEvaluator(new org.matheclipse.core.reflection.system.LaguerreL());
		LaplaceTransform.setEvaluator(new org.matheclipse.core.reflection.system.LaplaceTransform());
		LCM.setEvaluator(new org.matheclipse.core.reflection.system.LCM());
		LegendreP.setEvaluator(new org.matheclipse.core.reflection.system.LegendreP());
		LetterQ.setEvaluator(new org.matheclipse.core.reflection.system.LetterQ());
		Limit.setEvaluator(new org.matheclipse.core.reflection.system.Limit());
		LinearProgramming.setEvaluator(new org.matheclipse.core.reflection.system.LinearProgramming());
		Log.setEvaluator(new org.matheclipse.core.reflection.system.Log());
		Log10.setEvaluator(new org.matheclipse.core.reflection.system.Log10());
		Log2.setEvaluator(new org.matheclipse.core.reflection.system.Log2());
		LogisticSigmoid.setEvaluator(new org.matheclipse.core.reflection.system.LogisticSigmoid());
		LowerCaseQ.setEvaluator(new org.matheclipse.core.reflection.system.LowerCaseQ());
		MapAll.setEvaluator(new org.matheclipse.core.reflection.system.MapAll());
		MapAt.setEvaluator(new org.matheclipse.core.reflection.system.MapAt());
		Max.setEvaluator(new org.matheclipse.core.reflection.system.Max());
		Min.setEvaluator(new org.matheclipse.core.reflection.system.Min());
		Mod.setEvaluator(new org.matheclipse.core.reflection.system.Mod());
		MonomialList.setEvaluator(new org.matheclipse.core.reflection.system.MonomialList());
		Names.setEvaluator(new org.matheclipse.core.reflection.system.Names());
		NDSolve.setEvaluator(new org.matheclipse.core.reflection.system.NDSolve());
		Negative.setEvaluator(new org.matheclipse.core.reflection.system.Negative());
		NFourierTransform.setEvaluator(new org.matheclipse.core.reflection.system.NFourierTransform());
		NIntegrate.setEvaluator(new org.matheclipse.core.reflection.system.NIntegrate());
		NMaximize.setEvaluator(new org.matheclipse.core.reflection.system.NMaximize());
		NMinimize.setEvaluator(new org.matheclipse.core.reflection.system.NMinimize());
		NonCommutativeMultiply.setEvaluator(new org.matheclipse.core.reflection.system.NonCommutativeMultiply());
		Normal.setEvaluator(new org.matheclipse.core.reflection.system.Normal());
		NRoots.setEvaluator(new org.matheclipse.core.reflection.system.NRoots());
		NSolve.setEvaluator(new org.matheclipse.core.reflection.system.NSolve());
		Order.setEvaluator(new org.matheclipse.core.reflection.system.Order());
		Out.setEvaluator(new org.matheclipse.core.reflection.system.Out());
		Outer.setEvaluator(new org.matheclipse.core.reflection.system.Outer());
		PDF.setEvaluator(new org.matheclipse.core.reflection.system.PDF());
		Piecewise.setEvaluator(new org.matheclipse.core.reflection.system.Piecewise());
		Plot.setEvaluator(new org.matheclipse.core.reflection.system.Plot());
		Plot3D.setEvaluator(new org.matheclipse.core.reflection.system.Plot3D());
		Pochhammer.setEvaluator(new org.matheclipse.core.reflection.system.Pochhammer());
		PolyGamma.setEvaluator(new org.matheclipse.core.reflection.system.PolyGamma());
		PolyLog.setEvaluator(new org.matheclipse.core.reflection.system.PolyLog());
		PowerMod.setEvaluator(new org.matheclipse.core.reflection.system.PowerMod());
		PrimitiveRoots.setEvaluator(new org.matheclipse.core.reflection.system.PrimitiveRoots());
		Product.setEvaluator(new org.matheclipse.core.reflection.system.Product());
		ProductLog.setEvaluator(new org.matheclipse.core.reflection.system.ProductLog());
		Quotient.setEvaluator(new org.matheclipse.core.reflection.system.Quotient());
		RandomInteger.setEvaluator(new org.matheclipse.core.reflection.system.RandomInteger());
		RandomReal.setEvaluator(new org.matheclipse.core.reflection.system.RandomReal());
		RandomSample.setEvaluator(new org.matheclipse.core.reflection.system.RandomSample());
		Rationalize.setEvaluator(new org.matheclipse.core.reflection.system.Rationalize());
		Re.setEvaluator(new org.matheclipse.core.reflection.system.Re());
		Replace.setEvaluator(new org.matheclipse.core.reflection.system.Replace());
		ReplaceAll.setEvaluator(new org.matheclipse.core.reflection.system.ReplaceAll());
		ReplaceList.setEvaluator(new org.matheclipse.core.reflection.system.ReplaceList());
		ReplaceRepeated.setEvaluator(new org.matheclipse.core.reflection.system.ReplaceRepeated());
		Resultant.setEvaluator(new org.matheclipse.core.reflection.system.Resultant());
		Root.setEvaluator(new org.matheclipse.core.reflection.system.Root());
		RootIntervals.setEvaluator(new org.matheclipse.core.reflection.system.RootIntervals());
		Roots.setEvaluator(new org.matheclipse.core.reflection.system.Roots());
		Round.setEvaluator(new org.matheclipse.core.reflection.system.Round());
		Sec.setEvaluator(new org.matheclipse.core.reflection.system.Sec());
		Sech.setEvaluator(new org.matheclipse.core.reflection.system.Sech());
		Series.setEvaluator(new org.matheclipse.core.reflection.system.Series());
		SeriesData.setEvaluator(new org.matheclipse.core.reflection.system.SeriesData());
		Share.setEvaluator(new org.matheclipse.core.reflection.system.Share());
		Sign.setEvaluator(new org.matheclipse.core.reflection.system.Sign());
		SignCmp.setEvaluator(new org.matheclipse.core.reflection.system.SignCmp());
		Sin.setEvaluator(new org.matheclipse.core.reflection.system.Sin());
		Sinc.setEvaluator(new org.matheclipse.core.reflection.system.Sinc());
		Sinh.setEvaluator(new org.matheclipse.core.reflection.system.Sinh());
		SinIntegral.setEvaluator(new org.matheclipse.core.reflection.system.SinIntegral());
		Solve.setEvaluator(new org.matheclipse.core.reflection.system.Solve());
		StieltjesGamma.setEvaluator(new org.matheclipse.core.reflection.system.StieltjesGamma());
		StringDrop.setEvaluator(new org.matheclipse.core.reflection.system.StringDrop());
		StringJoin.setEvaluator(new org.matheclipse.core.reflection.system.StringJoin());
		StringLength.setEvaluator(new org.matheclipse.core.reflection.system.StringLength());
		StringTake.setEvaluator(new org.matheclipse.core.reflection.system.StringTake());
		StruveH.setEvaluator(new org.matheclipse.core.reflection.system.StruveH());
		StruveL.setEvaluator(new org.matheclipse.core.reflection.system.StruveL());
		Sum.setEvaluator(new org.matheclipse.core.reflection.system.Sum());
		Surd.setEvaluator(new org.matheclipse.core.reflection.system.Surd());
		SyntaxLength.setEvaluator(new org.matheclipse.core.reflection.system.SyntaxLength());
		Tan.setEvaluator(new org.matheclipse.core.reflection.system.Tan());
		Tanh.setEvaluator(new org.matheclipse.core.reflection.system.Tanh());
		Taylor.setEvaluator(new org.matheclipse.core.reflection.system.Taylor());
		ToCharacterCode.setEvaluator(new org.matheclipse.core.reflection.system.ToCharacterCode());
		ToPolarCoordinates.setEvaluator(new org.matheclipse.core.reflection.system.ToPolarCoordinates());
		ToString.setEvaluator(new org.matheclipse.core.reflection.system.ToString());
		ToUnicode.setEvaluator(new org.matheclipse.core.reflection.system.ToUnicode());
		TrigExpand.setEvaluator(new org.matheclipse.core.reflection.system.TrigExpand());
		TrigReduce.setEvaluator(new org.matheclipse.core.reflection.system.TrigReduce());
		TrigToExp.setEvaluator(new org.matheclipse.core.reflection.system.TrigToExp());
		UnitStep.setEvaluator(new org.matheclipse.core.reflection.system.UnitStep());
		
		Zeta.setEvaluator(new org.matheclipse.core.reflection.system.Zeta());
	}

	final static FunctionDefinitions CONST = new FunctionDefinitions();

	public static FunctionDefinitions initialize() {
		return CONST;
	}

	private FunctionDefinitions() {

	}
}
