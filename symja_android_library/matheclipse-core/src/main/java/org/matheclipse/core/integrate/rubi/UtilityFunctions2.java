package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.*;

import org.matheclipse.core.interfaces.IAST;
/** 
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class UtilityFunctions2 { 
  public static IAST RULES = List( 
ISetDelayed(122,MinimumMonomialExponent(u_,x_Symbol),
    Module(List(Set(n,MonomialExponent(First(u),x))),CompoundExpression(Scan(Function(If(PosQ(Plus(n,Negate(MonomialExponent(Slot1,x)))),Set(n,MonomialExponent(Slot1,x)))),u),n))),
ISetDelayed(123,MonomialExponent(Times(a_DEFAULT,Power(x_,n_DEFAULT)),x_Symbol),
    Condition(n,FreeQ(List(a,n),x))),
ISetDelayed(124,LinearMatchQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(LinearMatchQ(Slot1,x)),Throw(False))),u),True)),MatchQ(u,Condition(Plus(a_DEFAULT,Times(b_DEFAULT,x)),FreeQ(List(a,b),x))))),
ISetDelayed(125,PowerOfLinearMatchQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(PowerOfLinearMatchQ(Slot1,x)),Throw(False))),u),True)),MatchQ(u,Condition(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x)),m_DEFAULT),FreeQ(List(a,b,m),x))))),
ISetDelayed(126,QuadraticMatchQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(QuadraticMatchQ(Slot1,x)),Throw(False))),u),True)),Or(MatchQ(u,Condition(Plus(a_DEFAULT,Times(b_DEFAULT,x),Times(c_DEFAULT,Sqr(x))),FreeQ(List(a,b,c),x))),MatchQ(u,Condition(Plus(a_DEFAULT,Times(c_DEFAULT,Sqr(x))),FreeQ(List(a,c),x)))))),
ISetDelayed(127,CubicMatchQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(CubicMatchQ(Slot1,x)),Throw(False))),u),True)),Or(MatchQ(u,Condition(Plus(a_DEFAULT,Times(b_DEFAULT,x),Times(c_DEFAULT,Sqr(x)),Times(d_DEFAULT,Power(x,3))),FreeQ(List(a,b,c,d),x))),MatchQ(u,Condition(Plus(a_DEFAULT,Times(b_DEFAULT,x),Times(d_DEFAULT,Power(x,3))),FreeQ(List(a,b,d),x))),MatchQ(u,Condition(Plus(a_DEFAULT,Times(c_DEFAULT,Sqr(x)),Times(d_DEFAULT,Power(x,3))),FreeQ(List(a,c,d),x))),MatchQ(u,Condition(Plus(a_DEFAULT,Times(d_DEFAULT,Power(x,3))),FreeQ(List(a,d),x)))))),
ISetDelayed(128,BinomialMatchQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(BinomialMatchQ(Slot1,x)),Throw(False))),u),True)),MatchQ(u,Condition(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x,n_DEFAULT))),FreeQ(List(a,b,n),x))))),
ISetDelayed(129,GeneralizedBinomialMatchQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(GeneralizedBinomialMatchQ(Slot1,x)),Throw(False))),u),True)),MatchQ(u,Condition(Plus(Times(a_DEFAULT,Power(x,q_DEFAULT)),Times(b_DEFAULT,Power(x,n_DEFAULT))),FreeQ(List(a,b,n,q),x))))),
ISetDelayed(130,TrinomialMatchQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(TrinomialMatchQ(Slot1,x)),Throw(False))),u),True)),MatchQ(u,Condition(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x,n_DEFAULT)),Times(c_DEFAULT,Power(x,j_DEFAULT))),And(FreeQ(List(a,b,c,n),x),EqQ(Plus(j,Times(CN1,C2,n)),C0)))))),
ISetDelayed(131,GeneralizedTrinomialMatchQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(GeneralizedTrinomialMatchQ(Slot1,x)),Throw(False))),u),True)),MatchQ(u,Condition(Plus(Times(a_DEFAULT,Power(x,q_DEFAULT)),Times(b_DEFAULT,Power(x,n_DEFAULT)),Times(c_DEFAULT,Power(x,r_DEFAULT))),And(FreeQ(List(a,b,c,n,q),x),EqQ(Plus(r,Negate(Plus(Times(C2,n),Negate(q)))),C0)))))),
ISetDelayed(132,QuotientOfLinearsMatchQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(QuotientOfLinearsMatchQ(Slot1,x)),Throw(False))),u),True)),MatchQ(u,Condition(Times(e_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x)),-1)),FreeQ(List(a,b,c,d,e),x))))),
ISetDelayed(133,PolynomialTermQ(u_,x_Symbol),
    Or(FreeQ(u,x),MatchQ(u,Condition(Times(a_DEFAULT,Power(x,n_DEFAULT)),And(FreeQ(a,x),IntegerQ(n),Greater(n,C0)))))),
ISetDelayed(134,PolynomialTerms(u_,x_Symbol),
    Map(Function(If(PolynomialTermQ(Slot1,x),Slot1,C0)),u)),
ISetDelayed(135,NonpolynomialTerms(u_,x_Symbol),
    Map(Function(If(PolynomialTermQ(Slot1,x),C0,Slot1)),u)),
ISetDelayed(136,PseudoBinomialQ(u_,x_Symbol),
    ListQ(PseudoBinomialParts(u,x))),
ISetDelayed(137,PseudoBinomialPairQ(u_,v_,x_Symbol),
    With(List(Set($s("lst1"),PseudoBinomialParts(u,x))),If(AtomQ($s("lst1")),False,With(List(Set($s("lst2"),PseudoBinomialParts(v,x))),If(AtomQ($s("lst2")),False,SameQ(Drop($s("lst1"),C2),Drop($s("lst2"),C2))))))),
ISetDelayed(138,NormalizePseudoBinomial(u_,x_Symbol),
    With(List(Set($s("lst"),PseudoBinomialParts(u,x))),Plus(Part($s("lst"),C1),Times(Part($s("lst"),C2),Power(Plus(Part($s("lst"),C3),Times(Part($s("lst"),C4),x)),Part($s("lst"),C5)))))),
ISetDelayed(139,PseudoBinomialParts(u_,x_Symbol),
    If(And(PolynomialQ(u,x),Greater(Expon(u,x),C2)),Module(List(a,c,d,n),CompoundExpression(Set(n,Expon(u,x)),Set(d,Rt(Coefficient(u,x,n),n)),Set(c,Times(Coefficient(u,x,Plus(n,Negate(C1))),Power(Times(n,Power(d,Plus(n,Negate(C1)))),-1))),Set(a,Simplify(Plus(u,Negate(Power(Plus(c,Times(d,x)),n))))),If(And(NeQ(a,C0),FreeQ(a,x)),List(a,C1,c,d,n),False))),False)),
ISetDelayed(140,PerfectPowerTest(u_,x_Symbol),
    If(PolynomialQ(u,x),Module(List(Set($s("lst"),FactorSquareFreeList(u)),Set($s("§gcd"),C0),Set(v,C1)),CompoundExpression(If(SameQ(Part($s("lst"),C1),List(C1,C1)),Set($s("lst"),Rest($s("lst")))),Scan(Function(Set($s("§gcd"),GCD($s("§gcd"),Part(Slot1,C2)))),$s("lst")),If(Greater($s("§gcd"),C1),CompoundExpression(Scan(Function(Set(v,Times(v,Power(Part(Slot1,C1),Times(Part(Slot1,C2),Power($s("§gcd"),-1)))))),$s("lst")),Power(Expand(v),$s("§gcd"))),False))),False)),
ISetDelayed(141,RationalFunctionQ(u_,x_Symbol),
    If(Or(AtomQ(u),FreeQ(u,x)),True,If(IntegerPowerQ(u),RationalFunctionQ(Part(u,C1),x),If(Or(ProductQ(u),SumQ(u)),Catch(CompoundExpression(Scan(Function(If(Not(RationalFunctionQ(Slot1,x)),Throw(False))),u),True)),False)))),
ISetDelayed(142,RationalFunctionFactors(u_,x_Symbol),
    If(ProductQ(u),Map(Function(If(RationalFunctionQ(Slot1,x),Slot1,C1)),u),If(RationalFunctionQ(u,x),u,C1))),
ISetDelayed(143,NonrationalFunctionFactors(u_,x_Symbol),
    If(ProductQ(u),Map(Function(If(RationalFunctionQ(Slot1,x),C1,Slot1)),u),If(RationalFunctionQ(u,x),C1,u))),
ISetDelayed(144,RationalFunctionExponents(u_,x_Symbol),
    If(PolynomialQ(u,x),List(Exponent(u,x),C0),If(IntegerPowerQ(u),If(Greater(Part(u,C2),C0),Times(Part(u,C2),RationalFunctionExponents(Part(u,C1),x)),Times(CN1,Part(u,C2),Reverse(RationalFunctionExponents(Part(u,C1),x)))),If(ProductQ(u),Plus(RationalFunctionExponents(First(u),x),RationalFunctionExponents(Rest(u),x)),If(SumQ(u),With(List(Set(v,Together(u))),If(SumQ(v),Module(List($s("lst1"),$s("lst2")),CompoundExpression(Set($s("lst1"),RationalFunctionExponents(First(u),x)),Set($s("lst2"),RationalFunctionExponents(Rest(u),x)),List(Max(Plus(Part($s("lst1"),C1),Part($s("lst2"),C2)),Plus(Part($s("lst2"),C1),Part($s("lst1"),C2))),Plus(Part($s("lst1"),C2),Part($s("lst2"),C2))))),RationalFunctionExponents(v,x))),List(C0,C0)))))),
ISetDelayed(145,RationalFunctionExpand(Times(u_,Power(v_,n_)),x_Symbol),
    Condition(With(List(Set(w,RationalFunctionExpand(u,x))),If(SumQ(w),Map(Function(Times(Slot1,Power(v,n))),w),Times(w,Power(v,n)))),And(FractionQ(n),UnsameQ(v,x)))),
ISetDelayed(146,RationalFunctionExpand(u_,x_Symbol),
    Module(List(v,w),CompoundExpression(Set(v,ExpandIntegrand(u,x)),If(And(UnsameQ(v,u),Not(MatchQ(u,Condition(Times(Power(x,m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,x)),p_),Power(Plus(a_,Times(b_DEFAULT,Power(x,n_))),-1)),And(FreeQ(List(a,b,c,d,p),x),IntegersQ(m,n),Equal(m,Plus(n,Negate(C1)))))))),v,CompoundExpression(Set(v,ExpandIntegrand(RationalFunctionFactors(u,x),x)),Set(w,NonrationalFunctionFactors(u,x)),If(SumQ(v),Map(Function(Times(Slot1,w)),v),Times(v,w))))))),
ISetDelayed(147,PolyGCD(u_,v_,x_Symbol),
    NonfreeFactors(PolynomialGCD(u,v),x)),
ISetDelayed(148,AlgebraicFunctionQ(u_,x_Symbol,Optional($p("flag"),False)),
    If(Or(AtomQ(u),FreeQ(u,x)),True,If(And(PowerQ(u),Or(RationalQ(Part(u,C2)),And($s("flag"),FreeQ(Part(u,C2),x)))),AlgebraicFunctionQ(Part(u,C1),x,$s("flag")),If(Or(ProductQ(u),SumQ(u)),Catch(CompoundExpression(Scan(Function(If(Not(AlgebraicFunctionQ(Slot1,x,$s("flag"))),Throw(False))),u),True)),If(ListQ(u),If(SameQ(u,List()),True,If(AlgebraicFunctionQ(First(u),x,$s("flag")),AlgebraicFunctionQ(Rest(u),x,$s("flag")),False)),False))))),
ISetDelayed(149,QuotientOfLinearsQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(QuotientOfLinearsQ(Slot1,x)),Throw(False))),u),True)),And(QuotientOfLinearsP(u,x),$(Function(And(NeQ(Part(Slot1,C2),C0),NeQ(Part(Slot1,C4),C0))),QuotientOfLinearsParts(u,x))))),
ISetDelayed(150,QuotientOfLinearsP(Times(a_,u_),x_),
    Condition(QuotientOfLinearsP(u,x),FreeQ(a,x))),
ISetDelayed(151,QuotientOfLinearsP(Plus(a_,u_),x_),
    Condition(QuotientOfLinearsP(u,x),FreeQ(a,x))),
ISetDelayed(152,QuotientOfLinearsP(Power(u_,-1),x_),
    QuotientOfLinearsP(u,x)),
ISetDelayed(153,QuotientOfLinearsP(u_,x_),
    Condition(True,LinearQ(u,x))),
ISetDelayed(154,QuotientOfLinearsP(Times(u_,Power(v_,-1)),x_),
    Condition(True,And(LinearQ(u,x),LinearQ(v,x)))),
ISetDelayed(155,QuotientOfLinearsP(u_,x_),
    Or(SameQ(u,x),FreeQ(u,x))),
ISetDelayed(156,QuotientOfLinearsParts(Times(a_,u_),x_),
    Condition(Apply(Function(List(Times(a,Slot1),Times(a,Slot2),Slot(C3),Slot(C4))),QuotientOfLinearsParts(u,x)),FreeQ(a,x))),
ISetDelayed(157,QuotientOfLinearsParts(Plus(a_,u_),x_),
    Condition(Apply(Function(List(Plus(Slot1,Times(a,Slot(C3))),Plus(Slot2,Times(a,Slot(C4))),Slot(C3),Slot(C4))),QuotientOfLinearsParts(u,x)),FreeQ(a,x))),
ISetDelayed(158,QuotientOfLinearsParts(Power(u_,-1),x_),
    Apply(Function(List(Slot(C3),Slot(C4),Slot1,Slot2)),QuotientOfLinearsParts(u,x))),
ISetDelayed(159,QuotientOfLinearsParts(u_,x_),
    Condition(List(Coefficient(u,x,C0),Coefficient(u,x,C1),C1,C0),LinearQ(u,x))),
ISetDelayed(160,QuotientOfLinearsParts(Times(u_,Power(v_,-1)),x_),
    Condition(List(Coefficient(u,x,C0),Coefficient(u,x,C1),Coefficient(v,x,C0),Coefficient(v,x,C1)),And(LinearQ(u,x),LinearQ(v,x)))),
ISetDelayed(161,QuotientOfLinearsParts(u_,x_),
    If(SameQ(u,x),List(C0,C1,C1,C0),If(FreeQ(u,x),List(u,C0,C1,C0),CompoundExpression(Print($str("QuotientOfLinearsParts error!")),List(u,C0,C1,C0))))),
ISetDelayed(162,SubstForFractionalPowerOfQuotientOfLinears(u_,x_Symbol),
    Module(List(Set($s("lst"),FractionalPowerOfQuotientOfLinears(u,C1,False,x))),If(Or(AtomQ($s("lst")),AtomQ(Part($s("lst"),C2))),False,With(List(Set(n,Part($s("lst"),C1)),Set($s("tmp"),Part($s("lst"),C2))),CompoundExpression(Set($s("lst"),QuotientOfLinearsParts($s("tmp"),x)),With(List(Set(a,Part($s("lst"),C1)),Set(b,Part($s("lst"),C2)),Set(c,Part($s("lst"),C3)),Set(d,Part($s("lst"),C4))),If(EqQ(d,C0),False,CompoundExpression(Set($s("lst"),Simplify(Times(Power(x,Plus(n,Negate(C1))),SubstForFractionalPower(u,$s("tmp"),n,Times(Plus(Negate(a),Times(c,Power(x,n))),Power(Plus(b,Times(CN1,d,Power(x,n))),-1)),x),Power(Plus(b,Times(CN1,d,Power(x,n))),-2)))),List(NonfreeFactors($s("lst"),x),n,$s("tmp"),Times(FreeFactors($s("lst"),x),Plus(Times(b,c),Times(CN1,a,d)))))))))))),
ISetDelayed(163,SubstForFractionalPowerQ(u_,v_,x_Symbol),
    If(Or(AtomQ(u),FreeQ(u,x)),True,If(FractionalPowerQ(u),SubstForFractionalPowerAuxQ(u,v,x),Catch(CompoundExpression(Scan(Function(If(Not(SubstForFractionalPowerQ(Slot1,v,x)),Throw(False))),u),True))))),
ISetDelayed(164,SubstForFractionalPowerAuxQ(u_,v_,x_),
    If(AtomQ(u),False,If(And(FractionalPowerQ(u),EqQ(Part(u,C1),v)),True,Catch(CompoundExpression(Scan(Function(If(SubstForFractionalPowerAuxQ(Slot1,v,x),Throw(True))),u),False))))),
ISetDelayed(165,FractionalPowerOfQuotientOfLinears(u_,n_,v_,x_),
    If(Or(AtomQ(u),FreeQ(u,x)),List(n,v),If(CalculusQ(u),False,If(And(FractionalPowerQ(u),QuotientOfLinearsQ(Part(u,C1),x),Not(LinearQ(Part(u,C1),x)),Or(FalseQ(v),EqQ(Part(u,C1),v))),List(LCM(Denominator(Part(u,C2)),n),Part(u,C1)),Catch(Module(List(Set($s("lst"),List(n,v))),CompoundExpression(Scan(Function(If(AtomQ(Set($s("lst"),FractionalPowerOfQuotientOfLinears(Slot1,Part($s("lst"),C1),Part($s("lst"),C2),x))),Throw(False))),u),$s("lst")))))))),
ISetDelayed(166,SubstForInverseFunctionOfQuotientOfLinears(u_,x_Symbol),
    With(List(Set($s("tmp"),InverseFunctionOfQuotientOfLinears(u,x))),If(AtomQ($s("tmp")),False,With(List(Set(h,InverseFunction(Head($s("tmp")))),Set($s("lst"),QuotientOfLinearsParts(Part($s("tmp"),C1),x))),With(List(Set(a,Part($s("lst"),C1)),Set(b,Part($s("lst"),C2)),Set(c,Part($s("lst"),C3)),Set(d,Part($s("lst"),C4))),List(Times(SubstForInverseFunction(u,$s("tmp"),Times(Plus(Negate(a),Times(c,$(h,x))),Power(Plus(b,Times(CN1,d,$(h,x))),-1)),x),D($(h,x),x),Power(Plus(b,Times(CN1,d,$(h,x))),-2)),$s("tmp"),Plus(Times(b,c),Times(CN1,a,d)))))))),
ISetDelayed(167,InverseFunctionOfQuotientOfLinears(u_,x_Symbol),
    If(Or(AtomQ(u),CalculusQ(u),FreeQ(u,x)),False,If(And(InverseFunctionQ(u),QuotientOfLinearsQ(Part(u,C1),x)),u,Module(List($s("tmp")),Catch(CompoundExpression(Scan(Function(If(Not(AtomQ(Set($s("tmp"),InverseFunctionOfQuotientOfLinears(Slot1,x)))),Throw($s("tmp")))),u),False)))))),
ISetDelayed(168,SubstForFractionalPower(u_,v_,n_,w_,x_Symbol),
    If(AtomQ(u),If(SameQ(u,x),w,u),If(And(FractionalPowerQ(u),EqQ(Part(u,C1),v)),Power(x,Times(n,Part(u,C2))),Map(Function(SubstForFractionalPower(Slot1,v,n,w,x)),u)))),
ISetDelayed(169,SubstForInverseFunction(u_,v_,x_Symbol),
    SubstForInverseFunction(u,v,Times(Plus(Negate(Coefficient(Part(v,C1),x,C0)),$(InverseFunction(Head(v)),x)),Power(Coefficient(Part(v,C1),x,C1),-1)),x)),
ISetDelayed(170,SubstForInverseFunction(u_,v_,w_,x_Symbol),
    If(AtomQ(u),If(SameQ(u,x),w,u),If(And(SameQ(Head(u),Head(v)),EqQ(Part(u,C1),Part(v,C1))),x,Map(Function(SubstForInverseFunction(Slot1,v,w,x)),u)))),
ISetDelayed(171,AbsurdNumberQ(u_),
    RationalQ(u)),
ISetDelayed(172,AbsurdNumberQ(Power(u_,v_)),
    And(RationalQ(u),Greater(u,C0),FractionQ(v))),
ISetDelayed(173,AbsurdNumberQ(Times(u_,v_)),
    And(AbsurdNumberQ(u),AbsurdNumberQ(v))),
ISetDelayed(174,AbsurdNumberFactors(u_),
    If(AbsurdNumberQ(u),u,If(ProductQ(u),Map($rubi("AbsurdNumberFactors"),u),NumericFactor(u)))),
ISetDelayed(175,NonabsurdNumberFactors(u_),
    If(AbsurdNumberQ(u),C1,If(ProductQ(u),Map($rubi("NonabsurdNumberFactors"),u),NonnumericFactors(u)))),
ISetDelayed(176,FactorAbsurdNumber(m_),
    If(RationalQ(m),FactorInteger(m),If(PowerQ(m),Map(Function(List(Part(Slot1,C1),Times(Part(Slot1,C2),Part(m,C2)))),FactorInteger(Part(m,C1))),CombineExponents(Sort(Flatten(Map($rubi("FactorAbsurdNumber"),Apply(List,m)),C1),Function(Less(Part(Slot1,C1),Part(Slot2,C1)))))))),
ISetDelayed(177,CombineExponents($p("lst")),
    If(Less(Length($s("lst")),C2),$s("lst"),If(Equal(Part($s("lst"),C1,C1),Part($s("lst"),C2,C1)),CombineExponents(Prepend(Drop($s("lst"),C2),List(Part($s("lst"),C1,C1),Plus(Part($s("lst"),C1,C2),Part($s("lst"),C2,C2))))),Prepend(CombineExponents(Rest($s("lst"))),First($s("lst")))))),
ISetDelayed(178,AbsurdNumberGCD($ps("seq")),
    With(List(Set($s("lst"),List($s("seq")))),If(Equal(Length($s("lst")),C1),First($s("lst")),AbsurdNumberGCDList(FactorAbsurdNumber(First($s("lst"))),FactorAbsurdNumber(Apply($rubi("AbsurdNumberGCD"),Rest($s("lst")))))))),
ISetDelayed(179,AbsurdNumberGCDList($p("lst1"),$p("lst2")),
    If(SameQ($s("lst1"),List()),Apply(Times,Map(Function(Power(Part(Slot1,C1),Min(Part(Slot1,C2),C0))),$s("lst2"))),If(SameQ($s("lst2"),List()),Apply(Times,Map(Function(Power(Part(Slot1,C1),Min(Part(Slot1,C2),C0))),$s("lst1"))),If(Equal(Part($s("lst1"),C1,C1),Part($s("lst2"),C1,C1)),If(LessEqual(Part($s("lst1"),C1,C2),Part($s("lst2"),C1,C2)),Times(Power(Part($s("lst1"),C1,C1),Part($s("lst1"),C1,C2)),AbsurdNumberGCDList(Rest($s("lst1")),Rest($s("lst2")))),Times(Power(Part($s("lst1"),C1,C1),Part($s("lst2"),C1,C2)),AbsurdNumberGCDList(Rest($s("lst1")),Rest($s("lst2"))))),If(Less(Part($s("lst1"),C1,C1),Part($s("lst2"),C1,C1)),If(Less(Part($s("lst1"),C1,C2),C0),Times(Power(Part($s("lst1"),C1,C1),Part($s("lst1"),C1,C2)),AbsurdNumberGCDList(Rest($s("lst1")),$s("lst2"))),AbsurdNumberGCDList(Rest($s("lst1")),$s("lst2"))),If(Less(Part($s("lst2"),C1,C2),C0),Times(Power(Part($s("lst2"),C1,C1),Part($s("lst2"),C1,C2)),AbsurdNumberGCDList($s("lst1"),Rest($s("lst2")))),AbsurdNumberGCDList($s("lst1"),Rest($s("lst2"))))))))),
ISetDelayed(180,NormalizeIntegrand(u_,x_Symbol),
    With(List(Set(v,NormalizeLeadTermSigns(NormalizeIntegrandAux(u,x)))),If(SameQ(v,NormalizeLeadTermSigns(u)),u,v))),
ISetDelayed(181,NormalizeIntegrandAux(u_,x_Symbol),
    If(SumQ(u),Map(Function(NormalizeIntegrandAux(Slot1,x)),u),If(ProductQ(MergeMonomials(u,x)),Map(Function(NormalizeIntegrandFactor(Slot1,x)),MergeMonomials(u,x)),NormalizeIntegrandFactor(MergeMonomials(u,x),x)))),
ISetDelayed(182,NormalizeIntegrandFactor(u_,x_Symbol),
    Module(List($s("bas"),$s("deg"),$s("§min")),If(And(PowerQ(u),FreeQ(Part(u,C2),x)),CompoundExpression(Set($s("bas"),NormalizeIntegrandFactorBase(Part(u,C1),x)),Set($s("deg"),Part(u,C2)),If(And(IntegerQ($s("deg")),SumQ($s("bas")),EveryQ(Function(MonomialQ(Slot1,x)),$s("bas"))),CompoundExpression(Set($s("§min"),MinimumMonomialExponent($s("bas"),x)),Times(Power(x,Times($s("§min"),$s("deg"))),Power(Map(Function(Simplify(Times(Slot1,Power(Power(x,$s("§min")),-1)))),$s("bas")),$s("deg")))),Power($s("bas"),$s("deg")))),If(And(PowerQ(u),FreeQ(Part(u,C1),x)),Power(Part(u,C1),NormalizeIntegrandFactorBase(Part(u,C2),x)),CompoundExpression(Set($s("bas"),NormalizeIntegrandFactorBase(u,x)),If(And(SumQ($s("bas")),EveryQ(Function(MonomialQ(Slot1,x)),$s("bas"))),CompoundExpression(Set($s("§min"),MinimumMonomialExponent($s("bas"),x)),Times(Power(x,$s("§min")),Map(Function(Times(Slot1,Power(Power(x,$s("§min")),-1))),$s("bas")))),$s("bas"))))))),
ISetDelayed(183,NormalizeIntegrandFactorBase(Times(u_,Power(x_,m_DEFAULT)),x_Symbol),
    Condition(NormalizeIntegrandFactorBase(Map(Function(Times(Power(x,m),Slot1)),u),x),And(FreeQ(m,x),SumQ(u)))),
ISetDelayed(184,NormalizeIntegrandFactorBase(u_,x_Symbol),
    If(BinomialQ(u,x),If(BinomialMatchQ(u,x),u,ExpandToSum(u,x)),If(TrinomialQ(u,x),If(TrinomialMatchQ(u,x),u,ExpandToSum(u,x)),If(ProductQ(u),Map(Function(NormalizeIntegrandFactor(Slot1,x)),u),If(And(PolynomialQ(u,x),LessEqual(Exponent(u,x),C4)),ExpandToSum(u,x),If(SumQ(u),With(List(Set(v,TogetherSimplify(u))),If(Or(SumQ(v),MatchQ(v,Condition(Times(Power(x,m_DEFAULT),w_),And(FreeQ(m,x),SumQ(w)))),Greater(LeafCount(v),Plus(LeafCount(u),C2))),UnifySum(u,x),NormalizeIntegrandFactorBase(v,x))),Map(Function(NormalizeIntegrandFactor(Slot1,x)),u))))))),
ISetDelayed(185,NormalizeTogether(u_),
    NormalizeLeadTermSigns(Together(u))),
ISetDelayed(186,NormalizeLeadTermSigns(u_),
    With(List(Set($s("lst"),If(ProductQ(u),Map($rubi("SignOfFactor"),u),SignOfFactor(u)))),If(Equal(Part($s("lst"),C1),C1),Part($s("lst"),C2),AbsorbMinusSign(Part($s("lst"),C2))))),
ISetDelayed(187,AbsorbMinusSign(Times(u_DEFAULT,$p(v,Plus))),
    Times(u,CN1,v)),
ISetDelayed(188,AbsorbMinusSign(Times(u_DEFAULT,Power($p(v,Plus),m_))),
    Condition(Times(u,Power(Negate(v),m)),OddQ(m))),
ISetDelayed(189,AbsorbMinusSign(u_),
    Negate(u)),
ISetDelayed(190,NormalizeSumFactors(u_),
    If(Or(AtomQ(u),StopFunctionQ(u)),u,If(ProductQ(u),$(Function(Times(Part(Slot1,C1),Part(Slot1,C2))),SignOfFactor(Map($rubi("NormalizeSumFactors"),u))),Map($rubi("NormalizeSumFactors"),u)))),
ISetDelayed(191,SignOfFactor(u_),
    If(Or(And(RationalQ(u),Less(u,C0)),And(SumQ(u),Less(NumericFactor(First(u)),C0))),List(CN1,Negate(u)),If(And(IntegerPowerQ(u),SumQ(Part(u,C1)),Less(NumericFactor(First(Part(u,C1))),C0)),List(Power(CN1,Part(u,C2)),Power(Negate(Part(u,C1)),Part(u,C2))),If(ProductQ(u),Map($rubi("SignOfFactor"),u),List(C1,u))))),
ISetDelayed(192,NormalizePowerOfLinear(u_,x_Symbol),
    With(List(Set(v,FactorSquareFree(u))),If(And(PowerQ(v),LinearQ(Part(v,C1),x),FreeQ(Part(v,C2),x)),Power(ExpandToSum(Part(v,C1),x),Part(v,C2)),ExpandToSum(v,x)))),
ISetDelayed(193,MergeMonomials(Times(u_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT)),x_Symbol),
    Condition(Times(u,Power(b,m),Power(Power(d,m),-1),Power(Plus(c,Times(d,x)),Plus(m,n))),And(FreeQ(List(a,b,c,d),x),IntegerQ(m),EqQ(Plus(Times(b,c),Times(CN1,a,d)),C0)))),
ISetDelayed(194,MergeMonomials(Times(u_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Times(c_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),n_DEFAULT)),p_)),x_Symbol),
    Condition(Times(u,Power(Times(c,Power(Plus(a,Times(b,x)),n)),Plus(Times(m,Power(n,-1)),p)),Power(Power(c,Times(m,Power(n,-1))),-1)),And(FreeQ(List(a,b,c,m,n,p),x),IntegerQ(Times(m,Power(n,-1)))))),
ISetDelayed(195,MergeMonomials(Times(a_DEFAULT,Power(u_,m_)),x_Symbol),
    Condition(Times(a,Power(u,Simplify(m))),FreeQ(List(a,m),x))),
ISetDelayed(196,MergeMonomials(u_,x_Symbol),
    If(LinearQ(u,x),Cancel(u),u)),
ISetDelayed(197,SimplifyIntegrand(u_,x_Symbol),
    Module(List(v),CompoundExpression(Set(v,NormalizeLeadTermSigns(NormalizeIntegrandAux(Simplify(u),x))),If(Less(LeafCount(v),Times(QQ(4L,5L),LeafCount(u))),v,If(UnsameQ(v,NormalizeLeadTermSigns(u)),v,u))))),
ISetDelayed(198,SimplifyTerm(u_,x_Symbol),
    Module(List(Set(v,Simplify(u)),w),CompoundExpression(Set(w,Together(v)),NormalizeIntegrand(If(Less(LeafCount(v),LeafCount(w)),w,w),x)))),
ISetDelayed(199,TogetherSimplify(u_),
    TimeConstrained(With(List(Set(v,Together(Simplify(Together(u))))),TimeConstrained(FixSimplify(v),Times(C1D3,$s("§$timelimit")),v)),$s("§$timelimit"),u)),
ISetDelayed(200,SmartSimplify(u_),
    TimeConstrained(Module(List(v,w),CompoundExpression(Set(v,Simplify(u)),Set(w,Factor(v)),Set(v,If(Less(LeafCount(w),LeafCount(v)),w,v)),Set(v,If(And(Not(FalseQ(Set(w,FractionalPowerOfSquareQ(v)))),FractionalPowerSubexpressionQ(u,w,Expand(w))),SubstForExpn(v,w,Expand(w)),v)),Set(v,FactorNumericGcd(v)),TimeConstrained(FixSimplify(v),Times(C1D3,$s("§$timelimit")),v))),$s("§$timelimit"),u)),
ISetDelayed(201,SubstForExpn(u_,v_,w_),
    If(SameQ(u,v),w,If(AtomQ(u),u,Map(Function(SubstForExpn(Slot1,v,w)),u)))),
ISetDelayed(202,Simp(u_,x_),
    TimeConstrained(NormalizeSumFactors(SimpHelp(u,x)),$s("§$timelimit"),u)),
ISetDelayed(203,SimpHelp(Exp(Times(u_DEFAULT,Plus(w_,Times(v_DEFAULT,Log(a_))))),x_),
    Times(Power(a,Times(u,v)),SimpHelp(Exp(Times(u,w)),x))),
ISetDelayed(204,SimpHelp(u_,x_),
    If(Or(AtomQ(u),StopFunctionQ(u)),u,If(FreeQ(u,x),With(List(Set(v,SmartSimplify(u))),If(LessEqual(LeafCount(v),LeafCount(u)),v,u)),If(ProductQ(u),If(And(EqQ(First(u),C1D2),MatchQ(Rest(u),Condition(Plus(a_DEFAULT,Times(n_,Pi),Times(b_DEFAULT,v_)),And(FreeQ(List(a,b),x),Not(FreeQ(v,x)),EqQ(Sqr(n),C1D4))))),If(MatchQ(Rest(u),Condition(Plus(Times(n_,Pi),Times(b_DEFAULT,v_)),And(FreeQ(b,x),Not(FreeQ(v,x)),EqQ(Sqr(n),C1D4)))),Map(Function(Times(C1D2,Slot1)),Rest(u)),If(MatchQ(Rest(u),Condition(Plus(Times(m_,a_DEFAULT),Times(n_,Pi),Times(p_,b_DEFAULT,v_)),And(FreeQ(List(a,b),x),Not(FreeQ(v,x)),IntegersQ(Times(C1D2,m),Times(C1D2,p))))),Map(Function(Times(C1D2,Slot1)),Rest(u)),u)),Module(List(Set(v,FreeFactors(u,x)),Set(w,NonfreeFactors(u,x))),CompoundExpression(Set(v,Times(NumericFactor(v),SmartSimplify(Times(NonnumericFactors(v),Sqr(x))),Power(x,-2))),Set(w,If(ProductQ(w),Map(Function(SimpHelp(Slot1,x)),w),SimpHelp(w,x))),Set(w,FactorNumericGcd(w)),Set(v,MergeFactors(v,w)),If(ProductQ(v),Map(Function(SimpFixFactor(Slot1,x)),v),v)))),If(SumQ(u),If(MatchQ(u,Condition(Plus(a_DEFAULT,Times(n_,Pi),Times(b_DEFAULT,x)),And(FreeQ(List(a,b),x),EqQ(Sqr(n),QQ(1L,16L))))),u,If(And(PolynomialQ(u,x),LessEqual(Exponent(u,x),C0)),SimpHelp(Coefficient(u,x,C0),x),If(And(PolynomialQ(u,x),Equal(Exponent(u,x),C1),SameQ(Coefficient(u,x,C0),C0)),Times(SimpHelp(Coefficient(u,x,C1),x),x),Module(List(Set(v,C0),Set(w,C0)),CompoundExpression(Scan(Function(If(FreeQ(Slot1,x),Set(v,Plus(Slot1,v)),Set(w,Plus(Slot1,w)))),u),Set(v,SmartSimplify(v)),Set(w,If(SumQ(w),Map(Function(SimpHelp(Slot1,x)),w),SimpHelp(w,x))),Plus(v,w)))))),If(TrigQ(u),With(List(Set(v,SimpHelp(Part(u,C1),x))),If(And(LinearQ(v,x),MatchQ(Coefficient(v,x,C0),Condition(Plus(Times(m_DEFAULT,Plus(Times(n_DEFAULT,Pi),r_DEFAULT)),s_DEFAULT),RationalQ(m,n)))),NormalizeTrig(Head(u),Coefficient(v,x,C0),Coefficient(v,x,C1),x),$(Head(u),v))),If(HyperbolicQ(u),With(List(Set(v,SimpHelp(Part(u,C1),x))),If(And(LinearQ(v,x),MatchQ(Coefficient(v,x,C0),Condition(Plus(Times(m_DEFAULT,Plus(Times(n_DEFAULT,Complex(C0,$p("nz")),Pi),r_DEFAULT)),s_DEFAULT),RationalQ(m,n,$s("nz"))))),NormalizeHyperbolic(Head(u),Coefficient(v,x,C0),Coefficient(v,x,C1),x),$(Head(u),v))),Map(Function(SimpHelp(Slot1,x)),u)))))))),
ISetDelayed(205,NormalizeTrig($p("func"),Plus(Times(m_DEFAULT,Plus(Times(Pi,n_DEFAULT),r_DEFAULT)),s_DEFAULT),b_,x_),
    Condition(If(And(Equal(Times(m,n),C1D4),NegQ(b)),Switch($s("func"),Sin,Cos(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))),Cos,Sin(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))),Tan,Cot(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))),Cot,Tan(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))),Sec,Csc(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))),Csc,Sec(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),If(Equal(Times(m,n),CN1D4),If(PosQ(b),Switch($s("func"),Sin,Negate(Cos(Plus(Times(C1D4,Pi),Times(m,r),s,Times(b,x)))),Cos,Sin(Plus(Times(C1D4,Pi),Times(m,r),s,Times(b,x))),Tan,Negate(Cot(Plus(Times(C1D4,Pi),Times(m,r),s,Times(b,x)))),Cot,Negate(Tan(Plus(Times(C1D4,Pi),Times(m,r),s,Times(b,x)))),Sec,Csc(Plus(Times(C1D4,Pi),Times(m,r),s,Times(b,x))),Csc,Negate(Sec(Plus(Times(C1D4,Pi),Times(m,r),s,Times(b,x))))),Switch($s("func"),Sin,Negate(Sin(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Cos,Cos(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))),Tan,Negate(Tan(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Cot,Negate(Cot(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Sec,Sec(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))),Csc,Negate(Csc(Plus(Times(C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))))),$($s("func"),Plus(Times(m,n,Pi),Times(m,r),s,Times(b,x))))),RationalQ(m,n))),
ISetDelayed(206,NormalizeHyperbolic($p("func"),Plus(s_DEFAULT,Times(m_DEFAULT,Plus(r_DEFAULT,Times(Pi,n_DEFAULT,Complex(C0,$p("nz")))))),b_,x_),
    Condition(If(And(Equal(Times(m,n,$s("nz")),C1D4),NegQ(b)),Switch($s("func"),Sinh,Times(CI,Cosh(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Cosh,Times(CN1,CI,Sinh(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Tanh,Negate(Coth(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Coth,Negate(Tanh(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Sech,Times(CI,Csch(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Csch,Times(CN1,CI,Sech(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))))),If(Equal(Times(m,n,$s("nz")),CN1D4),If(PosQ(b),Switch($s("func"),Sinh,Times(CN1,CI,Cosh(Plus(Times(CI,C1D4,Pi),Times(m,r),s,Times(b,x)))),Cosh,Times(CN1,CI,Sinh(Plus(Times(CI,C1D4,Pi),Times(m,r),s,Times(b,x)))),Tanh,Coth(Plus(Times(CI,C1D4,Pi),Times(m,r),s,Times(b,x))),Coth,Tanh(Plus(Times(CI,C1D4,Pi),Times(m,r),s,Times(b,x))),Sech,Times(CI,Csch(Plus(Times(CI,C1D4,Pi),Times(m,r),s,Times(b,x)))),Csch,Times(CI,Sech(Plus(Times(CI,C1D4,Pi),Times(m,r),s,Times(b,x))))),Switch($s("func"),Sinh,Negate(Sinh(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Cosh,Cosh(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))),Tanh,Negate(Tanh(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Coth,Negate(Coth(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))),Sech,Sech(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x))),Csch,Negate(Csch(Plus(Times(CI,C1D4,Pi),Times(CN1,m,r),Negate(s),Times(CN1,b,x)))))),$($s("func"),Plus(Times(m,n,$s("nz"),CI,Pi),Times(m,r),s,Times(b,x))))),RationalQ(m,n,$s("nz")))),
ISetDelayed(207,FractionalPowerOfSquareQ(u_),
    If(AtomQ(u),False,If(And(FractionalPowerQ(u),MatchQ(Part(u,C1),Condition(Times(a_DEFAULT,Sqr(Plus(b_,c_))),NonsumQ(a)))),Part(u,C1),Module(List($s("tmp")),Catch(CompoundExpression(Scan(Function(If(Not(FalseQ(Set($s("tmp"),FractionalPowerOfSquareQ(Slot1)))),Throw($s("tmp")))),u),False)))))),
ISetDelayed(208,FractionalPowerSubexpressionQ(u_,v_,w_),
    If(AtomQ(u),False,If(And(FractionalPowerQ(u),GtQ(Times(Part(u,C1),Power(w,-1)),C0)),And(Not(SameQ(Part(u,C1),v)),Less(LeafCount(w),Times(C3,LeafCount(v)))),Catch(CompoundExpression(Scan(Function(If(FractionalPowerSubexpressionQ(Slot1,v,w),Throw(True))),u),False))))),
ISetDelayed(209,FixSimplify(Times(u_DEFAULT,Complex(C0,a_),Power(Plus(w_,Times(v_DEFAULT,Complex(C0,b_))),n_DEFAULT))),
    Condition(Times(Power(CN1,Times(C1D2,Plus(n,C1))),a,u,FixSimplify(Power(Plus(Times(b,v),Times(CN1,CI,w)),n))),OddQ(n))),
ISetDelayed(210,FixSimplify(Times(Power(u_,m_DEFAULT),Power(v_,n_),w_DEFAULT)),
    Condition(With(List(Set(z,Simplify(Times(Power(u,Times(m,Power(GCD(m,n),-1))),Power(v,Times(n,Power(GCD(m,n),-1))))))),Condition(FixSimplify(Times(w,Power(z,GCD(m,n)))),Or(AbsurdNumberQ(z),SqrtNumberSumQ(z)))),And(RationalQ(m),FractionQ(n),SqrtNumberSumQ(u),SqrtNumberSumQ(v),GtQ(u,C0),GtQ(v,C0))))
  );
}
