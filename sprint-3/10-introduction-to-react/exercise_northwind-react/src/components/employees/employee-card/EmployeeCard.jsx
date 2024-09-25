import './EmployeeCard.css';

export default function EmployeeCard({ id, employee, onEmployeeSelected }) {

  const imageUrl = `/images/employees/${id}.webp`; 

  const employeeClicked = () => {
    onEmployeeSelected(employee);

  };

  return (
    <div className="card employee-card" onClick={employeeClicked}>
      <div id="employee-body" className="card-body">
   
        <img id="employee-image" src={imageUrl} alt={`${employee.firstName} ${employee.lastName}`} />
        <div id="employee-header" className="card-header">
 
          <p>ID: {employee.employeeId} </p>
          <p>{employee.firstName} {employee.lastName}</p>
          <p>{employee.title}</p>
        </div>
      </div>
    </div>
  );
}
