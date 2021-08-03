package p8499.platform.s1.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "EMPLOYEE", schema = "USERNAME")
data class Employee(
    @get:Id
    @get:SequenceGenerator(name = "EMPLOYEE_EMID", allocationSize = 1)
    @get:GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_EMID")
    var emid: Long? = null,

    @get:Basic
    var emstatus: Long? = null,

    @get:Basic
    var emgender: String? = null,

    @get:Basic
    var emname: String? = null,

    @get:Basic
    @get:JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
    var embirthday: Date? = null
)