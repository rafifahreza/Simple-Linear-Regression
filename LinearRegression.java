
class LinearRegression{
	double x_mean = 0;
	double y_mean = 0;
	
	//This is a simple dataset
	double[] x = {4, 6, 2, 1, 0};
	double[] y = {3.5, 3.8, 3.4, 2.8, 2.4};
	
	private double getXMean(){
		/*
			This function used to get mean of X values
		*/
		for(int i=0; i<x.length; i++){
			x_mean= x_mean+x[i];
		}
		x_mean = x_mean / x.length;

		return x_mean;
	}
	
	private double getYMean(){
		/*
			This function used to get mean of Y values
		*/
		for(int j=0; j<y.length; j++){
			y_mean= y_mean+y[j];
		}
		y_mean = y_mean / y.length;
		return y_mean;
	}
	
	private double getXYMean(){
		/*
			This function used to get mean of X multiply by Y values
		*/
		double[] xy = new double[x.length];
		for(int i=0; i<x.length; i++){
			xy[i] = x[i] * y[i];
		}
		
		double xy_mean=0;
		for(int j=0; j<xy.length; j++){
			xy_mean= xy_mean+xy[j];
		}
		xy_mean = Math.round((xy_mean / xy.length)*100.0)/100.0;
		
		return xy_mean;
	}
	
	private double SqXMean(){
		/*
			This function used to get mean of Squared X values
		*/
		double x_mean = this.getXMean();
		return Math.round(Math.pow(x_mean, 2) * 100.0)/100.0;
	}
	
	private double SqX(){
		/*
			This function used to get mean of X values
		*/
		double[] x_squared = new double[x.length];
		for(int i=0; i<x.length; i++){
			x_squared[i] = Math.pow(x[i],2);
		}
		double xs_sum = 0;
		for(int j=0; j<x_squared.length; j++){
			xs_sum = xs_sum + x_squared[j];
		}
		xs_sum = xs_sum / x_squared.length;
		
		return xs_sum;
	}
	
	private double getSlope(){
		/*
			y = mX + b
			This function used to get m values
		*/
		return ((this.getXMean() * this.getYMean()) - this.getXYMean()) / (this.SqXMean() - this.SqX());
	}
	
	public static void main(String[] args){
		Linear Silly = new Linear();
		double m, b;
		m = Math.round(Silly.getSlope() * 100.0)/100.0;
		b = Math.round((Silly.getYMean() - (m * Silly.getXMean())) * 100.0)/100.0;
		double new_prediction;
		new_prediction = 1.5;
		System.out.println(m*new_prediction + b);
	}
}