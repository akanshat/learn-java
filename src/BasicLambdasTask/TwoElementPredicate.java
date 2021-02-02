package BasicLambdasTask;

@FunctionalInterface
public interface TwoElementPredicate<T> {
	// GENERIC FUNCTIONAL INTERFACE
	public boolean isFirstBetterThanSecond(T first, T second);
}
