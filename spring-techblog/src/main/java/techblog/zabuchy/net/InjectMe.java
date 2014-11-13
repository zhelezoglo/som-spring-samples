package techblog.zabuchy.net;

//import org.aspectj.lang.ProceedingJoinPoint;

public class InjectMe {

    public InjectMe() {
    }

    public void injectMethod() {
        System.out.println("INJECT!");
    }

    public void injectAfter(Object ret) {
        System.out.println("INJECT AFTER! Returned: " + ret);
    }

    public void injectException(IllegalArgumentException exception) {
        System.out.println("INJECT AFTER! Returned: " + exception);
    }

    public void injectFinally() {
        System.out.println("INJECT AFTER!");
    }

//	public Object injectAround(ProceedingJoinPoint pjp) throws Throwable {
//		// do some logic before
//		System.out.println("INJECT BEFORE!");
//
//		// run the actual method
//		Object retVal = null;
//		try {
//			retVal = pjp.proceed();
//		} catch (Exception e) {
//
//		}
//
//		// more logic after method executes
//		System.out.println("INJECT AFTER!");
//		return retVal;
//	}
}
