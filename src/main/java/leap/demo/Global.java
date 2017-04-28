package leap.demo;

import leap.web.App;

public class Global extends App {

    @Override
    protected void init() throws Throwable {
        System.out.println("app init.");
        super.init();
    }
}