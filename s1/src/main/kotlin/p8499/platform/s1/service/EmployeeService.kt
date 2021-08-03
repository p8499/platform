package p8499.platform.s1.service

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import p8499.platform.s1.entity.Employee
import p8499.platform.s1.repository.EmployeeRepository


@Service
class EmployeeService {
    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    @Autowired
    lateinit var rabbitTemplate: RabbitTemplate

    fun get(emid: Long): Employee? =
        employeeRepository.findByIdOrNull(emid)

    fun add(employee: Employee) = employee
        .takeIf { it.emid == null }
        ?.also(employeeRepository::saveAndFlush)
        ?.also { it.emid?.run { rabbitTemplate.convertAndSend("", "employee", this) } }

    fun update(employee: Employee) = employee
        .takeIf { it.emid?.let(employeeRepository::existsById) ?: false }
        ?.also(employeeRepository::saveAndFlush)
        ?.also { it.emid?.run { rabbitTemplate.convertAndSend("", "employee", this) } }

    fun delete(emid: Long) =
        employeeRepository.deleteById(emid)

    fun query(specification: Specification<Employee>, pageable: Pageable) =
        employeeRepository.findAll(specification, pageable)
}