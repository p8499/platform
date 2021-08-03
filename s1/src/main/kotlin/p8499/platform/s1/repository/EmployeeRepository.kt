package p8499.platform.s1.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import p8499.platform.s1.dao.EmployeeDao
import p8499.platform.s1.entity.Employee

@Repository
interface EmployeeRepository :
    JpaRepository<Employee, Long>,
    JpaSpecificationExecutor<Employee>,
    PagingAndSortingRepository<Employee, Long>,
    EmployeeDao