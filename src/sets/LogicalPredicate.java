package sets;

import sets.exceptions.*;

public class LogicalPredicate extends Predicate{
	public static final LogicalPredicate TRUE;
	public static final LogicalPredicate FALSE;	
	public static final LogicalPredicate IDENTITY;
	public static final LogicalPredicate NOT;
	public static final LogicalPredicate OR;
	public static final LogicalPredicate AND;
	//public static final LogicalPredicate AND;
	
	static{
		try{
			TRUE = new LogicalPredicate(0, new TruthValue[]{TruthValue.TRUE});
			FALSE = new LogicalPredicate(0, new TruthValue[]{TruthValue.FALSE});
			IDENTITY = new LogicalPredicate(1, new TruthValue[]{TruthValue.FALSE,TruthValue.TRUE});
			NOT = new LogicalPredicate(1, new TruthValue[]{TruthValue.TRUE,TruthValue.FALSE});
			OR = new LogicalPredicate(2, new TruthValue[]{TruthValue.FALSE,TruthValue.TRUE,TruthValue.TRUE,TruthValue.TRUE});
			AND = new LogicalPredicate(2, new TruthValue[]{TruthValue.FALSE,TruthValue.FALSE,TruthValue.FALSE,TruthValue.TRUE});
		} catch (final InvalidPredicateArgsNum e){
			throw new RuntimeException("Failed to create elementary logical predicate instance in static block.",e);
		}
	}
	
	public final int arity;
	public final TruthValue[] truthTable;
	
	
	public LogicalPredicate(int arity,TruthValue[] truthTable) throws InvalidPredicateArgsNum{
		if(truthTable.length != Math.pow(2,arity)){
			throw new InvalidPredicateArgsNum((int) Math.pow(2, arity), truthTable.length);
		}
		this.arity=arity;
		this.truthTable = truthTable;
	}
	
	public LogicalPredicate(Object[] parameters) throws InvalidPredicateArgsNum{
		//TODO: Implement a checking mechanism to see if the parameters correspond to valid truth table. If it doesn't pass, throw an exception.
		int[] argumentsTemp = new int[parameters.length];
		int counter=0;
		int max = -1;
		for(int i=0;i<=parameters.length-1;i++){
			if(parameters[i] instanceof Integer){
				 argumentsTemp[counter] = (int) parameters[i];
				 if(argumentsTemp[counter]>max){
					 max = argumentsTemp[counter]; 
				 }
				 counter++;
			}
		}
		arity=max;
		int[] arguments = new int[counter];
		
		int[] operators = new int[parameters.length-arguments.length];
		counter=0;
		for(int i=0;i<=parameters.length-1;i++){
			if(parameters[i] instanceof LogicalPredicate){
				 argumentsTemp[counter] = (int) parameters[i];
				 counter++;
			}
		}
		
		
	}
		
		
		/*
		int max = variables[0];
		for(int i = 0;i<=variables.length-1;i++){
			max=Math.max(max, variables[i]);
		}
		
		
		
		arity=max;
		int length = operators.length+variables.length;
		TruthValue[] arguments;
		
		Object[] level_1 = {2,3};
		Object[] level_2 = {AND,level_1};
		Object[] level_3 = {level_2};
		Object[] level_4 = {NOT,level_3};
		Object[] level_5 = {1,level_4};
		Object[] level_6 = {OR,level_5};
		
		Object[] level_all = {OR, new Object[]{1,new Object[]{NOT,new Object[]{new Object[]{AND,new Object[]{2,3}}}}}};
		
		Object[] x = {0};
		Object[] y = {x};
	  //Object[] z1 = {{0}};  //<--Doesn't work; "Cannot convert from int[] to Object."
		Object[][] z1_5 = {{0}};
		Object[][] z2 = {{0}};
		
		
		for(int i=0;i<=Math.pow(2, arity)-1;i++){
			//arguments=intToTruths(i);
			arguments=new TruthValue[]{};
			//operators[operators.length-1].eval(intToTruths(i).);
		}
		
		
		truthTable=new TruthValue[]{};
		*/
		
	public TruthValue eval(TruthValue[] arguments) throws InvalidPredicateArgsNum{
		if(arguments.length != arity){
			throw new InvalidPredicateArgsNum(arity, arguments.length);
		}
		
		TruthValue x=TruthValue.FALSE;
		for(int i=0;i<=Math.pow(2,arity)-1;i++){
			if(i==truthsToInt(arguments)){
				x=truthTable[i];
			}
		}
		return x;
	}
	
	private static int truthsToInt(TruthValue[] truthValues){
		int[] bits = new int[truthValues.length];
		for(int i=0;i<=truthValues.length-1;i++){
			if(truthValues[i]==TruthValue.FALSE){
				bits[i]=0;
			} else if(truthValues[i]==TruthValue.TRUE){
				bits[i]=1;
			}
		}

		int val=0;
		for(int i=0;i<=bits.length-1;i++){
			val=val+bits[bits.length-1-i]*(int)(Math.pow(2, i));
		}
		
		return val;
	}
	
//	private static TruthValue[] intToTruths(int val){
//		//return val;
//
//		for(int i=0;i<=bits.length-1;i++){
//			val=val+bits[bits.length-1-i]*(int)(Math.pow(2, i));
//		}
//		
//		int[] bits = new int[truthValues.length];
//		for(int i=0;i<=truthValues.length-1;i++){
//			if(truthValues[i]==TruthValue.FALSE){
//				bits[i]=0;
//			} else if(truthValues[i]==TruthValue.TRUE){
//				bits[i]=1;
//			}
//		}
//
//
//		
//	}
	
}
