import { useState } from 'react';
import EmployeeCard from '../employee-card/EmployeeCard'
import './EmployeeCardContainer.css'
import { employees } from '../../../data'

export default function EmployeeCardContainer() {

    const [selectedEmployee, setSelectedEmployee] = useState("None Selected");

    const employeeSelected = (name) => {

        setSelectedEmployee(name);
        console.log(name);

    }

    return(
        <>
        <h5 className="container">Selected Employee: {selectedEmployee}</h5>
        <main className="container mt-4 employees-container" id="employees-container">
            {
                employees.map((employee) => (
                    <EmployeeCard key={employee.employeeId}
                        employee={employee.employeeName}
                        id={employee.employeeId}
                        onEmployeeSelected={employeeSelected}
                        ></EmployeeCard>
                )
            
            )}
        </main>
        </>
    )

}