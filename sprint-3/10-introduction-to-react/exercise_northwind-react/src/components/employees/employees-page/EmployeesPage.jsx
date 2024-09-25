import EmployeeCardContainer from '../employee-card-container/EmployeeCardContainer'
import './EmployeesPage.css'

export default function EmployeesPage() {
    return (
      <>
        <header className="employees-page-header container mt-4">
          <h1>Employees</h1>
        </header>
  
        <main className="employees-page-content container">
          <EmployeeCardContainer />
        </main>
      </>
    );
  }