# 说明
* consul-80、8611、8612 均为 consul 测试工程
* 80 为消费端
* 8611、8612 为服务端

# 服务端
通过 8611、8612 模拟集群提供相同的服务，
可以发现这两个工程里面均有一个 `/hi/` 的 Mapping 映射，
他们提相同的服务。

# 消费端
通过 `LoadBalancerClient` 来获取 8611、8612 提供的服务：service-provider，
然后会得到一个 `serviceInstance` ，通过该 `serviceInstance`   以 RestTemplate
的方式去访问 8611、8612 上的服务。
由于视同的是默认的负载均衡策略，所以会以轮询的方式显示 `Hi from 8611` 和 `Hi from 8612`

# 优化
* 以 WebService 的方式调用服务而非 RestTemplate
* 自定义其他负载均衡算法