package BasicLambdasTask;

@FunctionalInterface
public interface TwoStringPredicate {
	public boolean isFirstBetterThanSecond(String s1, String s2);
	// default methods, why?????
	// default implementation is req when static is used in methods here, so even if
	// we dont override it , our existing code wont break!!
	// therefore default methods were introduced
	// public default void ting(){ // provide body}
	// so anyone implementing this interface, wont have to override this method if
	// he/she doesnt need to use it
}
