package co.sid.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anis on 8/26/2015.
 */

@Controller
public class HelloController  {

    @Autowired
    IdService idService;

    @Autowired
    Foo foo;

    @Autowired
    @Qualifier(value = "carBean")
    AbstractCar car;

    @Autowired
    @Qualifier(value = "AudiBean")
    AbstractCar car2;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public List<Entity> hello(){

        System.out.println(foo.getName());
        System.out.println(car.getName());
        System.out.println(car2.getName());
        List<Entity> es = new ArrayList<Entity>();
        for(int i=0;i<10;i++){
            Entity e = new Entity();
            e.Id =idService.generateId();
            e.Name = "test" + (i+1);
            es.add(e);
        }

        return es;
    }
}
