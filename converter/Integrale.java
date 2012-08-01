package converter;



public final class Integrale {
	
	public static double calcola(Function myFunction, double begin, double end) 
	{
		return calcola(myFunction, begin, end, 10000);
	}
	
	public static double calcola(Function myFunction, double begin , double end, double parts) {
            
            double step = (end - begin)/parts;
            double temp = myFunction.evaluate(begin)/2;
            begin += step;
            double result = 0;
            for (int c = 0; c < parts-1; c++,  begin += step) {
			temp+= myFunction.evaluate(begin);
            }
            temp += myFunction.evaluate(begin)/2;
            result = temp*step;
            return result;	
	}
	
}
