package p8499.platform.s1.handler

import com.rabbitmq.client.Channel
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MQHandler {
    @RabbitListener(queues = ["employee"])
    fun handleEmployee(msg: Any, message: Message, channel: Channel) {
        println("xxxxxxxxxxx msg: $msg");
    }
}