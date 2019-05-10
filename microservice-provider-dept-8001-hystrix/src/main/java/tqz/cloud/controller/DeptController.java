package tqz.cloud.controller;

import tqz.cloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tqz.cloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

//    @Autowired
//    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
//        return service.get(id);

        Dept dept = null;
        try {
            dept = service.get(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }

        return dept;
    }
    /**
     * 必须携带上一个方法的参数！！
     * @param id
     * @return
     *
     * 存在代码冗余问题：每加一个方法需要一个fallback函数，所以需要改进，实现解耦与分离
     *
     * 熔断：直接关闭服务不提供任何无服务
     * 降级：虽然服务熔断了不提供服务，但是为了提高可用性，客户端返回简单的响应
     */
    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

//    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
//    public Object discovery() {
//        List<String> list = client.getServices();
//        System.out.println("**********" + list);
//
//        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
//        for (ServiceInstance element : srvList) {
//            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
//                    + element.getUri());
//        }
//        return this.client;
//    }

}
