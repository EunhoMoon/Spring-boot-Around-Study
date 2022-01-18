package study.spring.AroundHubSpringBoot.common;

public class Constants {

	public enum ExceptionClass {
		
		PRODUCT("Product"), ORDER("Order"), PROVIDER("PROVIDER");
		
		private String exceptionClass;
		
		ExceptionClass(String exceptionClasss) {
			this.exceptionClass = exceptionClasss;
		}

		public String getExceptionClass() {
			return exceptionClass;
		}

		@Override
		public String toString() {
			return getExceptionClass() + " Exception. ";
		}
		
	}
	
}
