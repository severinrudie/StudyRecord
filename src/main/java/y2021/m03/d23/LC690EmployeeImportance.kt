package y2021.m03.d23

class LC690EmployeeImportance {

data class Employee(
	val id:Int = 0,
	val importance:Int = 0,
	val subordinates:List<Int> = listOf()
)
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val emps = employees.filterNotNull().map { e -> e.id to e }.toMap()
        return getImportance(employees.filterNotNull().first { it.id == id }, emps)
    }

    fun getImportance(emp: Employee, emps: Map<Int, Employee>): Int {
        if (emp.subordinates.isEmpty()) return emp.importance

        return emp.importance + emp.subordinates.map { getImportance(emps[it]!!, emps) }.sum()
    }
}