package p8499.platform.s1.repository.impl

import org.springframework.stereotype.Repository
import p8499.platform.s1.dao.EmployeeDao
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Repository
class EmployeeRepositoryImpl : EmployeeDao {
    @PersistenceContext
    private lateinit var em: EntityManager

//    override fun get(emid: Long): Employee? =
//        em.createQuery("select e from Employee e where e.emid=:emid", Employee::class.java)
//            .setParameter("emid", emid).resultList.firstOrNull()

//    override fun add(bean: Employee): Employee = bean.also(em::persist)
}
