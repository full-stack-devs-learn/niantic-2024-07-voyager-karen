import { useState } from 'react';
import EmployeeCard from '../employee-card/EmployeeCard';
import './EmployeeCardContainer.css';
import { employees } from '../../../data';

export default function EmployeeCardContainer() {
  const [selectedEmployee, setSelectedEmployee] = useState(null);

  const employeeSelected = (employee) => {
    setSelectedEmployee(employee);
  };

  return (
    <>
      <h5 className="container">
        Selected Employee: {selectedEmployee ? `${selectedEmployee.firstName} ${selectedEmployee.lastName}` : "None"}
      </h5>

      {selectedEmployee && (
      <div className="selected-employee-details">
        <img
          className="selected-employee-image"
          src={`/images/employees/${selectedEmployee.employeeId}.webp`}
          alt={`${selectedEmployee.firstName} ${selectedEmployee.lastName}`}
        />
        <p><strong>Full Name:</strong> {selectedEmployee.firstName} {selectedEmployee.lastName}</p>
        <p><strong>Title:</strong> {selectedEmployee.title}</p>
        <p><strong>Salary:</strong> ${selectedEmployee.salary.toLocaleString()}</p>
        <p><strong>Notes:</strong> {selectedEmployee.notes}</p>
    </div>
      )}

      <main className="employees-container mt-4" id="employees-container">
        {employees.map((employee) => (
          <EmployeeCard
            key={employee.employeeId}
            id={employee.employeeId}
            employee={employee}
            onEmployeeSelected={() => employeeSelected(employee)}
          />
        ))}
      </main>
    </>
  );
}
