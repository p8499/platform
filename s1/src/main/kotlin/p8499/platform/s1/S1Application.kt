package p8499.platform.s1

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@EnableEurekaClient
@SpringBootApplication
class S1Application

fun main(args: Array<String>) {
    runApplication<S1Application>(*args)
}

@Configuration
class S1Configuration {
    @Autowired
    lateinit var amqpAdmin: AmqpAdmin

    @PostConstruct
    fun configureMQ() =
        with(amqpAdmin) {
            declareExchange(DirectExchange("s1"))
            declareQueue(Queue("employee", true))
            declareBinding(Binding("employee", Binding.DestinationType.QUEUE, "s1", "employee", null))
        }
}