package leap.demo.controller;

import leap.core.annotation.Inject;
import leap.web.view.ViewData;

public class HomeController {
    public void index(ViewData vd, String name){
        vd.put("name", name);

    }
}